package Final_Exam.models;

import Final_Exam.interfaces.Lootable;

public class Monster extends GameCharacter implements Lootable{
	public Monster() {
		super("Java", 50);
	}

	@Override
	public void atk(GameCharacter target) {
		if (!IsCorrect.isCorrect) {
			target.hp -= 20;
		}
	}

	@Override
	public String dropLoot() {
		return "";
	}
}
