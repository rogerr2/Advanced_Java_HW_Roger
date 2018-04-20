	/*
	 * Programmers: Dalton Larrington, Roger Robinson
	 * Date: 3-25-2018
	 * Description: Minesweeper Game
	 */
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.lang.model.type.ArrayType;
import javax.swing.*;
import java.awt.Image;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.awt.event.MouseAdapter;

	public class MinesweeperMain extends JFrame{
		 protected Minesweeper object; 
		  private JPanel layout; 
		  private JPanel menu; 
		  private JPanel top, bottom; 
		  private ImageIcon cover;
		  private JButton easy; 
		  private JButton medium;
		  private JButton hard;
		  private JButton menuReturn;
		  private ArrayType button;
		  private JLabel text, image, difficulty;
		  
		  public static void main(String[] args) {	  
		    MinesweeperMain mine = new MinesweeperMain();
		    
		  }
		  
		    public MinesweeperMain() {
		    object = new Minesweeper();
		    menuOpener();
		    
		  }
		 
		  public void menuOpener() { 
		    setTitle("Minesweeper");
		    setSize(300, 400);
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setResizable(false);

		    menu = new JPanel();
		    menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));

		    text = new JLabel();
		    text.setText("Minesweeper");
		    text.setAlignmentX(Component.CENTER_ALIGNMENT);   
		    
		    cover = new ImageIcon("logo.png");
		    image = new JLabel(cover);
		    image.setAlignmentX(Component.CENTER_ALIGNMENT);

		    easy = new JButton();
		    easy.setText("Easy");
		    easy.addMouseListener(new MouseAdapter() {
		    	
		      public void mouseClicked(MouseEvent e) {
		        object.easy();
		        object.buildInit();        
		        difficulty = new JLabel();
		        difficulty.setText("Easy Difficulty - Minesweeper");
		        buildGui();
		        
		      }
		      
		    }); 
		    
		    easy.setAlignmentX(Component.CENTER_ALIGNMENT);
		    
		    medium = new JButton();
		    medium.setText("Medium");
		    medium.addMouseListener(new MouseAdapter() {
		    	public void mouseClicked(MouseEvent e) {
		    		object.medium();
		    		object.buildInit();
		    		setSize(400, 400);
		    		difficulty = new JLabel();
		    		difficulty.setText("Medium Difficulty - Minesweeper");
		    		buildGui();
		    		    		
		    	}    	
		    	
		    	
		    });
		    
		    medium.setAlignmentX(Component.CENTER_ALIGNMENT);
		    
		   hard = new JButton();
		   hard.setText("Hard");
		   hard.addMouseListener(new MouseAdapter() {	   
			   public void mouseClicked(MouseEvent e) {
				   object.hard();
				   object.buildInit();
				   setSize(700, 700);
				   difficulty = new JLabel();
				   difficulty.setText("Hard Difficulty - Minesweeper");
				   buildGui();
				   
			   }
			   
		   });
		   
		   hard.setAlignmentX(Component.CENTER_ALIGNMENT);
		   
		   menu.add(text);
		   menu.add(easy);
		   menu.add(medium);
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
		  
		  public void mouseClicked(MouseEvent arg0) {
			  
			  for (int a = 0; a < button.length; a++) {
				  button[a][b] = new JButton("");
				  button[a][b].addActionListener(this);
				  final int finalB = b;
				  final int finalA = a;
				  button[a][b].addMouseListener(new MouseAdapter() {
					  
					  @Override
					  public void mousePressed (MouseEvent e) {
						  if (SwingUtilities.isRightMouseButton(e)) {
							  mineFlagger(true, finalA, finalB);					  
							  
						  }				  
						  
					  }
					  
				  });
				  
				  layout.add(button[a][b]);
				  
			  }
			  
		  }
		  
		  public void mineFlagger (boolean flag, int x, int y) {
			  button[x][y].setText("F");
			  
			  
		  }

		}
