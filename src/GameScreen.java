import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameScreen extends JPanel implements KeyListener, MouseListener {
    public Worm worm;
    private BufferedImage background;
    private BufferedImage rightImage;
    private BufferedImage leftImage;
    private Image jumpRight;
    private Image jumpLeft;
    private boolean[] keys;
    private boolean lastLeft;
    private boolean lastRight = true;
    public GameScreen() {
        try {
            background = ImageIO.read(new File("src/background.png"));
            rightImage = ImageIO.read(new File("src/wormR.png"));
            leftImage = ImageIO.read(new File("src/wormL.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        jumpRight = new ImageIcon("src/wormLongJumpRGIF.gif").getImage();
        jumpLeft = new ImageIcon("src/wormLongJumpLGIF.gif").getImage();
        worm = new Worm("src/wormWalkRGIF (1).gif", "src/wormWalkLGIF (1).gif");
        keys = new boolean[128];
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.PINK);
        g.drawImage(background, 0, 0, null);
        if (lastRight && !keys[65] && !keys[68]) {
            g.drawImage(rightImage, worm.getX(), worm.getY(), null);
        }
        if (lastLeft && !keys[65] && !keys[68]) {
            g.drawImage(leftImage, worm.getX(), worm.getY(), null);
        }
        if (keys[65]) {
            g.drawImage(worm.getWorm(), worm.getX(), worm.getY(), null);
            worm.fLeft();
            worm.moveLeft();
            lastLeft = true;
            lastRight = false;
        }
        if (keys[68]) {
            g.drawImage(worm.getWorm(), worm.getX(), worm.getY(), null);
            worm.fRight();
            worm.moveRight();
            lastLeft = false;
            lastRight = true;
        }
        if (keys[32]) {
            if (lastRight) {
                g.drawImage(jumpRight, worm.getX(), worm.getY(), null);
                worm.jumpRight();
            }
            if (lastLeft) {
                g.drawImage(jumpLeft, worm.getX(), worm.getY(), null);
                worm.jumpLeft();
            }
        }
    }
    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println(key);
        keys[key] = true;
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        keys[key] = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
