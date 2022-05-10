package com.company;


import java.util.Map;
import java.util.TreeMap;

public class NumberService {


    private final static TreeMap<Integer, String> romanConvert = new TreeMap<>();

    static {
        romanConvert.put(1, "I");
        romanConvert.put(4, "IV");
        romanConvert.put(5, "V");
        romanConvert.put(9, "IX");
        romanConvert.put(10, "X");
        romanConvert.put(40, "XL");
        romanConvert.put(50, "L");
        romanConvert.put(90, "XC");
        romanConvert.put(100, "C");
    }

    static Number parseAndValidate(String symbol) throws Exception {

        int value;
        NumberType type;

        try {
            value = Integer.parseInt(symbol);
            type = NumberType.ARABIC;
        } catch (NumberFormatException e) {
            value = arabicNumber(symbol);
            type = NumberType.ROMAN;
        }

        if (value < 1 || value > 10) {
            throw new Exception("Туура эмес сан берилди, 1 ден 10го чейинки сандарды колдонунуз");
        }

        return new Number(value, type);
    }

    static Number parseAndValidate(String symbol, NumberType type) throws Exception {

        Number number = parseAndValidate(symbol);
        if (number.getType() != type) {
            throw new Exception("Берилген сан эки турдуу, бир турдуу сандарды колдонунуз");
        }

        return number;
    }

    private static int letterToNumber(char letter) {

        int result = -1;

        for (Map.Entry<Integer, String> entry : romanConvert.entrySet()) {
            if (entry.getValue().equals(String.valueOf(letter))) result = entry.getKey();
        }
        return result;
    }

    static String romanNumber(int number) {

        int i = romanConvert.floorKey(number);

        if (number == i) {
            return romanConvert.get(number);
        }
        return romanConvert.get(i) + romanNumber(number - i);
    }

    static int arabicNumber(String roman) throws Exception {
        int result = 0;

        int i = 0;
        while (i < roman.length()) {
            char letter = roman.charAt(i);
            int num = letterToNumber(letter);

            if (num < 0) throw new Exception("Туура эмес рим цифрасы жазылды");

            i++;
            if (i == roman.length()) {
                result += num;
            } else {
                int nextNum = letterToNumber(roman.charAt(i));
                if (nextNum > num) {
                    result += (nextNum - num);
                    i++;
                } else result += num;
            }
        }
        return result;
    }
}



