package MainPackage;

import java.awt.*;

public class MainHero extends GameObject {

    Handler handler;
    int hp = 100;
    private boolean canShoot = true;
    private int timer;

    public MainHero(int x, int y, ID id, Handler handler,SpriteSheet ss) {
        super(x, y, id,ss);
        this.handler = handler;
    }

    @Override
    public void move() {
        x+=velX;
        y+=velY;

        collision();

        if (handler.isUp() && handler.isRight()) {
            velY = -3f;
            velX = 3f;
            return;
        } else if (!handler.isUp() && !handler.isRight()) {
            velX = 0;
            velY = 0;
        }

        if (handler.isDown() && handler.isRight()) {
            velY = 3f;
            velX = 3f;
            return;
        } else if (!handler.isDown() && !handler.isRight()) {
            velX = 0;
            velY = 0;
        }

        if (handler.isUp() && handler.isLeft()) {
            velY = -3f;
            velX = -3f;
            return;
        } else if (!handler.isUp() && !handler.isLeft()) {
            velX = 0;
            velY = 0;
        }

        if (handler.isDown() && handler.isLeft()) {
            velY = 3f;
            velX = -3;
            return;
        } else if (!handler.isDown() && !handler.isLeft()) {
            velX = 0;
            velY = 0;
        }

        if (handler.isUp()) {
            velY = -4f;
        } else if (!handler.isDown()) velY = 0;

        if (handler.isDown()) {
            velY = 4;
        } else if (!handler.isUp()) velY = 0;

        if (handler.isLeft()) {
            velX = -4;
        } else if (!handler.isRight()) velX = 0;

        if (handler.isRight()) {
            velX = 4;
        } else if (!handler.isLeft()) velX = 0;
    }

    public void tick() {
        if (handler.isCanMove()) tickTimer();

        if (timer >= 20) resetTimer();

        x += velX;
        y += velY;
        move();

        if (hp <= 0) {
            handler.removeObject(this);
        }
    }

    private void collision() {
        for (int i = 0; i < handler.operatableObjects.size(); i++) {
            GameObject tempObj = handler.operatableObjects.get(i);

            if (tempObj.getId() == ID.Rock)
                if (this.getBounds().intersects(tempObj.getBounds())) {

                    x += velX * -1;
                    y += velY * -1;
                }

            if (tempObj.getId() == ID.Enemy)
                if (this.getBounds().intersects(tempObj.getBounds()))
                    hp-=10;
        }
    }

    public void render(Graphics g) {
        g.drawImage(ss.grabImage(2),x,y,null);
//        g.setColor(Color.MAGENTA);
//        g.fillOval(x, y, 50, 50);
    }

    //Определяет размеры нашего игрока
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

    public void tickTimer()
    {
        timer++;
    }

    public void resetTimer()
    {
        timer=0;
        setCanShoot(true);
    }

    public boolean isCanShoot() {
        return canShoot;
    }

    public void setCanShoot(boolean canShoot) {
        this.canShoot = canShoot;
    }
}
