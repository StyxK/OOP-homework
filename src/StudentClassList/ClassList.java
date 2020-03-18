package StudentClassList;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class ClassList {
    private String fileName;
    private int numberOfStudents;
    private int[] numberOfStudentsWithGrade = new int[8];
    
    public ClassList(String file,int n) throws IOException{
        this.fileName = file;
        this.numberOfStudents = n;
        generateStudentRecordsToFile();
    }
    
    private void generateStudentRecordsToFile() throws IOException{
        Random rand = new Random();
        FileWriter fileWriter = new FileWriter("C:\\Users\\StyxK\\Documents\\test spring\\OOP_homework\\src\\StudentClassList\\"+fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for(int i=0;i<numberOfStudents;i++){
            printWriter.println(rand.nextInt(1000)+" "+rand.nextInt(100));
        }
        printWriter.close();
    }
    
    public int countGrade(String grade,int lowerBound,int upperBound) throws FileNotFoundException{
        int count = 0;
        Scanner file = new Scanner(new FileReader("C:\\Users\\StyxK\\Documents\\test spring\\OOP_homework\\src\\StudentClassList\\"+fileName));
        while(file.hasNextLine()){
            String s = file.nextLine();
            int score = Integer.parseInt(s.split(" ")[1]);
            if(score>=lowerBound && score<=upperBound){
                ++count;
            }
        }
        if(grade.equalsIgnoreCase("A"))this.numberOfStudentsWithGrade[0]=count;
        else if(grade.equalsIgnoreCase("B+"))this.numberOfStudentsWithGrade[1]=count;
        else if(grade.equalsIgnoreCase("B"))this.numberOfStudentsWithGrade[2]=count;
        else if(grade.equalsIgnoreCase("C+"))this.numberOfStudentsWithGrade[3]=count;
        else if(grade.equalsIgnoreCase("C"))this.numberOfStudentsWithGrade[4]=count;
        else if(grade.equalsIgnoreCase("D+"))this.numberOfStudentsWithGrade[5]=count;
        else if(grade.equalsIgnoreCase("D"))this.numberOfStudentsWithGrade[6]=count;
        else if(grade.equalsIgnoreCase("F"))this.numberOfStudentsWithGrade[7]=count;
        return count;
    }
}
