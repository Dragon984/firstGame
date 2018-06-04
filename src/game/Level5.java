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
 * Level 5 of the game
 */
public class Level5 extends GameLevel {

    private static final int jewelsCollected = 1;

    MainCharacter player;
    MyView view;
    Game game;
    private int i;

    private int level;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        level = game.getLevel();

        Shape groundShape = new BoxShape(70f, 1f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(35, -17f));

        Shape wallShape = new BoxShape(2f, 20f);
        Body wall = new StaticBody(this, wallShape);
        wall.setPosition(new Vec2(-34f, -0f));

        Shape groundShape1 = new BoxShape(70f, 1f);
        Body ground1 = new StaticBody(this, groundShape1);
        ground1.setPosition(new Vec2(35f, 18f));

        for (int i = 0; i < 6; i++) {
            Shape groundShape2 = new BoxShape(1f, 0.5f);
            Body ground2 = new StaticBody(this, groundShape2);
            ground2.setPosition(new Vec2(0 + i * 15, -0f));
        }
        for (int i = 0; i < 6; i++) {
            Body enemy2 = new Enemy5(this, view);
            enemy2.setPosition(new Vec2(0 + i * 15, 1f));
            enemy2.addCollisionListener(new PlayerCollision(getPlayer()));
            System.out.println("i exist lol");
        }

        for (int i = 0; i < 6; i++) {
            Spikes spike1 = new Spikes(this);
            spike1.setPosition(new Vec2(0 + i * 15, -15f));
            spike1.addCollisionListener(new PlayerCollision(getPlayer()));
        }
        for (int i = 0; i < 6; i++) {
            Spikes spike1 = new Spikes(this);
            spike1.setPosition(new Vec2(2 + i * 15, -15f));
            spike1.addCollisionListener(new PlayerCollision(getPlayer()));
        }
        for (int i = 0; i < 6; i++) {
            Spikes spike1 = new Spikes(this);
            spike1.setPosition(new Vec2(-2 + i * 15, -15f));
            spike1.addCollisionListener(new PlayerCollision(getPlayer()));
        }

        for (int i = 0; i < jewelsCollected; i++) {
            Body powerUp = new PowerUps(this);
            powerUp.setPosition(new Vec2(i * 3 - 10, 10));
            powerUp.addCollisionListener(new PlayerCollision(getPlayer()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(-20, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(100, -15);
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
