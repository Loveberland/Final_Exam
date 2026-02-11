package Final_Exam.models;

import java.util.Random;

public class Boss extends GameCharacter {
	public Boss(String name) {
		super(name, 250);
	}

	public void atk(GameCharacter target) {
		if (!IsCorrect.isCorrect) {
			target.hp -= (int)(Math.random() * (50 - 20 + 1)) + 20;
		}
	}
}
