import character.Hero;
import character.Monster;
import characterBuilders.MonsterBuilder;
import promptUser.PromptUser;

/**
 * Title: Dungeon.java
 *
 * Description: Driver file for Heroes and Monsters project
 *
 * Copyright: Copyright (c) 2001 Company: Code Dogs Inc. I.M. Knurdy
 *
 * History: 11/4/2001: Wrote program --created DungeonCharacter class --created
 * Hero class --created Monster class --had Hero battle Monster --fixed attack
 * quirks (dead monster can no longer attack) --made Hero and Monster abstract
 * --created Warrior --created Ogre --made Warrior and Ogre battle --added
 * battleChoices to Hero --added special skill to Warrior --made Warrior and
 * Ogre battle --created Sorceress --created Thief --created Skeleton --created
 * Gremlin --added game play features to Dungeon.java (this file) 11/27/2001:
 * Finished documenting program version 1.0
 */

/*
 * This class is the driver file for the Heroes and Monsters project. It will do
 * the following:
 * 
 * 1. Allow the user to choose a hero 2. Randomly select a monster 3. Allow the
 * hero to battle the monster
 * 
 * Once a battle concludes, the user has the option of repeating the above
 */
public class Dungeon {
	static PromptUser user = new PromptUser();
	static String[] characterClasses = { "Warrior", "Sorceress", "Thief" };

	public static void main(String[] args) {
		Hero theHero;
		Monster theMonster;
		MonsterBuilder monsterBuilder = new MonsterBuilder();

		do {
			theHero = user.chooseHero(characterClasses);
			theMonster = monsterBuilder.buildMonster();
			battle(theHero, theMonster);

		} while (user.playAgain());

		user.close();
	}

	/*-------------------------------------------------------------------
	 battle is the actual combat portion of the game.  It requires a Hero
	 and a Monster to be passed in.  Battle occurs in rounds.  The Hero
	 goes first, then the Monster.  At the conclusion of each round, the
	 user has the option of quitting.
	 ---------------------------------------------------------------------*/
	public static void battle(Hero theHero, Monster theMonster) {
		String pause = "p";
		System.out.println(theHero.getName() + " battles "
				+ theMonster.getName());
		System.out.println("---------------------------------------------");

		// do battle
		while (theHero.isAlive() && theMonster.isAlive()
				&& !pause.equalsIgnoreCase("q")) {
			// hero goes first
			theHero.battleChoices(theMonster);

			// monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
				theMonster.attack(theHero);

			// let the player bail out if desired
			pause = user.bailOut();

		}

		if (!theMonster.isAlive())
			System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else
			System.out.println("Quitters never win ;-)");

	}

}