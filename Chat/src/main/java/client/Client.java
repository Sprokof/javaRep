package client;

import server.Connection;
import server.ConsoleHelper;
import server.Message;
import server.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
    public class SocketThread extends Thread {
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        private void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " has been connected to chat.");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " has been left from chat");
        }

        protected void notifyConnectionStatusChanged(boolean ClientConnection) {
            Client.this.clientConnected = ClientConnection;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType().equals(MessageType.NAME_REQUEST)) {
                    String name = getUserName();
                    connection.send(new Message(MessageType.USER_NAME, name));
                } else if (message.getType().equals(MessageType.NAME_ACCEPTED)) {
                    notifyConnectionStatusChanged(true);
                    break;
                } else {
                    throw new IOException("Unexpected MessageType");}}}

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType()==MessageType.TEXT){processIncomingMessage(message.getData());}
                else if(message.getType()==MessageType.USER_ADDED){
                    informAboutAddingNewUser(message.getData());}
                else if(message.getType()==MessageType.USER_REMOVED){
                    informAboutDeletingNewUser(message.getData());}
                throw new IOException("Unexpected MessageType");}
        }

        @Override
        public void run() {
            try{
                Socket socket = new Socket(getServerAddress(), getServerPort());
                Client.this.connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();}
            catch (IOException|ClassNotFoundException e){
                notifyConnectionStatusChanged(false);
                e.printStackTrace();}}}


    private Connection connection;

    private volatile boolean clientConnected = false;

    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this){
            try{
                this.wait();}
            catch (InterruptedException ie){
                ConsoleHelper.writeMessage("При работе клиента возникла ошибка.");}
            if(clientConnected){ConsoleHelper.writeMessage("Соединение установлено.\nДля выхода наберите" +
                    "команду 'exit'");}
            else{ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");}
            while(clientConnected) {
                String message = ConsoleHelper.readString();
                if(message.equalsIgnoreCase("exit")){
                    break;}
                if(shouldSendTextFromConsole()){sendTextMessage(message);}
            }}}


    protected String getServerAddress(){
        System.out.print("Введите адресс сервера: ");
        String address = ConsoleHelper.readString();
        return address;}

    protected int getServerPort(){
        System.out.print("Введите порт сервера: ");
        int port =  ConsoleHelper.readInt();
        return port;}

    protected boolean shouldSendTextFromConsole(){
        return true;}

    protected String getUserName(){String name = ConsoleHelper.readString();
        System.out.println("Введите userName: "+name);
        return name;}

    protected SocketThread getSocketThread(){
        return new SocketThread();}

    protected void sendTextMessage(String text){
        try{
            connection.send(new Message(MessageType.TEXT,text));}
        catch(IOException ioe){
            System.out.println("Ошибка отправки сообщения серверу");
            clientConnected  = false;}



    }


}

