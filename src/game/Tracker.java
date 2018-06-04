/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import java.util.List;
import org.jbox2d.common.Vec2;

/**
 * Class responsible for tracking parameters:
*/
/*
 * @param view which tracks the view of the current world
 * @param player which retrieves the player from the current world and it's position to centre the screen on the player
 * @param hearts which is used to track the heart amount to specify their location on the players screen
 * @param jewels which is used to track the amount of jewels that player has collected // note // haven't managed this feature to work 
 */
public class Tracker implements StepListener {

    /**
     * The view
     */
    private UserView view;
    List<Heart> hearts;
    /**
     * The body
     */
    private MainCharacter player;
    List<Jewel> jewels;

    Game game;

    private MyView view1;

    public Tracker(UserView view, MainCharacter player, List<Heart> hearts, List<Jewel> jewels) {
        this.view = view;
        this.player = player;
        this.hearts = hearts;
        this.jewels = jewels;
        //this.heart = heart;
    }

    @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {
        view.setCentre(player.getPosition());
        int i = 0;
        for (Heart heart : hearts) {
            heart.setPosition(new Vec2(-29 + i * 1, 16).add(player.getPosition()));
            i++;
            
        }
    }
}
