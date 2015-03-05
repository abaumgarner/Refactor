package characterBuilders;

import character.Hero;
import character.Sorceress;
import character.Thief;
import character.Warrior;

public class HeroBuilder {
	private String heroClass;

	@SuppressWarnings("unused")
	private HeroBuilder() {
		this("Thief");
	}

	public HeroBuilder(String str) {
		this.heroClass = str;
	}

	public Hero buildHero() {
		if (this.heroClass.equalsIgnoreCase("Warrior"))
			return new Warrior();
		else if (this.heroClass.equalsIgnoreCase("Sorceress"))
			return new Sorceress();
		return new Thief();
	}

}
