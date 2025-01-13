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
        JButton button = new JButton("hi");
        JLabel outputID = new JLabel("ID: " + num.id);
        JLabel outputName = new JLabel("Name: " + num.name);
        JLabel outputAge = new JLabel("Age: " + num.age);
        JLabel outputCost = new JLabel("Cost: " + num.cost);
        JLabel outputAlcohol = new JLabel("Alcohol: " + num.alcohol);
        JLabel outputTrain = new JLabel("Train: " + num.train);
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
