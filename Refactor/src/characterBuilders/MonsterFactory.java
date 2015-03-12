package characterBuilders;

import character.Gremlin;
import character.Monster;
import character.Ogre;
import character.Skeleton;

public class MonsterFactory {
	private String monsterClass;
	private final String[] monsters = { "Ogre", "Gremlin", "Skeleton" };

	public MonsterFactory() {
		this.monsterClass = generateMonsterClass();
	}

	private String generateMonsterClass() {
		int choice = (int) (Math.random() * monsters.length);

		return monsters[choice];
	}

	public Monster generateMonster() {
		if (this.monsterClass.equalsIgnoreCase("Ogre"))
			return new Ogre();
		else if (this.monsterClass.equalsIgnoreCase("Gremlin"))
			return new Gremlin();
		return new Skeleton();
	}
}
