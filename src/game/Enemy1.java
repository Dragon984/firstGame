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
 * the class responsible for enemy 1
 */
public class Enemy1 extends Walker {

    //creating a polygon shape for the Enemy1 object
    private static final Shape enemyShape1 = new PolygonShape(
            -0.71f, 0.5f, -0.39f, 0.82f, 0.23f, 0.82f, 0.55f, 0.49f, 0.55f, -0.9f, -0.71f, -0.91f, -0.72f, 0.4f);
    private static BodyImage image = new BodyImage("data/Enemy1.png", 3f);

    //allows to create enemy1 objects inside the levels
    public Enemy1(GameLevel world) {
        super(world, enemyShape1);
        addImage(image);

    }

}
