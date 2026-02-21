package Final_Exam.models;

import java.util.Random;

abstract public class Character {
        private String name;
        private int hp;
        private int maxHp;
        protected Random dmg = new Random();

        public Character(String name, int maxHp) {
                this.name = name;
                this.maxHp = maxHp;
                this.hp = maxHp;
        }

        public abstract void atk(Character target);

        public void takeDmg(int dmg) {
		hp -= dmg;
		if (hp < 0) hp = 0;
	}

        public boolean isAlive() { return hp > 0;}

        public String getName() { return name; }

        public int getHp() { return hp; }
}
