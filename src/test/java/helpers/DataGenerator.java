package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

public class DataGenerator {

    public static String randomString(int length) {
        String validChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random();
        String string = "";
        for (int i = 0; i < length; i++) {
            int rndIndex = rand.nextInt(validChars.length());
            char rndChar = validChars.charAt(rndIndex);
            string += rndChar;
        }
        return string;
    }

    public static String randomInteger(int length) {
        String validChars = "0123456789";
        Random rand = new Random();
        String string = "";
        for (int i = 0; i < length; i++) {
            int rndIndex = rand.nextInt(validChars.length());
            char rndChar = validChars.charAt(rndIndex);
            string += rndChar;
        }
        return string;
    }

    public static String currentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(new Date());
    }
}
