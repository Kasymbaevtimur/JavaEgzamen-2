package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Кош келиниз ,бул калькулятор 1 ден 10 го чейинки Рим жана Араб цифралары менен иштейт");
        System.out.println("Калькулятор через пробел иштейт !");
        System.out.println("Сан  жазыныз :");
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();

        try {
            String[] symbols = line.split(" ");
            if (symbols.length != 3)
                throw new Exception("Ката чыкты, башынан жазыныз");

            Number firstNumber = NumberService.parseAndValidate(symbols[0]);
            Number secondNumber = NumberService.parseAndValidate(symbols[2], firstNumber.getType());
            String result = CalculateService.calculate(firstNumber, secondNumber, symbols[1]);
            System.out.println("Жооп: \n" + line + " = " + result);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Саламатта калыныз");

        }
    }

}

