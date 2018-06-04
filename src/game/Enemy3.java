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
 * the class responsible for enemy 3
 */
public class Enemy3 extends Walker {

    //creating a polygon shape for the Enemy3 objects
    private static final Shape enemyShape3 = new PolygonShape(
            -0.81f, 0.53f, -0.4f, 0.8f, 0.27f, 0.8f, 0.81f, 0.27f, 0.41f, -0.67f, -0.13f, -0.67f, -0.93f, 0.14f);
    private static BodyImage image = new BodyImage("data/Enemy3.png", 3f);

    /**
     * SolidFixture fixture = new SolidFixture(body, enemy2, 20f);
     * fixture.setFriction(1f); fixture.setRestitution(0.65f);
     */
    //allows to create enemy3 objects inside the levels
    public Enemy3(GameLevel world) {
        super(world, enemyShape3);
        addImage(image);

    }

}
