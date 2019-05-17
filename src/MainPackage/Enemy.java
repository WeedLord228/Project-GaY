package MainPackage;

import java.awt.*;
import java.util.Random;

public class Enemy extends GameObject {

    Handler handler;
    int hp = 100;
    Random r = new Random();
    int choose = 0;

    public Enemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        choose = r.nextInt(10);

        for (int i = 0; i < handler.operatableObjects.size(); i++) {
            GameObject tempObject = handler.operatableObjects.get(i);

            if (tempObject.id == ID.Rock) {
                if (getBoundsBig().intersects(tempObject.getBounds())) {
                    x += (velX * 5) * -1;
                    y += (velY * 5) * -1;
                    velX = -1;
                    velY = -1;
                }
//                else{
//                    x +=
//                }
//                } else if (choose == 0) {
//                    velX = (r.nextInt(2 - -4) + -4);
//                    velY = (r.nextInt(2 - -4) + -4);
//                }
            }
            if (tempObject.getId() == ID.Player)
            {
                double angle = Math.atan2(tempObject.x - x,tempObject.y - y);
                if (angle < 0) angle += 2 * Math.PI;
                x+=  2 * Math.cos(angle);
                y+= -2 * Math.sin(angle);
            }
            if (tempObject.getId() == ID.Bullet) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    hp -= 50;
                    handler.removeObject(tempObject);
                }
            }
        }
        if (hp <= 0)
            handler.removeObject(this);
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
