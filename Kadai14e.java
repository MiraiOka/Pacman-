// 15D8102008B Mirai Oka 岡実来 2017/07/21
import java.awt.*;
import java.awt.event.*; 
import java.util.*;
import javax.swing.*;

class BlueCircle
{
	int w, h;
	int x, y, vx, vy;
	double r;
	public BlueCircle(int w, int h)
	{
		this.w = w;
		this.h = h;
		x = urand(300) + w/4;
		y = urand(200) + h/4;
		vx = 5;
		vy = 3;
		r = 30;
	}
	
	public BlueCircle(int w, int h, double r)
	{
		this(w, h);
		this.r = r;
    }
    
    public void large()
    {
        r *= 1.5;
    }

    public void small()
    {
        r *= 0.5;
    }

    public void accelerate()
    {
        vx *= 1.5;
		vy *= 1.5;
    }

    public void decelerate()
    {
        vx *= 0.5;
		vy *= 0.5;
    }
	
	public void update()
	{
		x += vx;
		y += vy;
		
		if(x-r <  50  ){ x -= vx; vx = -vx; }
		if(x+r >= w-50){ x -= vx; vx = -vx; }
		if(y-r <  50  ){ y -= vy; vy = -vy; }
		if(y+r >= h-50){ y -= vy; vy = -vy; }
	}
	
	int urand(int m)
	{
		return (int)(Math.random()*m);
	}
	
	void disp(Graphics g)
	{
		g.setColor(Color.blue);
		g.drawOval(x-(int)r, y-(int)r, (int)r*2, (int)r*2);
	}
}

public class Kadai14e 
{
    JButton[] buttons;
    int N = 6;
	public static void main(String[] args){
		Kadai14e gui = new Kadai14e();
		gui.go();
	}
	
	public void go()
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        buttons = new JButton[N];
       
        MyDrawPanel drawPanel = new MyDrawPanel();

        buttons[0] = new JButton("Add a Ball");
        buttons[1] = new JButton("Add a Small Ball");
        buttons[2] = new JButton("Large");
        buttons[3] = new JButton("Small");
        buttons[4] = new JButton("Accelerate");
        buttons[5] = new JButton("Decelerate");

        for(JButton button: buttons) button.addActionListener(drawPanel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for(JButton button: buttons) panel.add(button);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.setSize(700, 500);
        frame.setVisible(true);
	}
	
	class MyDrawPanel extends JPanel implements ActionListener
	{
		ArrayList<BlueCircle> al;
		javax.swing.Timer time;
		
		public MyDrawPanel()
		{
			al = new ArrayList<BlueCircle>();
			time = new javax.swing.Timer(20, this);
			time.start();
		}
		
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == buttons[0]){
				BlueCircle c = new BlueCircle(getWidth(), getHeight());
				al.add(c);
			} else if (e.getSource() == buttons[1]){
				BlueCircle c = new BlueCircle(getWidth(), getHeight(), 15);
				al.add(c);
            } else if (e.getSource() == buttons[2]){
				for(BlueCircle a: al) a.large();
			} else if (e.getSource() == buttons[3]){
				for(BlueCircle a: al) a.small();
			} else if (e.getSource() == buttons[4]){
				for(BlueCircle a: al) a.accelerate();
			} else if (e.getSource() == buttons[5]){
				for(BlueCircle a: al) a.decelerate();
			} else {
				repaint();
			}
        }
        
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.setColor(Color.white);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.blue);
			g.drawRect(50, 50, getWidth()-100, getHeight()-100);
			
			Iterator<BlueCircle> it = al.iterator();
			while(it.hasNext())
			{
				BlueCircle c = it.next();
				c.update();
				c.disp(g);
			}
		}
	}	
}