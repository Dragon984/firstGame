package game;

import city.cs.engine.BodyImage;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import javax.swing.Timer;

/**
 *
 * @author darkk
 */
/**
 * This is the class responsible for Creating the bullet objects
 */
public class Bullet extends DynamicBody implements CollisionListener {

    private MainCharacter player;
    Game game;
    //creating a polygon shape for the bullet object, initialising it's dimensions
    //as well as adding the image to it
    private static final Shape bullet = new PolygonShape(
            -0.471f, -0.049f, 0.045f, 0.147f, 0.207f, 0.15f, 0.379f, -0.027f, 0.381f, -0.102f, 0.211f, -0.275f, 0.046f, -0.275f, -0.473f, -0.075f);
    private static BodyImage bulletImage = new BodyImage("data/bullet.png", 0.9f);

    //creating a bullet object in the world
    public Bullet(World world) {
        super(world, bullet);
        addImage(bulletImage);
        this.setGravityScale(0);
        addCollisionListener(this);
    }
    //possible collisions when bullet interacts with different objects
    //.destroy method removes the bullets from memory after they've collided with something
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Enemy1) {
            e.getReportingBody().destroy();
        } else if (e.getOtherBody() instanceof Enemy2) {
            e.getReportingBody().destroy();
        } else if (e.getOtherBody() instanceof Enemy3) {
            e.getReportingBody().destroy();
        } else if (e.getOtherBody() instanceof Enemy4) {
            e.getReportingBody().destroy();
        } else if (e.getOtherBody() instanceof Enemy5) {
            e.getReportingBody().destroy();
        } else if (e.getOtherBody() instanceof StaticBody) {
            Timer timer = new Timer(3000, new DestroyBulletTimer(this));
            timer.setRepeats(false);
            timer.start();
        } else if (e.getOtherBody() instanceof MainCharacter) {

        } else {
            Timer timer1 = new Timer(7000, new DestroyBulletTimer(this));
            timer1.setRepeats(false);
            timer1.start();
        }

    }

}
