import java.awt.Graphics; 
import java.awt.Color;
import java.util.ArrayList; 

public class Food {
  
  public ArrayList<Circle> data;
  
  public Food() {
    this.data = new ArrayList<Circle>(); 
    for (int i = 0; i < 5; i++) {
      getFood();
    }
  }
  public void getFood() {
	  this.data.add(new Circle((int) (25 + 350 * Math.random()),(int) (25+350*Math.random()),Snake.R));
  }
  
  public void show(Graphics g) {
    for (Circle c : this.data)
      c.draw(g, Color.YELLOW, Color.GREEN);
  }
}