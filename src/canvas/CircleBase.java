package canvas;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * 小球的基类 只描述小球的基础信息 位置 速度 颜色 半径
 * 实现小球的具体绘制方法draw() 在MainCanvas 的 draw()中调用
 */
public class CircleBase {
    // -----------------------------------------------------------------------------------------------------------------
    public double posx;     // 小球的位置x
    public double posy;     // 小球的位置y
    public double speedx;   // 小球的速度x
    public double speedy;   // 小球的速度y
    public double maxspeed; // 小球的最终速度
    public double radius;   // 小球的半径radius
    public Color color;     // 小球的颜色color
    public String name;
    Font font = new Font("Any", Font.BOLD, 27);

    public boolean transparent;
    // -----------------------------------------------------------------------------------------------------------------

    /**
     *
     * @param posx  小球x坐标
     * @param posy  小球y坐标
     * @param speedx    小球的x速度
     * @param speedy    小球的y速度
     * @param radius    小球的半径
     * @param color     小球的颜色
     */
    public CircleBase(String name, double posx, double posy, double speedx, double speedy, double radius, Color color) { // ---------
        this.name = name;
        this.posx = posx;
        this.posy = posy;
        this.speedx = speedx;
        this.speedy = speedy;
        maxspeed = Math.sqrt(speedx * speedx + speedy * speedy);
        this.radius = radius;
        this.color = color;
        transparent = false;
    } // ---------------------------------------------------------------------------------------------------------------


    /**
     * 无参构造函数
     */
    public CircleBase(){ // --------------------------------------------------------------------------------------------
        name = "unknown";
        posy = posx = 0.0;
        speedy = speedx = 0.0;
        radius = 0;
        color = Color.BLACK;
    } // ---------------------------------------------------------------------------------------------------------------


    /**
     * 在画布MainCanvas中调用 以绘制到屏幕上
     * @param graphics2D 传入画布的图形 在这个图形上绘制
     */
    public void draw(Graphics2D graphics2D){ // ------------------------------------------------------------------------
        graphics2D.setColor(color);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Paint paint = graphics2D.getPaint();

        if(transparent){

            float[] dist = {0.0f, 0.8f, 1.0f};
            Color[] colors = { new Color(255, 255, 255, 128), new Color(color.getRed(), color.getGreen(), color.getBlue(), 80), new Color(255, 255, 255, 0)};

            RadialGradientPaint radialGradientPaint = new RadialGradientPaint((float)(posx + radius), (float)(posy + radius), (float)radius, dist, colors);
            graphics2D.setPaint(radialGradientPaint);
        }

        graphics2D.fill(new Ellipse2D.Double(posx, posy, radius * 2, radius * 2));
        int light = (int)(color.getRed() * 0.30+ color.getGreen() * 0.59 + color.getBlue() * 0.11);
        Color c = new Color(color.getRGB());
        if(light > 192){
            c = c.darker().darker().darker();
        } else if(light > 128) {
            c = c.darker().darker();
        } else if(light > 64){
            c.brighter().brighter();
        } else {
            c.brighter().brighter().brighter();
        }
        c = new Color(255 - color.getRed(), 255 - color.getGreen(), 255 - color.getBlue(), 64);

        graphics2D.setPaint(paint);
        graphics2D.setColor(c);
        int size = (int)(radius * 2 * 72 / 96);
        font = new Font("any", Font.BOLD, size);
        graphics2D.setFont(font);
        FontMetrics fm = graphics2D.getFontMetrics(graphics2D.getFont());

        int x = (int)(posx + radius - fm.stringWidth(name) / 2);
        int y = (int)(posy + radius + fm.getHeight() / 4.0);
        graphics2D.drawString(name, x, y);

    } // ---------------------------------------------------------------------------------------------------------------

}
