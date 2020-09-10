package pers.faiz.test.model;

public class News {

    private String title;
    private String content;
    private int image;

    public News() {

    }

    public News(String tile, String content, int image) {
        this.content = content;
        this.image = image;
        this.title = tile;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
