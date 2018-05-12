package com.projectzeus.enemy;

import java.util.Random;

public class EnemyFactory {
    public static Enemy getEnemy() {
	Random rand = new Random();
	int enemy = rand.nextInt(4);

	switch(enemy) {
	0: return new AssaultRifleEnemy();
	1: return new SMGEnemy();
	2: return new SniperEnemy();
	3: return new SemiAutoSniperEnemy();
	}
    }
}
