package Final_Exam.models;

public class Nisit extends GameCharacter {
	private Weapon curWeapon;

	public Nisit(String name) {
		super(name, 100);
	}

	public void equip(Weapon newWeapon) {
		this.curWeapon = newWeapon;
	}

	public void atk(GameCharacter target) {
		if (IsCorrect.isCorrect) {
			if (curWeapon.tryToHit()) {
				target.hp -= curWeapon.getDmg();
			}
		}
	}
}
