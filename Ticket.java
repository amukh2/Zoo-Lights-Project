import java.io.*;
import javax.swing.*;


public class Ticket {
    String id;
    String name;
    int age;
    double cost;
    boolean alcohol;
    boolean train;
    int numPeople;

    public static void main(String[] args) {
        Ticket kyle = new Ticket("Kyle", 1823, 80, false, false, 1);
        output(kyle);
    }

    public Ticket(String name, int age, double cost, boolean alcohol, boolean train, int numPeople){
        for (int i = 0; i < 5; i++){
            id = id + String.valueOf((int) Math.round(Math.random() * 10));
            this.name = name;
            this.age = age;
            this.cost = cost;
            this.alcohol = alcohol;
            this.train = train;
            this.numPeople = numPeople;
        }
    }

    public static void output(Ticket num){
        JFrame frame = new JFrame();

        // Creating instance of JButton
        JButton button = new JButton(" GFG WebSite Click");

        JTextField outputName = new JTextField("Name: " + num.name);


        // adding button in JFrame
        frame.add(button);
        frame.add(outputName);

        // 400 width and 500 height
        frame.setSize(500, 250);

        // using no layout managers
        frame.setLayout(null);

        // making the frame visible
        frame.setVisible(true);

    }
}
