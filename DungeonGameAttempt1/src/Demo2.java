import java.util.ArrayList;

public class Demo2{

	public static void main(String[] args) {
		Player p1 = new Player();
		ArrayList<Enemy> enemyList=new ArrayList<Enemy>();
		enemyList=initializeEnemies();
		MyFrame frame = new MyFrame(p1,enemyList);
		//Level level = new Level(frame.getCurrentFrameWidth(),frame.getCurrentFrameWidth());
		
		//frame.addPlayer1(p1);
		
		
	}
	
	public static ArrayList<Enemy> initializeEnemies(){
		ArrayList<Enemy> tempEnemyList=new ArrayList<Enemy>();
		Enemy enemy = new Enemy(600,400);
		tempEnemyList.add(enemy);
		return tempEnemyList;
		
	}

}
