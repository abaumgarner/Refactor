package promptUser;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import character.Hero;
import characterBuilders.HeroBuilder;

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

	public Hero forHeroChoice(String[] characterClasses) {
		String choice = promptForCharacter(characterClasses);

		int option = Integer.parseInt(choice);
		HeroBuilder builder = new HeroBuilder();

		return builder.buildHero(characterClasses[option - 1]);

	}

	private String promptForCharacter(String[] characterClasses) {
		String choice;

		do {
			displayCharacters(characterClasses);
			choice = kb.nextLine();

			if (!regex(choice, "[1-3]"))
				System.out.println("Invalid choice");
		} while (!regex(choice, "[1-3]"));

		return choice;
	}

	private boolean regex(String str, String strPattern) {
		Matcher matches;
		Pattern pattern;

		pattern = Pattern.compile(strPattern);
		matches = pattern.matcher(str);

		return matches.matches();
	}

	private void displayCharacters(String[] characterClasses) {
		for (int i = 0; i < characterClasses.length; i++)
			System.out.println(i + 1 + ". " + characterClasses[i]);

		System.out.print("Choice: ");
	}

	public boolean forPlayingAgain() {
		String again;

		System.out.println("Play again (y/n)?");
		again = kb.nextLine();

		return (again.equalsIgnoreCase("Y"));
	}

	public boolean forBailingOut() {
		System.out.print("\n-->q to quit, press enter to continue: ");
		return kb.nextLine().equalsIgnoreCase("q");
	}

	public int forAttack(String character) {
		String choice, pattern = "[1-2]";

		do {
			System.out.println("1. Attack Opponent");

			if (character.equalsIgnoreCase("Warrior"))
				displayWarriorSpecialAttack();
			else if (character.equalsIgnoreCase("Sorceress"))
				displaySorceressSpecailAttack();
			else
				displayThiefSpecialAttack();

			System.out.print("Choose an option: ");
			choice = kb.nextLine();

			if (!regex(choice, pattern))
				System.out.println("invalid choice!");
		} while (!regex(choice, pattern));

		return Integer.parseInt(choice);
	}

	private void displayThiefSpecialAttack() {
		System.out.println("2. Surprise Attack");
	}

	private void displaySorceressSpecailAttack() {
		System.out.println("2. Increase Hit Points");
	}

	private void displayWarriorSpecialAttack() {
		System.out.println("2. Crushing Blow on Opponent");
	}

	public String forCharacterName() {
		String str, pattern = "[A-z]+";

		do {
			System.out.print("Enter character name: ");
			str = kb.nextLine();
			if (!regex(str, pattern))
				System.out.println("Invalid name.");
		} while (!regex(str, pattern));

		return str;
	}

	public void closePrompt() {
		this.kb.close();
	}
}
