package com.example.simpleloginapp;

public class bookModel {
    private String name;
    private String genre;
    private String isbn;
    private String author;
    private String review;
    private String userEmail;

    public bookModel()
    {

    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public bookModel(String name, String genre, String isbn, String author, String review, String userEmail) {
        this.name = name;
        this.genre = genre;
        this.isbn = isbn;
        this.author = author;
        this.review = review;
        this.userEmail = userEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
