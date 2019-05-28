package MainPackage;

import java.awt.*;

public class SpawnPoint extends GameObject {
    static int enemiesLimit;
    static int ememiesCount;



    Handler handler;

    public SpawnPoint(int x, int y, ID id,Handler handler,SpriteSheet ss) {

        super(x, y, id,ss);
        enemiesLimit = 10;
        this.handler = handler;
    }

    public void move() {

    }

    public void tick() {
        if (getEnemiesCount() < 5)
        handler.addObject(new MeeleEnemy(x,y,ID.Enemy,handler,ss));
    }

    public void render(Graphics g) {
//        g.drawImage(ss.grabImage(1), x,y,null);
    }

    public Rectangle getBounds() {
        return null;
//        return new Rectangle(x,y,32,32);
    }

    public int getEnemiesCount()
    {
        int c = 0;
        for (int i = 0; i < handler.operatableObjects.size(); i++)
        {
            GameObject object = handler.operatableObjects.get(i);
            if(object.id == ID.Enemy)
            c++;
        }
        return c;
    }

}
