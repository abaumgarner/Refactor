package character;

import promptUser.PromptUser;

/**
 * Title: Description: Copyright: Copyright (c) 2001 Company:
 * 
 * @author
 * @version 1.0
 */

public class Warrior extends Hero {

	public Warrior() {
		super(.2);
		super.setName("Warror");
		super.setHitPoints(125);
		super.setAttackSpeed(4);
		super.setChanceToHit(.8);
		super.setDamageMin(35);
		super.setDamageMax(60);
		super.setName(prompt.forCharacterName());

	}

	public void crushingBlow(DungeonCharacter opponent) {
		if (Math.random() <= .4) {
			int blowPoints = (int) (Math.random() * 76) + 100;
			System.out.println(name + " lands a CRUSHING BLOW for "
					+ blowPoints + " damage!");
			opponent.subtractHitPoints(blowPoints);
		} else {
			System.out.println(name + " failed to land a crushing blow");
			System.out.println();
		}
	}

	public void attack(DungeonCharacter opponent) {
		System.out.println(name + " swings a mighty sword at "
				+ opponent.getName() + ":");
		super.attack(opponent);
	}

	public void battleChoices(DungeonCharacter opponent) {
		int choice;
		PromptUser prompt = new PromptUser();

		super.battleChoices(opponent);

		do {
			choice = prompt.forAttack("Warrior");

			switch (choice) {
			case 1:
				attack(opponent);
				break;
			case 2:
				crushingBlow(opponent);
				break;
			}

			numTurns--;
			if (numTurns > 0)
				System.out.println("Number of turns remaining is: " + numTurns);

		} while (numTurns > 0);
	}

}