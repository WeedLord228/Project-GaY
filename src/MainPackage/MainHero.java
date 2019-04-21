package MainPackage;

import java.awt.*;

public class MainHero extends GameObject {

    Handler handler;

    public MainHero(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    public void tick() {
        x += velX;
        y += velY;

        collision();

        //эта конструкция описывает движение. TODO Поиграться с костантами!

        if (handler.isUp()) {
            if (handler.isDown()) {
                velY = 0;
                return;
            }
            if (handler.isLeft()) {
                velY = -2f;
                velX = -2f;
                return;
            }
            if (handler.isRight()) {
                velY = -2f;
                velX = 2f;
                return;
            }
            velY = -4;
            return;
        } else if (!handler.isDown()) velY = 0;

        if (handler.isDown()) {
            if (handler.isUp()) {
                velY = 0;
                return;
            }
            if (handler.isLeft()) {
                velY = 2f;
                velX = -2f;
                return;
            }
            if (handler.isRight()) {
                velY = 2f;
                velX = 2f;
                return;
            }
            velY = 4;
            return;
        } else if (!handler.isUp()) velY = 0;

        if (handler.isLeft()) {
            velX = -4;
            return;
        } else if (!handler.isRight()) velX = 0;

        if (handler.isRight()) {
            velX = 4;
            return;
        } else if (!handler.isLeft()) velX = 0;
    }

    private void collision() {
        for (int i = 0; i < handler.operatableObjects.size(); i++) {
            GameObject tempObj = handler.operatableObjects.get(i);

            if (tempObj.getId() == ID.Rock)
                if (this.getBounds().intersects(tempObj.getBounds())) {
                    x += velX * -1;
                    y += velY * -1;
                }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillOval(x, y, 20, 20);
    }

    //Определяет размеры нашего игрока
    public Rectangle getBounds() {
        return new Rectangle(x, y, 20, 20);
    }
}
