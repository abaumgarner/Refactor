import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Aaron Baumgarner
 * Notes: This class is to extract all of the user prompting done in the Dungeon class. More of a style of mine.
 * 			I did rework the inputs to user the Scanner object that was added to Java since this program was written.
 */

public class PromptUser {
	private Scanner kb;

	public PromptUser() {
		this.kb = new Scanner(System.in);
	}

	/*-------------------------------------------------------------------
	chooseHero allows the user to select a hero, creates that hero, and
	returns it.  It utilizes a polymorphic reference (Hero) to accomplish
	this task
	---------------------------------------------------------------------*/
	public Hero chooseHero() {
		String choice = promptForCharacter();

		int option = Integer.parseInt(choice);

		if (option == 1)
			return new Warrior();
		else if (option == 2)
			return new Sorceress();
		else
			return new Thief();

	}// end chooseHero method

	private String promptForCharacter() {
		String choice;
		Matcher matches;
		Pattern pattern;

		do {
			displayCharacters();
			choice = kb.nextLine();

			pattern = Pattern.compile("[1-3]");
			matches = pattern.matcher(choice);

			if (!matches.matches())
				System.out.println("Invalid choice");
		} while (!matches.matches());

		return choice;
	}

	private void displayCharacters() {
		System.out.println("Choose a hero:");
		System.out.println("1. Warrior");
		System.out.println("2. Sorceress");
		System.out.println("3. Thief");
		System.out.print("Choice: ");
	}

	/*-------------------------------------------------------------------
	playAgain allows gets choice from user to play another game.  It returns
	true if the user chooses to continue, false otherwise.
	---------------------------------------------------------------------*/
	public boolean playAgain() {
		String again;

		System.out.println("Play again (y/n)?");
		again = kb.nextLine();

		return (again.equalsIgnoreCase("Y"));
	}// end playAgain method

	/*
	 * Allows for the user to just press enter by using the Scanner object
	 */
	public String bailOut() {
		System.out.print("\n-->q to quit, press enter to continue: ");
		return kb.nextLine();
	}

	public void close() {
		this.kb.close();
	}
}
