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

		this.setName("Gnarltooth the Gremlin");
		this.setHitPoints(70);
		this.setAttackSpeed(5);
		this.setChanceToHit(.8);
		this.setDamageMin(15);
		this.setDamageMax(30);
	}

	@Override
	public void attack(DungeonCharacter opponent) {
		System.out.println(this.getName() + " jabs his kris at "
				+ opponent.getName() + ":");
		super.attack(opponent);

	}

}