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
        return image.getSubimage(1*col+(col*16-16),0,16,16);
    }
}
