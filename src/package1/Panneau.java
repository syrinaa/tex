package package1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JPanel;

public class Panneau extends JPanel {
  private int posX = 50;
  private int posY = 50;
  Random rand=new Random();
  Thread th;
  boolean continuer=true;
  Fenetre ff;
  int compteur;
  ArrayList<Balle> balles = new ArrayList<Balle>();

 public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		for(int i=0;i<balles.size();i++) {
			g.setColor(balles.get(i).coul);
			balles.get(i).paintComponent(g);
}
	}

public void supprimer() {
	if(balles.size()>0) {
		balles.remove(balles.size()-1);
	}
}
synchronized void suspendre()
{
  continuer = false;
  

}
synchronized void reprendre()
{
    continuer = true;
	notify();
}
  public void ajout(Balle balle) {
	if(balles.size()<100) {
		int maxX=this.getWidth();
		int maxY=this.getHeight();
	if(rand.nextFloat()>0.5) {
		balle.setDirectX(1);
	}else {
		balle.setDirectX(-1);
	}
	if(rand.nextFloat()>0.5) {
		balle.setDirectY(1);
	}else {
		balle.setDirectY(-1);
	}
	balle.posX=balle.dx+(int)(rand.nextFloat()*(((maxX-balle.dx)+1)));
	balle.posY=balle.dx+(int)(rand.nextFloat()*(((maxY-balle.dx)+1)));
	balle.coul= balle.randomColor();
	balles.add(balle);}
	}
  
  public void deplacer(){
		 for(int i=0;i<balles.size();i++) {
			  balles.get(i).setPosX(balles.get(i).posX+balles.get(i).getDirectX());
			  balles.get(i).setPosY(balles.get(i).posY+balles.get(i).getDirectY());
			  balles.get(i).repaint();
			  
			  if(balles.get(i).getPosX()>this.getWidth()-balles.get(i).dx) balles.get(i).setDirectX(-1);
			  if(balles.get(i).getPosY()>this.getHeight()-balles.get(i).dx) balles.get(i).setDirectY(-1);
			  
			  if(balles.get(i).getPosX()<=0) balles.get(i).setDirectX(1);
			  if(balles.get(i).getPosY()<=0) balles.get(i).setDirectY(1);
			 }

  }
  public void Collision() {
	  
	 ArrayList<Balle>bal=new ArrayList<Balle>();
	 
	  for (int i=0;i<balles.size();i++) {
		  
		  for(int j=i+1;j<balles.size();j++) {
		
			  double rx1=balles.get(i).getPosX()+(balles.get(i).dx/2);
			  double rx2=balles.get(j).getPosX()+(balles.get(j).dx/2);
			  double l1=Math.abs(rx1-rx2);
			  double ry1=balles.get(i).getPosY()+(balles.get(i).dx/2);
			  double ry2=balles.get(j).getPosY()+(balles.get(j).dx/2);
			  double l2=Math.abs(ry1-ry2);
	    
			   if (Math.pow(l1, 2)+Math.pow(l2, 2)<=Math.pow((balles.get(i).dx),2)) {
	
			         	 bal.add(balles.get(i));
			         	 bal.add(balles.get(j));
			         	 compteur++;
			             System.out.println(compteur);
   }  }  }
	
         for(int i=0;i<bal.size();i++) {
		   balles.remove(bal.get(i));
	
	  }

 
  }
public void cancel() {
	// TODO Auto-generated method stub
	th.interrupt();
}}
