package application;

import domain.User;
import domain.Video;

import java.util.List;

public class AdminApplication extends Application {
    public AdminApplication(List<User> userList, List<Video> videoList, User userConnected) {
        super(userList, videoList, userConnected);
    }

    public User findUser(String email){
        User foundUser = null;

        for(User aux:this.userList){
            if(aux.getEmail().equals(email)){
                foundUser = aux;
                break;
            }
        }

        return foundUser;
    }

    public void createUser(String email, String name, String surname, String password){
        User user = new User(email, name, surname, password);

        this.userList.add(user);
    }

    public void menu(){
        String option;

        do{
            System.out.println("Select one option");
            System.out.println("1 - create a new user.");
            System.out.println("2 - list all users.");
            System.out.println("3 - logout.");

            option = Application.getInput("selection : ");
        } while(!option.equals("1") && !option.equals("2") && !option.equals("3"));

        switch (option){
            case "1":
                menu_admCreateUser();
                break;
            case "2":
                listAllUsers();
                break;
            case "3":
                // nothing
        }
    }

    private void menu_admCreateUser(){
        String email;
        String name;
        String surname;
        String password;
        User user;

        do {
            do {
                System.out.println("Create a new user. Please insert data for");
                email = Application.getInput("email : ");
                name = Application.getInput("name : ");
                surname = Application.getInput("surname : ");
                password =Application. getInput("password : ");
            } while (email.isEmpty() || name.isEmpty() || surname.isEmpty() || password.isEmpty());

            user = findUser(email);

            if(user != null){
                System.out.println("Existing user.");
            }
        } while (user != null);

        createUser(email.trim(), name.trim(), surname.trim(), password.trim());

        System.out.println("User successfully created.");

        menu();
    }

    private void listAllUsers(){
        for(User aux:userList){
            System.out.println(aux.toString());
        }

        menu();
    }
}
