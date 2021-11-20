import java.util.regex.*;
public class Converter {
    public static void main(String[] args) {
        String binaryNumber = "10001";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "11";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        if(binaryNumber == null||binaryNumber.equals("")){return "";}
        if(binaryNumber.length()%4!=0){
            StringBuilder tempLine = new StringBuilder(binaryNumber);
            while(tempLine.length()%4!=0){
            tempLine.insert(0, "0");}
        binaryNumber  = tempLine.toString();}
        Pattern pat = Pattern.compile("[^0-1]");
        if(pat.matcher(binaryNumber).find()){return "";}
        int decimalNumber=0;
        for(int i=0; i<binaryNumber.length(); i++){
            int index=binaryNumber.length()-1-i;
            int value=Character.getNumericValue(binaryNumber.charAt(index));
            decimalNumber+=value*Math.pow(2,i);}
        String hex = "";
        while(decimalNumber!=0){
            final String HEX = "0123456789abcdef";
            hex = (HEX.charAt(decimalNumber%16))+hex;
            decimalNumber = decimalNumber/16;}
            return hex;}


    public static String toBinary(String hexNumber) {
        if(hexNumber==null){return "";}
        Pattern pat = Pattern.compile("[a-f0-9]");
        if(!pat.matcher(hexNumber).find()||hexNumber.equals("")){return "";}
        int decimal = 0;
        for(int i = 0; i<hexNumber.length(); i++){
            final String HEX = "0123456789abcdef";
            decimal = 16*decimal+HEX.indexOf(hexNumber.charAt(i));}
        String bin = "";
        while(decimal>0){
        int d = decimal%2;
        bin = d + bin;
        decimal/=2;}
        return  bin;}

}

