package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * the class responsible for the enemy 5
 */
public class Enemy5 extends Walker implements StepListener {

    //creating a polygon shape for the Enemy 5 object
    private ShootingBullet bullet;
    private MainCharacter player;
    private MyView view;
    GameLevel world;
    private Vec2 target;
    private Vec2 enemyPos;
    private Vec2 difPos;

    private static final Shape enemyShape5 = new PolygonShape(
            -1.21f, 0.92f, -0.3f, 1.39f, 0.32f, 1.39f, 1.24f, 0.95f, 0.3f, -1.04f, -0.3f, -1.04f, -1.21f, 0.6f);
    private static BodyImage image = new BodyImage("data/Enemy5.png", 3f);


    //allows to create enemy5 objects inside the levels
    public Enemy5(GameLevel world, MyView view) {
        super(world, enemyShape5);
        this.view = view;
        addImage(image);
        this.world = world;
        this.player = world.getPlayer();
        System.out.println("i still exist");

    }

    //the method responsible for for enemy 5 shooting
    //the bullet is getting created inside the world
    //the players position (x,y) is getting retrieved from the world
    //the enemy position (x,y) is getting retrieved from the world
    //after what i calculate the 2d distance between player and the enemy
    //to get the speed and direction of the bullet
    @Override
    public void preStep(StepEvent stepEvent) {
        Bullet bullet = new Bullet(view.getWorld());
        player = world.getPlayer();
        enemyPos = this.getPosition();
        target = player.getPosition();
        System.out.println("target (" + target.x + ", " + target.y + ")");
        difPos = enemyPos.sub(target);
        difPos.normalize();
        bullet.setPosition(enemyPos.add(difPos.mul(1.35f)));
        difPos = difPos.mul(25);
        bullet.setLinearVelocity(difPos);
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
