/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The class responsible for bullet collision timer, so that if bullet collided with a static body it would be destroyed within 3 seconds
 * @author darkk
 */
public class DestroyBulletTimer implements ActionListener {
    MainCharacter player;
    Bullet bullet;
    
    public DestroyBulletTimer(Bullet bullet){
        this.bullet = bullet;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        bullet.destroy();
        
    }
}
