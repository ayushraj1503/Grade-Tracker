package MP3;

import java.util.Calendar;

public class Validators {
    public static boolean isValidDOB(String DOB) {
        if (DOB.length() != 10)
            return false;

        try {
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);

            // Check month/day/year
            // 01/31/2000
            return !(Integer.parseInt(DOB.substring(0, 2)) < 0 || Integer.parseInt(DOB.substring(0, 2)) > 12
                    || !DOB.substring(2, 3).equals("/") || Integer.parseInt(DOB.substring(3, 5)) < 1
                    || Integer.parseInt(DOB.substring(3, 5)) > 31 || !DOB.substring(5, 6).equals("/")
                    || Integer.parseInt(DOB.substring(6)) < currentYear - 100
                    || Integer.parseInt(DOB.substring(6)) > currentYear);
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidEmail(String email) {
        int atIdx = email.indexOf("@");

        try {
            return !(atIdx == -1 || atIdx == 0 || atIdx != email.lastIndexOf("@")
                    || email.substring(atIdx + 1).indexOf(".") != email.substring(atIdx + 1).lastIndexOf("."));
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 10 || phoneNumber.charAt(0) == '0')
            return false;

        try {
            return Double.parseDouble(phoneNumber) > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
