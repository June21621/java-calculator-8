package calculator;

import java.util.Scanner;

public class Application {
    // 커스텀 구분자를 ','로 바꾸는 함수
    private static String OtherSymbol(String s, char ch) {
        StringBuilder result = new StringBuilder();

        try {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ch) {
                    result.append(',');
                } else {
                    result.append(s.charAt(i));
                }
            }
            return result.toString();
        }
        catch (Exception e) {
            throw new IllegalArgumentException("잘못된 값이 입력됨", e);
        }
    }

    // 문자열을 나눠서 더하는 함수
    private static int PlusMethod (String line) {
        int result = 0;
        StringBuilder token = new StringBuilder("0");

        try {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ',' || line.charAt(i) == ':') {
                    result += Integer.parseInt(token.toString());
                    token = new StringBuilder("0");
                } else {
                    token.append(line.charAt(i));
                }
            }
            result += Integer.parseInt(token.toString());

            return result;
        }
        catch (Exception e) {
            throw new IllegalArgumentException("잘못된 값이 입력됨", e);
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
        String inputWord;
        char ch = ',';

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        try {
            inputWord = scanner.nextLine();
            // 커스텀 구분자를 사용할 경우 커스텀 구분자를 ,로 바꾸기
            if (inputWord.startsWith("//")) {
                ch = inputWord.charAt(2);
                inputWord = OtherSymbol(scanner.next(), ch);
            }
            System.out.println("결과 : " + PlusMethod(inputWord));
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
