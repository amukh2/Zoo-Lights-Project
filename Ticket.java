import javax.swing.*;
import java.awt.*;

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
        
        JFrame frame = new JFrame();
        JButton button = new JButton("hi");
        JLabel outputID = new JLabel("ID: " + id);
        JLabel outputName = new JLabel("Name: " + name);
        JLabel outputAge = new JLabel("Age: " + age);
        JLabel outputCost = new JLabel("Cost: " + check.getPrice());
        JLabel outputAlcohol = new JLabel("Alcohol: " + alcoholAccess);
        JLabel outputTrain = new JLabel("Train: " + rainAccess);
        Color c = new Color(255,244,155);


        outputName.setBounds(20,50, 300,30);
        outputID.setBounds(20,25, 300,30);
        outputAge.setBounds(20,75, 300,30);
        outputCost.setBounds(20,100, 300,30);
        outputAlcohol.setBounds(20,125, 300,30);
        outputTrain.setBounds(20,150, 300,30);

        frame.add(button);
        frame.add(outputName);
        frame.add(outputID);
        frame.add(outputAge);
        frame.add(outputCost);
        frame.add(outputAlcohol);
        frame.add(outputTrain);

        frame.setSize(500, 250);
        frame.setLayout(null);
        UIManager.put("Label.font", "Broadway");
        //UIManager.put("Label.", 32 );
        SwingUtilities.updateComponentTreeUI(frame);
        frame.getContentPane().setBackground(c);
        frame.setVisible(true);
    }

}
