package character;

/**
 * Title: Description: Copyright: Copyright (c) 2001 Company:
 * 
 * @author
 * @version 1.0
 */

public class Skeleton extends Monster {

	public Skeleton() {
		super(.3, 30, 50);
		super.setName("Sargath the Skeleton");
		super.setHitPoints(100);
		super.setAttackSpeed(3);
		super.setChanceToHit(.8);
		super.setDamageMin(30);
		super.setDamageMax(50);
	}

	public void attack(DungeonCharacter opponent) {
		System.out.println(name + " slices his rusty blade at "
				+ opponent.getName() + ":");
		super.attack(opponent);
	}

}