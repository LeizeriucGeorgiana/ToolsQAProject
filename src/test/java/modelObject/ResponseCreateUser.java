package modelObject;

import java.util.List;

public class ResponseCreateUser {
    private String userID;
    private String username;
    private List<BookModel> books;

    public void setUserId(String userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }

    public String getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public List<BookModel> getBooks() {
        return books;
    }
}
