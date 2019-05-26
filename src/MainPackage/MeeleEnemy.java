package MainPackage;

import java.awt.*;
import java.util.Random;

public class MeeleEnemy extends GameObject {

    Handler handler;
    int hp = 100;


    public MeeleEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }


    public void getDirection(GameObject object) {
        int diffX= object.x - x;
        int diffY= object.y - y;

        float norm = (float) Math.sqrt(diffX*diffX + diffY*diffY);

        velX = (diffX *= (2.5/norm));
        velY = (diffY *= (2.5/norm));
    }

    @Override
    public void move() {
        x +=velX;
        y +=velY;
    }

    @Override
    public void tick() {
        if (handler.isCanMove()) move();

        for (int i = 0; i < handler.operatableObjects.size(); i++) {
            GameObject tempObject = handler.operatableObjects.get(i);

            collision(tempObject);
            
                if (tempObject.getId() == ID.Player && handler.isCanMove()) {
                    getDirection(tempObject);
                    move();
                }
            }

            if (hp <= 0)
                handler.removeObject(this);
    }

    public void collision(GameObject object)
    {
        if (object.id == ID.Rock) {
            if (getBoundsBig().intersects(object.getBounds())) {
                x += (-velX * 5) * -1;
                y += (-velY * 5) * -1;
                velX = -1;
                velY = -1;
            }
        }

        if (object.getId() == ID.Bullet) {
            if (getBounds().intersects(object.getBounds())) {
                hp -= 50;
                handler.removeObject(object);
            }
        }
        
        if (object.id == ID.Enemy)
        {
            if ((object != this) && this.getBounds().intersects(object.getBounds())) {
                x += -1 * velX*2;
                y += -1 * velY*2;
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(x, y, 25, 25);

//        Graphics2D g2d = (Graphics2D) g;
//
//        g.setColor(Color.black);
//        g2d.draw(getBoundsBig());
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

    public Rectangle getBoundsBig() {
        return new Rectangle(x - 10, y - 10, 40, 40);
    }


}
