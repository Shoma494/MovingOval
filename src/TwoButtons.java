import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoButtons {


    int xPosition=0;
    int yPosition=0;
    int fillOvalWidth=50;
    int fillOvalHeight=50;

    public static void main(String[] args)  {
        TwoButtons gui =new TwoButtons();

        gui.go();


    }

    public void go() {
        JFrame frame =new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        MyDrawPanel myDrawPanel=new MyDrawPanel();


        frame.getContentPane().add(myDrawPanel);





        frame.setSize(800, 800);
        frame.setVisible(true);


    /////////конец метода go
        while (true){
            xPosition++;
            if (xPosition==frame.getWidth()) {xPosition=0;
            fillOvalWidth=fillOvalWidth+20;}
            yPosition++;
            if (yPosition==frame.getHeight()) {yPosition=0;
            fillOvalHeight=fillOvalHeight+20;}
            myDrawPanel.repaint();


            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }




    public  class MyDrawPanel extends JPanel {


        public void paintComponent(Graphics g) {



            g.setColor(Color.white);
           g.fillRect(0,0, this.getWidth(), this.getHeight());
            g.setColor(Color.blue);
            g.fillOval(xPosition,yPosition,fillOvalWidth,fillOvalHeight);



        }
    }
}
