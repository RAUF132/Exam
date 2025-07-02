package kg.geeks.game.players;

import java.util.Random;

public class Ludoman extends Hero {

    private Random random = new Random();

    public Ludoman(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.GAMBLE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int dice1 = random.nextInt(6) + 1;
        int dice2 = random.nextInt(6) + 1;

        if (dice1 == dice2) {
            int damage = dice1 * dice2;
            boss.setHealth(boss.getHealth() - damage);
            System.out.println(this.getName() + " выбросил " + dice1 + " и " + dice2 +
                    " — совпали! Нанёс боссу " + damage + " урона.");
        } else {

            Hero target;
            do {
                target = heroes[random.nextInt(heroes.length)];
            } while (target == this || target.getHealth() <= 0);

            int damage = dice1 + dice2;
            target.setHealth(target.getHealth() - damage);
            System.out.println(this.getName() + " выбросил " + dice1 + " и " + dice2 +
                    " — не совпали. Нанёс " + damage + " урона " + target.getName());
        }
    }
}