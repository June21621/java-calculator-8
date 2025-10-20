package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    // 커스텀 구분자를 ','로 바꾸는 함수
    private static String OtherSymbol(String s, char ch) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                result.append(',');
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    // 문자열을 나눠서 더하는 함수
    private static int PlusMethod (String line) {
        int result = 0;
        StringBuilder token = new StringBuilder("0");

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ',' || line.charAt(i) == ':') {
                int num = Integer.parseInt(token.toString());
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 사용할 수 없습니다.");
                }
                result += num;
                token = new StringBuilder("0");
            } else {
                token.append(line.charAt(i));
            }
        }
        int num = Integer.parseInt(token.toString());
        if (num < 0) {
            throw new IllegalArgumentException("음수는 사용할 수 없습니다.");
        }
        result += num;

        return result;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputWord;
        char ch = ',';

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        inputWord = Console.readLine();
        // 커스텀 구분자를 사용할 경우 커스텀 구분자를 ,로 바꾸기
        if (inputWord.startsWith("//")) {
            ch = inputWord.charAt(2);
            inputWord = inputWord.substring(5); // "//;\n" 이후 데이터
            inputWord = OtherSymbol(inputWord, ch);
        }
        System.out.println("결과 : " + PlusMethod(inputWord));

    }
}
