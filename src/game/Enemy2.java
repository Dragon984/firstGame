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
 * the class responsible for enemy 2
 */
public class Enemy2 extends Walker {

    //creating a polygon shape for the Enemy2 object
    private static final Shape enemyShape2 = new PolygonShape(
            -0.55f, 0.44f, -0.38f, 0.61f, 0.17f, 0.62f, 0.68f, -0.35f, 0.51f, -0.95f, -0.37f, -0.95f, -0.55f, -0.08f);
    private static BodyImage image = new BodyImage("data/Enemy2.png", 3f);

    /**
     * SolidFixture fixture = new SolidFixture(body, enemy2, 20f);
     * fixture.setFriction(1f); fixture.setRestitution(0.65f);
     */
    //allows to create enemy2 objects inside the levels
    public Enemy2(GameLevel world) {
        super(world, enemyShape2);
        addImage(image);

    }

}
