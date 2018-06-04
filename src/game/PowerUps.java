/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CircleShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.World;
import java.awt.Color;

/**
 * in theory they suppose to increase some sort of damage that player deals, but in reality they're required to proceed to next level
 * @author DragonSama
 */
public class PowerUps extends DynamicBody {

    private static final Shape shape = new CircleShape(0.3f);

    public PowerUps(GameLevel world) {
        super(world, shape);
        setFillColor(Color.cyan);

    }

}
