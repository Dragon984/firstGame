package game;

/**
 * this is the class responsible for initialising the selected levels to be
 * shown in the JFrame with all the features that the levels provide it also
 * keeps tracks of some of the variables
 */
import city.cs.engine.SoundClip;
import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

/**
 * The class responsible for initialising the JFrame and collecting all the
 * parameters for different levels to work
 *
 * @author darkk
 */
public class Game {

    /*
    * @param world The world.
    * @param view view to the world.
    * @param controller controls for the player.
    * @param sb shootingBullet method for player.
    * @int level responsible for backgroundImage, and setting the current level.
    * @int heartAmount is tracking the player's health
     */
    private GameLevel world;

    private MyView view;

    private int level;

    private boolean goNextLevel;

    public static int heartAmount = 10;

    public static int jewelAmount = 0;

    private boolean stopped = false;

    private Controller controller;
    private ShootingBullet sb;

    //Game constructor responsible for creating the JFrame
    //where the game will be shown
    //it also creates the level object specified
    public Game() {

        level = 1;//current level value
        world = new Level1();//current level to be created
        System.out.println("test");
        world.populate(this);//populate world with objects
        world.setGravity(20);//sets world gravity
        //world = new GameWorld1();
        view = new MyView(world, world.getPlayer(), 1280, 720, level);//size of the JFrame
        JFrame frame = new JFrame("The Game");
        Container buttons = new ControlPanel(this);
        frame.add(buttons, BorderLayout.WEST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        //display the world in the window
        frame.add(view);//add's player's view
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        world.addStepListener(new Tracker(view, world.getPlayer(), world.getHearts(), world.getJewels()));
        view.setGridResolution(0);
        sb = new ShootingBullet(view, world);
        view.addMouseListener(sb);
        controller = new Controller(world.getPlayer(), view);
        frame.addKeyListener(controller);
        frame.requestFocus();
        //JFrame debugView = new DebugViewer(world, 1280, 720);
        
            world.start();

        }

    

    public boolean isStopped() {
        return stopped;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    public GameLevel getWorld() {
        return world;
    }

    public void pause() {
        world.stop();
    }

    public void unPause() {
        world.start();
    }

    public void restart() {
        world.stop();
        view.removeMouseListener(sb);
        if (level == 1) {
            // create a new world
            world = new Level1();
            // populate the world with objects and bodies
            world.populate(this);
            world.setGravity(20);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            //show the new world in the view
            view.setWorld(world);

            //stepListener that keeps track of view,player,player's health, and jewel count
            world.addStepListener(new Tracker(view, world.getPlayer(), world.getHearts(), world.getJewels()));
            //new mouse listener for the player for player to be able to shoot bullets
            sb = new ShootingBullet(view, world);
            view.addMouseListener(sb);
            //sets the background depending on current level
            view.setBackground(level);
            world.start();
        } else if (level == 2) {
            // create a new world
            world = new Level2();
            // populate the world with objects and bodies
            world.populate(this);
            world.setGravity(20);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            //show the new world in the view
            view.setWorld(world);
            //stepListener that keeps track of view,player,player's health, and jewel count
            world.addStepListener(new Tracker(view, world.getPlayer(), world.getHearts(), world.getJewels()));
            //new mouse listener for the player for player to be able to shoot bullets
            sb = new ShootingBullet(view, world);
            view.addMouseListener(sb);
            //sets the background depending on current level
            view.setBackground(level);
            world.start();
        } else if (level == 3) {
            // create a new world
            world = new Level3();
            // populate the world with objects and bodies
            world.populate(this);
            world.setGravity(20);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            //show the new world in the view
            view.setWorld(world);
            //stepListener that keeps track of view,player,player's health, and jewel count
            world.addStepListener(new Tracker(view, world.getPlayer(), world.getHearts(), world.getJewels()));
            //new mouse listener for the player for player to be able to shoot bullets
            sb = new ShootingBullet(view, world);
            view.addMouseListener(sb);
            //sets the background depending on current level
            view.setBackground(level);
            world.start();
        } else if (level == 4) {
            // create a new world
            world = new Level4();
            // populate the world with objects and bodies
            world.populate(this);
            world.setGravity(20);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            //show the new world in the view
            view.setWorld(world);
            //stepListener that keeps track of view,player,player's health, and jewel count
            world.addStepListener(new Tracker(view, world.getPlayer(), world.getHearts(), world.getJewels()));
            //new mouse listener for the player for player to be able to shoot bullets
            sb = new ShootingBullet(view, world);
            view.addMouseListener(sb);
            //sets the background depending on current level
            view.setBackground(level);
            world.start();
        } else if (level == 5) {
            // create a new world
            world = new Level5();
            // populate the world with objects and bodies
            world.populate(this);
            world.setGravity(20);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            //show the new world in the view
            view.setWorld(world);
            //stepListener that keeps track of view,player,player's health, and jewel count
            world.addStepListener(new Tracker(view, world.getPlayer(), world.getHearts(), world.getJewels()));
            //new mouse listener for the player for player to be able to shoot bullets
            sb = new ShootingBullet(view, world);
            view.addMouseListener(sb);
            //sets the background depending on current level
            view.setBackground(level);
            world.start();
        }
    }

    public void setWorld(GameLevel world) {
        this.world = world;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public MainCharacter getPlayer() {
        return world.getPlayer();
    }

    public Chest getChest() {
        return world.getChest();
    }

    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    public void goNextLevel() {
        world.stop();
        view.removeMouseListener(sb);

        //MainCharacter getHealth = world.getPlayer();
        if (level == 5) {
            System.exit(0);

        } else if (level == 1) {
            //raise level by 1
            level++;
            // create a new world
            world = new Level2();
            // populate the world with objects and bodies
            world.populate(this);
            world.setGravity(20);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            //show the new world in the view
            view.setWorld(world);
            //stepListener that keeps track of view,player,player's health, and jewel count
            world.addStepListener(new Tracker(view, world.getPlayer(), world.getHearts(), world.getJewels()));
            //new mouse listener for the player for player to be able to shoot bullets
            sb = new ShootingBullet(view, world);
            view.addMouseListener(sb);
            //sets the background depending on current level
            view.setBackground(level);
            world.start();
        } else if (level == 2) {
            //raise level by 1
            level++;
            // create a new world
            world = new Level3();
            // populate the world with objects and bodies
            world.populate(this);
            world.setGravity(20);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            //show the new world in the view
            view.setWorld(world);
            //stepListener that keeps track of view,player,player's health, and jewel count
            world.addStepListener(new Tracker(view, world.getPlayer(), world.getHearts(), world.getJewels()));
            //new mouse listener for the player for player to be able to shoot bullets
            sb = new ShootingBullet(view, world);
            view.addMouseListener(sb);
            //sets the background depending on current level
            view.setBackground(level);
            world.start();
        } else if (level == 3) {
            //raise level by 1
            level++;
            // create a new world
            world = new Level4();
            // populate the world with objects and bodies
            world.populate(this);
            world.setGravity(20);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            //show the new world in the view
            view.setWorld(world);
            //stepListener that keeps track of view,player,player's health, and jewel count
            world.addStepListener(new Tracker(view, world.getPlayer(), world.getHearts(), world.getJewels()));
            //new mouse listener for the player for player to be able to shoot bullets
            sb = new ShootingBullet(view, world);
            view.addMouseListener(sb);
            //sets the background depending on current level
            view.setBackground(level);
            world.start();
        } else if (level == 4) {
            //raise level by 1
            level++;
            // create a new world
            world = new Level5();
            // populate the world with objects and bodies
            world.populate(this);
            world.setGravity(20);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            //show the new world in the view
            view.setWorld(world);
            //stepListener that keeps track of view,player,player's health, and jewel count
            world.addStepListener(new Tracker(view, world.getPlayer(), world.getHearts(), world.getJewels()));
            //new mouse listener for the player for player to be able to shoot bullets
            sb = new ShootingBullet(view, world);
            view.addMouseListener(sb);
            //sets the background depending on current level
            view.setBackground(level);
            world.start();
        }
    }

    // responsible for starting the game
    public static void main(String[] args) {
        new Game();
    }

}
