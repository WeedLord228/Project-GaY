//package MainPackage;
//
//import java.awt.*;
//import java.awt.geom.Line2D;
//import java.awt.geom.Point2D;
//import java.lang.reflect.GenericArrayType;
//
//public class Turret extends GameObject {
//    Handler handler;
//
//
//    public Turret(int x,int y, ID id, Handler handler)
//    {
//        super(x, y, id);
//        this.handler = handler;
//    }
//
//
//    @Override
//    public void tick() {
////        Line2D ray = new Line2D.Double();
//        boolean canShoot = false;
//
//
//        for (int i = 0; i < handler.operatableObjects.size(); i++) {
//            GameObject tempObject = handler.operatableObjects.get(i);
//
//            if (tempObject.getId() == ID.Player); {
////                ray.setLine(this.x,this.y,tempObject.x,tempObject.y);
////                for (int j=0; j < handler.operatableObjects.size(); j++){
////                    GameObject tempObject2 = handler.operatableObjects.get(j);
////                    if(tempObject2.getId() == ID.Rock && ray.intersects(tempObject2.getBounds()))
////                        canShoot = true;
////                }
////                canShoot = visionCheck(tempObject);
//                if (canShoot) {
//                    handler.addObject(new Bullet(this.getX() + 16, this.getY() + 24, ID.Bullet, handler, tempObject.x, tempObject.y));
//                    canShoot=false;
//                }
//            }
//        }
//    }
//
//    @Override
//    public void render(Graphics g) {
//        g.setColor(Color.red);
//        g.fillOval(x,y,32,32);
//
//    }
//
//    @Override
//    public Rectangle getBounds() {
//        return new Rectangle(x, y, 32, 32);
//    }
//
////    public boolean visionCheck(GameObject object) {
////        Line2D ray = new Line2D.Double();
////
////        for (int i = 0; i < handler.operatableObjects.size(); i++) {
////            GameObject tempObject = handler.operatableObjects.get(i);
////            if (tempObject.getId() == ID.Rock)
////            {
////                ray.setLine(this.x,this.y,tempObject.x,tempObject.y);
////                return ray.intersects(object.getBounds());
////            }
////        }
////        return false;
////    }
//
//
//}
