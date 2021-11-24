/*
 * 과제: homework08
 * 작성: 201735030 이호민
 * 파일: Main.java
 */
import java.util.Scanner;
import java.lang.Comparable;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정렬하고자 하는 수의 갯수>> ");
        int num = sc.nextInt();

        Comparable<Integer>[] arr = new Comparable[num + 1];
        System.out.print("수 입력>> ");
        for (int i = 1; i < num + 1; i++) { arr[i] = sc.nextInt(); }
        System.out.println();

        Comparable<Integer>[] arr1 = arr;
        Timer.startTimer();
        Heap.sort(arr1);
        Timer.printTimer("힙");
        for (int i = 1; i < num + 1; i++) { System.out.print(arr1[i] + " "); }

        Comparable<Integer>[] arr2 = new Comparable[num];
        for (int i = 0; i < num; i++) { arr2[i] = arr[i + 1]; }
        Timer.startTimer();
        Merge.sort(arr2);
        Timer.printTimer("합병");
        for (int i = 0; i < num; i++) { System.out.print(arr2[i] + " "); }

        Comparable<Integer>[] arr3 = new Comparable[num];
        for (int i = 0; i < num; i++) { arr3[i] = arr[i + 1]; }
        Timer.startTimer();
        Quick.sort(arr3);
        Timer.printTimer("퀵");
        for (int i = 0; i < num; i++) { System.out.print(arr3[i] + " "); }
    }
}
