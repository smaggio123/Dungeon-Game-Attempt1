
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Player {

	private int player1XPos;
	private int player1YPos;
	private final int playerWidth=20;
	private final int playerHeight=20;
	private int [][] hitBox= {
			{getXPos(),getXPos()+playerWidth},
			{getYPos(),getYPos()+playerHeight}
	};
	private final int speed=20;
	private JLabel player1Label = new JLabel();
	private JPanel player1Panel= new JPanel();
	private boolean hasKey=false,hasSpawner=false;
	private int currentColor;
	public enum myColor {
		red,orange,yellow,green,blue,pink
	}
	
	public Player() {
		// TODO Auto-generated constructor stub
		player1XPos=100;
		player1YPos=100;
		
		player1Label.setBounds(this.getXPos(),this.getYPos(),playerWidth,playerHeight);
		player1Label.setVisible(true);
		player1Label.setBackground(Color.red);
		player1Label.setOpaque(true);
		
		player1Panel.setBounds(this.getXPos(),this.getYPos(),playerWidth,playerHeight);
		player1Panel.setVisible(true);
		player1Panel.setBackground(Color.red);
		player1Panel.setOpaque(true);
		updateHitBox();
		setColor(0);
	}
	public JLabel getLabel() {
		return player1Label;
	}
	public JPanel getPanel() {
		return player1Panel;
	}
	public int getXPos() {
		return player1XPos;
	}
	public int getYPos() {
		return player1YPos;
	}
	public void setXPos(int x) {
		player1XPos = x;
	}
	public void setYPos(int y) {
		player1YPos = y;
	}
	
	public int getColor() {
		return currentColor;
	}
	public void setColor(int col) {
		currentColor=col;
		this.updateColor(currentColor);
	}
	public void updateColor(int color) {
		//JLabel tempLabel = new JLabel();
		//tempLabel.setBounds(x,y,width,height);
		
		if(color==myColor.red.ordinal()) {
				this.getLabel().setBackground(Color.red);
		}
		else if(color==myColor.orange.ordinal()) {
				this.getLabel().setBackground(Color.orange);
		}
		else if(color==myColor.yellow.ordinal()){
				this.getLabel().setBackground(Color.yellow);
		}
		else if(color==myColor.green.ordinal()){
			this.getLabel().setBackground(Color.green);
		}
		else if(color==myColor.blue.ordinal()){
			this.getLabel().setBackground(Color.blue);
		}
		else if(color==myColor.pink.ordinal()){
			this.getLabel().setBackground(Color.pink);
		}
		this.getLabel().setOpaque(true);
		//return this.getJLabel();
		
	}
	
	public void updateLocation() {
		player1Label.setLocation(getXPos(), getYPos());
		updateHitBox();
		/*
		for(int i=0;i<2;i++) {
			for(int k=0;k<2;k++) {
				System.out.println(hitBox[i][k]);
			}
		}*/
	}
	
	public void updateHitBox() {
		hitBox[0][0]=getXPos();
		hitBox[0][1]=getXPos()+playerWidth;
		hitBox[1][0]=getYPos();
		hitBox[1][1]=getYPos()+playerHeight;
		
		
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
	public int getSpeed() {
		return speed;
	}
	public void setKeyCondition(boolean condition) {
		hasKey=condition;
	}
	public void setSpawnerCondition(boolean condition) {
		hasSpawner=condition;
	}
	public boolean getKeyCondition() {
		return hasKey;
	}
	public boolean getSpawnerCondition() {
		return hasSpawner;
	}
	

}
