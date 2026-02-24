package Final_Exam.models;

/**
 * Represents a Boss character in the game, inheriting from the Character class.
 * A Boss has a high maximum HP and deals a specific range of damage.
 */
public class Boss extends Character {
        /**
         * Constructs a new Boss with the specified name and a default maximum HP of 250.
         *
         * @param name The name of the Boss.
         */
        public Boss(String name) {
                super(name, 250);
        }

        /**
         * Performs an attack on a target character, dealing a randomized
         * damage value between 25 and 50.
         *
         * @param target The character receiving the attack.
         */
        @Override
        public void atk(Character target) {
                target.takeDmg(dmg.nextInt((50 - 25) + 1) + 25);   // dmg 25 - 50
        }
}
