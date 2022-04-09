import java.awt.Color;

import javax.swing.JLabel;

public class Key {

	private JLabel keyLabel = new JLabel();
	private int xPos;
	private int yPos;
	private final int speed=20;
	private final int LABEL_WIDTH=10;
	private final int LABEL_HEIGHT=10;
	private int [][] hitBox= {
			{getXPos(),getXPos()+LABEL_WIDTH},
			{getYPos(),getYPos()+LABEL_HEIGHT}
	};
	public Key(int x,int y) {
		// TODO Auto-generated constructor stub
		xPos=x;
		yPos=y;
		keyLabel.setBounds(getXPos(),getYPos(),LABEL_WIDTH,LABEL_HEIGHT);
		keyLabel.setBackground(Color.magenta);
		keyLabel.setVisible(true);
		keyLabel.setOpaque(true);
		updateHitBox();
	}
	public void updateHitBox() {
		hitBox[0][0]=getXPos();
		hitBox[0][1]=getXPos()+LABEL_WIDTH;
		hitBox[1][0]=getYPos();
		hitBox[1][1]=getYPos()+LABEL_HEIGHT;
	}
	public int[][] getHitBox(){
		return hitBox;
	}
	
	public void setXPos(int x) {
		xPos=x;
	}
	
	public void setYPos(int y) {
		yPos=y;
	}
	public int getXPos() {
		return xPos;
	}
	public int getYPos() {
		return yPos;
	}
	public JLabel getJLabel() {
		return keyLabel;
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
	public int getSpeed() {
		return speed;
	}
	public void updateLocation() {
		keyLabel.setLocation(getXPos(), getYPos());
		updateHitBox();
	}

}
