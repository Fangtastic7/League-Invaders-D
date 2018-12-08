import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
ArrayList <Projectile> projectiles = new ArrayList <Projectile>();

ArrayList <Alien> aliens = new ArrayList <Alien>();
Long enemyTimer = new Long(0); 
int enemySpawnTime = 1000;
Rocketship rocket;

public ObjectManager(Rocketship rocket) {
	this.rocket = rocket;
	
}
void update() {
	rocket.update();
	for(Projectile projectile : projectiles) {
		projectile.update();
	}
	for(Alien alien : aliens) {
		alien.update();
	}
}
void draw(Graphics object) {
	rocket.draw(object);
	for(Projectile projectile : projectiles) {
		projectile.draw(object);
	}
	for(Alien alien : aliens) {
		alien.draw(object);
		
	}
}
void addProjectile(Projectile projectile) {
	projectiles.add(projectile);
	
}
void addAlien(Alien alien) {
aliens.add(alien);
	
}
public void manageEnemies(){
    if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
            addAlien(new Alien(new Random().nextInt(450), 0, 50, 50));

enemyTimer = System.currentTimeMillis();
    }
}
void purgeObjects() {
	
	for(int i=0;i<projectiles.size();i++) {
		projectiles.remove(projectiles);
		
	}
	for(int i=0;i<aliens.size();i++) {
		aliens.remove(aliens);
		
	}
}
void checkCollision() {
	for(Alien a : aliens){

        if(rocket.collisionBox.intersects(a.collisionBox)){

                rocket.isAlive = false;

        }
	}
for(Projectile projectile : projectiles) {
	 if(rocket.collisionBox.intersects(projectile.collisionBox)) {
		 
		 projectile.isAlive = false;
		 
}
}

}
}


