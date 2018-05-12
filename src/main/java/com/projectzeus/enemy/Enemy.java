package com.projectzeus.enemy;

interface Enemy {
    // Get the enemy name
    String getName();

    // Calculate the attack damage for the given class of enemy
    int getAttackDamage();
}
