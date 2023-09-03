package org.example;

import java.util.Scanner;

public class Converter {
    String input;

    void inputText() {
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        scan.close();
    }

    String convertToUpperAndLowerCase() {
        inputText();
        char[] charArray = input.toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < charArray.length; ++i) {

            if (i % 2 == 0) {
                result.append(Character.toLowerCase(charArray[i]));
            } else result.append(Character.toUpperCase(charArray[i]));
        }
        return result.toString();
    }
}