//import MainPackage.*;
//import org.junit.jupiter.api.Test;
//
//import java.awt.*;
//import java.awt.event.KeyEvent;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class Tests {
//
//    private Object Handler;
//    MainPackage.Handler handler;
//
//    @Test
//    public void one_S_KEY_MoveTest() {
//        boolean expected = false;
//
//        MainHero mainHero = new MainHero(0, 0, ID.Player, (MainPackage.Handler) Handler,);
//        KeyInput keyInput = new KeyInput((MainPackage.Handler) Handler);
//        Game game = new Game();
////достать переменную isRunning из Game , и поставить ей true
//        int key = 53;//VK_S code
//        for (int i = 0; i < handler.operatableObjects.size(); i++) {
//            GameObject tempObject = handler.operatableObjects.get(i);
//            if (tempObject.getId() == ID.Player) {
//                if (key == KeyEvent.VK_S) {
//                    handler.setDown(true);
//                }
//                expected = handler.isDown();
//            }
//            boolean actual = true;
//            assertEquals(expected, actual);
//        }
//    }
//
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
//}