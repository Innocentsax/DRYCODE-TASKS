package dev.InnocentUdo;


import org.mindrot.jbcrypt.BCrypt;

import java.security.SecureRandom;
import java.util.Scanner;

public class passwordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the password: ");
        int passwordLength = scanner.nextInt();

        String generatedPassword = generatePassword(passwordLength);
        System.out.println("Your generated password is: " + generatedPassword);

        String hashedPassword = hashPassword(generatedPassword);
        System.out.println("Encrypted (hashed) password: " + hashedPassword);
    }

    public static String generatePassword(int length) {
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()_-+=<>?";

        String charMix = upperCase + lowerCase + numbers + specialChars;
        SecureRandom random = new SecureRandom();

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(charMix.length());
            password.append(charMix.charAt(randomIndex));
        }
        return password.toString();
    }
    public static String hashPassword(String password) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(password, salt);
    }
}
