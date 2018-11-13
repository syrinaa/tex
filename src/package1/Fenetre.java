package package1; 
import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class Fenetre extends Thread implements ActionListener{
 
  Bouton bouton = new Bouton("Stop");
  private Bouton bouton1 = new Bouton("+");
  private Bouton bouton3 = new Bouton("Start");
  private Bouton bouton2 = new Bouton("-");
  private Panneau pan = new Panneau();
  private JLabel label = new JLabel("score: 0");
  private Horloge horloge=new Horloge();
  private JLabel label1=new JLabel("horloge");
  private JPanel container = new JPanel();
  boolean test = false;
  JFrame f=new JFrame();

  int compteur1 = 0;
  private Balle balle=new Balle();
  private double x, y, dx=5, dy=5;

  private int posX = 50;
  private int posY = 50;
  private int rad=50;
  boolean continuer = true;
  JPanel south = new JPanel();

  public Fenetre() throws InterruptedException{
	  
  f.setTitle("Animation");
  f.setSize(500, 500);
  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  f.setLocationRelativeTo(null);
 
    container.setBackground(Color.white);
    container.setLayout(new BorderLayout());
    container.add(pan, BorderLayout.CENTER);

    bouton.addActionListener(this);
  
    bouton1.addActionListener(this);
    bouton3.addActionListener(this);
        
    bouton2.addActionListener(this);
        
    south.add(bouton);
    south.add(bouton3);
    south.add(bouton1);
   
    south.add(bouton2);
    container.add(south, BorderLayout.SOUTH);
     
    JPanel north=new JPanel();
    Font police = new Font("Tahoma", Font.BOLD, 16);
    label.setFont(police);
    label.setForeground(Color.blue);
    label.setHorizontalAlignment(JLabel.CENTER);
    north.add(label);
    horloge.setFont(police);
    horloge.setForeground(Color.blue);
    horloge.setHorizontalAlignment(JLabel.CENTER);
    north.add(horloge);
    container.add(north, BorderLayout.NORTH);
    f.setContentPane(container);
    f.setVisible(true);
    
    horloge.start();
  }
 


 
 public void run() {
	 while(true) {
		System.out.println("con ?");
		while(continuer) {
				try
				  {
					System.out.println("con ?");
				   	pan.deplacer();	
					pan.Collision();			
			    	
				    sleep(10);
					pan.repaint();
					compteur1=pan.compteur;
					label.setText("Score:" + this.compteur1+"      ");
					f.setContentPane(container);
				  }catch (InterruptedException exc) {}
		}
 
				
		
	}
 }
 
public void actionPerformed(ActionEvent arg0) {

    if((arg0.getSource() == bouton)) {//stop
    	continuer=false;
    	System.out.println("false");
    	horloge.stop();
    	
    	
    	
           
    	}
    if((arg0.getSource() == bouton3)) {//start
    	continuer=true;
    	System.out.println("true");
    	horloge.start();
    	
    	}
    	

	  if(arg0.getSource() == bouton1) {//+
		  continuer=true;
  	      pan.ajout(new Balle()); 
  	   
			pan.deplacer();
			  container.add(pan,BorderLayout.CENTER);
		  	   f.setContentPane(container);

		}
    
  	 
  	   
  
	

	 
		  if(arg0.getSource() == bouton2 && compteur1>0) {
		  
			  this.compteur1--;
	    label.setText("Score:" + this.compteur1+"      ");
	    pan.supprimer();
	    container.add(pan,BorderLayout.CENTER);
	    f.setContentPane(container);
	    
		  
		  }
	  }}
      
