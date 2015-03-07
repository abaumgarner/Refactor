package character;

/**
 * Title: Description: Copyright: Copyright (c) 2001 Company:
 * 
 * @author
 * @version 1.0
 */

public class Ogre extends Monster {

	public Ogre() {
		super(.1, 30, 50);
		super.setName("Oscar the Ogre");
		super.setHitPoints(200);
		super.setAttackSpeed(2);
		super.setChanceToHit(.6);
		super.setDamageMin(30);
		super.setDamageMax(50);
	}

	public void attack(DungeonCharacter opponent) {
		System.out.println(name + " slowly swings a club toward's "
				+ opponent.getName() + ":");
		super.attack(opponent);
	}

}