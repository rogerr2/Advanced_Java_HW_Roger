	/*
	 * Programmers: Dalton Larrington, Roger Robinson
	 * Date: 3-25-2018
	 * Description: Minesweeper Game
	 */

	import java.util.Random;
	import javax.swing.JPanel;
	import javax.swing.*;
	import java.awt.GridLayout;

	public class Minesweeper {

	  private int length, width; 
	  private Buttons[][] array;
	  protected int[][] key;
	  protected int[][] userArray;
	  private int[][] chainReactionSet;
	  private int bombs;
	  private Random box;
	  protected JPanel board;
	  
	  public Minesweeper() {

	    box = new Random();
	    
	  } 

	  public void hard(){
	    length = 16;
	    width = 30;
	    bombs = 99;
	    
	  }
	  
	  public void buildInit(){
	    bombCount();
	    buildBoard();
	    chainReactionSet = new int[key.length][];
	    for(int i = 0; i < key.length; i++){
	      chainReactionSet[i] = key[i].clone();
	      
	    }
	    
	  }
	  
	  // Spawns the bombs inside the board
	  public void bombCount(){
	    key = new int[length][width];
	    for(int i = 0; i< bombs; i++){
	      key[box.nextInt(length)][box.nextInt(width)] = 9;
	      
	    }
	    
	    toString(key);
	    numberBoard();
	    genUserArray();
	    
	  }
	  
	  // Method will check the condition of the win and if the the correct amount of bombs are flagged
	  public void playerWin() {    
	    boolean isWin = true;
	    for(int i = 0 ; i < userArray.length; i ++){
	      for(int a = 0 ; a < userArray[0].length; a++){
	        if(array[i][a].isMine == true && array[i][a].isFlagged == false){
	          isWin = false;

	        }

	        else if(array[i][a].isFlagged == false && array[i][a].isEnabled == true){
	          isWin = false;

	        }
	        
	      }
	      
	    } 
	    
	    if(isWin == true){
	      win();
	      
	    }

	  }
	  
	  // Determines when the user wins
	  public void win(){
	    for(int i = 0; i < key.length; i++){
	      for(int a = 0; a < key[0].length; a++){
	        array[i][a].isEnabled = false;
	        
	      }
	      
	    }
	    
	    JOptionPane.showMessageDialog(null, "You won");
	    
	  }

	  // Generates the numbers within the board
	  private void numberBoard(){
	    for (int i = 0; i < key.length; i++){
	      for (int a = 0; a < key[0].length; a++){      
	        if (key[i][a] == 0){
	          int count = 0;         
	          for (int x = -1; x < 2; x++){
	            for (int y = -1; y < 2; y++){             
	              int testX = i + x;
	              int testY = a + y;             
	              if ((testX >= 0 && testX < length) && (testY >= 0 && testY < width)) {           
	                if (key[testX][testY] == 9){count++;}

	              }
	              
	            }
	            
	          }
	          
	          key[i][a] = count;

	        }

	      }
	      
	    }
	    
	  }

	  private void genUserArray() {
	    userArray = new int[length][width];
	    for(int i = 0; i < userArray.length; i++) {
	      for(int a = 0; a < userArray[0].length; a++) {
	        userArray[i][a] = 14;
	        
	      }
	      
	    }
	    
	  }

	  // Builds the board
	  private JPanel buildBoard() {
	    board = new JPanel(new GridLayout(length,width));
	    array = new Buttons[length][width];
	    for(int i = 0; i < userArray.length; i++) { 
	      for(int a =0 ; a < userArray[0].length; a++) {
	        array[i][a] = new Buttons(i,a,this);
	        array[i][a].changeIcon(userArray[i][a]);
	        if(key[i][a] == 9){array[i][a].isMine = true;}       
	        board.add(array[i][a].button);
	        
	      }
	      
	    }
	    
	    return board;
	    
	  }

	  // Method that causes multiple buttons to become exposed given a specific condition
	  public void chainReaction(int col, int row) {
	    chainReactionSet[col][row] = -2;
	    if(key[col][row] != 0) {
	      array[col][row].updateNum(key[col][row]);
	      array[col][row].isEnabled = false;
	      array[col][row].isNumbered = true;
	      
	    }
	    
	    else if(key[col][row] == 0) {
	      array[col][row].changeIcon(key[col][row]);
	      array[col][row].isEnabled = false;
	      array[col][row].isBlank = true;
	      for (int x = -1; x < 2; x++) {
	        for (int y = -1; y < 2; y++) {        
	          int X = col + x;
	          int Y = row + y;         
	          if ((X >= 0 && X < length) && (Y >= 0 && Y < width)) {          
	            if (key[X][Y] != 9 && chainReactionSet[X][Y] != -2) {            	
	              chainReaction(X, Y);

	            }

	          }
	          
	        }

	      }
	      
	    }

	  }
	  
	  public static void toString(int[][] arr) {
	    for(int a[] : arr) {
	      for(int b : a) {
	        System.out.print(b + " ");
	        
	      }
	      
	      System.out.println();
	      
	    }
	    
	  }
	  
	  // Determines when the user loses
	  public void lost() {
	    for(int i = 0; i < userArray.length; i++) {
	      for(int a = 0; a < userArray[0].length; a++) {
	        array[i][a].isEnabled = false;
	        if(userArray[i][a] == 13){
	          continue;
	          
	        }
	        
	        if(userArray[i][a] == 10 && key[i][a] != 9) {
	          array[i][a].changeIcon(12);
	          
	        }
	        
	        else if(userArray[i][a] == 10 && key[i][a] == 9) {
	          continue;
	          
	        }
	        
	        else if(key[i][a] == 0 || key[i][a] == 9) {
	          array[i][a].changeIcon(key[i][a]);
	          
	        }
	        
	        else {
	          array[i][a].updateNum(key[i][a]);
	          
	        }
	        
	      }
	      
	    }
	    
	    JOptionPane.showMessageDialog(null, "You lost");
	    
	  }
	  
	

}
