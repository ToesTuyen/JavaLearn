import Model.Student;

import java.util.Scanner;

public class BaiTap_1 {
    public static int enter() {
        Scanner input = new Scanner(System.in);
        boolean check = false;
        int number = 0;
        Student student = new Student("Tuyen");
        while (!check) {
            System.out.print(" ");
            try {
                number = input.nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("You must enter number, try again...");
                input.nextLine();
            }
        }
        return (number);
    }

    public static int totalNumber(int number) {
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return (sum);
    }

    //Function tests prime numbers
    public static boolean checkPrimeNumber(int number) {
        if (number > 1) {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public static void analyzeNumber(int number) {
        int i = 2;
        System.out.print("Number " + number + " after analyze: n=");

        while (number > 1) {
            if (checkPrimeNumber(i) && number % i == 0) {
                System.out.print(i + ".");
                number /= i;
            } else i++;
        }
    }

    public static void listDivisions(int number) {
        System.out.print("\nDivisions of " + number + " is:");
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.print(" " + i);
            }
        }
    }

    public static void writePNFromList(int number) {
        System.out.print("\nDivisions of " + number + " is:");
        for (int i = 1; i <= number; i++) {
            if (number % i == 0 && (checkPrimeNumber(i))) {
                System.out.print(" " + i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("Import n:n=");
        int number = enter();
        System.out.println("Sum of the digits of " + number + " is: " + totalNumber(number));
        analyzeNumber(number);
        listDivisions(number);
        writePNFromList(number);
    }
}
