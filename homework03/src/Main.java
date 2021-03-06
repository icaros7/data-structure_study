/*
 * 과제: homework03
 * 이름: 이호민
 * 학번: 201735030
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // 연산자 우선 순위 처리 메서드
    private static boolean opPriority(char masterOp, char slaveOp) {
        Character[] ch = {'*', '/', '%'};
        if (masterOp == '+' || masterOp == '-') {
            if (Arrays.asList(ch).contains(slaveOp)) { return true; }
            else return slaveOp == '+' || slaveOp == '-';
        }
        else if (masterOp == '*' || masterOp == '/' || masterOp == '%') {
            return Arrays.asList(ch).contains(slaveOp);
        }

        return false;
    }

    // 후위 표기법 변환 메서드
    private static String toInfix(char[] usr) {
        ListStack<String> st = new ListStack<>(); // 저장용 Singly Linked List 기반 Stack
        String[] operator = {"+", "-", "*", "/", "%", "{", "[", "(", ")", "]", "}"}; // 연산자 배열
        StringBuilder out = new StringBuilder(); // 변환 결과 값 저장

        for (char c: usr) {
            if (Arrays.asList(operator).contains(c + "")) { // String 형 변환하여 연산자 혹은 괄호 인지 확인
                if (c == ')') {
                    while ((!st.isEmpty()) && (st.peek().charAt(0) != '(')) { out.append(st.pop()).append(" "); }
                    st.pop();
                }
                else if (c == ']') {
                    while ((!st.isEmpty()) && (st.peek().charAt(0) != '[')) { out.append(st.pop()).append(" "); }
                    st.pop();
                }
                else if (c == '}') {
                    while ((!st.isEmpty()) && (st.peek().charAt(0) != '{')) { out.append(st.pop()).append(" "); }
                    st.pop();
                }
                else {
                    // 연산자 일 경우 우선순위 처리
                    while ((!st.isEmpty()) && (opPriority(c, st.peek().charAt(0)))) { out.append(st.pop()).append(" "); }
                    st.push(c + "");
                }
            }

            // 숫자 일 경우 바로 out 출력
            else { out.append(c).append(" "); }
        }

        // 남은 연산자 처리
        if (!st.isEmpty()) { for (int i = 0; i < st.size(); i++) { out.append(st.pop()).append(" "); } }

        return out.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String usrValue;

        while (true) {
            System.out.print("수식: ");
            usrValue = sc.nextLine();

            if (usrValue.equals("")) { break; } // Return 키가 입력 되는 경우 종료

            usrValue = usrValue.replaceAll(" ", ""); // 모든 공백 제거
            System.out.println("값: " + toInfix(usrValue.toCharArray()));
        }

        sc.close(); // 명시적 close() 호출
    }
}
