package MainPackage;

import java.awt.*;

public class Rock extends GameObject {

    public Rock(int x, int y, ID id,SpriteSheet ss) {
        super(x, y, id,ss);
    }

    public void move() {

    }

    public void tick() {
    }

    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x,y,32,32);
    }

    public Rectangle getBounds() {
        return new Rectangle(x,y,32,32);
    }


}
