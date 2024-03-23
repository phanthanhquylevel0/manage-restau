package utils;





import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class Utils {
    private final static Scanner scanner = new Scanner(System.in);
    private final static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private final static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");


    //method
    public static SimpleDateFormat getSimpleDateFormat(){
        return sdf;
    }
    public static SimpleDateFormat getSimpleDateFormat2(){
        return sdf2;
    }

    public static Scanner getScanner(){
        return Utils.scanner;
    }


    public static Boolean checkValidDate(String date){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
