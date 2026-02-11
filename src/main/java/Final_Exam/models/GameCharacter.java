package Final_Exam.models;

abstract class GameCharacter {
	protected String name;
	protected int hp;
	protected int maxHp;

	public GameCharacter(String name, int maxHp) {
		this.name = name;
		this.hp = this.maxHp = maxHp;
	}

	public boolean isAlive() {
		return this.hp > 0;
	}

	public String getName() {
		return this.name;
	}

	public abstract void atk(GameCharacter target);
}
