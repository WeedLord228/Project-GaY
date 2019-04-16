package MainPackage;

import java.awt.*;

public class Rock extends GameObject {

    public Rock(int x, int y, ID id) {
        super(x, y, id);

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x,y,32,32);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,32,32);
    }
}
