import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.event.*;

class Direction
{
    public static int UP    = 0;
    public static int DOWN  = 1;
    public static int LEFT  = 2;
    public static int RIGHT = 3;
}
 
public class Report15 extends JFrame
{
    //private Panel panel;
    Pacman pacman = new Pacman();
    public static void main(String[] args) {
        Report15 repo = new Report15();
        // 忘れやすいので注意
        //repaint();
    }

    public Report15()
    {
        super("Report15");
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(25*28, 25*31);
        frame.setTitle("Pacman");
        //panel = new Panel();
        frame.setVisible(true);
        frame.addKeyListener(new KeyInputController());
    }

    // public class Panel extends JPanel 
    // {
    //     public Panel()
    //     {
            
    //     }

    //     public void paintComponet(Graphics g)
    //     {
    //         super.paintComponent(g);
    //     }
    // }
public class KeyInputController implements KeyListener
{
    public void keyPressed(KeyEvent e)
    {
    // //キーコード取得
    int keycode = e.getKeyCode();

        if(keycode == KeyEvent.VK_UP) pacman.changeDirection(Direction.UP);
        if(keycode == KeyEvent.VK_DOWN) pacman.changeDirection(Direction.DOWN);
        if(keycode == KeyEvent.VK_LEFT) pacman.changeDirection(Direction.LEFT);
        if(keycode == KeyEvent.VK_RIGHT) pacman.changeDirection(Direction.RIGHT);
    }

    @Override
    public void keyReleased(KeyEvent e){}
    // @Override
    public void keyTyped(KeyEvent event){}
        
}
        
}  
    