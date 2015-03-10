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
		this.setName("Oscar the Ogre");
		this.setHitPoints(200);
		this.setAttackSpeed(2);
		this.setChanceToHit(.6);
		this.setDamageMin(30);
		this.setDamageMax(50);
	}

	@Override
	public void attack(DungeonCharacter opponent) {
		System.out.println(this.getName() + " slowly swings a club toward's "
				+ opponent.getName() + ":");
		super.attack(opponent);
	}

}