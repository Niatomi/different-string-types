package praktika7;
import java.util.Scanner;
public class Main {
    
    /**
    * Перовое задание. 
    * Конкатенация чисел от 0 до 10000
    * Реализация через String
    * @return conc сформированная строка от 0 до 10000
    */
    public static String PartA() {
        String conc = "";
        for (int i = 0; i < 10000; i++) {
        conc += i;
        } 
        return conc;
    }
    
    /**
    * Перовое задание. 
    * Конкатенация чисел от 0 до 10000
    * Реализация через StringBuilder
    * @return conc сформированная строка от 0 до 10000
    */
    public static String PartB() {
        StringBuilder conc = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            conc.append(i);
        }
        return conc.toString();
    }
    
    /**
    * Перовое задание. 
    * Конкатенация чисел от 0 до 10000
    * Реализация через StringBuffer
    * @return conc сформированная строка от 0 до 10000
    */
    public static String PartC() {
        StringBuffer conc = new StringBuffer();
        for (int i = 0; i < 10000; i++) {
            conc.append(i);
        }
        return conc.toString();
    }
    
    /**
    * Второе задание. 
    * Изменение строки в зависимости от её размера
    * @param s исходная строка 
    * @param new_length длина новой исходной строки
    * @param symbol символ-заменитель 
    * @return new_string изменённая строка
    */
    public static StringBuilder Second(String s, int new_length, char symbol) {
        StringBuilder new_string = new StringBuilder(s);
        StringBuilder buffer = new StringBuilder();
        if (new_length >= new_string.length()) {
            for (int i = new_string.length(); i < new_length; i++) {
                buffer.append(symbol);
            }
            buffer.append(s);
            new_string = buffer;
        } else {
            new_string.setLength(new_length);
        }
        return new_string;
    }
    
    /**
    * Третье задание. 
    * Изменение строки в зависимости от её размера
    * @param s исходная строка 
    * @param new_length длина новой исходной строки
    * @param line строка-заменитель 
    * @return new_string изменённая строка
    */
    public static StringBuilder Third(String s, int new_length, String line) {
        StringBuilder new_string = new StringBuilder(s);
        StringBuilder buffer = new StringBuilder();
        char[] arr_chars = line.toCharArray();
        if (new_length >= new_string.length()) {
            for (int i = 0; i < (new_length - s.length()); i++) {
                buffer.append(arr_chars[(i % arr_chars.length)]);
            }
            buffer.append(s);
            new_string = buffer;
        } else {
            new_string.setLength(new_length);
        }
        return new_string;
    }
    
    /**
    * Четвёртое задание. 
    * Моноалфавитное шифрование
    * Выводит зашифрованную строку
    * Передаёт закодированную строку в дешифратор FourthB
    * @param line изнчальная строка
    * @param key ключ шифрования
    */
    public static void FourthA(String line, int key) {
        StringBuilder coded = new StringBuilder();
        char[] arr_line = line.toCharArray();
        int[] code_arr = new int[arr_line.length];
        for (int i = 0; i < code_arr.length; i++) {
            code_arr[i] = (int) arr_line[i];
        }
        int[] arr_key = new int[(Integer.toString(key)).length()];
        for (int i = 0; i < arr_key.length; i++) {    
            arr_key[i] = (Integer.toString(key)).charAt(i) - '0';
        }
        for (int i = 0; i < arr_line.length; i++) {
            coded.append((char) (arr_line[i] + arr_key[i % arr_key.length]));

        }
        System.out.println(coded);
        FourthB(coded.toString(), key);
    }
    
    /**
    * Четвёртое задание. 
    * Моноалфавитное дешифрование
    * Выводит изначальную строку
    * @param line закодированная строка
    * @param key ключ шифрования
    */
    public static void FourthB(String line, int key) {
        StringBuilder coded = new StringBuilder();
        char[] arr_line = line.toCharArray();
        int[] code_arr = new int[arr_line.length];
        for (int i = 0; i < code_arr.length; i++) {
            code_arr[i] = (int) arr_line[i];
        }
        int[] arr_key = new int[(Integer.toString(key)).length()];
        for (int i = 0; i < arr_key.length; i++) {
            arr_key[i] = (Integer.toString(key)).charAt(i) - '0';
        }
        for (int i = 0; i < arr_line.length; i++) {   
            coded.append((char) ((int) (arr_line[i] - arr_key[i % arr_key.length])));
        }
        System.out.println(coded);
    }
    
    /**
     * Метод с которого начинается программа.
     *
     * @param args
     */
     public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        //String
        long num2, num1 = System.currentTimeMillis();
        String str = PartA();
        num2 = System.currentTimeMillis();
        long num3;
        num3 = (num2 - num1);
        System.out.println(num3);

        //String Builder
        num1 = System.currentTimeMillis();
        str = PartB();
        num2 = System.currentTimeMillis();
        num3 = (num2 - num1);
        System.out.println(num3);

        //String Buffer
        num1 = System.currentTimeMillis();
        str = PartC();
        num2 = System.currentTimeMillis();
        num3 = (num2 - num1);
        System.out.println(num3);
        
        //Второе задание
        String line = sc.nextLine();
        int length = sc.nextInt();
        char symbol = sc.next().charAt(0);
        System.out.println(Second(line, length, symbol));
        
        //Третье задание
        String line3 = sc.nextLine();
        line3 = sc.nextLine();
        short length3 = sc.nextShort();
        String s = sc.nextLine();
        s = sc.nextLine();
        System.out.println(Third(line3,length3, s));

        //Четвёртое задание
        //Использование русских символов в вводе приводит к неправильному их отображению
        //При вводе на русском непосредственно в  методе этой ошибки нет
        line = sc.nextLine();
        int key = sc.nextInt();
        FourthA(line, key);

    }
}
