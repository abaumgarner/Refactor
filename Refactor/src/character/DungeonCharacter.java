package character;

/**
 * Title: DungeonCharacter.java
 *
 * Description: Abstract Base class for inheritance hierarchy for a role playing
 * game
 *
 * class variables (all will be directly accessible from derived classes): name
 * (name of character) hitPoints (points of damage a character can take before
 * killed) attackSpeed (how fast the character can attack) chanceToHit (chance
 * an attack will strike the opponent) damageMin, damageMax (range of damage the
 * character can inflict on opponent)
 *
 * class methods (all are directly accessible by derived classes):
 * DungeonCharacter(String name, int hitPoints, int attackSpeed, double
 * chanceToHit, int damageMin, int damageMax) public String getName() public int
 * getHitPoints() public int getAttackSpeed() public void addHitPoints(int
 * hitPoints) public void subtractHitPoints(int hitPoints) -- this method will
 * be overridden public boolean isAlive() public void attack(DungeonCharacter
 * opponent) -- this method will be overridden
 *
 * Copyright: Copyright (c) 2001 Company:
 * 
 * @author
 * @version 1.0
 */

public abstract class DungeonCharacter implements Comparable<Object> {

	private String name;
	private int hitPoints;
	private int attackSpeed;
	private double chanceToHit;
	private int damageMin, damageMax;

	public int compareTo(Object o) {
		return 1;
	}

	public DungeonCharacter() {

	}

	void setName(String str) {
		this.name = str;
	}

	void setHitPoints(int hp) {
		this.hitPoints = hp;
	}

	void setAttackSpeed(int as) {
		this.attackSpeed = as;
	}

	void setChanceToHit(double hitChance) {
		this.chanceToHit = hitChance;
	}

	void setDamageMin(int minDamage) {
		this.damageMin = minDamage;
	}

	void setDamageMax(int maxDamage) {
		this.damageMax = maxDamage;
	}

	public String getName() {
		return name;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public int getAttackSpeed() {
		return attackSpeed;
	}

	public void addHitPoints(int hitPoints) {
		if (hitPoints <= 0)
			System.out.println("Hitpoint amount must be positive.");
		else {
			this.hitPoints += hitPoints;
		}
	}

	public void subtractHitPoints(int hitPoints) {
		if (hitPoints < 0)
			System.out.println("Hitpoint amount must be positive.");
		else if (hitPoints > 0) {
			this.hitPoints -= hitPoints;
			if (this.hitPoints < 0)
				this.hitPoints = 0;
			System.out.println(getName() + " hit " + " for <" + hitPoints
					+ "> points damage.");
			System.out.println(getName() + " now has " + getHitPoints()
					+ " hit points remaining.");
			System.out.println();
		}

		if (this.hitPoints == 0)
			System.out.println(name + " has been killed :-(");
	}

	/*-------------------------------------------------------
	 isAlive is used to see if a character is still alive by checking hit points

	 Receives: nothing
	 Returns: true is hero is alive, false otherwise

	 This method calls: nothing
	 This method is called by: unknown (intended for external use)
	 ---------------------------------------------------------*/
	public boolean isAlive() {
		return (hitPoints > 0);
	}

	/*-------------------------------------------------------
	 attack allows character to attempt attack on opponent.  First, chance to hit
	 is considered.  If a hit can occur, then the damage is calculated based on
	 character's damage range.  This damage is then applied to the opponenet.

	 Receives: opponent being attacked
	 Returns: nothing

	 This method calls: Math.random(), subtractHitPoints()
	 This method is called by: overridden versions of the method in monster and
	 hero classes and externally
	 ---------------------------------------------------------*/
	public void attack(DungeonCharacter opponent) {
		boolean canAttack;
		int damage;

		canAttack = Math.random() <= chanceToHit;

		if (canAttack) {
			damage = (int) (Math.random() * (damageMax - damageMin + 1))
					+ damageMin;
			opponent.subtractHitPoints(damage);

			System.out.println();
		} else {

			System.out.println(getName() + "'s attack on " + opponent.getName()
					+ " failed!");
			System.out.println();
		}

	}

}