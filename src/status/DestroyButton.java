package status;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class DestroyButton extends Component {
    public Color color = Color.RED;
    public Shape shape = null;
    private Image offscreen = null;

    public DestroyButton(Color color){
        this.color = color;
    }

    public void draw(Graphics g){
        int r = getHeight() > getWidth() ? getWidth()  - 5 : getHeight() - 5;
        shape = new Rectangle2D.Double(getWidth()/2.0 - r / 2.0, getHeight() / 2.0 - r / 2.0, r, r);
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.clearRect(0, 0, getWidth(), getHeight());
        graphics2D.setColor(color);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
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
        g.drawImage(offscreen, 0, 0, null);
        og.dispose();
    }

}
