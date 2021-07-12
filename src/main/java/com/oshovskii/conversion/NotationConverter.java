package com.oshovskii.conversion;

public class NotationConverter {
    public static void main(String[] args) {
        System.out.println(toArabic(null));
    }

    public static int toArabic(String romanNotation) throws InvalidValueException {

        if (romanNotation == null || romanNotation.isBlank() || !romanNotation.matches("^[IVXLCDM]+$")) {
            throw new InvalidValueException("String must contain only valid roman numerals\n" + "[I, V, X, L, C, D, M].\n");
        }
        String message = romanNotation.toUpperCase();
        int temp = 0;
        String[] arr = message.split("");
        for (int i = 0; i < arr.length; i++) {
            int current = Conversion.valueOf(arr[i]).getValue();
            int nextCurrent = 0;
            if (i + 1 < arr.length) {
                nextCurrent = Conversion.valueOf(arr[i + 1]).getValue();
                if ((current < nextCurrent) && (current == 1 || current%10 == 0)) {
                    temp = (nextCurrent - current) + temp;
                    i++;
                } else {
                    temp = current + temp;
                }
            } else {
                temp = current + temp;
            }
        }
        return temp;
    }
}
