package battle;

import promptUser.PromptUser;
import character.Hero;
import character.Monster;

public class Battle {
	private Hero theHero;
	private Monster theMonster;

	public Battle(Hero heroIn, Monster monsterIn) {
		this.theHero = heroIn;
		this.theMonster = monsterIn;
	}

	/*-------------------------------------------------------------------
	 battle is the actual combat portion of the game.  It requires a Hero
	 and a Monster to be passed in.  Battle occurs in rounds.  The Hero
	 goes first, then the Monster.  At the conclusion of each round, the
	 user has the option of quitting.
	 ---------------------------------------------------------------------*/
	public void startBattle(PromptUser user) {
		boolean quit = false;

		displayBattleTitle();

		while (battleLoopController(quit)) {

			theHero.battleChoices(theMonster);

			if (theMonster.isAlive())
				theMonster.attack(theHero);

			quit = user.forBailingOut();
		}

		displayWinner();
	}

	private void displayBattleTitle() {
		System.out.println(theHero.getName() + " battles "
				+ theMonster.getName());
		System.out.println("---------------------------------------------");
	}

	private void displayWinner() {

		if (!theMonster.isAlive())
			System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else
			System.out.println("Quitters never win ;-)");
	}

	private boolean battleLoopController(boolean quit) {
		return theHero.isAlive() && theMonster.isAlive() && !quit;
	}
}
