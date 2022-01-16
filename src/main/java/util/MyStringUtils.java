package util;

import java.util.List;

import static java.lang.Character.UnicodeBlock.*;

public class MyStringUtils {

    private static final List<Character> numberList = List.of('1', '2', '3', '4', '5', '6', '7', '8', '9');

    public static boolean isBlank(String line){
        return (line == null || line.trim().length() == 0);
    }

    public static boolean startWithNumber(String line) {
        if (isBlank(line)) return false;
        return numberList.contains(line.charAt(0));
    }

    public static boolean startWithChinese(String line) {
        if (isBlank(line)) return false;
        return checkCharContainChinese(line.charAt(0));
    }

    private static boolean checkCharContainChinese(char checkChar){
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(checkChar);
        return CJK_UNIFIED_IDEOGRAPHS == ub || CJK_COMPATIBILITY_IDEOGRAPHS == ub || CJK_COMPATIBILITY_FORMS == ub ||
                CJK_RADICALS_SUPPLEMENT == ub || CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A == ub || CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B == ub;
    }

    public static int getIndexOfFirstChinese(String line){
        if (isBlank(line)) return -1;
        for (int i = 0; i < line.length(); i++) {
            if (checkCharContainChinese(line.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void addTwoLineSeparator(StringBuilder stringBuilder){
        stringBuilder.append(System.lineSeparator()).append(System.lineSeparator());
    }

    public static void addLineSeparator(StringBuilder stringBuilder){
        stringBuilder.append(System.lineSeparator());
    }

    public static void main(String[] args) {
//        System.out.println(startWithNumber("1. Hello! / Hi! 你好！"));
//        System.out.println(checkCharContainChinese("1你好".charAt(0)));
//        System.out.println(getIndexOfFirstChinese("1你好"));
        System.out.println(startWithChinese("1你好"));
    }
}
