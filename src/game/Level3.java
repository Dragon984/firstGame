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
import java.util.Timer;
import java.util.TimerTask;

import org.jbox2d.common.Vec2;

/**
 * Level 3 of the game
 */
public class Level3 extends GameLevel {

    private static final int jewelsCollected = 1;
    private int secondsPassed;
    MainCharacter player;
    MyView view;
    Game game;
    private int i;

    Timer myTimer = new Timer();
    TimerTask task = new TimerTask() {
        public void run() {
            secondsPassed++;
            System.out.println("Seconds passed: " + secondsPassed);
        }
    };
    private Timer timer = new Timer();

    private int level;

    /**
     * Populate the world.
     */
    @Override

    public void populate(Game game) {
        super.populate(game);

        level = game.getLevel();

        Shape groundShape = new BoxShape(80f, 0.01f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(40, -3f));

        Body enemy = new Enemy5(this, view);
        enemy.setPosition(new Vec2(-35f, 0));
        enemy.addCollisionListener(new PlayerCollision(getPlayer()));

        for (int i = 0; i < jewelsCollected; i++) {
            Body powerUp = new PowerUps(this);
            powerUp.setPosition(new Vec2(i * 3 - 10, 10));
            powerUp.addCollisionListener(new PlayerCollision(getPlayer()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(-30, 0);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(80, 2);
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
