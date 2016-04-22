/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wuziqi;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author zekeng
 */
public class Tip extends JFrame {
    private String m;
   public Tip(String m){
      this.m =m;
      add(new JLabel(m));
      this.setSize(50,100);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
   }
   
}
