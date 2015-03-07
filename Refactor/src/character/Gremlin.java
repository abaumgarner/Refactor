package character;

/**
 * Title: Description: Copyright: Copyright (c) 2001 Company:
 * 
 * @author
 * @version 1.0
 */

public class Gremlin extends Monster {

	public Gremlin() {
		super(.4, 20, 40);

		super.setName("Gnarltooth the Gremlin");
		super.setHitPoints(70);
		super.setAttackSpeed(5);
		super.setChanceToHit(.8);
		super.setDamageMin(15);
		super.setDamageMax(30);
	}

	public void attack(DungeonCharacter opponent) {
		System.out.println(name + " jabs his kris at " + opponent.getName()
				+ ":");
		super.attack(opponent);

	}

}