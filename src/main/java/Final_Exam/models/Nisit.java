package Final_Exam.models;

public class Nisit extends Character {
        public Nisit() {
                super("Kittipong", 100);
        }

        @Override
        public void atk(Character target) {
                target.takeDmg(dmg.nextInt((75 - 25) + 1) + 25);   // Dmg 25 - 75
        }
}
