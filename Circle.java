import java.awt.Graphics;
import java.awt.Color;

public class Circle {
  private int x, y, radius; 
  
  public int x() { 
	  return this.x; 
	  } 
  
  public int y() { 
	  return this.y; 
	  } 
  
  public Circle(int x, int y, int r) {
    this.x = x;
    this.y = y; 
    this.radius = r;
  }
  public void draw(Graphics g, Color fill, Color border) {
    g.setColor(fill); 
    g.fillOval(this.x - this.radius, this.y - this.radius, 2 * this.radius, 2 * this.radius);  
    g.setColor(border); 
    g.drawOval(this.x - this.radius, this.y - this.radius, 2 * this.radius, 2 * this.radius);  
  }
  public void moveTo(int x, int y) {
    this.x = x;
    this.y = y; 
  }
  public boolean collide(Circle other) {
	  return Math.sqrt(Math.pow(this.x-other.x, 2) + Math.pow(this.y-other.y, 2)) < this.radius+other.radius;
  }
}