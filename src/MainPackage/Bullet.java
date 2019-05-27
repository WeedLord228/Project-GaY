package MainPackage;

import java.awt.*;

public class Bullet extends GameObject {
    private Handler handler;
    public Bullet(int x, int y, ID id,Handler handler,int mx, int my,SpriteSheet ss) {
        super(x, y, id,ss);
        this.handler = handler;

        setSpeed(mx,my);
    }

    public void setSpeed(int tx,int ty) {
        int diffX=  tx - x;
        int diffY= ty - y;

        float norm = (float) Math.sqrt(diffX*diffX + diffY*diffY);

        velX = (float) diffX*(30/norm);
        velY = (float) diffY*(30/norm);
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
