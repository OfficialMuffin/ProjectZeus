package com.projectzeus.enemy;

import java.util.Random;

public class EnemyFactory {
    public static Enemy getEnemy() {
	Random rand = new Random();
	int enemy = rand.nextInt(4);

	switch(enemy) {
	case 0: return new AssaultRifleEnemy();
	case 1: return new SMGEnemy();
	case 2: return new SniperEnemy();
	case 3: return new SemiAutoSniperEnemy();
	default: return new AssaultRifleEnemy(); // Should never happen, but need to satisfy compiler
	}
    }
}
