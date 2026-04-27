package model;

public class Book {
    private String bookTitle;
    private String bookAuthor;
    private String isbnNumber;

    public Book(){}
    public Book(String bookTitle,String bookAuthor, String ispnNumber){
        this.bookTitle=bookTitle;
        this.bookAuthor=bookAuthor;
        this.isbnNumber=ispnNumber;
    }

    //setters
    public void setBookTitle(String bookTitle){
        this.bookTitle=bookTitle;
    }
    public void setBookAuthor(String bookAuthor){
        this.bookAuthor=bookAuthor;
    }
    public void setIsbnNumber(String ispnNumber){
        this.isbnNumber=ispnNumber;
    }
    //getters
    public String getBookTitle(){
        return bookTitle;
    }
    public String getBookAuthor(){
        return bookAuthor;
    }
    public String getIsbnNumber(){
        return isbnNumber;
    }
}
