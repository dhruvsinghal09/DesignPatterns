package main.java.CreationalPatterns.SingletonPattern;

public class Main {

    public static void main(String[] args){
        AppSettings appSettings = AppSettings.getInstance();
        AppSettings appSettings1 = AppSettings.getInstance();
        System.out.println(appSettings1==appSettings); // true
    }
}
