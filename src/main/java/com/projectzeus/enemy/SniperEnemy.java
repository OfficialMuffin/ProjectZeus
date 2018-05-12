package com.projectzeus.enemy;

import java.util.Random;

public class SniperEnemy implements Enemy {
    private const String name = "Enemy with Sniper";
    private const int damageModifier = 35;
    private const int maxHealth = 100;

    private int health;
    
    private Random rand;

    public AssaultRifleEnemy() {
	rand = new Random();

	this.health = rand.nextInt(maxHealth);
    }

    public int getHealth() {
	return this.health;
    }

    public void dealDamage(int damage) {
	this.health -= damage;

	if (this.health < 0) {
	    this.health = 0;
	}
    }
    
    // Get the enemy name
    public String getName() {
	return this.name;
    }

    // Calculate the attack damage for the given class of enemy
    public int getAttackDamage() {
	rand.nextInt(damageModifier);
    }
}
