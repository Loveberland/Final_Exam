package Final_Exam.models;

public class Nisit extends Character {
        /**
         * Constructs a new Nisit with the specified name and a default maximum HP of 100
         *
         * @param name The name of the Nisit.
         */
        public Nisit(String name) {
                super(name, 100);
        }

        /**
         * Performs an attack on a target character, dealing a randomized 
         * damage value between 25 and 75.
         *
         * @param target The character receiving the attack.
         */
        @Override
        public void atk(Character target) {
                target.takeDmg(dmg.nextInt((75 - 25) + 1) + 25);   // Dmg 25 - 75
        }
}
