/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Body;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Time taken for player to reload gun
 * @author darkk
 */
public class reloadTimer implements ActionListener {

    MainCharacter player;

    public reloadTimer(MainCharacter player) {
        this.player = player;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.reload(7);
        player.setReloading(false);
        System.out.println("Finished Reloading");
    }

}
