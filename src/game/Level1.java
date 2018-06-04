package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Level 1 of the game
 */
public class Level1 extends GameLevel {

    MainCharacter player;
    MyView view;
    Game game;

    private int i;

    private int level;

    private static final int jewelsCollected = 2;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        level = game.getLevel();

        Shape groundShape = new BoxShape(50f, 1f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(15f, -19f));

        Shape wallShape = new BoxShape(1f, 20f);
        Body wall = new StaticBody(this, wallShape);
        wall.setPosition(new Vec2(-34f, 1f));

        Shape wallShape1 = new BoxShape(1f, 20f);
        Body wall1 = new StaticBody(this, wallShape1);
        wall1.setPosition(new Vec2(64f, 1f));

        Shape groundShape1 = new BoxShape(50f, 1f);
        Body ground1 = new StaticBody(this, groundShape1);
        ground1.setPosition(new Vec2(15, 19));

        Spikes spike1 = new Spikes(this);
        spike1.setPosition(new Vec2(-10f, -17.5f));
        spike1.addCollisionListener(new PlayerCollision(getPlayer()));

        Spikes spike2 = new Spikes(this);
        spike2.setPosition(new Vec2(-7f, -17.5f));
        spike2.addCollisionListener(new PlayerCollision(getPlayer()));

        Spikes spike3 = new Spikes(this);
        spike3.setPosition(new Vec2(-4f, -17.5f));
        spike3.addCollisionListener(new PlayerCollision(getPlayer()));

        Spikes spike4 = new Spikes(this);
        spike4.setPosition(new Vec2(6f, -17.5f));
        spike4.addCollisionListener(new PlayerCollision(getPlayer()));

        Spikes spike5 = new Spikes(this);
        spike5.setPosition(new Vec2(8f, -17.5f));
        spike5.addCollisionListener(new PlayerCollision(getPlayer()));

        Spikes spike6 = new Spikes(this);
        spike6.setPosition(new Vec2(10f, -17.5f));
        spike6.addCollisionListener(new PlayerCollision(getPlayer()));

        Spikes spike7 = new Spikes(this);
        spike7.setPosition(new Vec2(12f, -17.5f));
        spike7.addCollisionListener(new PlayerCollision(getPlayer()));

        Spikes spike8 = new Spikes(this);
        spike8.setPosition(new Vec2(14f, -17.5f));
        spike8.addCollisionListener(new PlayerCollision(getPlayer()));

        Spikes spike9 = new Spikes(this);
        spike9.setPosition(new Vec2(20f, -17.5f));
        spike9.addCollisionListener(new PlayerCollision(getPlayer()));

        Spikes spike10 = new Spikes(this);
        spike10.setPosition(new Vec2(22f, -17.5f));
        spike10.addCollisionListener(new PlayerCollision(getPlayer()));

        Spikes spike11 = new Spikes(this);
        spike11.setPosition(new Vec2(24f, -17.5f));
        spike11.addCollisionListener(new PlayerCollision(getPlayer()));

        Spikes spike12 = new Spikes(this);
        spike12.setPosition(new Vec2(26f, -17.5f));
        spike12.addCollisionListener(new PlayerCollision(getPlayer()));

        Spikes spike13 = new Spikes(this);
        spike13.setPosition(new Vec2(28f, -17.5f));
        spike13.addCollisionListener(new PlayerCollision(getPlayer()));

        Spikes spike14 = new Spikes(this);
        spike14.setPosition(new Vec2(30f, -17.5f));
        spike14.addCollisionListener(new PlayerCollision(getPlayer()));

        Chest chest = new Chest(this, game);
        chest.setPosition(new Vec2(55f, -16f));
        chest.addCollisionListener(chest);
        
        for (int i = 0; i < jewelsCollected; i++) {
            Body powerUp = new PowerUps(this);
            powerUp.setPosition(new Vec2(i * 17.5f, 10));
            powerUp.addCollisionListener(new PlayerCollision(getPlayer()));
        }

    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(-15, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(62, -16);
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
