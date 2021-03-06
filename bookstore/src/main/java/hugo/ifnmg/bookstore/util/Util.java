package hugo.ifnmg.bookstore.util;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utilitaries
 */
public class Util {
    /**
     * Verify the validity of a CPF through its verification digits
     *
     * @param CPF: CPF to be validated
     * @return CPF validation
     */
    public static boolean isValidCPF(String CPF) {
        final Pattern pattern = Pattern.compile("^\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}$");
        final Matcher matcher = pattern.matcher(CPF);
        if (!matcher.matches())
            return false;
        CPF = CPF.replaceAll("[.-]", "");
        if (CPF.length() != 11)
            return false;
        
        Integer isEqualDigit;
        try {
            isEqualDigit= (int)(CPF.charAt(0) - '0');
            for (int i = 0; i < CPF.length(); i++) {
                int digit = (int)(CPF.charAt(i) - '0');
                isEqualDigit ^= digit;
            }
        } catch (InputMismatchException ex) {
            return false;
        }
        if (isEqualDigit == 0) {
            return false;
        }
        
        Integer weight10 = 10, weight11 = 11;
        Integer sumDigit10 = 0, sumDigit11 = 0;
        for (int i = 0; i < 9; i++, weight10--, weight11--) {
            int digit = (int)(CPF.charAt(i) - '0');
            sumDigit10 += (digit * weight10);
            sumDigit11 += (digit * weight11);
        }
        
        char digit10, digit11;
        sumDigit10 = (11 - (sumDigit10 % 11));
        if (sumDigit10 >= 10)
            sumDigit10 = 0;
        digit10 = (char)(sumDigit10 + '0');
        
        sumDigit11 += (int)(digit10 - '0') * weight11;
        sumDigit11 = (11 - (sumDigit11 % 11));
        if (sumDigit11 >= 10)
            sumDigit11 = 0;
        digit11 = (char)(sumDigit11 + '0');
        
        return digit10 == CPF.charAt(9) && digit11 == CPF.charAt(10);
    }
    
    /**
     * Verify the validity of a name
     * 
     * @param name: name to be validated
     * @return name validation
     */
    public static boolean isValidName(String name) {
        final Pattern pattern = Pattern.compile("^[\\p{L} .'-]+$");
        final Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
    
    /**
     * Verify the validity of a e-mail
     * 
     * @param email: e-mail to be validated
     * @return e-mail validation
     */
    public static boolean isValidEmail(String email) {
        final Pattern pattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        final Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}