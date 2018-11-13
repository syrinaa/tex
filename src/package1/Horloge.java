package package1;
import java.awt.Color;
import java.awt.Font;
import java.awt.color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Horloge extends JLabel implements ActionListener{

	
	private final Timer timer=new Timer(1000,this);
	private  int temps=0;

	public Horloge() {
		
		this.setFont(new Font("Helvetica",Font.BOLD,16));
		this.setForeground(Color.blue);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setText("Temps : 0 s");
}

	public void start(){
			timer.start();
	}
	
public void stop() {
		    timer.stop();
 }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		temps++;
			
      this.setText("Temps :"+temps+" s");
        	}
}
