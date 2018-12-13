package image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StaticImage extends Component {

    public BufferedImage image;

    private Image offscreen = null;

    public int width;
    public int height;

    private StaticImage() {
        this.width = 0;
        this.height = 0;
    }

    public StaticImage(String path){
        this();
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e){
            e.printStackTrace();
        }
        width = image.getWidth(this);
        height = image.getHeight(this);
        setPreferredSize(new Dimension(width, height));
        setSize(width, height);
    }

    public StaticImage(BufferedImage image) {
        this();
        this.image = image;
        width = image.getWidth(this);
        height = image.getHeight(this);
    }


    public void draw(Graphics g){
        BufferedImage drawImage;
        int w = getWidth(); double fw = w * 1.0 / image.getWidth();
        int h = (int)(image.getHeight() * fw); double fh = fw;
        setSize(w, h);
        setPreferredSize(new Dimension(w, h));

        drawImage = scale(image, image.getType(), w, h, fw, fh);
        g.drawImage(drawImage, 0, 0, this);
    }

    public void invalidate() {
        super.invalidate();
        offscreen = null;
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void paint(Graphics g) {
        if(offscreen == null) {
            offscreen = createImage(getSize().width, getSize().height);
        }
        Graphics og = offscreen.getGraphics();
        og.setClip(0,0,getSize().width, getSize().height);
        draw(og);
        g.drawImage(offscreen, 0, 0, null);
        og.dispose();
    }

    /**
     * scale image
     *
     * @param sbi image to scale
     * @param imageType type of image
     * @param dWidth width of destination image
     * @param dHeight height of destination image
     * @param fWidth x-factor for transformation / scaling
     * @param fHeight y-factor for transformation / scaling
     * @return scaled image
     */
    public static BufferedImage scale(BufferedImage sbi, int imageType, int dWidth, int dHeight, double fWidth, double fHeight) {
        BufferedImage dbi = null;
        if(sbi != null) {
            dbi = new BufferedImage(dWidth, dHeight, imageType);
            Graphics2D g = dbi.createGraphics();
            AffineTransform at = AffineTransform.getScaleInstance(fWidth, fHeight);
            g.drawRenderedImage(sbi, at);
        }
        return dbi;
    }

}