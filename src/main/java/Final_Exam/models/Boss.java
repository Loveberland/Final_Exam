package Final_Exam.models;

public class Boss extends Character {
        public Boss(String name) {
                super(name, 250);
        }

        @Override
        public void atk(Character target) {
                target.takeDmg(dmg.nextInt((50 - 25) + 1) + 25);   // dmg 25 - 50
        }
}
