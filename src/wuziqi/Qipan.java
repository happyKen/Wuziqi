/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wuziqi;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author zekeng
 */
public class Qipan extends JFrame {

    /**
     * @param args the command line arguments
     */
    public Qipan() {
         Chess mychess = new Chess();
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(8, 8));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton white = new JButton();
                JButton black = new JButton();
                white.addActionListener(new ChessListener(mychess,white,i, j));
                black.addActionListener(new ChessListener(mychess,black,i, j));
                white.setBackground(Color.WHITE);
                black.setBackground(Color.BLACK);
                if (i % 2 == 0) {
                    if (j % 2 == 0) {

                        p1.add(white);
                    } else {
                        p1.add(black);
                    }
                } else {
                    if (j % 2 == 0) {

                        p1.add(black);
                    } else {
                        p1.add(white);
                    }
                }

            }
        }
        add(p1);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new Qipan();
        frame.setTitle("棋盘");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    class ChessListener implements ActionListener {

        private int x;
        private int y;
        private JButton button;
        private Chess mychess;

        public ChessListener() {

        }

        public ChessListener(Chess mychess,JButton button,int x, int y) {
            this.mychess = mychess;
            this.x = x;
            this.y = y;
            this.button = button;
        }

        public void actionPerformed(ActionEvent e) {
            //ImageIcon icon = new ImageIcon("green.gif");
            //System.out.println(e.getSource);
           
            //mychess.setWho(2);
            if(mychess.getWho()==2){
            button.setIcon(new ImageIcon(getClass().getResource("green.gif")));
            mychess.addChess(mychess.getWho(), x, y);
            System.out.println("该格子位置为:" + x + "," + y);
          //  mychess.checkWin(x, x, y)
            if(mychess.checkWhoWin()==2){
                Tip p1 = new Tip("黑方胜利"); 
                System.out.println("黑方胜利");
            };
            mychess.setWho(1);
            }
            else if(mychess.getWho()==1){
             button.setIcon(new ImageIcon(getClass().getResource("red.gif")));
            mychess.addChess(mychess.getWho(), x, y);
            System.out.println("该格子位置为:" + x + "," + y);
              //  mychess.checkWin(x, x, y)
             if(mychess.checkWhoWin()==1){
                Tip p1 = new Tip("白方胜利"); 
                System.out.println("白方胜利");
            };
            mychess.setWho(2);
        }
            
        }
    }
}
