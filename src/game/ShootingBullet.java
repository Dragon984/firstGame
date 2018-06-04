/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.SoundClip;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;

/**
 *The class that implements shooting method for a player
 */
public class ShootingBullet extends MouseAdapter {

    private int secondsPassed = 0;
    private MyView view;
    private Vec2 target;
    private Vec2 playerPos;
    private Vec2 difPos;

    private MainCharacter player;

    GameLevel world;
    Game game;

    public ShootingBullet(MyView view, GameLevel worldAtr) {
        this.view = view;
        world = worldAtr;
        this.player = world.getPlayer();

    }

    public Vec2 getTarget() {
        return target;
    }

    public void setTarget(Vec2 target) {
        this.target = target;
    }

    public Vec2 getPlayerPos() {
        return playerPos;
    }

    public void setPlayerPos(Vec2 playerPos) {
        this.playerPos = playerPos;
    }

    public Vec2 getDifPos() {
        return difPos;
    }

    public void setDifPos(Vec2 difPos) {
        this.difPos = difPos;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (player.getBulletAmount() > 0) {
            Bullet bullet = new Bullet(view.getWorld());
            player = world.getPlayer();
            playerPos = player.getPosition();
            // System.out.println(playerPos);
            target = view.viewToWorld(e.getPoint());
            System.out.println("target (" + target.x + ", " + target.y + ")");
            //System.out.println(bullet);
            difPos = target.sub(playerPos);
            difPos.normalize();
            bullet.setPosition(playerPos.add(difPos.mul(1.35f)));
            difPos = difPos.mul(50);
            bullet.setLinearVelocity(difPos);
            player.decrementBulletAmount();
            try{
                SoundClip pistolShot = new SoundClip("data/pistolShot.wav");
                pistolShot.play();
            } catch(UnsupportedAudioFileException | IOException | LineUnavailableException e1){
                e1.printStackTrace();
            }
            // else statement is initialised when the player is out of bullets so bullets = 0
            //causing the reload timer to activate so after 3 seconds the bullets will be refilled
        } else {
            if (player.isReloading() == false) {
                player.setReloading(true);
                System.out.println("Reloading");
                player.setReloading(true);
                Timer timer = new Timer(3000, new reloadTimer(player));
                timer.setRepeats(false);
                timer.start();
            }
        }

    }

}
