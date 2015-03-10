package characterBuilders;

import character.Hero;
import character.Sorceress;
import character.Thief;
import character.Warrior;

public class HeroBuilder {
	public HeroBuilder() {
	}

	public Hero buildHero(String str) {
		if (str.equalsIgnoreCase("Warrior"))
			return new Warrior();
		else if (str.equalsIgnoreCase("Sorceress"))
			return new Sorceress();
		return new Thief();
	}

}
