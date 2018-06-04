/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 * this is the class responsible for creating Chest objects
 */
public class Chest extends StaticBody implements CollisionListener {

    private Game game;
    private GameLevel world;
    private boolean chestOpened = false;
    private int i;

    //creating a polygon shape for the chest in the closed state as well as initialising it's polygon shape
    private static Shape closedChest = new PolygonShape(
            -1.36f, 1.26f, -1.48f, 0.18f, -1.43f, -1.25f, 1.48f, -1.24f, 1.47f, 0.34f, 1.4f, 1.25f, -1.31f, 1.27f);
    private static BodyImage image = new BodyImage("data/closedChest.png", 3f);
    //creting a polygon shape for the chest in the opened state as well as initialising it's polygon shape
    private static Shape openedChest = new PolygonShape(
            -1.4f, 1.46f, -1.4f, 0.01f, -1.4f, -1.41f, 1.41f, -1.41f, 1.41f, 0.05f, 1.41f, 1.45f, -1.27f, 1.46f);
    private static BodyImage image1 = new BodyImage("data/openedChest.png", 3f);

    //setter for the condition chestOpened
    public void setChestOpened(boolean chestOpened) {
        this.chestOpened = chestOpened;
    }

    //this changes the value of chest opened from false to true
    //causinng the chest image and polygon shape to change to openedChest
    public void changeChestTexture() {
        if (chestOpened == true) {
            removeAllImages();
            BodyImage image = image1;
            addImage(image1);
        }
    }

    public Chest(GameLevel world, Game game) {
        super(world, closedChest);
        addImage(image);
        this.world = world;
        this.game = game;
        addCollisionListener(this);
    }

    //this event occurs if the player collides with the chest
    @Override
    public void collide(CollisionEvent e) {
        //chest = (Chest) e.getReportingBody();
        if (e.getOtherBody() instanceof MainCharacter) {
            if (i < 1) {
                System.out.println("chest opened");
                setChestOpened(true);
                changeChestTexture();
                // had to remove this adding jewel feature because im getting name = null, and idk how to fix it
                /**
                 * Jewel jewel = new Jewel(world); jewel.setPosition(new
                 * Vec2(this.getPosition().x, this.getPosition().y + 3));
                 * jewel.addCollisionListener(new
                 * PlayerCollision(game.getPlayer()));
                 */
                i++;

            }
        }
    }

}
