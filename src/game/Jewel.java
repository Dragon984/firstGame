package game;

import city.cs.engine.BodyImage;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.World;

/**
 * Class responsible for jewels
 */
public class Jewel extends DynamicBody {

    private static final Shape greenJewelShape = new PolygonShape(
            0.048f, 0.438f, 0.324f, 0.438f, 0.61f, 0.133f, 0.6f, -0.114f, 0.295f, -0.419f, 0.038f, -0.419f, -0.257f, -0.114f, -0.248f, 0.152f);
    private static BodyImage greenJewel = new BodyImage("data/greenJewel.png", 2f);

    public Jewel(GameLevel world) {
        super(world, greenJewelShape);
        addImage(greenJewel);
        this.addCollisionListener(new PlayerCollision(world.getPlayer()));

    }

}
