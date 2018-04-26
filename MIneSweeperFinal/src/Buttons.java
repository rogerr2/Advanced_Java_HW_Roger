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

public class Buttons { 
	
  protected int status, col,row; 
  protected JButton button;
  private MineSweeper mine;
  protected boolean isEnabled;
  protected boolean isMine;
  protected boolean isFlagged;
  protected boolean isNumbered;
  protected boolean isBlank;
  
  public Buttons(int i, int a, MineSweeper mine) {
    isEnabled = true;    
    isBlank = false;
    col = i;
    row = a;
    
    this.mine = mine;
    
    button = new JButton();   
    button.addMouseListener(new MouseAdapter() {
    	
    // Detects a left click on the buttons
      public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
          if(isEnabled) {
            if(mine.userArray[col][row] == 10){    
            	
            }    
            
            // Determines if the player loses and opens the board to show all buttons
            else
            	if(mine.key[col][row] == 9){
              mine.userArray[col][row] = 13;
              changeIcon(13);
              mine.lost();
              
            }
            
            // Updates the board to create a chain reaction if the button is 0
            else if(mine.key[col][row] == 0) {
              mine.chainReaction(col,row);

            }

            // Updates the buttons
            else {
              if(isEnabled) {
                mine.userArray[col][row] = mine.key[col][row];
                updateBoard(mine.key[i][a]);
                isEnabled = false;
                isNumbered = true;
                
              }

            }
            
            // Updates the bomb count
            mine.bombCount();
            
          }

        }        
        
        // Will check for a right click and refresh the board to a new board
        else if(e.getButton() == MouseEvent.BUTTON3) {
          if(isEnabled) {
            if(mine.userArray[col][row] == 10) {
              mine.userArray[col][row] = 14;
              status = 14;
              changeIcon(14);
              isFlagged = false;
              
            }            
            
            else if(mine.userArray[col][row] == 14 ) {
              mine.userArray[col][row] = 10;
              status = 10;
              changeIcon(10);
              isFlagged = true;
              
            }
            
            // Updates bomb count
            mine.bombCount();
            
          }

        }

      }
      
    });    

  }
  
  // Updates the board 
  public void updateBoard(int num) {
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
  
  // Changes the icon of the button depending on what number the button is
  public void changeIcon(int img) { 
    status = img;
    String image = status + "logo.png";
    ImageIcon box = new ImageIcon(image);


    button.setIcon(box);

  }
  
  public JButton addCell() {
    return button;
    
  }
  
}