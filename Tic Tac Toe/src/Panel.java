import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


//JPanel class to place components on it 

public class Panel extends JPanel implements ActionListener
{
	//Variabels declaration
	Image X = new ImageIcon("D:\\Github local repositories\\Tic tac toe\\Tic Tac Toe\\photos\\RedX.png").getImage();
	Image O = new ImageIcon("D:\\Github local repositories\\Tic tac toe\\Tic Tac Toe\\photos\\RedO.png").getImage();
	
	JButton[] myButton = new JButton[9]; //Allocate memory for 9 JButtons
	int p ; //Player's id that is his turn
	int round ; //round of the game (is used to define who is playing and to change the symbol)
	int[] player1Choices = new int[9]; //The tiles that player1 has played
	int[] player2Choices = new int[9]; //The tiles that player1 has played
	
	//Setters - Getters
	public void setP(int p)
	{
		this.p = p;
	}
	
	public void setRound(int round)
	{
		this.round = round ;
	}
	
	public int getP()
	{
		return this.p;
	}
	
	public int getRound()
	{
		return this.round;
	}
	
	//Constructor
	Panel()
	{
		this.setBackground(Color.black);
		this.setLayout(new GridLayout(3,3,1,1)); //Setting the layout to a "3x3 Board"
		
		this.setRound(1);
		
		
		for(int i = 0 ; i < 9 ; i++)
		{
			myButton[i] = new JButton(); //Creating 9 JButtons to display the board
			this.add(myButton[i]); //Add 9 buttons (3x3)
			myButton[i].setFocusable(false);  
			myButton[i].addActionListener(this); //Setting the buttons to perform the ActionListener interface

		}	
		
		
		//Setting the values of players choices to some crap
		for(int i = 0 ; i < 9 ; i++) //Player1
		{
			this.player1Choices[i] = 0; 
			this.player2Choices[i] = 0;
		}
		
		//Getting the coordinates of every button(for placing X and O)
		//System.out.println(myButton1.getLocation());
	}
	
	//Defines which player's turn is 
	public void changePlayer()
	{
		if(this.getRound() % 2 == 0)
			this.setP(2);
		else
			this.setP(1);
	}
	
	public void checkWinner()
	{	
		int i = 0;
		if(this.getP() == 1)
		{
			if( ((this.player1Choices[0] == this.player1Choices[1]) && (this.player1Choices[1] == this.player1Choices[2]) && this.player1Choices[0] == 1)
				|| 	 ((this.player1Choices[0] == this.player1Choices[3]) && (this.player1Choices[3] == this.player1Choices[6]) && this.player1Choices[0] == 1)
				||   ((this.player1Choices[0] == this.player1Choices[4]) && (this.player1Choices[4] == this.player1Choices[8]) && this.player1Choices[0] == 1)
				||   ((this.player1Choices[3] == this.player1Choices[4]) && (this.player1Choices[4] == this.player1Choices[5]) && this.player1Choices[3] == 1)
				||   ((this.player1Choices[6] == this.player1Choices[7]) && (this.player1Choices[7] == this.player1Choices[8]) && this.player1Choices[6] == 1)
				||   ((this.player1Choices[2] == this.player1Choices[5]) && (this.player1Choices[5] == this.player1Choices[8]) && this.player1Choices[2] == 1)
				||	 ((this.player1Choices[1] == this.player1Choices[4]) && (this.player1Choices[4] == this.player1Choices[7]) && this.player1Choices[1] == 1)
					)
				JOptionPane.showMessageDialog(null, "PLAYER 1 WON", "INFO", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			if( ((this.player2Choices[0] == this.player2Choices[1]) && (this.player2Choices[1] == this.player2Choices[2]) && this.player2Choices[0] == 2)
				|| 	 ((this.player2Choices[0] == this.player2Choices[3]) && (this.player2Choices[3] == this.player2Choices[6]) && this.player2Choices[0] == 2)
				||   ((this.player2Choices[0] == this.player2Choices[4]) && (this.player2Choices[4] == this.player2Choices[8]) && this.player2Choices[0] == 2)
				||   ((this.player2Choices[3] == this.player2Choices[4]) && (this.player2Choices[4] == this.player2Choices[5]) && this.player2Choices[3] == 2)
				||   ((this.player2Choices[6] == this.player2Choices[7]) && (this.player2Choices[7] == this.player2Choices[8]) && this.player2Choices[6] == 2)
				||   ((this.player2Choices[2] == this.player2Choices[5]) && (this.player2Choices[5] == this.player2Choices[8]) && this.player2Choices[2] == 2)
				||   ((this.player2Choices[1] == this.player2Choices[4]) && (this.player2Choices[4] == this.player2Choices[7]) && this.player2Choices[1] == 2)	
					)
				JOptionPane.showMessageDialog(null, "PLAYER 2 WON", "INFO", JOptionPane.INFORMATION_MESSAGE);

		}	
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		for(int i = 0 ; i < 9 ; i++)
		{
			if(e.getSource() == myButton[i]) //Which button is clicked on
			{
				this.changePlayer();//Define who's turn is
				
				//Draw player's unique symbol and check for possible winner
				if(this.getP() == 1)
				{
					myButton[i].setIcon(new ImageIcon(X));
					this.player1Choices[i] = 1;
					checkWinner();
				}
				else
				{
					myButton[i].setIcon(new ImageIcon(O));
					this.player2Choices[i] = 2;
					checkWinner();
				}
				
				this.setRound(this.getRound() + 1); //Next round
				
				myButton[i].setBackground(Color.black);
				myButton[i].setEnabled(false); //Cannot change it anymore 
			}
		}
	}
	
}
