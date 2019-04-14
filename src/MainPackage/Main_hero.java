package MainPackage;

import java.awt.*;

public class Main_hero extends GameObject {

    Handler handler;

    public Main_hero(int x, int y, ID id , Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    public void tick() {
        x+=velX;
        y+=velY;
        //эта конструкция описывает движение. Поиграться с костантами!
        if(handler.isUp()) velY = -5;
        else if(!handler.isDown()) velY = 0;

        if(handler.isDown()) velY = 5;
        else if(!handler.isUp()) velY = 0;

        if(handler.isLeft()) velX = -5;
        else if(!handler.isRight()) velX = 0;

        if(handler.isRight()) velX = 5;
        else if(!handler.isLeft()) velX = 0;
    }

    public void render(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillRect(x,y,20,20);
    }

    public Rectangle getBounds() {
        return new Rectangle(x,y,20 , 20);
    }
}
