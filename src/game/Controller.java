/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Walker;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import org.jbox2d.common.Vec2;

/**
 * this class is responsible for controlling the players movement.
 */
public class Controller extends KeyAdapter {

    private MyView view;
    
    private Game game;
    
    private float zoom;

    private static final float WALKING_SPEED = 10;

    private int jump = 1;

    private Walker body;

    public Controller(Walker body, MyView view) {
        this.body = body;
        this.view = view;
        
    }

    /**
     * Handle key press events for walking and jumping.
     *
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_W) { // J = jump
            Vec2 v = body.getLinearVelocity();
            if (jump > 0) {
                body.applyImpulse(new Vec2(0, 200));
                jump--;
            }
            // only jump if body is not already jumping
            if (Math.abs(v.y) <= 0) {
                jump = 1;
            }
        } else if (code == KeyEvent.VK_A) {
            body.startWalking(-WALKING_SPEED); // 1 = walk left
        } else if (code == KeyEvent.VK_D) {
            body.startWalking(WALKING_SPEED); // 2 = walk right
        } else if (code == KeyEvent.VK_S) {
            body.applyImpulse(new Vec2(0, -100));// force character to the ground.
            //using Z or U keys differ the zoom to the player
        } else if (code == KeyEvent.VK_Z) {
            zoom = view.getZoom();
            zoom++;
            view.setZoom(zoom);
              
        } else if (code == KeyEvent.VK_U){
            zoom = view.getZoom();
            zoom--;
            view.setZoom(zoom);
        }

    }

    /**
     * Handle key release events (stop walking).
     *
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            body.stopWalking();
        } else if (code == KeyEvent.VK_D) {
            body.stopWalking();
        }
    }

    public void setBody(Walker body) {
        this.body = body;
    }
}
