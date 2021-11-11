package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Server{
    private static class Handler extends Thread {
        private Socket socket;


        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String userName = "";
            try{
                ConsoleHelper.writeMessage("Установленно соединение с удаленном адресом - " +
                        socket.getRemoteSocketAddress());
                Connection connection = new Connection(socket);
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                connectionMap.remove(userName);}
            catch (Exception e){e.printStackTrace();}}

        private void serverMainLoop(Connection connection, String userName) throws  IOException, ClassNotFoundException{
            while(true){
                if(connection.receive().getType()== MessageType.TEXT){
                    String message = userName+": "+connection.receive();
                    sendBroadcastMessage(new Message(MessageType.TEXT, message));}
                else{
                    System.out.println("Wrong type of input text");}
            }
        }

        private void notifyUsers(Connection connection, String userName) throws  IOException{
            for(String name: connectionMap.keySet()){
                if(!name.equalsIgnoreCase(userName)){
                    connection.send(new Message(MessageType.USER_ADDED, name));}
            }}


        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            while (true){
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message name  = connection.receive();
                if(name.getType().equals(MessageType.USER_NAME)&&
                        name.getData().isEmpty()
                        &&!connectionMap.containsKey(name.getData())){
                    connectionMap.put(name.getData(), connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    return connection.receive().getData();}}}

        private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

        public static void sendBroadcastMessage(Message message){
            try{
                for(Connection connection: connectionMap.values()){
                    connection.send(message);}}
            catch (IOException e){
                ConsoleHelper.writeMessage("Не удалось отправить сообщение");}
        }}


    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("Ввведите порт сервера");
        ServerSocket socketServer = new ServerSocket(ConsoleHelper.readInt());
        System.out.println("Сервер запущен");
        Socket socket = null;
        try{
            while (true) {
                socket = socketServer.accept();
                if(socket!=null) {
                    new Handler(socket).start();}}}
        catch (Exception e){
            ConsoleHelper.writeMessage("Произошла ошибка при запуске или во время работы сервера");
            socketServer.close();}}}

