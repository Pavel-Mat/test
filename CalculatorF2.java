
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Calc {

    public static void main(String[] args) throws Exception {
        //создается объект Scanner с именем scan
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите числа от 1 до 10 : ");
        //считывает строку, введенную пользователем, и сохраняет ее в переменную expression.
        String expression = scan.nextLine();
        System.out.println(calc(expression));
        //System.out.println("чек" + 5);
    }
    // вызываю метод calc
    static String calc(String expression) throws Exception {
        //объявляю переменные для хранения первого и второго числа
        int num1;
        int num2;
        //объявляю переменные для хранения операции и результата, и типа boolean указывающего являются ли числа римскими
        String operator;
        String result;
        boolean isRoman;
        //разбиваю введенную строку на две части по математическому оператору
        String[] operands = expression.split("[+\\-*/]");
        //проверяю содержит ли ввод ровно два операнда если нет генерируется исключение с сообщением об ошибке
        if (operands.length != 2) throw new Exception("Должно быть два числа");
        //вызываю метод detectOperation чтобы определить какая операция была введена пользователем и сохраняет результат в переменную operator
        operator = detectOperation(expression);
        //проверяю была ли определена операция если нет генерируется исключение с сообщением об ошибке
        if (operator == null) throw new Exception("Неподдерживаемая математическая операция");
        //проверяю являются ли оба числа римские
        if (Roman.isRoman(operands[0]) && Roman.isRoman(operands[1])) {
            //если оба числа римские конвертируем в арабские с помощью метода convertToArabian из класса Roman
            num1 = Roman.convertToArabian(operands[0]);
            num2 = Roman.convertToArabian(operands[1]);
            isRoman = true;
        }
        //проверяю являются ли оба числа арабскими
        else if (!Roman.isRoman(operands[0]) && !Roman.isRoman(operands[1])) {
            //если арабские то конвертируем из строки в целые числ с помощью метода parseInt
            num1 = Integer.parseInt(operands[0]);
            num2 = Integer.parseInt(operands[1]);
            isRoman = false;
        }
        //если одно число римское а другое арабское генерируется исключение и сообщение об ошибке
        else {
            throw new Exception("Числа должны быть в одном формате");
        }
        //находятся ли оба числа в допустимом диапазоне от 1 до 10, если нет то генерируется исключение
        if (num1 > 10 || num2 > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }
        //выполняется математическую операцию с арабскими числами, и сохраняет результат в переменной arabian
        int arabian = calc(num1, num2, operator);
        //проверяю были ли исходные числа римскими
        if (isRoman) {
            //если римское число получилось меньше либо равно нулю генерируется исключение
            if (arabian <= 0) {
                throw new Exception("Римское число должно быть больше нуля");
            }
            //конвертируем результат операции из арабского в римское с помощью метода convertToRoman из класса Roman
            result = Roman.convertToRoman(arabian);
            //если числа были арабскими преобразует результат обратно в строку
        } else {
            result = String.valueOf(arabian);
        }
        //возвращает строковое представление результата
        return result;
    }

    //используем цикл для определения математической операции
    static String detectOperation(String expression) {
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else return null;
    }
    //выполнение математической операции
    static int calc(int a, int b, String oper) {

        if (oper.equals("+")) return a + b;
        else if (oper.equals("-")) return a - b;
        else if (oper.equals("*")) return a * b;
        else return a / b;
    };
}


//класс Roman содержит методы и данные для работы с римскими числами
class Roman {

