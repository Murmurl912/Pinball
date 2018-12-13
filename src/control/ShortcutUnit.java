package control;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ShortcutUnit extends Component {

    public Color color = Color.ORANGE;
    public Shape shape = null;
    public double radius = 10;
    private Image offscreen = null;

    public ShortcutUnit(Color color){
        this.color = color;
    }

    public void draw(Graphics g){

        shape = new Ellipse2D.Double(getWidth()/2.0 - radius, getHeight()/2.0 - radius, 2 * radius, 2 * radius);
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.clearRect(0, 0, getWidth(), getHeight());
        graphics2D.setColor(color);
        graphics2D.fill(shape);

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
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(offscreen, 0, 0, null);
        og.dispose();
    }

}
