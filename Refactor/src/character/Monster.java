package character;

/**
 * Title: Description: Copyright: Copyright (c) 2001 Company:
 * 
 * @author
 * @version 1.0
 */

public abstract class Monster extends DungeonCharacter {
	protected double chanceToHeal;
	protected int minHeal, maxHeal;

	public Monster(double chanceToHeal, int minHeal, int maxHeal) {
		this.chanceToHeal = chanceToHeal;
		this.maxHeal = maxHeal;
		this.minHeal = minHeal;

	}

	public void heal() {
		boolean canHeal;
		int healPoints;

		canHeal = (Math.random() <= chanceToHeal) && (hitPoints > 0);

		if (canHeal) {
			healPoints = (int) (Math.random() * (maxHeal - minHeal + 1))
					+ minHeal;
			addHitPoints(healPoints);
			System.out.println(name + " healed itself for " + healPoints
					+ " points.\n" + "Total hit points remaining are: "
					+ hitPoints);
			System.out.println();
		}

	}

	public void subtractHitPoints(int hitPoints) {
		super.subtractHitPoints(hitPoints);
		heal();
	}

}