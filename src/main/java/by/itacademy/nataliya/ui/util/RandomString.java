package by.itacademy.nataliya.ui.util;

public class RandomString {
    public static String generateRandomString() {
        String abc = "abcdefghijklmnopqrstuvwxyz";
        String result = "";
        for (int i = 0; i < 5; i++) {

            result += abc.charAt((int) (Math.random() * abc.length()));
        }
        return result;
    }
}
