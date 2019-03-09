package application;

import domain.User;
import domain.Video;

import java.util.List;
import java.util.Scanner;

public abstract class Application {
    protected List<User> userList;
    protected List<Video> videoList;
    protected User userConnected;

    public Application(List<User> userList, List<Video> videoList, User userConnected) {
        this.userList = userList;
        this.videoList = videoList;
        this.userConnected = userConnected;
    }

    public static String getInput(String prompt) {
        System.out.print(prompt);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public abstract void menu();

}
