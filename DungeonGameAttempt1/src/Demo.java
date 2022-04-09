import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Demo {
	static JLabel character = new JLabel();
	static JLabel goalSpot=new JLabel();
	static int movementSpeed=20;
	static int characterXPos=100;
	static int characterYPos=100;
	static int goalSpotXPos=500;
	static int goalSpotYPos=500;
	static int characterRespawnXPos=100;
	static int characterRespawnYPos=100;
	static JLayeredPane pane = new JLayeredPane();
	private static ArrayList<JLabel> horizontalWallLabel= new ArrayList<JLabel>();
	//static boolean stillPlaying=true;
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		//frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,2000,850);
		//frame.setSize(2000,850);
		//frame.setLayout();
		frame.add(pane);
		
		pane.setVisible(true);
		pane.setBounds(0,0,1500,800);
		
		
		
		character.setBounds(characterXPos,characterYPos,20,20);
		character.setVisible(true);
		character.setBackground(Color.red);
		character.setOpaque(true);
		
		
		goalSpot.setBounds(goalSpotXPos,goalSpotYPos,50,50);
		goalSpot.setVisible(true);
		goalSpot.setBackground(Color.blue);
		goalSpot.setOpaque(true);
		
		
		
		generateLevel();
		
		
		frame.addKeyListener(new KeyListener() {
			
	        @Override
	        public void keyTyped(KeyEvent e) {
	        }

	        @Override
	        public void keyPressed(KeyEvent e) {
	        	//System.out.println("moved");
	        	//if(stillPlaying) {
	        		if (e.getKeyCode() == KeyEvent.VK_UP) {
	        			if(characterYPos-movementSpeed>0) {
	        				characterYPos=characterYPos-movementSpeed;
	        			}
	        			
	        			//character.setBounds(characterXPos,characterYPos,20,20);
	        			
			        	if(checkForWin()) {
			        		//stillPlaying=false;
			        		resetGame();
			        		System.out.println("You Win!");
			        	}
	        			
	        			
	        		}
	        		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	        			if(characterYPos+movementSpeed<780) {
	        				characterYPos=characterYPos+movementSpeed;
	        			}
		        			
		        			//character.setBounds(characterXPos,characterYPos,20,20);
				        	if(checkForWin()) {
			        			//stillPlaying=false;
				        		resetGame();
			        			System.out.println("You Win!");
			        		}
		        		
			        	
		        	}
		        	else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		        		if(characterXPos-movementSpeed>0) {
		        			characterXPos=characterXPos-movementSpeed;
		        		}
		        			
		        			//character.setBounds(characterXPos,characterYPos,20,20);
				        	if(checkForWin()) {
			        			//stillPlaying=false;
				        		resetGame();
			        			System.out.println("You Win!");
			        		}
		        		
			        	
		        	}
		        	else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		        		if(characterXPos+movementSpeed<1510) {
		        			characterXPos=characterXPos+movementSpeed;
		        		}
		        			
		        			//character.setBounds(characterXPos,characterYPos,20,20);
				        	if(checkForWin()) {
			        			//stillPlaying=false;
				        		resetGame();
			        			System.out.println("You Win!");
			        		}
		        	}
	        	//}
	        		character.setBounds(characterXPos,characterYPos,20,20);
	        	//VK_DOWN, VK_LEFT, VK_RIGHT
	        	/*
		        	else {
	        		System.out.println("Key pressed code=" + e.getKeyCode() + ", char=" + e.getKeyChar());
	        	}
	        	*/
	        }
	        

	        @Override
	        public void keyReleased(KeyEvent e) {
	        }
	    });
		
		/*
		//The reset button
		JButton resetButton = new JButton();
		resetButton.setBounds(750,50,100,50);
		resetButton.setText("reset");
		resetButton.setVisible(true);
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==resetButton) {
					resetGame();
				}
			}
		});
		*/
		frame.setVisible(true);
		//frame.getContentPane().add(character);
		
		pane.add(character, Integer.valueOf(1));
		pane.add(goalSpot, Integer.valueOf(1));
		//pane.add(resetButton, Integer.valueOf(1));
		
	}
	
	public static boolean checkForWin() {
		int diffInX=Math.abs(characterXPos-(goalSpotXPos+20));
		int diffInY=Math.abs(characterYPos-(goalSpotYPos+20));
		if(diffInX<30&&diffInY<30) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public static int genRandomNumber(int num) {
		int number = (int) (Math.random()*num)+1;
		return number;
	}
	
	public static void resetGame() {
		//stillPlaying=true;
		characterXPos=characterRespawnXPos;
		characterYPos=characterRespawnYPos;
		goalSpotXPos=genRandomNumber(1400);
		goalSpotYPos=genRandomNumber(750);
		goalSpot.setLocation(goalSpotXPos,goalSpotYPos);
		character.setLocation(characterRespawnXPos,characterRespawnYPos);
	}
	
	public static void timeDown() {
		LocalDateTime date = LocalDateTime.now();
		int initialTime = date.toLocalTime().toSecondOfDay();
		int finalTime = date.toLocalTime().toSecondOfDay();
		int count=0;
		while(count<1) {
			//System.out.println("here");
			//System.out.println(finalTime-(initialTime+(count*1)));
			if((finalTime-(initialTime+(count*1)))>1) {
				//character.repaint();
				character.repaint();
				count++;
				System.out.println(count);
			}
			else {
				date = LocalDateTime.now();
        		finalTime = date.toLocalTime().toSecondOfDay();
			}
		}
		
		/*
		LocalDateTime date = LocalDateTime.now();
		int initialTime = date.toLocalTime().toSecondOfDay();
		int finalTime = date.toLocalTime().toSecondOfDay();
		int count=0;
		while(count<1) {
			//System.out.println("here");
			System.out.println(finalTime-(initialTime+(count*1)));
			if((finalTime-(initialTime+(count*1)))>1) {
				
				count++;
				//yPos=yPos-10;
				//character.setLocation(xPos,yPos);
			}
			else {
				date = LocalDateTime.now();
        		finalTime = date.toLocalTime().toSecondOfDay();
			}
		}
		*/
		//System.out.println(initialTime);
		//System.out.println(finalTime);
		
		//yPos=yPos-10;
    		/*
			Timer timer = new Timer(200, new ActionListener() {
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				
    				yPos=yPos-10;
    				character.setLocation(xPos,yPos);
    				System.out.println("hi");			
    			}
    			
    	});
    		timer.setRepeats(false);
    		timer.start();
    		try {
				timer.wait(100);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		
    		setFinalYPos();
    		*/
    		
			
		
    	//character.setLocation(xPos,yPos);
		
	}

	public static void generateLevel(){
		setBarrier();
		
	}
	public static void setBarrier() {
		for(int k=1;k<=2;k++) {
			for(int i=0;i<31;i++) {
				JLabel horizontalBarrier=new JLabel();
				if(k==1) {
					horizontalBarrier.setBounds((i*50),0,50,20);
					horizontalBarrier.setVisible(true);
					horizontalBarrier.setBackground(Color.green);
					horizontalBarrier.setOpaque(true);
					pane.add(horizontalBarrier,Integer.valueOf(1));
				}
				if(k==2) {
					horizontalBarrier.setBounds((i*50),780,50,20);
					horizontalBarrier.setVisible(true);
					horizontalBarrier.setBackground(Color.green);
					horizontalBarrier.setOpaque(true);
					pane.add(horizontalBarrier,Integer.valueOf(1));
				}
			}
		}
		for(int k=1;k<=2;k++) {
			for(int i=0;i<31;i++) {
				JLabel verticalBarrier=new JLabel();
				if(k==1) {
					verticalBarrier.setBounds(0,(i*50),20,50);
					verticalBarrier.setVisible(true);
					verticalBarrier.setBackground(Color.green);
					verticalBarrier.setOpaque(true);
					pane.add(verticalBarrier,Integer.valueOf(1));
				}
				if(k==2) {
					verticalBarrier.setBounds(1520,(i*50),20,50);
					verticalBarrier.setVisible(true);
					verticalBarrier.setBackground(Color.green);
					verticalBarrier.setOpaque(true);
					pane.add(verticalBarrier,Integer.valueOf(1));
				}
			}
		}
	}
	
	
}
