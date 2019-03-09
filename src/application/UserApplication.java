package application;

import domain.User;
import domain.Video;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserApplication extends Application {
    public UserApplication(List<User> userList, List<Video> videoList, User userConnected) {
        super(userList, videoList, userConnected);
    }

    public void menu(){
        String option;

        do{
            System.out.println("Select one option");
            System.out.println("1 - create a new video.");
            System.out.println("2 - list my videos.");
            System.out.println("3 - list all videos.");
            System.out.println("4 - logout.");

            option = Application.getInput("selection : ");
        } while(!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4"));

        switch (option){
            case "1":
                menu_createVideo();
                break;
            case "2":
                listUserVideos();
                break;
            case "3":
                listAllVideos();
                break;
            case "4":
                // nothing
        }
    }

    private void menu_createVideo(){
        String url;
        String title;
        String tags;
        List<String> tags_aux = null;
        Video video = null;

        do {
            try {
                do {
                    System.out.println("Introduce the data for");
                    url = Application.getInput("url : ");
                    title = Application.getInput("title : ");
                    tags = Application.getInput("tags(comma separated) : ");
                } while (url.isEmpty() || title.isEmpty() || tags.isEmpty());

                if(!tags.isEmpty()) {
                    tags_aux = Arrays.asList(tags.split(","));

                    if(tags_aux.size() == 0){
                        throw new Exception("Tags format is not correct");
                    }
                }

                video = new Video(url, title, tags_aux, this.userConnected);

                videoList.add(video);

                List<Video> userVideos = this.userConnected.getVideos();
                if(userVideos == null){
                    userVideos = new ArrayList<>();
                }
                userVideos.add(video);
                this.userConnected.setVideos(userVideos);

                System.out.println("The video has successfully created.");

            } catch (Exception e) {
                System.out.println("Error creating the video. Please check the tags format.");
            }
        } while (video == null);

        menu();
    }

    private void listUserVideos(){
        if(userConnected.getVideos() != null) {
            for (Video aux : userConnected.getVideos()) {
                System.out.println(aux);
            }
        }

        menu();
    }

    private void listAllVideos(){
        if(videoList != null) {
            for (Video aux : videoList) {
                System.out.println(aux);
            }
        }

        menu();
    }
}
