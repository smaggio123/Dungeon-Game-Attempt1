import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Level {
	
	private ArrayList<JLabel> horizontalWalls=new ArrayList<JLabel>();
	private ArrayList<JLabel> verticalWalls=new ArrayList<JLabel>();
	//private ArrayList<Enemy> enemyList=new ArrayList<Enemy>();
	
	public Level(int currentFrameWidth,int currentFrameHeight) {
		HorizontalWall hw = new HorizontalWall();
		VerticalWall vw = new VerticalWall();
		int adjustmentConstant=60;
		for(int i=0;i<currentFrameWidth-adjustmentConstant;i+=hw.getWidth()) {
			HorizontalWall tempHorizontalWall = new HorizontalWall(i,0);
			horizontalWalls.add(tempHorizontalWall.getLabel());
		}
		for(int k=0;k<currentFrameWidth-adjustmentConstant;k+=hw.getWidth()) {
			HorizontalWall tempHorizontalWall = new HorizontalWall(k,currentFrameHeight-adjustmentConstant);
			horizontalWalls.add(tempHorizontalWall.getLabel());
		}
		for(int alpha=0;alpha<currentFrameHeight;alpha+=vw.getHeight()) {
			VerticalWall tempVerticalWall = new VerticalWall(0,alpha);
			verticalWalls.add(tempVerticalWall.getLabel());
		}
		for(int bravo=0;bravo<currentFrameHeight;bravo+=vw.getHeight()) {
			VerticalWall tempVerticalWall = new VerticalWall(currentFrameWidth-adjustmentConstant,bravo);
			verticalWalls.add(tempVerticalWall.getLabel());
		}
		
		
	}
	
	public ArrayList<JLabel> getHorizontalWallsList(){
		return horizontalWalls;
	}
	
	public ArrayList<JLabel> getVerticalWallsList(){
		return verticalWalls;
	}
	
	/*
	public ArrayList<Enemy> getEnemyList(){
		return enemyList;
	}
	*/
}