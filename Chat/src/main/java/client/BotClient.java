package client;

import server.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client{
    public class BotSocketThread extends SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            try{
                BotClient.this.sendTextMessage("Hi to evereony. Я бот. Понимаю команды: дата, день, месяц, год, время, час, " +
                        "минуты, секунды.");
                super.clientMainLoop();}
            catch (IOException|ClassNotFoundException e){
                e.printStackTrace();}
        }
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
            String[] temp = message.split(": ");
            if(temp.length!=2){return;}
            String name = temp[0];
            String text = temp[1];
            String format = null;
            switch (text){
                case "дата":
                    format = "d.MM.YYYY";
                    break;
                case "день":
                    format = "d";
                    break;
                case "месяц":
                    format = "MMM";
                    break;
                case "время":
                    format = "H:mm:ss";
                    break;
                case "час":
                    format = "H";
                    break;
                case "минуты":
                    format = "m";
                    break;
                case "секунды":
                    format = "s";
                    break;}

            if(format != null){
                String time = new SimpleDateFormat(format).format(Calendar.getInstance());
                BotClient.this.sendTextMessage("Информация для "+name+": "+ time);

            }}}


    protected SocketThread getSocketThread(){
        return new BotSocketThread();}

    protected boolean shouldSendTextFromConsole(){
        return false;}

    public String getUserName(){
        return "informBot - "+(int)(Math.random()*100);}

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }}