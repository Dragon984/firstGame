package game;

import city.cs.engine.UserView;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * This is the class responsible for player's game view
 */

public class MyView extends UserView {

    MainCharacter player;

    GameLevel level;

    private Image background;

    int currentLevel;

    /**
     *
     * @param world
     * @param player
     * @param width
     * @param height
     * @param currentLevel
     */
    public MyView(GameLevel world, MainCharacter player, int width, int height, int currentLevel) {
        super(world, width, height);
        this.player = player;
        // images are copyrighted By Zeyu Ren 任泽宇
        // those images are not to be used for any commercial projects
        // as this game is only being developed as part of a course work for the university
        // and is not to be sold anywhere.

        //currentLevel parameter is being retrieved from the game therefore 
        //causing background image to change depending on what level the player is currently at
        background = new ImageIcon("data/level" + currentLevel + ".png").getImage();

    }

    /**
     *
     * @param g
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }

    /**
     *
     * @param g
     */
    @Override
    protected void paintForeground(Graphics2D g) {

        g.drawString("Score:" + player.getPowerUpCount(), 1150, 50);
        g.drawString("CONTROLS W A S D TO MOVE LEFT CLICK TO SHOOT", 50, 100);
    }

    /**
     *
     * @param level
     */
    public void setBackground(int level) {
        this.background = new ImageIcon("data/level" + level + ".png").getImage();
    }

}
