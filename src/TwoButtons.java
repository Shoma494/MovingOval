import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoButtons {
    JFrame frame;
    JLabel label;

    public static void main(String[] args) {
        TwoButtons gui =new TwoButtons();
        gui.go();


    }

    private void go() {
        frame =new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton =new JButton("Change Label");
        labelButton.addActionListener(new LabelListener());

        JButton colorButton =new JButton("Change Circle");


        label = new JLabel("I'm label");
        MyDrawPanel myDrawPanel=new MyDrawPanel();


        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, myDrawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);




        frame.setSize(500, 500);
        frame.setVisible(true);
        myDrawPanel.y=frame.getHeight()-30;


        while (myDrawPanel.y>0) { myDrawPanel.y=myDrawPanel.y-10;
            colorButton.addActionListener(new ColorListener());

        }



    }

    class LabelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
          label.setText("Oach");

        }
    }

    class ColorListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            frame.repaint();

        }
    }

    public static class MyDrawPanel extends JPanel {
        int x;
        int y;

        public MyDrawPanel() {

        }


        public MyDrawPanel(int x, int y) {
            this.x=x;
            this.y=y;
        }

        public void paintComponent(Graphics g) {
            Graphics2D graphics2D=(Graphics2D) g;


            int red = (int) (Math.random()*255);
            int green =(int) (Math.random()*255);
            int blue =(int) (Math.random()*255);
            Color randomColor1 =new Color(red, green, blue);

            red = (int) (Math.random()*255);
            green =(int) (Math.random()*255);
            blue =(int) (Math.random()*255);
            Color randomColor2 =new Color(red, green, blue);

            GradientPaint gradientPaint = new GradientPaint(this.getX(),this.getY(),randomColor2,this.getX()+this.getWidth(),this.getY()+this.getHeight(),randomColor1);




            graphics2D.setPaint(gradientPaint);
            graphics2D.fillOval(x,y,50,50);


        }
    }
}
