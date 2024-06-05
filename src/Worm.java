import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Worm {
    private Image right;
    private Image left;
    private double x;
    private double y;
    private boolean fRight;
    private final int base = 290;
    private final int maxHeight = 330;
    private double speed = .05;
    public Worm(String right, String left) {
        fRight = true;
        x = 400;
        y = 290;
        this.right = new ImageIcon(right).getImage();
        this.left = new ImageIcon(left).getImage();
    }

    public int getX() {
        return (int) x;
    }
    public int getY() {
        return (int) y;
    }
    public void fRight() {
        fRight = true;
    }
    public void fLeft() {
        fRight = false;
    }
    public void jumpRight() {
        if (y - speed >= maxHeight) {
            y -= speed;
        }
    }
    public void jumpLeft() {
        if (y - speed >= y - 40) {
            y -= speed;
        }
    }
    public void moveRight() {
        if (x + speed <= 750) {
            x += speed;
        }
    }
    public void moveLeft() {
        if (x - speed >= 0) {
            x-= speed;
        }
    }
    public Image getWorm() {
        if (fRight) {
            return right;
        } else {
            return left;
        }
    }
    public Rectangle wormRect() {
        int wormW = getWorm().getWidth(null);
        int wormH = getWorm().getHeight(null);
        Rectangle r = new Rectangle((int) x, (int) y, wormW, wormH);
        return r;
    }
}
