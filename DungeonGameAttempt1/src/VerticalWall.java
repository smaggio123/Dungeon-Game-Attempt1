import java.awt.Color;

import javax.swing.JLabel;

public class VerticalWall {
	
	private JLabel wallLabel=new JLabel();
	private int xPos;
	private int yPos;
	private final int wallWidth=20;
	private final int wallHeight=40;
	private int [][] hitBox=new int [2][2];

	public VerticalWall() {
		
	}
	
	
	public VerticalWall(int x, int y) {
		// TODO Auto-generated constructor stub
		xPos=x;
		yPos=y;
		updateHitBox();
		wallLabel.setBounds(getXPos(),getYPos(),wallWidth,wallHeight);
		wallLabel.setVisible(true);
		wallLabel.setBackground(Color.green);
		wallLabel.setOpaque(true);
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	public int getWidth() {
		return wallWidth;
	}
	
	public int getHeight() {
		return wallHeight;
	}
	
	public JLabel getLabel() {
		return wallLabel;
	}
	public void updateHitBox() {
		hitBox[0][0]=getXPos();
		hitBox[0][1]=getXPos()+wallWidth;
		hitBox[1][0]=getYPos();
		hitBox[1][1]=getYPos()+wallHeight;
	}

}
