package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Level 2 of the game
 */
public class Level2 extends GameLevel {

    private static final int jewelsCollected = 2;

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

        Shape groundShape = new BoxShape(5f, 1f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(-15f, -3f));

        Shape groundShape1 = new BoxShape(3f, 1f);
        Body ground1 = new StaticBody(this, groundShape1);
        ground1.setPosition(new Vec2(3f, 5f));

        Shape groundShape2 = new BoxShape(3f, 1f);
        Body ground2 = new StaticBody(this, groundShape2);
        ground2.setPosition(new Vec2(20f, -5f));

        Body enemy = new Enemy1(this);
        enemy.setPosition(new Vec2(20f, -3f));
        enemy.addCollisionListener(new PlayerCollision(getPlayer()));

        Body enemy1 = new Enemy2(this);
        enemy1.setPosition(new Vec2(20f, 15f));
        enemy1.addCollisionListener(new PlayerCollision(getPlayer()));

        Shape groundShape3 = new BoxShape(3f, 1f);
        Body ground3 = new StaticBody(this, groundShape3);
        ground3.setPosition(new Vec2(20f, 13f));

        Shape groundShape4 = new BoxShape(3f, 1f);
        Body ground4 = new StaticBody(this, groundShape4);
        ground4.setPosition(new Vec2(35f, 5f));

        Shape groundShape5 = new BoxShape(3f, 1f);
        Body ground5 = new StaticBody(this, groundShape5);
        ground5.setPosition(new Vec2(63f, 5f));

        for (int i = 0; i < jewelsCollected; i++) {
            Body powerUp = new PowerUps(this);
            powerUp.setPosition(new Vec2(3 + i * 60, 10));
            powerUp.addCollisionListener(new PlayerCollision(getPlayer()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(-15, 0);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(65, 7);
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
