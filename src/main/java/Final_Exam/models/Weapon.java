package Final_Exam.models;

import java.util.Random;

abstract class Weapon {
	protected String name;
	protected int dmg;
	protected double acc;

	public Weapon(String name, int dmg, double acc) {
		this.name = name;
		this.dmg = dmg;
		this.acc = acc;
	}

	public String getName() {
		return this.name;
	}

	public boolean tryToHit() {
		return Math.random() <= acc;
	}

	public int getDmg() {
		return this.dmg;
	}
}
