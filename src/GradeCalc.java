import java.util.Scanner;
public class GradeCalc {
     public static void main(String[] args ) {
         Scanner input = new Scanner(System.in);
         System.out.println("==Welcome to Grade Calculator==");
         double mark=-1.0;
         char grade;

        
         for (int i = 0; i < 5; i++) {
             System.out.println("Subject " + (i + 1));
             do {
                 System.out.print("Enter your Exam Mark [0-100]: ");
                 if (input.hasNextDouble()) {
                     mark = input.nextDouble();
                     if (mark < 0 || mark > 100) {
                         System.out.println(" X Invalid! Mark must be between 0 and 100\n");
                     }
                 }else {
                     System.out.println("Invalid! input please Enter a valid numeric value");
                     mark=-1;
                     input.next();

                 }
                 }while (mark < 0 || mark > 100);


                     if (mark >= 90) {
                         grade = 'A';
                     } else if (mark >= 80) {
                         grade = 'B';
                     } else if (mark >= 70) {
                         grade = 'C';
                     } else if (mark >= 60) {
                         grade = 'D';
                     } else {
                         grade = 'F';
                     }
                 switch (grade) {
                     case 'A' -> System.out.println("Distinction! Outstanding performance");

                     case 'B' -> System.out.println("Very good, Upper Division pass.");

                     case 'C' -> System.out.println("satisfactory pass");

                     case 'D' -> System.out.println("Conditional pass. Support Recommended");

                     case 'F' -> System.out.println("Unsatisfactory. Academic re-evaluation required");

                     default -> System.out.println("!error");
                 }

             }
         input.close();
         }
     }
