package Final_Exam.models;

import java.util.Random;

/**
 * Represents an abstract character in the game with basic attributes
 */
abstract public class Character {
        private String name;
        private int hp;
        private int maxHp;
        protected Random dmg = new Random();

        /**
         * Constructs a new Character with the specified name and maximum HP.
         *
         * @param name  The name of the character.
         * @param maxHp The maximum health points (and initial health points) of the character.
         */
        public Character(String name, int maxHp) {
                this.name = name;
                this.maxHp = maxHp;
                this.hp = maxHp;
        }

        /**
         * Performs an attack on a target character. The specific damage logic is implemented by subclasses.
         *
         * @param target The character being attacked.
         */
        public abstract void atk(Character target);

        /**
         * Reduces the character's HP by the specified damage amount.
         * Ensures that the character's HP does not fall below 0.
         *
         * @param dmg The amount of damage the character will take.
         */
        public void takeDmg(int dmg) {
		hp -= dmg;
		if (hp < 0) hp = 0;
	}

        /**
         * Checks if the character is currently alive.
         *
         * @return true if the character's HP is greater than 0, false otherwise.
         */
        public boolean isAlive() { return hp > 0;}

        /**
         * Retrieves the name of the character.
         *
         * @return The character's name.
         */
        public String getName() { return name; }

        /**
         * Retrieves the current health points (HP) of the character.
         *
         * @return The character's current HP.
         */
        public int getHp() { return hp; }
}
