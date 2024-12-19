import java.util.ArrayList;

public class Check {

    String id;
    double totalPrice = 0;
    boolean discountCode;
    ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    int adultWeekendPrice = 25;
    int adultWeekdayPrice = 16;
    int youngAdultWeekendPrice = 18;
    int youngAdultWeekdayPrice = 12;
    int kidWeekendPrice = 12;
    int kidWeekdayPrice = 8;

    int baseDriveThroughPrice = 65;
    int driveThroughAddonPrice = 12;

    public Check(String id, boolean discountCode) {

        this.id = id;
        this.discountCode = discountCode;

    }

    public void processTicketPrice(Ticket ticket) {

        int price = 0;

        String day = ticket.day;
        int age = ticket.age;
        int numPeople = ticket.numPeople;
        boolean weekend;

        weekend = day.equals("Saturday") || day.equals("Sunday");

        if (ticket.walkthrough) {
            if (age >= 2 && age <= 14) {
                if (weekend) {
                    price += kidWeekendPrice;
                } else {
                    price += kidWeekdayPrice;
                }
            } else if (age >= 15 && age < 18) {
                if (weekend) {
                    price += youngAdultWeekendPrice;
                } else {
                    price += youngAdultWeekdayPrice;
                }
            } else if (age >= 18) {
                if (weekend) {
                    price += adultWeekendPrice;
                } else {
                    price += adultWeekdayPrice;
                }
            }
        } else {

            price += baseDriveThroughPrice;
            if (numPeople > 8) {
                price += (numPeople-8)*driveThroughAddonPrice;
            }

        }

        ticket.price = price;
        totalPrice += price;

    }

    public double getPrice() {
        double price = totalPrice;
        if (discountCode) {
            price *= 0.8;
        }
        return price;
    }

}

