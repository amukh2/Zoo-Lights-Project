public class Ticket {

    String id;
    String name;
    String day;
    int age;
    int height;
    int weight;
    int price;
    int numPeople = 0;
    boolean walkthrough;
    Check check;

    boolean trainAccess;
    boolean alcoholAccess;

    public Ticket(String id, String name,String day, int age, int height, int weight, boolean walkthrough, Check check) {

        this.id = id;
        this.name = name;
        this.age = age; // age when at date of attendance
        this.height = height;
        this.weight = weight;
        this.walkthrough = walkthrough;
        this.check = check;
        this.day = day;

        trainAccess = AccessToTrain();
        alcoholAccess = AccessToAlcohol();

        check.processTicketPrice(this);

    }

    public boolean AccessToTrain() {
        boolean access = true;
        if (!walkthrough || height < 48 || weight < 300) {
            access = false;
        }
        return access;
    }

    public boolean AccessToAlcohol() {
        boolean access = true;
        if (!walkthrough || age < 21) {
            access = false;
        }
        return access;
    }

    public void DisplayTicket() {
        System.out.println("\nTicket " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Alcohol access: "+alcoholAccess);
        System.out.println("Train access: "+trainAccess);
        System.out.println("Ticket price: "+price);
        System.out.println("Check price: "+check.getPrice());
    }

}
