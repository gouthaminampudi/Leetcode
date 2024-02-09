package com.goutham.tutorials;

public class CreditCardValidator {
    
    public static boolean isValidCreditCardNumber(String cardNumber) {
        int nDigits = cardNumber.length();
        int sum = 0;
        boolean isSecond = false;
        
        for (int i = nDigits - 1; i >= 0; i--) {
            int d = cardNumber.charAt(i) - '0';
            
            if (isSecond == true) {
                d = d * 2;
            }
            
            // We add two digits to handle cases that make two digits after doubling
            int dByTen = d/10;
            sum = sum +dByTen;
            int dModTen = d%10;
            sum = sum +dModTen;
            
            isSecond = !isSecond;
        }
        return (sum % 10 == 0);
    }
    
    public static void main(String[] args) {
        String cardNumber = "5161056306014198";
        if (isValidCreditCardNumber(cardNumber)) {
            System.out.println(cardNumber + " is a valid credit card number");
        } else {
            System.out.println(cardNumber + " is not a valid credit card number");
        }
    }
}

