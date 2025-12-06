package main.java.DesignPatterns.StructuralPatterns.FacadePattern;

public class UserService {

    public String getUser(String name){
        return "User returned: ".concat(name);
    }
}
