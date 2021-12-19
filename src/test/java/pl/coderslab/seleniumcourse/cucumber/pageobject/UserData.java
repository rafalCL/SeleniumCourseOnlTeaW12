package pl.coderslab.seleniumcourse.cucumber.pageobject;

import java.time.Month;

// DTO
public class UserData {
    private boolean isMr;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int days;
    private Month month;
    private int years;
    private boolean isNewsletter;
    private boolean isGetSpecialOffers;

    public boolean isMr() {
        return isMr;
    }

    public UserData setMr(boolean mr) {
        isMr = mr;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserData setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserData setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserData setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserData setPassword(String password) {
        this.password = password;
        return this;
    }

    public int getDays() {
        return days;
    }

    public UserData setDays(int days) {
        this.days = days;
        return this;
    }

    public Month getMonth() {
        return month;
    }

    public UserData setMonth(Month month) {
        this.month = month;
        return this;
    }

    public int getYears() {
        return years;
    }

    public UserData setYears(int years) {
        this.years = years;
        return this;
    }

    public boolean isNewsletter() {
        return isNewsletter;
    }

    public UserData setNewsletter(boolean newsletter) {
        isNewsletter = newsletter;
        return this;
    }

    public boolean isGetSpecialOffers() {
        return isGetSpecialOffers;
    }

    public UserData setGetSpecialOffers(boolean getSpecialOffers) {
        isGetSpecialOffers = getSpecialOffers;
        return this;
    }
}
