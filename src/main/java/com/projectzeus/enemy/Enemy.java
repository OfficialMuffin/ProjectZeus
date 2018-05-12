package com.projectzeus.enemy;

public interface Enemy {
    // Get the enemy health
    int getHealth();

    // Deal damage to the enemy
    void dealDamage(int damage);
    
    // Get the enemy name
    String getName();

    // Calculate the attack damage for the given class of enemy
    int getAttackDamage();
}
