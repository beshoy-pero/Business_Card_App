package com.beshoykamal.businesscardapp.Pojo;

public class Slide {

    private int Image;
    private String Title;
    private String descrip;
    private String guid;
    private String pubDate;

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public Slide(int image, String title, String descrip, String date, String pubDate) {
        Image = image;
        Title = title;
        this.descrip = descrip;
        this.date = date;
        this.pubDate = pubDate;
    }


    private String date;

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Slide(int image, String title, String descrip) {
        Image = image;
        Title = title;
        this.descrip = descrip;
    }


    public Slide(int image, String title) {
        Image = image;
        Title = title;

    }

    public Slide(String title) {
        Title = title;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
