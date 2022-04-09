import java.awt.Color;

import javax.swing.JLabel;

public class goalSpot {
	
	private JLabel goalLabel = new JLabel();
	private int xPos;
	private int yPos;
	private final int LABEL_WIDTH=60;
	private final int LABEL_HEIGHT=60;
	private int [][] hitBox= {
			{getXPos(),getXPos()+LABEL_WIDTH},
			{getYPos(),getYPos()+LABEL_HEIGHT}
	};
	

	public goalSpot(int x, int y) {
		// TODO Auto-generated constructor stub
		xPos=x;
		yPos=y;
		goalLabel.setBounds(getXPos(),getYPos(),LABEL_WIDTH,LABEL_HEIGHT);
		goalLabel.setBackground(Color.blue);
		goalLabel.setVisible(true);
		goalLabel.setOpaque(true);
		updateHitBox();
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
	public void updateHitBox() {
		hitBox[0][0]=getXPos();
		hitBox[0][1]=getXPos()+LABEL_WIDTH;
		hitBox[1][0]=getYPos();
		hitBox[1][1]=getYPos()+LABEL_HEIGHT;
	}
	public int[][] getHitBox(){
		return hitBox;
	}
	public JLabel getJLabel() {
		return goalLabel;
	}

}
