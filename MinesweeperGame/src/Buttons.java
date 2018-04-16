	/*
	 * Programmers: Dalton Larrington, Roger Robinson
	 * Date: 3-25-2018
	 * Description: Minesweeper Game
	 */

	import javax.swing.*;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
	import java.awt.event.MouseAdapter;
	import java.awt.Insets;

	public class Buttons{ 
	  protected int status, col,row; //status records the current STATUS OF THE CELL
	  protected JButton button;
	  private Minesweeper mine;
	  protected boolean isEnabled;
	  protected boolean isMine;
	  protected boolean isFlagged;
	  protected boolean isNumbered;
	  protected boolean isBlank;
	  
	  public Buttons(int i,int a, Minesweeper mine) {
	    isEnabled = true;
	    isFlagged = false;
	    isBlank = false;
	    col = i;
	    row = a;
	    
	    this.mine = mine;
	    
	    button = new JButton();   
	    button.addMouseListener(new MouseAdapter() {
	    	
	      public void mouseClicked(MouseEvent e) {
	        if(e.getButton() == MouseEvent.BUTTON1) {
	          if(isEnabled){
	            if(mine.userArray[col][row] == 10){}
	            else if(mine.key[col][row] == 9){
	              mine.userArray[col][row] = 13;
	              changeIcon(13);
	              mine.lost();
	              
	            }
	            
	            else if(mine.key[col][row] == 0) {
	              mine.chainReaction(col,row);

	            }

	            else {
	              if(isEnabled){
	                mine.userArray[col][row] = mine.key[col][row];
	                updateNum(mine.key[i][a]);
	                isEnabled = false;
	                isNumbered = true;
	                
	              }

	            }
	            
	            mine.bombCount();
	            
	          }

	        }
	        
	        else if(e.getButton() == MouseEvent.BUTTON3) {
	          if(isEnabled) {
	            if(mine.userArray[col][row] == 10){
	              mine.userArray[col][row] = 14;
	              status = 14;
	              changeIcon(14);
	              isFlagged = false;
	              
	            }
	            
	            else if(mine.userArray[col][row] == 14 ){
	              mine.userArray[col][row] = 10;
	              status = 10;
	              changeIcon(10);
	              isFlagged = true;
	              
	            }
	            
	            mine.bombCount();
	            
	          }

	        }

	      }
	      
	    });    

	  }
	  
	  public void updateNum(int num) {
	    status = num;
	    button.setIcon(null);
	    String text = Integer.toString(num);
	    System.out.println(num);
	    button.setText(text);

	    button.setBorder(null);
	    button.setBorderPainted(false);
	    button.setMargin(new Insets(0,0,0,0));
	    button.setEnabled(false);
	    
	  }
	  
	  public void changeIcon(int img) { 
	    status = img;
	    String directory = "../img/" + status + "box.png";
	    ImageIcon box = new ImageIcon(directory);


	    button.setIcon(box);

	  }
	  
	  public JButton addCell() {
	    return button;
	    
	  }
	  
	}


