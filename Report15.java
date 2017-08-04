import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

class Direction
{
    public static int UP    = 0;
    public static int DOWN  = 1;
    public static int LEFT  = 2;
    public static int RIGHT = 3;
}

public class Report15 
{
    Pacman pacman = new Pacman();
    int N = 25;
	public static void main(String[] args){
		Report15 gui = new Report15();
        gui.go();
	}
	
	public void go()
	{
		JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyDrawPanel drawPanel = new MyDrawPanel();
        drawPanel.setBackground(Color.black);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(28*N, 31*N);
        frame.setVisible(true);
        pacman.go();
	}
	
	class MyDrawPanel extends JPanel implements ActionListener
	{
        javax.swing.Timer time;
        
        public MyDrawPanel()
        {
            time = new javax.swing.Timer(20, this);
            time.start();
        }
		
		public void actionPerformed(ActionEvent e) { repaint(); }
        
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
            System.out.println("x = " + pacman.getPositionX() + " y = " + pacman.getPositionY());
            g.setColor(Color.yellow);
            g.fillOval(pacman.getPositionX(), pacman.getPositionY(), N, N);
		}
    }

    class KeyInputController implements KeyListener
    {
        public void keyPressed(KeyEvent e)
        {
            //キーコード取得
            int keycode = e.getKeyCode();
            if(keycode == KeyEvent.VK_UP)    pacman.changeDirection(Direction.UP);
            if(keycode == KeyEvent.VK_DOWN)  pacman.changeDirection(Direction.DOWN);
            if(keycode == KeyEvent.VK_LEFT)  pacman.changeDirection(Direction.LEFT);
            if(keycode == KeyEvent.VK_RIGHT) pacman.changeDirection(Direction.RIGHT);
        }

        @Override
        public void keyReleased(KeyEvent e){}
        // @Override
        public void keyTyped(KeyEvent event){}
    }
}