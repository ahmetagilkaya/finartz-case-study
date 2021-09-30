package tr.com.finartz.casestudy.core.util;

public class CreditCardUtil {

    public static Boolean checkCreditCardStringIsValid(String creditCardString){
        return getValidCreditCardString(creditCardString).length() == 16;
    }

    public static String getValidCreditCardString(String creditCardString){
        return creditCardString.replaceAll("[^0-9]", "");
    }

    public static String hideCreditCard(String creditCardString){
        return new StringBuilder()
                .append(creditCardString.substring(0,6))
                .append("******")
                .append(creditCardString.substring(12,16)).toString();
    }

}
