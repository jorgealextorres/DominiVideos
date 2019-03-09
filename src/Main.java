import application.AdminApplication;
import application.Application;
import application.UserApplication;
import domain.User;
import domain.Video;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private final String ADMIN_EMAIL = "admin@example.com";

    private List<User> userList;
    private List<Video> videoList;
    private User userConnected;
    private Application app;
    private AdminApplication adminApp;

    public Main() {
        this.userList = new ArrayList<>();
        this.videoList = new ArrayList<>();
        this.userConnected = null;

        adminApp = new AdminApplication(userList, videoList, userConnected);

        adminApp.createUser(this.ADMIN_EMAIL,"admin","","admin123456");
    }

    public static void main(String[] args) {
        Main main = new Main();

        main.app_login();
    }

    public void app_login(){
        String userEmail;
        String userPassword;
        this.userConnected = null;

        do {
            do {
                System.out.println("Welcome to the application. Please insert email and password.");
                userEmail = Application.getInput("email : ");
                userPassword = Application.getInput("password : ");
            } while (userEmail.isEmpty() || userPassword.isEmpty());

            this.userConnected = adminApp.findUser(userEmail);

            if(this.userConnected == null || !this.userConnected.getPassword().equals(userPassword)){
                System.out.println("Wrong email or password.");
            }
        } while(this.userConnected == null);

        if(!this.userConnected.getEmail().equals(this.ADMIN_EMAIL)){
            app = new UserApplication(userList, videoList, userConnected);
        } else{
            app = new AdminApplication(userList, videoList, userConnected);
        }

        app.menu();

        logout();
    }

    public void logout(){
        this.userConnected = null;
        System.out.println("the user has successfully logout.");
        app_login();
    }
}
