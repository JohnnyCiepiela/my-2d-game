package entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.parser.GamePanel;
import org.parser.KeyHandler;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyHandler;

    public Player(GamePanel gp, KeyHandler keyHandler) {
        this.gp = gp;
        this.keyHandler = keyHandler;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {

            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/ghost_back.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/ghost_back2.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/ghost_front.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/ghost_front2.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/ghost_left.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/ghost_left2.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/ghost_right.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/ghost_right2.png"));

        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if(keyHandler.upPressed) {
            direction = "up";
            y -= speed;
        }
        else if(keyHandler.downPressed) {
            direction = "down";
            y += speed;
        }
        else if(keyHandler.leftPressed) {
            direction = "left";
            x -= speed;
        }
        else if(keyHandler.rightPressed) {
            direction = "right";
            x += speed;
        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;
        switch(direction) {
            case "up":
                image=up1;
                break;
            case "down":
                image=down1;
                break;
            case "left":
                image=left1;
                break;
            case "right":
                image=right1;
                break;
        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}