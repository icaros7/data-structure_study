/*
 * 과제: homework03
 * 이름: 이호민
 * 학번: 201735030
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // 후위 표기법 변환 메서드
    private static String toInfix(String usr) {
        String out = ""; // 변환 결과 값 저장
        ListStack<String> st = new ListStack<String>(); // 저장용 Singly Linked List 기반 Stack
        String[] oper = {"+", "-", "*", "/", "%", "{", "[", "(", ")", "]", "}"}; // 연산자 배열

        for (char c: usr.toCharArray()) {
            if (Arrays.asList(oper).contains(c + "")) { // String 형 변환하여 연산자 혹은 괄호 인지 확인
                if (c == ')') {
                    while (!st.isEmpty() && st.peek().charAt(0) != '(') {
                        out += st.pop() + " ";
                    }
                    st.pop();
                }
                else if (c == ']') {
                    while (!st.isEmpty() && st.peek().charAt(0) != '[') {
                        out += st.pop() + " ";
                    }
                    st.pop();
                }
                else if (c == '}') {
                    while (!st.isEmpty() && st.peek().charAt(0) != '{') {
                        out += st.pop() + " ";
                    }
                    st.pop();
                }
                else {
                    // 연산자 일 경우 우선순위 처리
                    while (!st.isEmpty() && opPriority(c, st.peek().charAt(0))) {
                        out += st.pop() + " ";
                    }
                    st.push(c + "");
                }
            }
            else { // 숫자 일 경우 바로 out 출력
                out += c + " ";
            }
        }

        // 남은 연산자 처리
        while(!st.isEmpty()) {
            out += st.pop() + " ";
        }

        return out;
    }

    // 연산자 우선 순위 처리 메서드
    private static boolean opPriority(char masterOp, char slaveOp) {
        Character[] ch = {'*', '/', '%'};
        switch (masterOp) {
            case '+':
            case '-':
                if (Arrays.asList(ch).contains(slaveOp)) { return true; }
                else if (slaveOp == '+' || slaveOp == '-') { return true; }
            case '*':
            case '/':
            case '%':
                if (Arrays.asList(ch).contains(slaveOp)) { return true; }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String usrValue;

        while (true) {
            System.out.print("수식: ");
            usrValue = sc.nextLine();

            if (usrValue.equals("")) { break; } // Return 키가 입력 되는 경우 종료

            usrValue = usrValue.replaceAll(" ", ""); // 모든 공백 제거
            System.out.println("값: " + toInfix(usrValue));
        }

        sc.close(); // 명시적 close() 호출
    }
}
