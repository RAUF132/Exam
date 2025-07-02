package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Warrior extends Hero {
    public Warrior(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int crit = this.getDamage() * RPG_Game.random.nextInt(2, 6);
        boss.setHealth(boss.getHealth() - crit);
        System.out.println("Warrior " + this.getName() + " hit critically: " + crit);
    }
}
