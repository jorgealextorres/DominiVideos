package domain;

import java.util.List;

public class Video {
    private String url;
    private String title;
    private List<String> tags;
    private User user;

    public Video() {
    }

    public Video(String url, String title, List<String> tags, User user) {
        this.url = url;
        this.title = title;
        this.tags = tags;
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public User getlUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String toString(){
        return "url : " + this.url + "; title : " + this.title + "; user : " + this.user.getEmail() + "; tags : " + this.tags;
    }
}
