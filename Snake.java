import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList; 
import java.util.List;

public class Snake {
  final static int R = 8; 
  public int x, y; 
  private String direction; 

  public void setDirection(String newDirection) {
    this.direction = newDirection;  
  }
  public Circle getHead() {
	  return body.get(0);
  }
  public List<Circle> getBody() {
	  return body.subList(1, body.size());
  }
  ArrayList<Circle> body = new ArrayList<Circle>(); 
  
  public Snake(int x, int y, String d) {
    this.x = x; 
    this.y = y;
    this.direction = d;
    this.body.add( new Circle(this.x + 0 * Snake.R, this.y + 0 * Snake.R, Snake.R));
    this.body.add( new Circle(this.x +  0 * Snake.R, this.y +  2 * Snake.R, Snake.R)); // down
    this.body.add( new Circle(this.x +  0 * Snake.R, this.y +  4 * Snake.R, Snake.R)); // down
    this.body.add( new Circle(this.x +  0 * Snake.R, this.y +  6 * Snake.R, Snake.R)); // down 
    this.body.add( new Circle(this.x +  0 * Snake.R, this.y +  8 * Snake.R, Snake.R)); // down 
    this.body.add( new Circle(this.x +  0 * Snake.R, this.y + 10 * Snake.R, Snake.R)); // down
    this.body.add( new Circle(this.x +  0 * Snake.R, this.y + 12 * Snake.R, Snake.R)); // down
    this.body.add( new Circle(this.x +  0 * Snake.R, this.y + 14 * Snake.R, Snake.R)); // down 
    this.body.add( new Circle(this.x +  0 * Snake.R, this.y + 16 * Snake.R, Snake.R)); // down
    this.body.add( new Circle(this.x +  0 * Snake.R, this.y + 18 * Snake.R, Snake.R)); // down 
    this.body.add( new Circle(this.x +  2 * Snake.R, this.y + 18 * Snake.R, Snake.R)); // right 
    this.body.add( new Circle(this.x +  4 * Snake.R, this.y + 18 * Snake.R, Snake.R)); // right 
    this.body.add( new Circle(this.x +  6 * Snake.R, this.y + 18 * Snake.R, Snake.R)); // right 
    this.body.add( new Circle(this.x +  8 * Snake.R, this.y + 18 * Snake.R, Snake.R)); // right
    this.body.add( new Circle(this.x + 10 * Snake.R, this.y + 18 * Snake.R, Snake.R)); // right 
    this.body.add( new Circle(this.x + 12 * Snake.R, this.y + 18 * Snake.R, Snake.R)); // right
    this.body.add( new Circle(this.x + 14 * Snake.R, this.y + 18 * Snake.R, Snake.R)); // right 
    this.body.add( new Circle(this.x + 16 * Snake.R, this.y + 18 * Snake.R, Snake.R)); // right
    this.body.add( new Circle(this.x + 18 * Snake.R, this.y + 18 * Snake.R, Snake.R)); // right
    this.body.add( new Circle(this.x + 20 * Snake.R, this.y + 18 * Snake.R, Snake.R)); // right
    this.body.add( new Circle(this.x + 22 * Snake.R, this.y + 18 * Snake.R, Snake.R)); // right 
    this.body.add( new Circle(this.x + 24 * Snake.R, this.y + 18 * Snake.R, Snake.R)); // right
    this.body.add( new Circle(this.x + 26 * Snake.R, this.y + 18 * Snake.R, Snake.R)); // right 
    this.body.add( new Circle(this.x + 28 * Snake.R, this.y + 18 * Snake.R, Snake.R)); // right 
    this.body.add( new Circle(this.x + 30 * Snake.R, this.y + 18 * Snake.R, Snake.R)); // right 
  }
  public void draw(Graphics g) {
    // g.drawString("I am here: ( " + this.x + ", " + this.y + ")", this.x, this.y); 
    this.getHead().draw(g, Color.RED, Color.BLACK);   
    for (Circle c : this.getBody())
      c.draw(g, Color.GREEN, Color.BLACK);
  }
  public void expSnake() {
	  if ("north:south:east:west".contains(this.direction)) {
		  if (this.direction.equals("north"))
			  this.y-= 2 * Snake.R;
		  else if (this.direction.equals("south"))
			  this.y += 2 * Snake.R;
		  else if (this.direction.equals("west"))
			  this.x -= 2 * Snake.R;
		  else if (this.direction.equals("east"))
			  this.x += 2 * Snake.R;
		  this.body.add(0, new Circle(this.x, this.y, Snake.R));
	  } 
  }
  public void move() {
    expSnake();
    this.body.remove(body.size()-1);
    }
  public int x() { 
	  return this.x; 
	  }
  public int y() { 
	  return this.y; 
	  }
}