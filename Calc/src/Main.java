
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner userInput = new Scanner(System.in);
        String a = calc(userInput.nextLine());
        System.out.println(a);

    }

    public static String calc(String input) throws Exception {
        int a = 0;
        int b = 0;
        String sum;
        boolean isRoman;
        String oper;

        String[] userInput = input.replaceAll(" ", "").split("[-*+/]");
        if (userInput.length >= 3) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else if (userInput.length <= 1) {
            throw new Exception("строка не является математической операцией");
        }
            oper = detectOperation(input);

        if (Roman.isRoman(userInput[0]) && Roman.isRoman(userInput[1])) {
            a = Roman.convertArab(userInput[0]);
            b = Roman.convertArab(userInput[1]);
            isRoman = true;
        }
        else if (!Roman.isRoman(userInput[0]) && !Roman.isRoman(userInput[1])) {
            a = Integer.parseInt(userInput[0]);
            b = Integer.parseInt(userInput[1]);
            isRoman = false;
        }
         else {
            throw new Exception("Числа должны быть в одном формате");
        }
        if (a > 10 || b > 10 || a < 1 || b < 1) {
                throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.");
            }
        int arabian = calc(a, b, oper);
        if (isRoman) {
            if (arabian <= 0) {
                throw new Exception("в римской системе нет отрицательных чисел");
            }
            sum = Roman.convertToRoman(arabian);
        } else {
            sum = String.valueOf(arabian);
        }
        return sum;



        }
    static String detectOperation(String expression) {
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else return null;
    }

    static int calc(int a, int b, String oper) {

        if (oper.equals("+")) return a + b;
        else if (oper.equals("-")) return a - b;
        else if (oper.equals("*")) return a * b;
        else return a / b;
    }
    }

class Roman {
    static String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};


    public static boolean isRoman(String val) {
        for (int i = 0; i < romanArray.length; i++) {
            if (val.equals(romanArray[i])) {
                return true;
            }
        }
        return false;
    }


    public static int convertArab(String a) {
        for (int i = 0; i < romanArray.length; i++) {
            if (a.equals(romanArray[i]))
                return i;
        }
        return -1;
    }

    public static String convertToRoman(int arabian) {
        return romanArray[arabian];
    }


}


