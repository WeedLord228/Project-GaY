package MainPackage;

public class Camera {
    private float x;

    private float y;

    public Camera(float x, float y){
        this.x = x;
        this.y = y;

        if (x)
    }

    public void tick(GameObject object)
    {
        x += ((object.getX() - x) - 1000/2) * 0.05f;
        y += ((object.getY() - y) - 563/2) * 0.05;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}
