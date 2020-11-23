import java.awt.Graphics;
import javax.swing.JFrame; 
import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game implements World {
  
  Food food; 
  
  Snake snake;
  int times;  
  
  boolean doubleSpeed = false;
  
  
  public Game() {
    this.snake = new Snake(50, 80, "east");  
    this.food = new Food(); 
  }
  
    
  public void draw(Graphics g) { 
    Font font = new Font("SansSerif", Font.BOLD, 20);
    g.setFont(font); 
    g.setColor(Color.BLACK);
    g.drawString("Score: " + this.times +  "", 20, 40); 

    this.snake.draw(g);
    this.food.show(g); 
    
  }
  public void actualice() { 
	  int speed = doubleSpeed ? 2 :1;
	  for (int i = 0; i < speed; i++) {
		  this.snake.move();
		  
		  ArrayList<Circle> delete = new ArrayList<>();
		  int addFood = 0;
		  for (Circle c : food.data) {
			  if(c.collide(snake.getHead())) {
				  delete.add(c);
				  addFood++;
				  snake.expSnake();
				  this.times++;
			  }
		  }
		  food.data.removeAll(delete);
		  for (int j = 0; j < addFood; j++)
			  food.getFood();
	  }
  }
  public void keh(KeyEvent e) {  
    int EAST = 39; 
    // System.out.println( e.getKeyCode() ); 
    int code = e.getKeyCode(); 
    if (code == 37) { // West 
      this.snake.setDirection("west"); 
    } else if (code == KeyEvent.VK_UP) { // North or 38 (not VK_KP_UP      
      this.snake.setDirection("north"); 
    } else if (code == EAST) { 
      this.snake.setDirection("east"); 
    } else if (code == 40) { // South 
      this.snake.setDirection("south"); 
    } else if (code==KeyEvent.VK_B) {
    	doubleSpeed = true;
    } else {
      this.snake.setDirection("no direction"); 
      // System.out.println( KeyEvent.VK_UP );
    }
  }
  public static void main(String[] args) {
    BigBang b = new BigBang( 100, new Game() ); 
    JFrame f = new JFrame(); 
    f.add(b); 
    f.addKeyListener(b); 
    f.setSize(400, 400); 
    f.setVisible(true); 
    b.start(); 
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  public boolean gameOver() {
	  for (Circle c :  snake.getBody()) {
		  if (c.collide(snake.getHead())) {
			  return true;
		  }
	  }
	  if (snake.x < 0 || snake.x > 400 || snake.y < 0 || snake.y > 400) 
		  return true;
	  return false;
  }
  
}