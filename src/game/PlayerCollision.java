/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * The class responsible for all player's collisions
*/
 /*
 * @param powerUps required to be picked up by the player in order to proceed to next level
 * @param Enemy different enemy objects
 * @param Jewel the jewel that could be picked up by the player in order to proceed to next level // note haven't got this feature working
 */

public class PlayerCollision implements CollisionListener {

    private MainCharacter player;

    private int i;

    public PlayerCollision(MainCharacter player) {
        this.player = player;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getReportingBody() instanceof PowerUps && e.getOtherBody() == player) {
            player.incrementPowerUpCount();
            player.addOne();
            e.getReportingBody().destroy();

        } else if (e.getReportingBody() instanceof Enemy1 && e.getOtherBody() == player) {
            player.decrementHeartCount();

        } else if (e.getReportingBody() instanceof Enemy2 && e.getOtherBody() == player) {
            player.decrementHeartCount();

        } else if (e.getReportingBody() instanceof Jewel && e.getOtherBody() == player) {
            player.incrementJewelCount();
            e.getReportingBody().destroy();

        } else if (e.getReportingBody() instanceof Spikes && e.getOtherBody() == player) {
            for (i = 0; i < 9; i++) {
                player.decrementHeartCount();
            }
        } else if (e.getReportingBody() instanceof Enemy3 && e.getOtherBody() == player) {
            for (i = 0; i < 2; i++) {
                player.decrementHeartCount();
            }

        } else if (e.getReportingBody() instanceof Enemy4 && e.getOtherBody() == player) {
            for (i = 0; i < 3; i++) {
                player.decrementHeartCount();
            }

        } else if (e.getReportingBody() instanceof Enemy5 && e.getOtherBody() == player) {
            for (i = 0; i < 5; i++) {
                player.decrementHeartCount();
            }

        }

    }
}
