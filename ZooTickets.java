import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;
import java.time.LocalDate;

public class ZooTickets {

    public static void main(String[] args) {

        ArrayList<Ticket> ticketList = new ArrayList<Ticket>(); // max 100 tickets can be stored
        ArrayList<Check> checkList = new ArrayList<Check>(); // max 100 checks can be stored

        Scanner input = new Scanner(System.in);

        String sellOrLookup;

        System.out.println("Welcome to the Zoo Tickets Application");
        System.out.println("Would you like to look up or sell tickets? (sell/look) > ");

        sellOrLookup = input.nextLine();

        if (sellOrLookup.equalsIgnoreCase("sell")) {
            sellTickets(ticketList);
        }


    }

    public static void sellTickets(ArrayList<Ticket> ticketList) {

        Scanner input = new Scanner(System.in);

        String id = generateId(ticketList); // checkId
        int numPeople;
        String driveOrWalk;
        String dataAttend;
        String haveDiscountCodeInput;
        boolean haveDiscountCode = false;
        boolean discountCodeValid = false;

        System.out.println("Drive-through or walkthrough? (w/d) > ");
        driveOrWalk = input.nextLine();
        System.out.println("How many people are in the party?  > ");
        numPeople = input.nextInt();
        input.nextLine();
        System.out.println("When do they want to attend? (mm/dd/yyyy)  > ");
        dataAttend = input.nextLine();
        System.out.println("Do they have a discount code? (yes/no)  > ");
        haveDiscountCodeInput = input.nextLine();

        if (haveDiscountCodeInput.equalsIgnoreCase("yes") ||
                haveDiscountCodeInput.equalsIgnoreCase("y") ||
                haveDiscountCodeInput.equalsIgnoreCase("true"))
        {
            haveDiscountCode = true;
        }

        if (haveDiscountCode) {
            String code;
            System.out.println("Enter discount code > ");
            code = input.nextLine();
            if (code.equalsIgnoreCase("MEMBER")) {
                discountCodeValid = true;
            }
        }

        Check check = new Check(id,discountCodeValid);

        if (driveOrWalk.equals("w")) {

            for (int i = 1; i <= numPeople; i++) {

                String ticketId = generateId(ticketList);

                System.out.println("Fill in information for person #" + i + ":");

                String name;
                int age;
                int height; // inches
                int weight; // pounds

                System.out.println("Full name > ");
                name = input.nextLine();
                System.out.println("Date of birth (mm/dd/yyyy) > ");
                age = getAgeFromDateAtTimeOfAttendance(input.nextLine(),dataAttend);
                System.out.println("Height (ft'in)  > ");
                height = getHeightInInches(input.nextLine());
                System.out.println("Weight (lb) > ");
                weight = input.nextInt();
                input.nextLine();

                Ticket ticket = new Ticket(ticketId,name,getDayOfWeekFromDate(dataAttend),age,height,weight,true,check);

                ticketList.add(ticket);

                check.tickets.add(ticket);

            }

        } else if (driveOrWalk.equals("d")) {
            System.out.println("Fill in information for driver");

            String name;
            int age;

            System.out.println("Driver full name > ");
            name = input.nextLine();
            System.out.println("Date of birth (mm/dd/yyyy) > ");
            age = getAgeFromDateAtTimeOfAttendance(input.nextLine(),dataAttend);

            Ticket ticket = new Ticket(id,name,getDayOfWeekFromDate(dataAttend),age,0,0,false,check);
            ticket.numPeople = numPeople;

            ticketList.add(ticket);

        }

        for (int i = 0;i<numPeople;i++) {
            ticketList.get(i).DisplayTicket();
        }

    }

    public static int getNextEmptySpot(int[] list) {
        for (int i = 0;i<list.length;i++) {
            if (list[i] == 0) {
                return i;
            }
        }
        System.out.println("No empty ticket spot found");
        return 0; // if no spots available
    }

    public static String generateId(ArrayList<Ticket> ticketList) {

        Random rand = new Random();

        int IdLength = 5;
        String id = "";

        for (int i = 0; i < IdLength; i++) {
            id = id + rand.nextInt(10);
        }

        for (int i = 0;i<ticketList.size();i++) {
            if (Objects.equals(ticketList.get(i).id, id)) {
                for (int i1 = 0; i1 < IdLength; i1++) {
                    id = id + rand.nextInt(10);
                }
                continue;
            }
        }

        return id;
    }

    public static String getDayOfWeekFromDate(String dateGiven) {

        String day;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(dateGiven,dtf);
        day = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        return day;
    }

    public static int getAgeFromDateAtTimeOfAttendance(String dateBornGiven,String attendanceDate) {
        int age;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate dateBorn = LocalDate.parse(dateBornGiven,dtf);
        LocalDate dateAttend = LocalDate.parse(attendanceDate,dtf);
        age = Period.between(dateBorn,dateAttend).getYears();

        return age;
    }

    public static int getHeightInInches(String heightGiven) {

        int height;

        int apostropheLocation = heightGiven.indexOf("'");

        int feet = Integer.parseInt(heightGiven.substring(apostropheLocation-1, apostropheLocation));
        int inches = Integer.parseInt(heightGiven.substring(apostropheLocation+1));

        height = feet*12+inches;

        return height;
    }

}
