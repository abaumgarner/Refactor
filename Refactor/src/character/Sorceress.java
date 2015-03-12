package character;

import promptUser.PromptUser;

/**
 * Title: Description: Copyright: Copyright (c) 2001 Company:
 * 
 * @author
 * @version 1.0
 */

public class Sorceress extends Hero {
	private final int MIN_ADD = 25;
	private final int MAX_ADD = 50;

	public Sorceress() {
		super(.3);
		super.setName("Sorceress");
		super.setHitPoints(75);
		super.setAttackSpeed(5);
		super.setChanceToHit(.7);
		super.setDamageMin(25);
		super.setDamageMax(50);
		super.setName(prompt.forCharacterName());
	}

	public void increaseHitPoints() {
		int hPoints;

		hPoints = (int) (Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		addHitPoints(hPoints);
		System.out.println(this.getName() + " added [" + hPoints
				+ "] points.\n" + "Total hit points remaining are: "
				+ this.getHitPoints());
		System.out.println();

	}

	@Override
	public void attack(DungeonCharacter opponent) {
		System.out.println(this.getName() + " casts a spell of fireball at "
				+ opponent.getName() + ":");
		super.attack(opponent);
	}

	@Override
	public void battleChoices(DungeonCharacter opponent) {
		super.battleChoices(opponent);
		int choice;
		PromptUser prompt = new PromptUser();

		do {
			choice = prompt.forAttack("Sorceress");

			switch (choice) {
			case 1:
				attack(opponent);
				break;
			case 2:
				increaseHitPoints();
				break;
			default:
				System.out.println("invalid choice!");
			}

			numTurns--;
			if (numTurns > 0)
				System.out.println("Number of turns remaining is: " + numTurns);

		} while (numTurns > 0 && this.getHitPoints() > 0
				&& opponent.getHitPoints() > 0);

	}

}