    //словать romanToArab для конвертации римских в арабские
    static Map<String, Integer> romanToArab = new HashMap<>();
    //словать arabToRoman для конвертации арабских в римские
    static Map<Integer, String> arabToRoman = new HashMap<>();
    static {
        romanToArab.put("I", 1);
        romanToArab.put("II", 2);
        romanToArab.put("III", 3);
        romanToArab.put("IV", 4);
        romanToArab.put("V", 5);
        romanToArab.put("VI", 6);
        romanToArab.put("VII", 7);
        romanToArab.put("VIII", 8);
        romanToArab.put("IX", 9);
        romanToArab.put("X", 10);
        romanToArab.put("XI", 11);
        romanToArab.put("XII", 12);
        romanToArab.put("XIII", 13);
        romanToArab.put("XIV", 14);
        romanToArab.put("XV", 15);
        romanToArab.put("XVI", 16);
        romanToArab.put("XVII", 17);
        romanToArab.put("XVIII", 18);
        romanToArab.put("XIX", 19);
        romanToArab.put("XX", 20);
        romanToArab.put("XXI", 21);
        romanToArab.put("XXII", 22);
        romanToArab.put("XXIII", 23);
        romanToArab.put("XXIV", 24);
        romanToArab.put("XXV", 25);
        romanToArab.put("XXVI", 26);
        romanToArab.put("XXVII", 27);
        romanToArab.put("XXVIII", 28);
        romanToArab.put("XXIX", 29);
        romanToArab.put("XXX", 30);
        romanToArab.put("XXXI", 31);
        romanToArab.put("XXXII", 32);
        romanToArab.put("XXXIII", 33);
        romanToArab.put("XXXIV", 34);
        romanToArab.put("XXXV", 35);
        romanToArab.put("XXXVI", 36);
        romanToArab.put("XXXVII", 37);
        romanToArab.put("XXXVIII", 38);
        romanToArab.put("XXXIX", 39);
        romanToArab.put("XL", 40);
        romanToArab.put("XLI", 41);
        romanToArab.put("XLII", 42);
        romanToArab.put("XLIII", 43);
        romanToArab.put("XLIV", 44);
        romanToArab.put("XLV", 45);
        romanToArab.put("XLVI", 46);
        romanToArab.put("XLVII", 47);
        romanToArab.put("XLVIII", 48);
        romanToArab.put("XLIX", 49);
        romanToArab.put("L", 50);
        romanToArab.put("LI", 51);
        romanToArab.put("LII", 52);
        romanToArab.put("LIII", 53);
        romanToArab.put("LIV", 54);
        romanToArab.put("LV", 55);
        romanToArab.put("LVI", 56);
        romanToArab.put("LVII", 57);
        romanToArab.put("LVIII", 58);
        romanToArab.put("LIX", 59);
        romanToArab.put("LX", 60);
        romanToArab.put("LXI", 61);
        romanToArab.put("LXII", 62);
        romanToArab.put("LXIII", 63);
        romanToArab.put("LXIV", 64);
        romanToArab.put("LXV", 65);
        romanToArab.put("LXVI", 66);
        romanToArab.put("LXVII", 67);
        romanToArab.put("LXVIII", 68);
        romanToArab.put("LXIX", 69);
        romanToArab.put("LXX", 70);
        romanToArab.put("LXXI", 71);
        romanToArab.put("LXXII", 72);
        romanToArab.put("LXXIII", 73);
        romanToArab.put("LXXIV", 74);
        romanToArab.put("LXXV", 75);
        romanToArab.put("LXXVI", 76);
        romanToArab.put("LXXVII", 77);
        romanToArab.put("LXXVIII", 78);
        romanToArab.put("LXXIX", 79);
        romanToArab.put("LXXX", 80);
        romanToArab.put("LXXXI", 81);
        romanToArab.put("LXXXII", 82);
        romanToArab.put("LXXXIII", 83);
        romanToArab.put("LXXXIV", 84);
        romanToArab.put("LXXXV", 85);
        romanToArab.put("LXXXVI", 86);
        romanToArab.put("LXXXVII", 87);
        romanToArab.put("LXXXVIII", 88);
        romanToArab.put("LXXXIX", 89);
        romanToArab.put("XC", 90);
        romanToArab.put("XCI", 91);
        romanToArab.put("XCII", 92);
        romanToArab.put("XCIII", 93);
        romanToArab.put("XCIV", 94);
        romanToArab.put("XCV", 95);
        romanToArab.put("XCVI", 96);
        romanToArab.put("XCVII", 97);
        romanToArab.put("XCVIII", 98);
        romanToArab.put("XCIX", 99);
        romanToArab.put("C", 100);

        arabToRoman.put(1, "I");
        arabToRoman.put(2, "II");
        arabToRoman.put(3, "III");
        arabToRoman.put(4, "IV");
        arabToRoman.put(5, "V");
        arabToRoman.put(6, "VI");
        arabToRoman.put(7, "VII");
        arabToRoman.put(8, "VIII");
        arabToRoman.put(9, "IX");
        arabToRoman.put(10, "X");
        arabToRoman.put(11, "XI");
        arabToRoman.put(12, "XII");
        arabToRoman.put(13, "XIII");
        arabToRoman.put(14, "XIV");
        arabToRoman.put(15, "XV");
        arabToRoman.put(16, "XVI");
        arabToRoman.put(17, "XVII");
        arabToRoman.put(18, "XVIII");
        arabToRoman.put(19, "XIX");
        arabToRoman.put(20, "XX");
        arabToRoman.put(21, "XXI");
        arabToRoman.put(22, "XXII");
        arabToRoman.put(23, "XXIII");
        arabToRoman.put(24, "XXIV");
        arabToRoman.put(25, "XXV");
        arabToRoman.put(26, "XXVI");
        arabToRoman.put(27, "XXVII");
        arabToRoman.put(28, "XXVIII");
        arabToRoman.put(29, "XXIX");
        arabToRoman.put(30, "XXX");
        arabToRoman.put(31, "XXXI");
        arabToRoman.put(32, "XXXII");
        arabToRoman.put(33, "XXXIII");
        arabToRoman.put(34, "XXXIV");
        arabToRoman.put(35, "XXXV");
        arabToRoman.put(36, "XXXVI");
        arabToRoman.put(37, "XXXVII");
        arabToRoman.put(38, "XXXVIII");
        arabToRoman.put(39, "XXXIX");
        arabToRoman.put(40, "XL");
        arabToRoman.put(41, "XLI");
        arabToRoman.put(42, "XLII");
        arabToRoman.put(43, "XLIII");
        arabToRoman.put(44, "XLIV");
        arabToRoman.put(45, "XLV");
        arabToRoman.put(46, "XLVI");
        arabToRoman.put(47, "XLVII");
        arabToRoman.put(48, "XLVIII");
        arabToRoman.put(49, "XLIX");
        arabToRoman.put(50, "L");
        arabToRoman.put(51, "LI");
        arabToRoman.put(52, "LII");
        arabToRoman.put(53, "LIII");
        arabToRoman.put(54, "LIV");
        arabToRoman.put(55, "LV");
        arabToRoman.put(56, "LVI");
        arabToRoman.put(57, "LVII");
        arabToRoman.put(58, "LVIII");
        arabToRoman.put(59, "LIX");
        arabToRoman.put(60, "LX");
        arabToRoman.put(61, "LXI");
        arabToRoman.put(62, "LXII");
        arabToRoman.put(63, "LXIII");
        arabToRoman.put(64, "LXIV");
        arabToRoman.put(65, "LXV");
        arabToRoman.put(66, "LXVI");
        arabToRoman.put(67, "LXVII");
        arabToRoman.put(68, "LXVIII");
        arabToRoman.put(69, "LXIX");
        arabToRoman.put(70, "LXX");
        arabToRoman.put(71, "LXXI");
        arabToRoman.put(72, "LXXII");
        arabToRoman.put(73, "LXXIII");
        arabToRoman.put(74, "LXXIV");
        arabToRoman.put(75, "LXXV");
        arabToRoman.put(76, "LXXVI");
        arabToRoman.put(77, "LXXVII");
        arabToRoman.put(78, "LXXVIII");
        arabToRoman.put(79, "LXXIX");
        arabToRoman.put(80, "LXXX");
        arabToRoman.put(81, "LXXXI");
        arabToRoman.put(82, "LXXXII");
        arabToRoman.put(83, "LXXXIII");
        arabToRoman.put(84, "LXXXIV");
        arabToRoman.put(85, "LXXXV");
        arabToRoman.put(86, "LXXXVI");
        arabToRoman.put(87, "LXXXVII");
        arabToRoman.put(88, "LXXXVIII");
        arabToRoman.put(89, "LXXXIX");
        arabToRoman.put(90, "XC");
        arabToRoman.put(91, "XCI");
        arabToRoman.put(92, "XCII");
        arabToRoman.put(93, "XCIII");
        arabToRoman.put(94, "XCIV");
        arabToRoman.put(95, "XCV");
        arabToRoman.put(96, "XCVI");
        arabToRoman.put(97, "XCVII");
        arabToRoman.put(98, "XCVIII");
        arabToRoman.put(99, "XCIX");
        arabToRoman.put(100, "C");
    }
    //метод isRoman проверяет содержится ли переданное значение val в словаре romanToArab,если да то оно является римским числом
    static boolean isRoman(String val) {
        return romanToArab.containsKey(val);

    }
    //метод convertToArabian преобразует римское число в арабское, ища соответствующее римское число в словаре romanToArab
    static int convertToArabian(String roman) {
        return romanToArab.get(roman);
    }
    //метод convertToRoman выполняет обратное преобразование, арабское число обратно в римское для коректного вывода ответа
    static String convertToRoman(int arabian) {
        return arabToRoman.get(arabian);
    }

}