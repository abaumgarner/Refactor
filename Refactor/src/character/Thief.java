package character;

import promptUser.PromptUser;

/**
 * Title: Description: Copyright: Copyright (c) 2001 Company:
 * 
 * @author
 * @version 1.0
 */

public class Thief extends Hero {

	public Thief() {
		super(.5);
		super.setName("Thief");
		super.setHitPoints(75);
		super.setAttackSpeed(6);
		super.setChanceToHit(.8);
		super.setDamageMin(20);
		super.setDamageMax(40);
	}

	public void surpriseAttack(DungeonCharacter opponent) {
		double surprise = Math.random();
		if (surprise <= .4) {
			System.out.println("Surprise attack was successful!\n" + name
					+ " gets an additional turn.");
			numTurns++;
			attack(opponent);
		} else if (surprise >= .9) {
			System.out.println("Uh oh! " + opponent.getName() + " saw you and"
					+ " blocked your attack!");
		} else
			attack(opponent);

	}

	public void battleChoices(DungeonCharacter opponent) {
		super.battleChoices(opponent);
		int choice;
		PromptUser prompt = new PromptUser();

		do {
			choice = prompt.forAttack("Thief");

			switch (choice) {
			case 1:
				attack(opponent);
				break;
			case 2:
				surpriseAttack(opponent);
				break;
			default:
				System.out.println("invalid choice!");
			}

			numTurns--;
			if (numTurns > 0)
				System.out.println("Number of turns remaining is: " + numTurns);

		} while (numTurns > 0);

	}
}