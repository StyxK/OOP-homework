package StudentClassList;

import java.io.IOException;

public class ClassListExecutor {
    public static void main(String [] args) throws IOException{
        ClassList c1 = new ClassList("CS111_62.dat",10);
        int gradeA = c1.countGrade("A",80,100);
        System.out.println("A: "+gradeA);
        int gradeBPlus = c1.countGrade("B+",70,79);
        System.out.println("B+: "+gradeBPlus);
        int gradeB = c1.countGrade("B",66,69);
        System.out.println("B: "+gradeB);
        int gradeCPlus = c1.countGrade("C+",61,65);
        System.out.println("C+: "+gradeCPlus);
        int gradeC = c1.countGrade("C",51,60);
        System.out.println("C: "+gradeC);
        int gradeDPlus = c1.countGrade("D+",46,50);
        System.out.println("D+: "+gradeDPlus);
        int gradeD = c1.countGrade("D",41,45);
        System.out.println("C: "+gradeB);
        int gradeF = c1.countGrade("F",0,40);
        System.out.println("F: "+gradeF);
    }
}
