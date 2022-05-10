package com.company;


public class CalculateService {


    public static String calculate(Number first, Number second, String arifSymbol) throws Exception {
        int result;

        switch (arifSymbol) {
            case "+":
                result = first.getValue() + second.getValue();
                break;
            case "-":
                result = first.getValue() - second.getValue();
                break;
            case "*":
                result = first.getValue() * second.getValue();
                break;
            case "/":
                result = first.getValue() / second.getValue();
                break;
            default:
                throw new Exception("Ката! Калькулятор бир гана +, -, *, /, сиьволдору менен иштейт.");
        }
        if (first.getType() == NumberType.ROMAN) {
            return NumberService.romanNumber(result);
        } else return String.valueOf(result);


    }
}
