/ Final project. A memory game that allows user to select two each turn. If they 
// are able to find three matches the user 'wins'. They have five lives, if they run out they lose.
// User also has an option to shuffle and quit. 
// Anya Fitzgerald

public class memory {
	
	int [][] myCards;  // initialize 2D array of cards
	int n = 5; // keeps track of lives
	int c = 0; // keeps track of successful matches
	String level; // initialize level varibale
	String maxCard; // initialize maxcard varibale

	// fills the array with the respective level information 
	public memory(String lvl){
		level = lvl;
		if (level.compareTo("0") == 0) { 
			int [][] cards = {{1,2,3,4,5,6}, {6,5,4,3,2,1}}; 
			myCards=cards; 
			maxCard = "five: ";  // fills out instructions
		}
		else {
			int [][] cards = {{1,2,3,4,5,6,7,8,9}, {9,8,7,6,5,4,3,2,1}};
			myCards=cards;
			maxCard = "eight: "; // fills out instructions
		}
	}
	
	// compare cards
	public boolean match(String cardOne, String cardTwo){   // pass in cardone and cardtwo

		// finds user inputted card in array 
		int cardOneNum = Integer.parseInt(cardOne);
		int cardTwoNum = Integer.parseInt(cardTwo);
	
		int one = myCards[0][cardOneNum];   
		int two = myCards[1][cardTwoNum];
		
		// compares the two cards selcted and returns information to user
		if (one == two){
			System.out.println("They match!");
			c++; // stores a "match" for user
			System.out.println("You have found " + c + " match(es).");
			return true;
		}
		else{
			System.out.println("The cards did not match.");
			n--; // takes away a life
			System.out.println("You have " + n + " lives left.");
			return false;
			
		}
	}

	// swaps a few four cards in the array
	public int[][] shuffle(){
	 	int swap = myCards[1][2];
	 	myCards[1][2]= myCards[1][4];
	 	myCards[1][4] = swap;

	 	int temp = myCards[1][5];
	 	myCards[1][5]= myCards[1][1];
	 	myCards[1][1] = temp;
	 	return myCards;
	}

	// returns successful matches
	public int count(){
		return c;
	}

	// returns number of lives
	public int lives(){ 
		return n;
	}
}