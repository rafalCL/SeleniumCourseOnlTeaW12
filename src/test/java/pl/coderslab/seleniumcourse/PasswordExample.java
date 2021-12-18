package pl.coderslab.seleniumcourse;

import java.util.Random;

public class PasswordExample {
    private String myPassword;

    public static void main(String[] args) {
        Random r = new Random(42); // note that seeding with static value causes generation of the same values!
        System.out.println(r.nextInt(100));
        System.out.println(r.nextInt(100));
    }

    public void generateRandomPassword() {
        // generate;
        this.myPassword = "alamakota";
    }

    public void fillForm() {
        String formElement = this.myPassword;
    }
}
