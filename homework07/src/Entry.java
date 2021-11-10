/*
 * 과제: homework07
 * 작성: 201735030 이호민
 * 파일: Entry.java
 */

public class Entry {
    private int frequency;      // 빈도 수
    private String word;        // 리프 노드의 문자 또는 내부 노드의 합성된 문자열
    private Entry left;         // 왼쪽 자식
    private Entry right;        // 오른쪽 자식
    private String code;        // 허프만 코드

    public Entry (int newFreq, String newValue, Entry l, Entry r, String s) {
        frequency = newFreq;
        word = newValue;
        left = l;
        right = r;
        code = s;
    }

    // getter
    public int getKey() { return frequency; }
    public String getValue() { return word; }
    public String getCode() { return code; }
    public Entry getLeft() { return left; }
    public Entry getRight() { return right; }

    // setter
    public void setCode(String newCode) { code = newCode; }
}
