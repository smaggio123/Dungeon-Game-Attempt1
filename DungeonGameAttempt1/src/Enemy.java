import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

//public class Enemy implements ActionListener{
public class Enemy{

	private int enemyXPos;
	private int enemyYPos;
	Image enemy;
	private int xVelocity = 5;
	private final int enemyWidth=50;
	private final int enemyHeight=50;
	//Timer timer;
	private int [][] hitBox= {
			{getXPos(),getXPos()+enemyWidth},
			{getYPos(),getYPos()+enemyHeight}
	};
	private final int speed=20;
	private JLabel enemyLabel = new JLabel();
	//private JPanel enemyPanel = new JPanel();
	
	public Enemy() {
		// TODO Auto-generated constructor stub
		enemyXPos=100;
		enemyYPos=100;
		
		enemyLabel.setBounds(this.getXPos(),this.getYPos(),enemyWidth,enemyHeight);
		enemyLabel.setVisible(true);
		enemyLabel.setBackground(Color.orange);
		enemyLabel.setOpaque(true);
		
		
		ImageIcon imageIcon = new ImageIcon("enemy.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		enemy = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(enemy);  // transform it back
		/*
		enemyPanel.setBounds(this.getXPos(),this.getYPos(),enemyWidth,enemyHeight);
		enemyPanel.setVisible(true);
		enemyPanel.setBackground(Color.orange);
		enemyPanel.setOpaque(true);
		timer = new Timer (10,this);
		timer.start();
		*/
	}
	public Enemy(int x, int y) {
		// TODO Auto-generated constructor stub
		enemyXPos=x;
		enemyYPos=y;
		
		enemyLabel.setBounds(this.getXPos(),this.getYPos(),enemyWidth,enemyHeight);
		enemyLabel.setVisible(true);
		enemyLabel.setBackground(Color.orange);
		enemyLabel.setOpaque(true);
		
		ImageIcon imageIcon = new ImageIcon("enemy.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		enemy = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(enemy);  // transform it back
		updateHitBox();
		/*
		enemyPanel.setBounds(this.getXPos(),this.getYPos(),enemyWidth,enemyHeight);
		enemyPanel.setVisible(true);
		//enemyPanel.setBackground(Color.orange);
		
		enemyPanel.setOpaque(true);
		*/
	}
	
	public JLabel getLabel() {
		return enemyLabel;
	}
	/*
	public JPanel getPanel() {
		return enemyPanel;
	}
	*/
	public int getXPos() {
		return enemyXPos;
	}
	public int getYPos() {
		return enemyYPos;
	}
	public void setXPos(int x) {
		enemyXPos = x;
	}
	public void setYPos(int y) {
		enemyYPos = y;
	}
	
	public void updateLocation() {
		enemyLabel.setLocation(getXPos(), getYPos());
		updateHitBox();
	}
	
	public void updateHitBox() {
		hitBox[0][0]=getXPos();
		hitBox[0][1]=getXPos()+enemyWidth;
		hitBox[1][0]=getYPos();
		hitBox[1][1]=getYPos()+enemyHeight;
		
		
	}
	public int[][] getHitBox(){
		return hitBox;
	}
	public void moveLeft() {
		int tempX=this.getXPos();
		tempX-=speed;
		this.setXPos(tempX);
		updateLocation();
	}
	
	public void moveRight() {
		int tempX=this.getXPos();
		tempX+=speed;
		this.setXPos(tempX);
		updateLocation();
	}
	
	public void moveUp() {
		int tempY=this.getYPos();
		tempY-=speed;
		this.setYPos(tempY);
		updateLocation();
	}
	public void moveDown() {
		int tempY=this.getYPos();
		tempY+=speed;
		this.setYPos(tempY);
		updateLocation();
	}
	public void move() {
		
	}
	/*
	public void paint(Graphics g) {
		
		//super.paint(g); //paint background
		
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.drawImage(enemy, enemyXPos, enemyYPos, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(enemyXPos>=20-enemy.getWidth(null)||enemyXPos<0) {
			xVelocity = xVelocity * -1;
		}
		
		enemyXPos = enemyXPos + xVelocity;
		//repaint();
		
	}
	public int getSpeed() {
		return speed;
	}
	*/

}
