import javax.swing.*;

//Just a JFrame class in order to display the game in here
public class Frame extends JFrame 
{
	
	//Declare and instantiate a "myPanel" Panel
	Panel myPanel = new Panel();
	
	
	//Constructor
	Frame()
	{
		this.setTitle("Tic Tac Toe");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(600, 600);
		
		this.add(myPanel);
		this.setVisible(true);
	}
}
