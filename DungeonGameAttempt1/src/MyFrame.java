import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;



public class MyFrame{
	
	private Level level;
	private JLayeredPane pane = new JLayeredPane();
	private JFrame frame = new JFrame();
	private Player p1;
	private final int frameWidth=1560;
	private final int frameHeight = 825;
	ArrayList<Enemy> listOfEnemies=new ArrayList<Enemy>();
	MyPanel panel1;
	JPanel panel2;
	private Key key;
	private Spawner spawner;
	private JLabel keyLabel,spawnerLabel,goalLabel,winMessage;
	private goalSpot goalArea;
	private boolean wonGame=false;
	private boolean keyRightSide=false,spawnerRightSide=false,pickedUpSpawner=false;
	
	public enum myColor {
		red,orange,yellow,green,blue,pink
	}
	

	public MyFrame(Player player,ArrayList<Enemy> enemyList) {
		// TODO Auto-generated constructor stub
		//frame
		//panel1 = new MyPanel();
		//panel2 = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(-10,0,frameWidth,frameHeight);
		frame.setVisible(true);
		frame.setLayout(null);
		pane=initializePane();
		frame.add(pane);
		pane.setSize(frameWidth,frameHeight);
		//frame.add(panel1);
		
		//panel2.setBounds(10,10,20,20);
		//panel2.setPreferredSize(new Dimension(100,100));
		//panel2.setBackground(Color.red);
		//frame.add(panel2);
		
		
		level= new Level(this.getCurrentFrameWidth(),this.getCurrentFrameHeight());
		listOfEnemies = enemyList;
		addEnemies();
		//frame.add(listOfEnemies.get(0).getPanel());
		frame.add(listOfEnemies.get(0).getLabel());
		initializeLevel();
		p1=player;
		//addPlayer1(p1);
		addToPane(p1.getLabel(),2);
		
		//key=new Key(genRandomNumber(getCurrentFrameWidth()-400,400),genRandomNumber(getCurrentFrameHeight()-400,400));
		key = new Key(400,400);
		keyLabel=key.getJLabel();
		addToPane(keyLabel,3);
		
		spawner = new Spawner(400,200);
		spawnerLabel=spawner.getJLabel();
		addToPane(spawnerLabel,3);
		
		goalArea=new goalSpot(500,500);
		goalLabel=goalArea.getJLabel();
		addToPane(goalLabel,1);
		
		winMessage=new JLabel();
		winMessage.setBounds(200,20,500,50);
		winMessage.setVisible(false);
		winMessage.setFont(new Font("Arial", Font.PLAIN, 50));
		winMessage.setText("You Win");
		addToPane(winMessage,1);
		int [][] playerHitBox=p1.getHitBox();
		
		frame.addKeyListener(new KeyListener(){
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					if(p1.getYPos()-p1.getSpeed()>0) {
						p1.moveUp();
						if(p1.getKeyCondition()) {
							key.moveUp();
						}
						else if(p1.getSpawnerCondition()) {
							spawner.moveUp();
						}
						
					}
					
        			
        			
				}
				else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if(p1.getYPos()+p1.getSpeed()<getCurrentFrameHeight()-50) {
						p1.moveDown();
						if(p1.getKeyCondition()) {
							key.moveDown();
						}
						else if(p1.getSpawnerCondition()) {
							spawner.moveDown();
						}
					}
				}
				else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if(p1.getXPos()-p1.getSpeed()>0) {
						p1.moveLeft();
						if(p1.getKeyCondition()) {
							key.moveLeft();
						}
						else if(p1.getSpawnerCondition()) {
							spawner.moveLeft();
						}
					}
				}
				else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if(p1.getXPos()+p1.getSpeed()<getCurrentFrameWidth()-50) {
						p1.moveRight();
						if(p1.getKeyCondition()) {
							key.moveRight();
						}
						else if(p1.getSpawnerCondition()) {
							spawner.moveRight();
						}
					}
				}
				else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(p1.getKeyCondition()==false && p1.getSpawnerCondition()==false) {
						if(checkForKey()) {
							//System.out.println("Made it here!!!");
							p1.setKeyCondition(true);
							key.setXPos(playerHitBox[0][1]);
							key.setYPos(playerHitBox[1][0]-5);
							keyLabel.setLocation(playerHitBox[0][1],playerHitBox[1][0]-5);
						}
						else if(checkForSpawner()) {
							p1.setSpawnerCondition(true);
							spawner.setXPos(playerHitBox[0][1]);
							spawner.setYPos(playerHitBox[1][0]-5);
							spawnerLabel.setLocation(playerHitBox[0][1],playerHitBox[1][0]-5);
						}
					}
					else if(p1.getKeyCondition()){
						p1.setKeyCondition(false);
						if(checkInGoalSpot()) {
							System.out.println("You won!!!");
							winMessage.setVisible(true);
						}
					}
					else if(p1.getSpawnerCondition()) {
						p1.setSpawnerCondition(false);
						if(checkInGoalSpot()) {
							System.out.println("You won!!!");
							winMessage.setVisible(true);
						}
					}
				}
				else if(e.getKeyChar()=='w') {
					if(p1.getKeyCondition()) {
						swapKey(false);
					}
					else if(p1.getSpawnerCondition()) {
						swapSpawner(false);
					}
				}
				else if(e.getKeyChar()=='e') {
					if(p1.getKeyCondition()) {
						swapKey(true);
					}
					else if(p1.getSpawnerCondition()) {
						swapSpawner(true);
					}
				}
				else if(e.getKeyChar()=='r') {
					if(p1.getKeyCondition()) {
						attackEnemy();
					}
					if(p1.getSpawnerCondition()) {
						Enemy spawnedEnemy=new Enemy(spawner.getXPos(),spawner.getYPos());
						listOfEnemies.add(spawnedEnemy);
						addToPane(spawnedEnemy.getLabel(), 1);
					}
				}
				else if(e.getKeyChar()=='c') {
					int colorValue=((p1.getColor()+1)%6);
					p1.setColor(colorValue);
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	public void swapKey(boolean rightSide) {
		keyRightSide=rightSide;
		int [][] playerHitBox=p1.getHitBox();
		if(rightSide) {
			key.setXPos(playerHitBox[0][1]);
			key.setYPos(playerHitBox[1][0]-5);
			keyLabel.setLocation(playerHitBox[0][1],playerHitBox[1][0]-5);
		}
		else {
			key.setXPos(playerHitBox[0][0]-5);
			key.setYPos(playerHitBox[1][0]-5);
			keyLabel.setLocation(playerHitBox[0][0]-5,playerHitBox[1][0]-5);
		}
	}
	public void swapSpawner(boolean rightSide) {
		spawnerRightSide=rightSide;
		int [][] playerHitBox=p1.getHitBox();
		if(rightSide) {
			spawner.setXPos(playerHitBox[0][1]);
			spawner.setYPos(playerHitBox[1][0]-5);
			spawnerLabel.setLocation(playerHitBox[0][1],playerHitBox[1][0]-5);
		}
		else {
			spawner.setXPos(playerHitBox[0][0]-5);
			spawner.setYPos(playerHitBox[1][0]-5);
			spawnerLabel.setLocation(playerHitBox[0][0]-5,playerHitBox[1][0]-5);
		}
	}
	
	public void attackEnemy() {
		//System.out.println("Size: "+listOfEnemies.size());
		if(listOfEnemies.size()>0) {
			for(int i=0;i<listOfEnemies.size();i++) {
				Enemy en=listOfEnemies.get(i);
				if(nearKey(en)) {
					en.getLabel().setVisible(false);
					pane.remove(listOfEnemies.get(i).getLabel());
					listOfEnemies.remove(i);
					//System.out.println("Size: "+listOfEnemies.size());
				}
			}
		}
		
	}
	
	public boolean nearKey(Enemy e) {
		int [][]enemyHitBox=e.getHitBox();
		int [][] keyHitBox= key.getHitBox();
		return collisionCheck(enemyHitBox,keyHitBox);
	}
	
	
	public boolean checkInGoalSpot() {
		int [][] playerHitBox = p1.getHitBox();
		int [][] goalHitBox = goalArea.getHitBox();
		return collisionCheck(playerHitBox,goalHitBox);
	}
	
	public boolean collisionCheck(int[][] firstHitBox,int[][] secondHitBox) {
		
		boolean xValid=false;
		boolean yValid=false;
		int firstLeftSide=firstHitBox[0][0];
		int firstRightSide=firstHitBox[0][1];
		int firstTopSide=firstHitBox[1][0];
		int firstBottomSide=firstHitBox[1][1];
		
		int secondLeftSide=secondHitBox[0][0];
		int secondRightSide=secondHitBox[0][1];
		int secondTopSide=secondHitBox[1][0];
		int secondBottomSide=secondHitBox[1][1];
		/*
		System.out.println("Key LS: "+secondLeftSide+" Player LS: "+firstLeftSide);
		System.out.println("Key RS: "+secondRightSide+" Player RS: "+firstRightSide);
		System.out.println("Key US: "+secondTopSide+" Player US: "+firstTopSide);
		System.out.println("Key DS: "+secondBottomSide+" Player DS: "+firstBottomSide);
		*/
		if((secondLeftSide>=firstLeftSide)&&(secondLeftSide<=firstRightSide)){
			xValid=true;
			//System.out.println("X Valid1!!!");
		}else if((secondRightSide>=firstLeftSide)&&(secondRightSide<=firstRightSide)){
			xValid=true;
			//System.out.println("X Valid2!!!");
			
		}
		if(secondTopSide>=firstTopSide&&secondTopSide<=firstBottomSide){
			yValid=true;
			//System.out.println("Y Valid1!!!");
		}
		else if(secondBottomSide>=firstTopSide&&secondBottomSide<=firstBottomSide) {
			yValid=true;
			//System.out.println("Y Valid2!!!");
		}
		if(xValid&&yValid) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean checkForSpawner() {
		int [][] playerHitBox = p1.getHitBox();
		int [][] spawnerHitBox = spawner.getHitBox();
		return collisionCheck(spawnerHitBox,playerHitBox);
	}
	
	public boolean checkForKey() {
		int [][] playerHitBox = p1.getHitBox();
		int [][] keyHitBox = key.getHitBox();
		return collisionCheck(keyHitBox,playerHitBox);	
	}
	
	public int genRandomNumber(int num) {
		int number = (int) (Math.random()*num)+1;
		return number;
	}
	public int genRandomNumber(int minNum,int maxNum) {
		int number = (int) (Math.random()*maxNum)+minNum;
		return number;
	}
	
	public int getCurrentFrameWidth() {
		Dimension size = frame.getBounds().getSize();
		int currentFrameWidth = size.width;
		return currentFrameWidth;
		//int theHeight=size.height;
		//System.out.printf("The width: %d\nThe height: %d\n",theWidth,theHeight);
	}
	
	public int getCurrentFrameHeight() {
		Dimension size = frame.getBounds().getSize();
		int currentFrameHeight = size.height;
		return currentFrameHeight;
	}
	
	public JLayeredPane initializePane() {
		JLayeredPane tempPane = new JLayeredPane();
		tempPane.setVisible(true);
		//tempPane.setBounds(0,0,getCurrentFrameWidth(),getCurrentFrameHeight());
		tempPane.setBounds(0,0,1600,800);
		return tempPane;
	}
	
	public void addToPane(Component a,int layerLevel) {
		pane.add(a,Integer.valueOf(layerLevel));
	}
	
	public void addPlayer1(Player p1) {
		JLabel player = new JLabel();
		player.setBounds(p1.getXPos(),p1.getYPos(),20,20);
		player.setVisible(true);
		player.setBackground(Color.red);
		player.setOpaque(true);
		//panel.add(player);
		pane.add(player);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void initializeLevel() {
		ArrayList<JLabel> horWallsList=new ArrayList<JLabel>();
		horWallsList=level.getHorizontalWallsList();
		ArrayList<JLabel> vertWallsList=new ArrayList<JLabel>();
		vertWallsList=level.getVerticalWallsList();
		for (JLabel horiLabel : horWallsList) {
			addToPane(horiLabel,1);
		}
		for (JLabel vertLabel : vertWallsList) {
			addToPane(vertLabel,1);
		}
		
		
	}
	
	

	public JLabel makeLabel(int x, int y, int width, int height,myColor color) {
		JLabel tempLabel = new JLabel();
		tempLabel.setBounds(x,y,width,height);
		tempLabel.setVisible(true);
		switch(color) {
		case red:
			tempLabel.setBackground(Color.red);
			break;
		case orange:
			tempLabel.setBackground(Color.orange);
			break;
		case yellow:
			tempLabel.setBackground(Color.yellow);
			break;
		case green:
			tempLabel.setBackground(Color.green);
			break;
		case blue:
			tempLabel.setBackground(Color.blue);
			break;
		case pink:
			tempLabel.setBackground(Color.pink);
			break;
		}
		tempLabel.setOpaque(true);
		return tempLabel;
	}
	
	public void addEnemies() {
		for(Enemy e:listOfEnemies) {
			//addToPane(e.getPanel(),1);
			addToPane(e.getLabel(),1);
		}
		
	}

}
