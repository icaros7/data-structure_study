/*
 * 과제: homework01
 * 이름: 이호민
 * 학번: 201735030
 */

import java.util.Comparator;

public class Student implements Comparable<Student> {
    public static final Comparator<Student> WITH_NAME = new WithName();
    public static final Comparator<Student> WITH_DEPT = new WithDept();
    public static final Comparator<Student> WITH_GRADE = new WithGrade();

    private int ID;
    private String name;
    private String dept;
    private int grade;

    // 생성자
    public Student(int IDIn, String nameIn, String deptIn, int gradeIn) {
        this.ID = IDIn;
        this.name = nameIn;
        this.dept = deptIn;
        this.grade = gradeIn;
    }

    // 필드 값 반환 메서드
    public int getID() { return ID; }
    public String getName() { return name; }
    public String getDept() { return dept; }
    public int getGrade() { return grade; }

    // 이름 값 비교 compare()
    public static class WithName implements Comparator<Student>{
        public int compare(Student s1, Student s2) { return s1.name.compareTo(s2.name); }
    }

    // 학과이름 비교 compare()
    public static class WithDept implements Comparator<Student>{
        public int compare(Student s1, Student s2){
            return s1.dept.compareTo(s2.dept);
        }
    }

    // 학년 비교 compare()
    public static class WithGrade implements Comparator<Student>{
        public int compare(Student s1, Student s2){
            if (s1.grade == s2.grade){ return s2.compareTo(s1); }
            return s1.grade - s2.grade;
        }
    }

    // 학번 비교 compareTo()
    public int compareTo(Student s1){ return this.ID - s1.ID; }
}