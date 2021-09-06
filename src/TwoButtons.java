import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
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
        MiniMinimusicApp mini = new MiniMinimusicApp();
        JFrame frame =new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        MyDrawPanel myDrawPanel=new MyDrawPanel();


        frame.getContentPane().add(myDrawPanel);





        frame.setSize(500, 400);
        frame.setVisible(true);




        int a =1;
        int b =1;
        while (true){
            xPosition= xPosition+a;
            if (xPosition==frame.getWidth()-fillOvalWidth|| xPosition==0) {a=-1*a;
                try {
                    mini.play();
                } catch (InvalidMidiDataException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (MidiUnavailableException e) {
                    e.printStackTrace();
                }
            }
            yPosition=yPosition+b;
            if (yPosition==frame.getHeight()-fillOvalHeight|| yPosition==0) {b=-1*b;
                try {
                    mini.play();
                } catch (InvalidMidiDataException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (MidiUnavailableException e) {
                    e.printStackTrace();
                }
            }
            myDrawPanel.repaint();


            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }




    public  class MyDrawPanel extends JPanel {


        public void paintComponent(Graphics g) {



            g.setColor(Color.cyan);
           g.fillRect(0,0, this.getWidth(), this.getHeight());
            g.setColor(Color.blue);
            g.fillOval(xPosition,yPosition,fillOvalWidth,fillOvalHeight);



        }
    }
}
