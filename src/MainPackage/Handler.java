package MainPackage;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Handler {

    public ArrayList<GameObject> operatableObjects = new ArrayList<GameObject>();
    private boolean up=false, down=false, right=false, left=false;


    public void tick() {
        for (int i = 0; i < operatableObjects.size(); i++) {
            GameObject tempObject = operatableObjects.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < operatableObjects.size(); i++) {
            GameObject tempObject = operatableObjects.get(i);
            tempObject.render(g);
        }
    }

    public void addObject(GameObject tempObject){
        operatableObjects.add(tempObject);
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void removeObject(GameObject tempObject){
        operatableObjects.remove(tempObject);
    }


}