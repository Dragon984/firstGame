package game;

import city.cs.engine.BodyImage;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 * Hearts class
 */

public class Heart extends StaticBody {

    private static BodyImage image = new BodyImage("data/heart.png", 2.25f);

    public Heart(GameLevel world) {
        super(world);
        addImage(image);
    }

}
