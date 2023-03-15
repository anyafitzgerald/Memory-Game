import java.util.Scanner;

class memoryTester {
	public static void main (String [] args) {

		// create scanner object to take user input
		Scanner scanner = new Scanner(System.in);

		// level select and intro
		System.out.println("This is a memory game. You will have five lives, to select two cards that match. Find three matches to win. Please select your level. Enter 0 for Easy and 1 for Hard.");
		String level = scanner.nextLine(); // takes the 'level' and puts it in the size
		memory memoryTester = new memory(level);
		
		// allows user to select a shuffle option
		System.out.println("Would you like to shuffle the cards?");
		String answer = scanner.nextLine();
		if (answer.compareTo("yes")==0){
			memoryTester.shuffle();
		}

		// will run infinite loop
		boolean running=true;

		// loop will run while true, while user still has lives and while user has not fiund three matches
		while(running && memoryTester.lives()!=0 && memoryTester.count()!=3) {
			// asks for card input
			System.out.println("Please select a card from options zero through " + memoryTester.maxCard);
			String cardOne = scanner.nextLine();
			System.out.println("Please select another card from options zero through " + memoryTester.maxCard);
			String cardTwo = scanner.nextLine();

			// if it returns 0, it means the string is identical to the given one
			if (cardOne.compareTo("quit")==0 || cardTwo.compareTo("quit")==0) { // if quit in either card input quit
				running = false;	// this will terminate while loop
				System.out.println("Bye!");
			}
			// calls match from memory to check if cards match
			else {
				boolean result = memoryTester.match(cardOne, cardTwo);
			}
		// if user reaches three matches they win
		if (memoryTester.count() == 3){
		 	System.out.println("Congratulations, you won!");

		}
		// if user runs out of lives they loose
		if (memoryTester.lives()==0){
		 	System.out.println("Sorry, you have run out of lives! Game over.");  // program ends if quit entered or reached lives max
		}
	}
	}
}




