package MainPackage;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage image;

    public SpriteSheet(BufferedImage image)
    {
        this.image = image;
    }

    public BufferedImage grabImage(int col)
    {
        return image.getSubimage(2*col+(col*32-32),0,32,32);
    }
}
