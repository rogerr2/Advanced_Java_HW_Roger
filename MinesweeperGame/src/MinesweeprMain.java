	/*
vv	 * Programmers: Dalton Larrington, Roger Robinson
	 * Date: 3-25-2018
	 * Description: Minesweeper Game
	 */
	import java.util.Scanner;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import java.awt.BorderLayout;
	import javax.swing.BoxLayout;
	import javax.swing.*;
	import java.awt.Image;
	import java.awt.Component;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
	import java.awt.event.MouseAdapter;

	public class MinesweeprMain extends JFrame{
	  protected Minesweeper object; 
	  private JPanel layout; 
	  private JPanel menu; 
	  private JPanel top, bottom; 

	  private ImageIcon cover;

	  private JButton hard; 
	  private JButton menuReturn;
	  private JLabel text, image, difficulty;
	  
	  public static void main(String[] args){	  
	    MinesweeprMain mine = new MinesweeprMain();
	    
	  }
	  
	    public MinesweeprMain() {
	    object = new Minesweeper();
	    menuOpener();
	    
	  }
	 
	  public void menuOpener(){ 
	    setTitle("Minesweeper");
	    setSize(300,400);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);

	    menu = new JPanel();
	    menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));

	    text = new JLabel();
	    text.setText("Minesweeper");
	    text.setAlignmentX(Component.CENTER_ALIGNMENT);   

	    hard = new JButton();
	    hard.setText("Hard");
	    hard.addMouseListener(new MouseAdapter() {
	    	
	      public void mouseClicked(MouseEvent e) {
	        object.hard();
	        object.buildInit();
	        setSize(1000,1000);
	        difficulty = new JLabel();
	        difficulty.setText("HARD Mode: Minesweeper");
	        buildGui();
	        
	      }
	      
	    });    
	    
	    menu.add(text);    
	    menu.add(hard);

	    add(menu);

	    setVisible(true);
	    
	  }
	  
	  public void buildGui() {
	    getContentPane().removeAll();
	    getContentPane().repaint();
	    layout = new JPanel(new BorderLayout());   
	    top = new JPanel();
	    top.add(difficulty);
	    bottom = new JPanel();
	    menuReturn = new JButton();
	    menuReturn.setText("Return to Menu");
	    menuReturn.addMouseListener(new MouseAdapter( ) {
	    	
	      public void mouseClicked(MouseEvent e) {
	        getContentPane().removeAll();
	        getContentPane().repaint();
	        menuOpener();
	        validate();
	        
	      }
	      
	    }); 



	    bottom.add(menuReturn);


	    layout.add(object.board, BorderLayout.CENTER);
	    layout.add(top, BorderLayout.NORTH);
	    layout.add(bottom, BorderLayout.SOUTH);
	    add(layout);
	    validate();
	    
	  }

	


}
