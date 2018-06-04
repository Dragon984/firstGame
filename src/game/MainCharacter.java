package game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.Walker;
import city.cs.engine.World;
import java.io.IOException;
import java.util.List;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *Class responsible for MainCharacter and it's functionality
 */
public class MainCharacter extends Walker {

    private boolean reloading = false;
    private int powerUpCount;
    private int lifeCount;
    private int heartAmount;
    private int count;
    private int bulletAmount;
    private int jewelCount;
    
    private static final Shape CharacterShape = new PolygonShape(
            -0.97f, -0.4f, -0.47f, 0.81f, 0.08f, 1.07f, 0.86f, 0.76f, 0.98f, 0.6f, 0.51f, -1.2f, -0.52f, -1.19f, -0.96f, -0.62f);
    private static BodyImage image = new BodyImage("data/MainRight1.png", 3f);

    public MainCharacter(World world, int heartAmount) {
        super(world, CharacterShape);
        addImage(image);
        powerUpCount = 0;
        this.heartAmount = heartAmount;
        count = 0;
        bulletAmount = 7;
        jewelCount = 0;

    }

    public boolean isReloading() {
        return reloading;
    }

    public void setReloading(boolean reloading) {
        this.reloading = reloading;
    }

    public void reload(int bulletAmount) {
        this.bulletAmount = bulletAmount;
    }

    public int getBulletAmount() {
        return bulletAmount;
    }

    public void setBulletAmount(int bulletAmount) {
        this.bulletAmount = bulletAmount;
    }

    public void decrementBulletAmount() {
        bulletAmount--;
    }

    public int getPowerUpCount() {
        return powerUpCount;
    }

    public void incrementPowerUpCount() {
        powerUpCount++;
        System.out.println("jewels collected: " + powerUpCount);
    }

    public int getJewelCount() {
        return jewelCount;
    }

    public void incrementJewelCount() {
        jewelCount++;
        System.out.println("Jewels collected" + jewelCount);
    }
    /*
    * if the player encounters object that has a collisionListener which has a decreaseHeartAmount method
    * the player would lose the health
    */
    public void decrementHeartCount() {
        heartAmount--;
        GameLevel world = (GameLevel) this.getWorld(); //method to retrieve the current world the player is in
        List<Heart> hearts = world.getHearts();
        if (heartAmount > 0) {
            hearts.get(hearts.size() - 1).destroy();
            hearts.remove(hearts.size() - 1);
            System.out.println("Ouch");
            System.out.println("Life count:" + heartAmount);
            try {
                SoundClip hurtSound = new SoundClip("data/hurtSound.wav");
                hurtSound.play();
            } catch(UnsupportedAudioFileException | IOException |LineUnavailableException e){
                e.printStackTrace();
            }
        } else {
            System.exit(0);
        }
    }

    /**
     * public int getHeartCount(){ return heartCount; }
     */
    public int getCount() {
        return count;
    }

    public void addOne() {
        count++;
    }
}
