package ZooLights;
import java.util.Scanner;

public class ZooLights {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //initaliza variables
        int numPpl;
        String[] names;
        String day;
        String dCode;
        int[] ages;
        double[] weights;
        int[] heights;
        String[] birthdays;
        System.out.println("Would you like to drive or walk? (input d/w)");

        //drivers
        if (input.nextLine().equals("d")){
            System.out.println("How many people are in your party? > ");
            numPpl = input.nextInt();
            System.out.println("What is your name? > ");
            names = new String[1];
            names[0] = input.next();
            System.out.println("What is your age? > ");
            ages = new int[1];
            ages[0] = input.nextInt();
            System.out.println("What day will you attend? > ");
            day = input.next();
            System.out.println("Enter any discount codes > ");
            dCode = input.next();

            //walkers
        }else{
            System.out.println("How many people are in your party? > ");
            numPpl = input.nextInt();
            // sets array lengths
            names = new String[numPpl];
            ages = new int[numPpl];
            weights = new double[numPpl];
            heights = new int[numPpl];
            birthdays = new String[numPpl];
            //questions
            for (int i=0; i<numPpl; i++){
                System.out.println("Party member #" + (i+1) + ".");
                System.out.println("Name? > ");
                names[i] = input.next();
                System.out.println("Age? > ");
                ages[i] = input.nextInt();
                System.out.println("Would you like to ride the train? (y/n) > ");
                if(input.next().equals("y")){
                    System.out.println("Weight? (lb) > ");
                    weights[i] = input.nextDouble();
                    System.out.println("Height? (in) > ");
                    heights[i] = input.nextInt();
                }
                System.out.println("Date of Birth? > ");
                birthdays[i] = input.next();
            }
            System.out.println("What day do you plan on attending? > ");
            day = input.next();
            System.out.println("Enter any discount codes > ");
            dCode = input.next();
        }
    }
}

