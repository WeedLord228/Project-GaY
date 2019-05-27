package MainPackage;

import java.awt.*;

public class SpawnPoint extends GameObject {
    static int enemiesLimit;
    static int ememiesCount;

    Handler handler;

    public SpawnPoint(int x, int y, ID id,SpriteSheet ss) {
        super(x, y, id,ss);
    }

    public void move() {

    }

    public void tick() {

    }

    public void render(Graphics g) {
//        g.drawImage(ss.grabImage(1), x,y,null);
    }

    public Rectangle getBounds() {
        return null;
//        return new Rectangle(x,y,32,32);
    }

    public void getEnemiesCount()
    {
        int c = 0;
        for (int i = 0; i < handler.operatableObjects.size(); i++)
        {
            GameObject object = handler.operatableObjects.get(i);
            if(object.id == ID.Enemy)
            c++;
        }
        enemiesLimit= c;
    }

}
