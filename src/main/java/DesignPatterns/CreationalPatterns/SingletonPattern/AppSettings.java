package main.java.DesignPatterns.CreationalPatterns.SingletonPattern;

public class AppSettings {

    private String dbUrl;
    private String key;

    private AppSettings(){
        dbUrl="jdbc:oracle";
        key="abcdefgh";
    }

    /*there can be many impl of singleton, this one is using Helper method. - second best.
    others are
    Singleton with Enum - best of all
    Singleton with Double-checked locking
    Singleton with Eager initialization
    Singleton with Serialization safety
    */
    private static class Helper{
        private static final AppSettings instance = new AppSettings();
    }

    public static AppSettings getInstance(){
        return Helper.instance;
    }
}
