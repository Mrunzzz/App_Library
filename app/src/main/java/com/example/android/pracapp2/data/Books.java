package com.example.android.pracapp2.data;


import com.google.gson.annotations.SerializedName;

/**
 * Created by mrunz on 16/5/17.
 */

public class Books {
    @SerializedName("bookID")
    private int bookID;
    @SerializedName("Title")
    private String bookName;
    @SerializedName("Author")
    private String bookAuthor;
    @SerializedName("Genre")
    private String bookGenre;
    private String bookStatus;


    public Books(String bookAuthor, String bookGenre,
                 String bookName){
        this.bookAuthor=bookAuthor;
        this.bookGenre=bookGenre;
        this.bookName=bookName;

    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID){this.bookID=bookID;}

    public String getBookName() {
        return bookName;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

}
