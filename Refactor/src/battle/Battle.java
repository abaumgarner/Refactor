package battle;

import promptUser.PromptUser;
import character.Hero;
import character.Monster;

public class Battle {

	/*-------------------------------------------------------------------
	 battle is the actual combat portion of the game.  It requires a Hero
	 and a Monster to be passed in.  Battle occurs in rounds.  The Hero
	 goes first, then the Monster.  At the conclusion of each round, the
	 user has the option of quitting.
	 ---------------------------------------------------------------------*/
	public void startBattle(Hero theHero, Monster theMonster, PromptUser user) {
		String pause = "p";
		System.out.println(theHero.getName() + " battles "
				+ theMonster.getName());
		System.out.println("---------------------------------------------");

		while (theHero.isAlive() && theMonster.isAlive()
				&& !pause.equalsIgnoreCase("q")) {

			theHero.battleChoices(theMonster);

			if (theMonster.isAlive())
				theMonster.attack(theHero);

			pause = user.forBailingOut();

		}

		if (!theMonster.isAlive())
			System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else
			System.out.println("Quitters never win ;-)");

	}
}
