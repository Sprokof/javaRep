package server;

import java.io.*;

public class ConsoleHelper {
    private static BufferedReader bf =
            new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);}

    public static String readString(){
        try{
            return bf.readLine();}
        catch(IOException e){
            System.out.println("Произошла ошибка при попытке ввода текста."+"\n"+"Попробуйте еще раз.");
            return readString();}}

    public static int readInt(){
        int result = 0;
        try{
            result = Integer.parseInt(readString());}
        catch(NumberFormatException e){
            System.out.println("Произошла ошибка при попытке ввода числа."+"\n"+"Попробуйте еще раз.");
            result = Integer.parseInt(readString());}
        return result;}

}
