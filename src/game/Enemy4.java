/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.Walker;

/**
 * the class responsible for enemy 4
 */
public class Enemy4 extends Walker {

    //creating a polygon shape for the Enemy4 object
    private static final Shape enemyShape4 = new PolygonShape(
            -1.36f, 0.44f, -0.09f, 0.61f, 0.81f, 0.62f, 1.0f, 0.26f, 1.0f, -0.99f, -0.8f, -0.99f, -1.36f, -0.27f);
    private static BodyImage image = new BodyImage("data/Enemy4.png", 3f);

    /**
     * SolidFixture fixture = new SolidFixture(body, enemy2, 20f);
     * fixture.setFriction(1f); fixture.setRestitution(0.65f);
     */
    //allows to create enemy4 objects inside the levels
    public Enemy4(GameLevel world) {
        super(world, enemyShape4);
        addImage(image);

    }

}
