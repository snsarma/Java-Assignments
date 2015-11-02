/*
 * Scrabble.java
 * Versions
 *  $ Id $
 * Revisions 
 *  $ Log $
 * 
 * 
 */

/*
 * Scrabble.java
 * Versions
 *  $ Id $
 * Revisions 
 *  $ Log $
 * 
 * 
 */

/*
 * @ author Shravya Narayan Sarma
 *          sxn8837
 *          
 * 
 */
 
/* Java class to implement the concept of the Board Game Scrabble with the utilization of Swings */

/* Referred Professor Hans-Peter Bischof's code to implement event handling which is detailed in Calculator Layout example(13.23) on his slides */

/* I have implemented the Scrabble board game as per the standard dimensions of 15*15 board and  a random alphabet generator It does not calculate the score and is a single player game */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Scrabble extends JFrame {
	
  static String str;                      /* str variable is declared as static since it is a single copy which accessed by both the methods */
  Random gen = new Random();              /* Create an object gen of type Random */
	String[] alphabetList = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	int[]rand = {gen.nextInt(26),gen.nextInt(26),gen.nextInt(26),gen.nextInt(26),gen.nextInt(26),gen.nextInt(26),gen.nextInt(26),gen.nextInt(26),gen.nextInt(26)};
	JButton[][] button = new JButton[225][225];
	JButton jbutton;
    /* alphabet list array to store all of the alphabets */
	 /* Rand Integer Array to store the random numbers */
	/*  button is a 2-D array of type JButton to implement the scrabble board */
	
	public Component createWords()
	{
		JPanel jPanel=new JPanel(new GridLayout(1,7,0,0));
		jPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		for(int k=0;k<8;k++){
	    	 
         jbutton = new JButton(alphabetList[rand[k]]);          /*Creates the button with the specified alphabet*/
	    	 jbutton.setSize(50,50);
         jPanel.add(jbutton);									             /* A method to create random alphabets generator */
	    
        jbutton.addActionListener(
        new ActionListener() {
                     	
                         public void actionPerformed(ActionEvent e) {
                         JButton o;
                         o=(JButton)e.getSource();				 /* When the buttons in the random alphabet generator are clicked the text is is stored in the string str */ 
                         str=o.getText();                                                    

                         }
                  }
              );

	    }
			
		return(jPanel);                                     /* Returns the panel */
	}
	
  
	 public Component createScrabbleBoard(){
	 
		JPanel jPanel=new JPanel(new GridLayout(15,15));         /* Function to create a scrabble board  */
		jPanel.setBorder(BorderFactory.createLoweredBevelBorder());
	   for(int i=0 ; i<15;i++){

	      for(int j=0;j<15;j++){  
  	        
            if(((i==0)&&(j==0))||((i==14)&&(j==14))||(((i==0)&&(j==7)))||(((i==0)&&(j==14)))||(((i==14)&&(j==0)))){  
  	        	button[i][j]=new JButton("3*WS");
  	             button[i][j].setBackground(Color.RED);
  	          }
  	        else if((i==7)&&(j==7)){ 
  	            	 button[i][j]=new JButton("*");
  	            	button[i][j].setBackground(Color.WHITE);
  	          }
  	        else if((i==0)&&(j==3)||((i==0)&&(j==11))||((i==2)&&(j==7))||((i==2)&&(j==9))||((i==3)&&(j==0))||((i==3)&&(j==7))||((i==3)&&(j==14))||((i==6)&&(j==2))||((i==6)&&(j==6))||((i==6)&&(j==8))||((i==6)&&(j==12))||((i==7)&&(j==3))||((i==7)&&(j==11))||((i==8)&&(j==2))||((i==8)&&(j==6))||((i==8)&&(j==8))||((i==8)&&(j==12))||((i==11)&&(j==7))||((i==11)&&(j==14))||((i==11)&&(j==0))||((i==12)&&(j==6))||((i==12)&&(j==8))||((i==14)&&(j==3))||((i==14)&&(j==11))){
  	        	 button[i][j]=new JButton("2*LS");
  	        	 button[i][j].setBackground(Color.CYAN); 
  	         }
  	        else if(((i==1)&&(j==5))||((i==1)&&(j==9))||(((i==5)&&(j==1)))||(((i==5)&&(j==5)))||(((i==5)&&(j==9)))||((i==9)&&(j==9))||((i==9)&&(j==1))||((i==9)&&(j==5))||((i==9)&&(j==13))){
  	        	button[i][j]=new JButton("3*LS");
  	        	button[i][j].setBackground(Color.BLUE);
  	        }
  	        else if(((i==1)&&(j==1))||((i==1)&&(j==13))||(((i==2)&&(j==2)))||(((i==2)&&(j==12)))||(((i==3)&&(j==3)))||((i==3)&&(j==11))||((i==4)&&(j==4))||((i==4)&&(j==10))||((i==10)&&(j==4))|| ((i==10)&&(j==10))||((i==11)&&(j==3))||((i==10)&&(j==4))||((i==10)&&(j==10))||((i==11)&&(j==3))||((i==11)&&(j==11))||((i==12)&&(j==2))||((i==12)&&(j==12))||((i==13)&&(j==1))||((i==13)&&(j==13))){	
  	        		button[i][j]=new JButton("2*WS"); 
  	        		button[i][j].setBackground(Color.PINK);
  	        }		
  	        else{
  	            button[i][j]=new JButton(" ");          /* The above loop is meant for designing the scrabble board */
  	          
  	          jPanel.add(button[i][j]);

            }  
  	          
  	        button[i][j].addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                        	JButton o;
                            o=(JButton)e.getSource();		/* Displays the text or the alphabet chosen on the other grid */
                            o.setText(str);

                        }
                 }
             );

           }
	    }
	   
	   
	   
	   return(jPanel);
	   	
  }
	    
	    
	public Component createComponents() {
        JPanel pane = new JPanel();
        pane.setBorder(BorderFactory.createLoweredBevelBorder());
        pane.setLayout(new FlowLayout( FlowLayout.CENTER, 5, 5) );  /* create the Components and add them to the panel and return it */
        pane.add(createScrabbleBoard());
        pane.add(createWords());
        return pane;
    }
	
	
	public static void main(String[] args) {
		
		Scrabble frame = new Scrabble();		       /* Scrabble extends JFrame create an object frame of type scrabble*/
		Component content=frame.createComponents();
		frame.setTitle("Scrabble");                /* Sets the title of the window as Scrabble */
		frame.getContentPane().add(content);        
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);                   /* Sets the visibility of frame to true */
	    
		
	}

}
