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
		this.setName("Sargath the Skeleton");
		this.setHitPoints(100);
		this.setAttackSpeed(3);
		this.setChanceToHit(.8);
		this.setDamageMin(30);
		this.setDamageMax(50);
	}

	@Override
	public void attack(DungeonCharacter opponent) {
		System.out.println(this.getName() + " slices his rusty blade at "
				+ opponent.getName() + ":");
		super.attack(opponent);
	}

}