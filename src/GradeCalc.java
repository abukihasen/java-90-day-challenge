import java.util.Scanner;
public class GradeCalc {
     public static void main(String[] args ){
        Scanner input=new Scanner(System.in);
        System.out.println("==Welcome to Grade Calculator==");
        for (int i=0;i<5;i++) {
            System.out.println("Student "+ (i + 1));
            System.out.print("Enter your grade: ");
            double score;


            score = input.nextDouble();
            boolean passed = false;
            char grade;
            while (!passed) {
                if (score < 0 || score > 100) {
                    System.out.println(" X Invalid Score  please try again");

                    System.out.print("Enter your grade: ");
                    score = input.nextDouble();
                } else {
                    passed = true;
                }
            }

            if (score >= 90) {
                grade = 'A';
            } else if (score >= 80) {
                grade = 'B';
            } else if (score >= 70) {
                grade = 'C';
            } else if (score >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }
            switch (grade) {
                case 'A' -> System.out.println("Excellent, your grade is  A");


                case 'B' -> System.out.println("Very good, your grade is  B");

                case 'C' -> System.out.println("Good, your grade is  C");

                case 'D' -> System.out.println("not bad , your grade is  D");

                case 'F' -> System.out.println("Try next , your grade is  F");

                default -> System.out.println("!error");
            }
        }
        input.close();
    }
}
