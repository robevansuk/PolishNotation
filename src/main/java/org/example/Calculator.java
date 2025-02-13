package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Calculator implements CalculatorInterface {

    public static final String DELIMITER = " ";
    private List<String> buffer;

    public Calculator() {
        this.buffer = new LinkedList();
    }

    // 4 5 +
    // 5 4 -
    // 6 3 *
    // 5 4 - 6 *
    @Override
    public Long calculate(String expression) {
        Arrays.stream(expression.split(DELIMITER)).map(String::trim).forEach(buffer::add);

        int i = 2;
        while (buffer.size() != 1 && i < buffer.size()) {
            if (!buffer.get(i).matches("[\\+\\-\\*/]{1}")) {
                i++;
                continue;
            }
            runCalc(i);
            i--;
        }

        return Long.parseLong(buffer.get(0));
    }

    private void runCalc(int i) {
        String operator = buffer.get(i);
        Long num1 = Long.parseLong(buffer.get(i -2));
        Long num2 = Long.parseLong(buffer.get(i -1));

        switch (operator) {
            case "+":
                buffer.set(i -2, String.valueOf(num1 + num2));
                break;
            case "-":
                buffer.set(i -2, String.valueOf(num1 - num2));
                break;
            case "*":
                buffer.set(i -2, String.valueOf(num1 * num2));
                break;
            case "/":
                buffer.set(i -2, String.valueOf(num1 / num2));
                break;
        }
        buffer.remove(i);
        buffer.remove(i -1);
    }
}