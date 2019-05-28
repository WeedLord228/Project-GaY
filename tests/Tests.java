import MainPackage.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    private Object Handler;
    MainPackage.Handler handler;

    @Test
    public void MainGotHit1() {
        MainHero mh = new MainHero(1,1,ID.Player,null,null);

        mh.getHit();

        assertEquals(90,mh.getHp());
    }

    @Test
    public void MainGotHit2() {
        MainHero mh = new MainHero(1,1,ID.Player,null,null);

        mh.getHit();
        mh.getHit();
        mh.getHit();

        assertEquals(70,mh.getHp());
    }

    @Test
    public void MainHeroTimer()
    {
        MainHero mh = new MainHero(1,1,ID.Player,null,null);

        mh.tickTimer();

        assertEquals(1,mh.getTimer());
        assertEquals(true,mh.isCanShoot());
    }

    @Test
    public void MainHeroTimer2()
    {
        MainHero mh = new MainHero(1,1,ID.Player,null,null);

        mh.tickTimer();
        mh.tickTimer();
        mh.tickTimer();
        mh.tickTimer();

        mh.resetTimer();


        assertEquals(0,mh.getTimer());
        assertEquals(true,mh.isCanShoot());
    }

    @Test
    public void BulletTest1()
    {
        Bullet bullet = new Bullet(0,0, ID.Bullet,null,10,10,null);

        bullet.move();

        assertEquals(21,bullet.getX());
        assertEquals(21,bullet.getY());
    }

    @Test
    public void BulletTest2()
    {
        Bullet bullet = new Bullet(0,0, ID.Bullet,null,10,10,null);

        bullet.setSpeed(10,20);
        bullet.move();

        assertEquals(13,bullet.getX());
        assertEquals(26,bullet.getY());
    }

    @Test
    public void BulletTest3()
    {
        Bullet bullet = new Bullet(0,0, ID.Bullet,null,10,10,null);

        bullet.setSpeed(0,20);
        bullet.move();

        assertEquals(0,bullet.getX());
        assertEquals(30,bullet.getY());
    }
    
//    @Test
//    public void MainHeroMove2() {
//        MainHero mh = new MainHero(1,1,ID.Player,null,null);
//
//        mh.setVelX(1);
//
//
//        mh.move();
//
//        assertEquals(2,mh.getX());
//        assertEquals(1,mh.getY());
//    }
//
//    @Test
//    public void MainHeroMove3() {
//        MainHero mh = new MainHero(1,1,ID.Player,null,null);
//
//        mh.setVelY(1);
//
//
//        mh.move();
//
//        assertEquals(1,mh.getX());
//        assertEquals(2,mh.getY());
//    }
//
//    @Test
//    public void MainHeroMove4() {
//        MainHero mh = new MainHero(1,1,ID.Player,null,null);
//
//        mh.setVelX(1);
//        mh.setVelY(1);
//
//
//        mh.move();
//
//        assertEquals(2,mh.getX());
//        assertEquals(2,mh.getY());
//    }
//    @Test
//    public void MainHeroMove1() {
//        MainHero mh = new MainHero(1,1,ID.Player,null,null);
//
//        mh.move();
//
//        assertEquals(1,mh.getX());
//        assertEquals(1,mh.getY());
//    }






//    @Test
//    public void collisionTest() {
////MainHero mainHero = new MainHero(0, 0, ID.Player, (MainPackage.Handler) Handler);
//        boolean isCollision = false;
//        boolean expect = false;
//        int x = 0;
//        int y = 0;
//        Rectangle a = new Rectangle(x, y, 20, 20);
//        for (int i = 0; i < handler.operatableObjects.size(); i++) {
//            GameObject tempObj = handler.operatableObjects.get(i);
//
//            if (tempObj.getId() == ID.Rock)
//                if (a.intersects(tempObj.getBounds())) {
//                    isCollision = true;
//                    expect = isCollision;
//                }
//        }
//        boolean actual = true;
//        assertEquals(expect, actual);
//    }
}