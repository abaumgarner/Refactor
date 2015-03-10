import battle.Battle;
import character.Gremlin;
import character.Hero;
import character.Monster;
import character.Ogre;
import character.Skeleton;
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
		Battle battle;
		MonsterBuilder monsterBuilder;

		System.out.println("Welcome to the Dungeon");
		System.out.println("----------------------");

		do {
			monsterBuilder = new MonsterBuilder();
			theHero = user.forHeroChoice(characterClasses);
			theMonster = monsterBuilder.buildMonster();

			battle = new Battle(theHero, theMonster);
			battle.startBattle(user);
		} while (user.forPlayingAgain());

		user.closePrompt();
	}

}