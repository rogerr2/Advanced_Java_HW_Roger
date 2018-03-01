import javax.swing.*;
import java.awt.*;



public class tictactoe extends JFrame{

public tictactoe() {
	
		setSize(622,722);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	

	public void setGame() {
		
		JPanel heading = new JPanel(new BorderLayout());
		App oApp = new App();
		add(oApp, BorderLayout.CENTER);
		show();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
