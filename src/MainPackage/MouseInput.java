package MainPackage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
    private Handler handler;
    private Camera camera;
    private MainHero hero;

    public MouseInput(Handler handler,Camera camera,MainHero hero)
    {
        this.handler = handler;
        this.camera = camera;
        this.hero = hero;
    }

//    public void mouseDragged(MouseEvent e)
//    {
//        for (int i = 0; i < handler.operatableObjects.size();i++)
//        {
//            GameObject tempObject = handler.operatableObjects.get(i);
//
//            tempObject.move();
//            }
//    }


    public void mousePressed(MouseEvent m)
    {
        if (hero.isCanShoot()) {
            hero.setCanShoot(false);
            int mx = (int) (m.getX() + camera.getX());
            int my = (int) (m.getY() + camera.getY());


            for (int i = 0; i < handler.operatableObjects.size(); i++) {
                GameObject tempObject = handler.operatableObjects.get(i);

                tempObject.move();

                if (tempObject.getId() == ID.Player) {
                    handler.addObject(new Bullet(tempObject.getX() + 16, tempObject.getY() + 24, ID.Bullet, handler, mx, my));
                }
            }
        }
    }
}
