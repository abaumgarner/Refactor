package characterBuilders;

import character.Gremlin;
import character.Monster;
import character.Ogre;
import character.Skeleton;

public class MonsterBuilder {
	private String monsterClass;
	private String[] monsters = { "Ogre", "Gremlin", "Skeleton" };

	public MonsterBuilder() {
		this.monsterClass = generateMonsterClass();
	}

	private String generateMonsterClass() {
		int choice = (int) (Math.random() * 3);

		return monsters[choice];
	}

	public Monster buildMonster() {
		if (this.monsterClass.equalsIgnoreCase("Ogre"))
			return new Ogre();
		else if (this.monsterClass.equalsIgnoreCase("Gremlin"))
			return new Gremlin();
		return new Skeleton();
	}
}
