package model;

public class User {
    private String userName;
    private String phoneNumber;
    private String dateAndTime;
    // No args Constructor & Parameterized Constructor
    public User(){
    }
    public User(String userName, String phoneNumber, String dateAndTime){
        this.userName=userName;
        this.phoneNumber=phoneNumber;
        this.dateAndTime=dateAndTime;
    }
    //Setters
    public void setUserName(String userName){
        this.userName=userName;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    public void setDateAndTime(String dateAndTime){
        this.dateAndTime=dateAndTime;
    }
    //Getters
    public String getUserName(){
        return userName;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getDateAndTime(){
        return dateAndTime;
    }
}
