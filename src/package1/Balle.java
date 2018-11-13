package package1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JPanel;

public class Balle extends JPanel{
 int X, Y;
int posX;
int posY;
int directX;
int directY;
int dx;
public Color randomColor;
Color coul;
	
    public Balle() {
    	posX=0;
    	posY=0;
    	dx=50;
    	directX=1;
    	directY=1;    
    }
 
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		
		g.fillOval(posX, posY, dx, dx);
		
	}
	public Color randomColor() {
	    Random random=new Random();
		float r = random.nextFloat();
		float g = random.nextFloat();
		float b = random.nextFloat();
		Color randomColor=new Color(r,g,b);
		return randomColor;
		
		
	}
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX=posX;
	}
	public int getPosY() {
		return posY;
		
}
	public void setPosY(int posY) {
		this.posY=posY;}
	
	public int getDirectX() {
			return directX;
		}
	public int getDirectY() {
			return directY;
		}
	public void setDirectX(int X) {
			this.directX=X;}
	public void setDirectY(int Y) {
			this.directY=Y;
		}

		}


