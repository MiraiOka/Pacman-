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
    Ghost[] ghosts = new Ghost[4];
    public static int N = 25;
    int[][] stageCell;
	public static void main(String[] args){
		Report15 gui = new Report15();
        gui.go();
	}
	
	public void go()
	{
        for(int i = 0; i < ghosts.length; i++) ghosts[i] = new Ghost();
        JFrame frame = new JFrame();
        stageCell = Stage.readCSV();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyDrawPanel drawPanel = new MyDrawPanel();
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(28 * N, 31 * N);
        frame.addKeyListener(new KeyInputController());
        frame.setVisible(true);
	}
	
	class MyDrawPanel extends JPanel implements ActionListener
	{
        javax.swing.Timer time;
        
        public MyDrawPanel()
        {
            time = new javax.swing.Timer(100, this);
            time.start();
        }
		
        public void actionPerformed(ActionEvent e) 
        {
            repaint(); 
            pacman.move();
            for(Ghost ghost: ghosts) ghost.move();
        }
        
		public void paintComponent(Graphics g)
		{
            super.paintComponent(g);
            boolean[][] pacmanPosition = pacman.getPosition();
            for(int row = 0; row < Stage.ROW_Y; row++){
                for(int col = 0; col < Stage.COL_X; col++){
                    switch(stageCell[row][col]){
                        case 0:
                        g.setColor(Color.blue);
                        break;

                        case 1:
                        g.setColor(Color.red);
                        break;

                        case 2:
                        g.setColor(Color.pink);
                        break;

                        case 3:
                        g.setColor(Color.black);
                        break;
                    }
                    g.fillRect(col * N, row * N, N, N);
                    
                }
            }

            for(Ghost ghost: ghosts)
            {
                for(int row = 0; row < Stage.ROW_Y; row++){
                    for(int col = 0; col < Stage.COL_X; col++){
                        g.setColor(Color.blue);
                        boolean[][] ghostPosition = ghost.getPosition();                            
                        if(ghostPosition[row][col]) {
                            
                            g.fillOval(col * N, row * N, N, N);
                        }
                    }
                }
            }

            for(int row = 0; row < Stage.ROW_Y; row++){
                for(int col = 0; col < Stage.COL_X; col++){
                    g.setColor(Color.yellow);
                    if(pacmanPosition[row][col]) {
                        g.fillOval(col * N, row * N, N, N);
                        stageCell[row][col] = 3;
                    }
                }
            }

            for(int row = 0; row < Stage.ROW_Y; row++) {
                for(int col = 0; col < Stage.COL_X; col++) {
                    for(Ghost ghost: ghosts){
                        if(pacman.getPositionX() == ghost.getPositionX() && pacman.getPositionY() == ghost.getPositionY()){
                            pacman.gameOver();
                            for(Ghost ghost2: ghosts) ghost2.gameOver();
                        } 
                    }
                }
            }
		}
    }

    class KeyInputController implements KeyListener
    {
        public void keyPressed(KeyEvent e)
        {
            int keycode = e.getKeyCode();
            if(keycode == KeyEvent.VK_UP)    pacman.changeDirection(Direction.UP);
            if(keycode == KeyEvent.VK_DOWN)  pacman.changeDirection(Direction.DOWN);
            if(keycode == KeyEvent.VK_LEFT)  pacman.changeDirection(Direction.LEFT);
            if(keycode == KeyEvent.VK_RIGHT) pacman.changeDirection(Direction.RIGHT);
        }

        public void keyReleased(KeyEvent e){}
        
        public void keyTyped(KeyEvent event){}
    }
}