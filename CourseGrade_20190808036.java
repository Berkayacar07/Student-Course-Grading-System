/**
 * @author Berkay Acar
{25.12.2020}
 */
import java.util.Scanner;
public class CourseGrade_20190808036 {
    static Scanner input = new Scanner(System.in);
    static String[] menu = {"Please enter a choice below:", "1 - Enter all"
       + " grades", "2 - Change a single grade", "3 - Display grade "
                             + "information", "0 - to Exit"};
    static String[] category = {"quiz", "midterm", "homework", "final "};
    static int[] quantity = {1, 2, 1, 1};
    static int[] weight = {100, 0, 0, 0};
    static int totalWeight = 0;
    static double[][] grade = new double[category.length][];
    static double sum;
    static double all =0;

    public static int displayMenu(String[] item, Scanner input) {
        for (String s : menu) {
            System.out.println(s);
        }
        return input.nextInt();
    }

    public static boolean validQuantity(int quantity) {
        return quantity > 0;
    }

    public static boolean validWeight(int weight, int totalWeight) {
        return weight < 0 || weight + totalWeight > 100;
    }
    public static String gradeLetter(double avarage) {
        String letter;
        if (avarage >= 88 && avarage <= 100) letter = "AA";
        else if (avarage >= 81) letter = "BA";
        else if (avarage >= 74) letter = "BB";
        else if (avarage >= 67) letter = "CB";
        else if (avarage >= 60) letter = "CC";
        else if (avarage >= 53) letter = "DC";
        else if (avarage >= 46) letter = "DD";
        else if (avarage >= 35) letter = "FD";
        else if (avarage >= 0) letter = "FF";
        else letter = "";
        return letter;
    }

    public static double gpaPoints(double avarage) {
        double points;
        if (avarage >= 88 && avarage <= 100) points = 4.0;
        else if (avarage >= 81) points = 3.5;
        else if (avarage >= 74) points = 3.0;
        else if (avarage >= 67) points = 2.5;
        else if (avarage >= 60) points = 2.0;
        else if (avarage >= 53) points = 1.5;
        else if (avarage >= 46) points = 1.0;
        else if (avarage >= 35) points = 0.5;
        else if (avarage >= 0) points = 0.0;
        else points = -1;
        return points;
    }

    public static String status(double avarage) {

        String status;
        if (avarage >= 88 && avarage <= 100) status = "passed";
        else if (avarage >= 81) status = "passed";
        else if (avarage >= 74) status = "passed";
        else if (avarage >= 67) status = "passed";
        else if (avarage >= 60) status = "passed";
        else if (avarage >= 53) status = "conditionally passed";
        else if (avarage >= 46) status = "conditionally passed";
        else if (avarage >= 35) status = "failed";
        else if (avarage >= 0) status = "failed";
        else status = "";
        return status;
    }

    public static double avarage(double[] a) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum / a.length;
    }
    public static void capitalize(String[] category) {
        for (int i = 0; i < category.length; i++) {
            category[i] = category[i].substring(0, 1).toUpperCase()
                          + category[i].substring(1).toLowerCase();
        }
    }

    public static void courseGrade(String[] category, int[] quantity,
                                   int[] weight) {
        capitalize(category);
        for (int s : quantity) {
            if (!validQuantity(s)) {
                System.out.println("ERROR: Invalid quantity entered.");
                System.exit(0);
            }
        }
        for (int i = 0; i < weight.length; i++) {
            if (validWeight(weight[i], totalWeight)) {
                System.out.println("ERROR: Invalid weight entered.");
                System.exit(0);
            }
            totalWeight += weight[i];
        }
        for (int j = 0; j < quantity.length; j++) {
            double[] arr1 = new double[quantity[j]];
            for (int i = 0; i < quantity[j]; i++) {
                arr1[i] = 0;
            }
            grade[j] = arr1;
        }
        int a;
        do {
            a = displayMenu(menu, input);
            if(a<0||a>3)
               System.out.println("Invalid choice.");
            else if (a == 1) {
                for (int j = 0; j < quantity.length; j++) {
                    double[] arr1 = new double[quantity[j]];
                    for (int i = 0; i < quantity[j]; i++) {
                        System.out.println("Please enter grade for " + category[j]
                                           + (i + 1));
                        arr1[i] = input.nextDouble();
                    }
                    grade[j] = arr1;
                }
            } else if (a == 2) {
                System.out.println("Please enter the category");
                for (int i = 0; i < category.length; i++) {
                    System.out.println((i + 1) + " - " + category[i]);
                }
                System.out.println("0- to Exit");
                int choice = input.nextInt();
                 if (choice < 0 || choice > category.length) {
                    System.out.println("Invalid choice"); }
                    else if(choice==0){
                     System.out.println();
                    }
                        else{
                        for (int i = 0; i < category.length; i++) {
                    if (choice == i) {
                        System.out.print("Please enter which " + category[i - 1] +
                                         " you would like to change " +
                                         ("(1 - " + quantity[i - 1]) + ") "
                                         + ">>");
                    }
                }
                int b = input.nextInt();
                if (b > quantity[choice-1] || b <= 0) {
                    System.out.println("Invalid choice");
                } else {
                    System.out.println("The current grade for "
                                       + category[choice - 1] + " " + b + " "
                                       + "is " + grade[choice - 1][b - 1]);
                    System.out.println("Please enter the new grade value "
                                       + ">>");
                    grade[choice - 1][b - 1] = input.nextDouble();
                } }
            } else if (a == 3) {
                all = 0;
                System.out.println("Category information:");
                for (int i = 0; i < category.length; i++) {
                    double[] array = new double[quantity[i]];
                    for (int j = 0; j < quantity[i]; j++) {
                        array[j] = grade[i][j];
                    }
                    System.out.println(category[i] + " - " + avarage(array));
                    all += avarage(array) * weight[i] /100;
                    }
                System.out.println("\nOverall Grade - " + all);
                System.out.println("Grade Letter - " +gradeLetter(all));
                System.out.println("GPA Points - " + gpaPoints(all));
                System.out.println("Status - " + status(all));
        } }
            while (a != 0) ;
        System.out.println("Thank you for using our system. Have a nice day.");
        }
        public static void main(String[] args) {
        courseGrade(category, quantity, weight);
    }
}
