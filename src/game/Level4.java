/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

/**
 * Level 4 of the game
 */
public class Level4 extends GameLevel {

    private static final int jewelsCollected = 1;

    private int i;

    MainCharacter player;
    MyView view;
    Game game;

    private int level;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        level = game.getLevel();

        Shape groundShape = new BoxShape(10f, 1f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(-15, -17f));

        for (int i = 0; i < 7; i++) {
            Shape groundShape2 = new BoxShape(1.5f, 0.5f);
            Body ground2 = new StaticBody(this, groundShape2);
            ground2.setPosition(new Vec2(0 + i * 15, 0));
        }

        for (int i = 0; i < 7; i++) {
            Shape groundShape4 = new BoxShape(1.5f, 0.5f);
            Body ground4 = new StaticBody(this, groundShape4);
            ground4.setPosition(new Vec2(0 + i * 15, 10));
        }

        for (int i = 0; i < 7; i++) {
            Shape groundShape3 = new BoxShape(1.5f, 0.5f);
            Body ground3 = new StaticBody(this, groundShape3);
            ground3.setPosition(new Vec2(0 + i * 15, -10));
        }
        for (int i = 0; i < 3; i++) {
            Body enemy1 = new Enemy4(this);
            enemy1.setPosition(new Vec2(15 + i * 30f, 0f));
            enemy1.addCollisionListener(new PlayerCollision(getPlayer()));
        }
        for (int i = 0; i < 4; i++) {
            Body enemy2 = new Enemy3(this);
            enemy2.setPosition(new Vec2(0 + i * 30f, 1f));
            enemy2.addCollisionListener(new PlayerCollision(getPlayer()));

        }
        for (int i = 0; i < 3; i++) {
            Body enemy3 = new Enemy4(this);
            enemy3.setPosition(new Vec2(15 + i * 30f, 11f));
            enemy3.addCollisionListener(new PlayerCollision(getPlayer()));
        }

        for (int i = 0; i < jewelsCollected; i++) {
            Body powerUp = new PowerUps(this);
            powerUp.setPosition(new Vec2(i * 3 - 10, 10));
            powerUp.addCollisionListener(new PlayerCollision(getPlayer()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(-15, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(105, 0);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getCount() == jewelsCollected;
    }

    @Override
    public int currentLevel() {
        return level;
    }
}
