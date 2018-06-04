/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 *The class responsible for the spikes in the world
 */
public class Spikes extends StaticBody {

    private static final Shape spike1 = new PolygonShape(
            -1.043f, -1.189f, -0.778f, 1.192f, 0.782f, 1.196f, 1.047f, -1.196f, -0.993f, -1.192f);
    private static BodyImage image = new BodyImage("data/spikes.png", 2.5f);

    public Spikes(World world) {
        super(world, spike1);
        addImage(image);
    }

}
