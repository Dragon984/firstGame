package game;

import city.cs.engine.*;
import java.util.ArrayList;
import java.util.List;
import org.jbox2d.common.Vec2;

/**
 * A level of the game.
 */
public abstract class GameLevel extends World {

    private MainCharacter player;
    private Chest chest;
    //ArrayList's where the health and jewel value is stored
    static List<Heart> hearts = new ArrayList<>();
    static List<Jewel> jewels = new ArrayList<>();

    public Chest getChest() {
        return chest;
    }

    public MainCharacter getPlayer() {
        return player;
    }

    public List<Heart> getHearts() {
        return hearts;
    }

    public List<Jewel> getJewels() {
        return jewels;
    }

    /**
     * Populate the world of this level.
     */
    public void populate(Game game) {
        player = new MainCharacter(this, game.heartAmount);
        player.setPosition(startPosition());
        Door door = new Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new DoorListener(game));

        for (int i = 0; i < game.heartAmount; i++) {
            Heart heart = new Heart(this);
            heart.setPosition(new Vec2(-13 - i * 2, 14f));
            hearts.add(heart);
        }
    }

    /**
     * The initial position of the player.
     */
    public abstract Vec2 startPosition();

    /**
     * The position of the exit door.
     */
    public abstract Vec2 doorPosition();

    /**
     * Is this level complete?
     */
    public abstract boolean isCompleted();

    public abstract int currentLevel();

    //public abstract int currentHealth();
}
