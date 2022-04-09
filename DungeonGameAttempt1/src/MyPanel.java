import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel implements ActionListener{

	final int panel_width=1500;
	final int panel_height=700;
	Image enemy;
	Image backgroundImage;
	Timer timer;
	int xVelocity = 5;
	int yVelocity = 5;
	int x = 1000;
	int y = 0;
	
	
	
	public MyPanel() {
		// TODO Auto-generated constructor stub
		this.setPreferredSize(new Dimension(panel_width,panel_height));
		this.setBackground(Color.black);
		ImageIcon imageIcon = new ImageIcon("enemy.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		enemy = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(enemy);  // transform it back
		//enemy = new ImageIcon("enemy.png").getImage();
		timer = new Timer (10,this);
		timer.start();
	}


	public void paint(Graphics g) {
		
		//super.paint(g); //paint background
		
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.drawImage(enemy, x, y, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(x>=panel_width-enemy.getWidth(null)||x<0) {
			xVelocity = xVelocity * -1;
		}
		
		x = x + xVelocity;
		repaint();
		
	}

}
