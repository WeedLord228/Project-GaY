package MainPackage;

import java.awt.*;

public class Bullet extends GameObject {
    private Handler handler;
    public Bullet(int x, int y, ID id,Handler handler,int mx, int my) {
        super(x, y, id);
        this.handler = handler;

        velX = (mx -x) / 10;
        velY = (my - y) / 10;
//        velX = (float)Math.sqrt((mx - x)*(mx - x) + (my - y)*(my - y))/10;
//        velY = (float)Math.sqrt((mx - x)*(mx - x) + (my - y)*(my - y))/10;
    }


    public void tick() {
        if (handler.isCanMove()) move();

        for (int i = 0; i < handler.operatableObjects.size(); i++)
        {
            GameObject tempObject = handler.operatableObjects.get(i);

            if (tempObject.getId() == ID.Rock)
                if (getBounds().intersects(tempObject.getBounds()))
                {
                    handler.removeObject(this);
                }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(x,y,8,8);
    }

    public Rectangle getBounds() {
        return new Rectangle(x,y,8,8);
    }

    @Override
    public void move() {
        x+=velX;
        y+=velY;
    }
}
