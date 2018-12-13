package canvas;

import main.MainFrame;
import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.util.Random;

import static main.Main.files;

public class Circle extends CircleBase implements Runnable {

    public MainFrame frame;
    public long lastCircleImpactTime;
    public long currentCircleImpactTime;

    public boolean mouseclicked = false;
    public int clickx;
    public int clicky;

    public boolean alive = true;           // 小球是否存活
    public boolean impactWall = false;      // 是否于墙壁相撞
    public boolean impactCircle = false;    // 是否与另一个球相撞

    public boolean candrawline = false;

    public boolean mute = false;


    /**
     * @param frame frame
     * @param posx  小球x坐标
     * @param posy  小球y坐标
     * @param speedx    小球的x速度
     * @param speedy    小球的y速度
     * @param radius    小球的半径
     * @param color     小球的颜色
     */
    public Circle(MainFrame frame, String name, double posx, double posy, double speedx, double speedy, double radius, Color color) { // -------------
        this.name = name;
        this.frame = frame;
        this.posx = posx;
        this.posy = posy;
        this.speedx = speedx;
        this.speedy = speedy;
        maxspeed = Math.sqrt(speedx * speedx + speedy * speedy);
        this.radius = radius;
        this.color = color;
        alive = true;
        mute = false;

        lastCircleImpactTime = System.currentTimeMillis();
        currentCircleImpactTime = -1000;

    } // ---------------------------------------------------------------------------------------------------------------

    public void run() {
        update();
    }

    /**
     * 更新小球的状态
     */
    public void update() { // ------------------------------------------------------------------------------------------
        while(alive){
            try{
                Thread.sleep(2);
                collision();
                if(impactCircle) {

                    currentCircleImpactTime = System.currentTimeMillis();
                    if(currentCircleImpactTime - lastCircleImpactTime > 500){
                        circle();
                        lastCircleImpactTime = currentCircleImpactTime;
                    }
                    impactCircle = false;
                }

                if(impactWall) {
                    wall();
                    impactWall = false;
                }

            } catch (InterruptedException e){
                e.printStackTrace();
            }

            // 其他...

        }
    } // ---------------------------------------------------------------------------------------------------------------

    public void collision() { // --------------------------------------------------------------------------------------

        // 小球碰撞检测
        // circle impact circle -------------------------------------------------------------------
        boolean flag = false;
        for(Circle circle : frame.circles){
            double distance = Math.sqrt(Math.pow(circle.posx + circle.radius - posx - radius, 2)
                    + Math.pow(circle.posy + circle.radius - posy - radius, 2));
            // 质量相同 交换速度
            // System.out.println("Collision detective: " + distance);
            if(circle.equals(this)){
                flag = true;
            }
            if(distance <= circle.radius + radius && flag && !circle.equals(this)){
                // System.out.println("Collision");
                impactCircle = true;
                // 交换速度
                do{
                    circle.posx -= circle.speedx; posx -= speedx;
                    circle.posy -= circle.speedy; posy -= speedy;
                    distance = Math.sqrt(Math.pow(circle.posx + circle.radius - posx - radius, 2)
                            + Math.pow(circle.posy + circle.radius - posy - radius, 2));
                } while(distance < radius + circle.radius);

                double vxa = ((circle.radius - radius) * circle.speedx + 2 * radius * speedx) / (circle.radius + radius);
                double vya = ((circle.radius - radius) * circle.speedy + 2 * radius * speedy) / (circle.radius + radius);

                double vxb = ((radius - circle.radius) * speedx + 2 * circle.radius * circle.speedx) / (circle.radius + radius);
                double vyb = ((radius - circle.radius) * speedy + 2 * circle.radius * circle.speedy) / (circle.radius + radius);

                circle.speedx = vxa; circle.speedy = vya;
                circle.maxspeed = Math.sqrt(vxa * vxa + vya * vya);

                speedx = vxb; speedy = vyb;
                maxspeed = Math.sqrt(vxb * vxb + vyb * vyb);
            }
        }

        // ------------------------------------------------------------------------------------
        if(candrawline){
            double distance = Math.sqrt(Math.pow(posx + radius - clickx, 2)
                    + Math.pow(posy + radius - clicky, 2));
            if(distance < 4){
                ///////////////////////////////////////////////////////////////////// 是否画线
                candrawline = true;
            }
        }

        // 鼠标点击响应
        // mouse clicked  ------------------------------------------------------------------------
        if(mouseclicked) {
            candrawline = true;
            // 计算离鼠标点击距离
            double distance = Math.sqrt(Math.pow(posx + radius - clickx, 2)
                    + Math.pow(posy + radius - clicky, 2));

            double distancex = posx + radius - clickx;
            double distancey = posy + radius - clicky;

            // 重新计算速度
            double x = Math.abs(distancex * maxspeed / (distance));
            double y = Math.abs(distancey * maxspeed / (distance));

            if(distancex > 0){
                x = -x;
            }

            if(distancey > 0){
                y = -y;
            }

            // 改变速度 指向鼠标点击位置
            speedx = x;
            speedy = y;

            mouseclicked = false;
        }

        // 小球撞墙检测
        // circle impact wall ----------------------------------------------------------------------
        if(posx + radius * 2 >= frame.canvas.getWidth()){
            impactWall = true;
            speedx = -speedx;
            posx = frame.canvas.getWidth() - 2 * radius - 1;
        }

        if(posx <= 0){
            impactWall = true;
            speedx = -speedx;
            posx = 1;
        }

        if(posy + radius * 2 >= frame.canvas.getHeight()) {
            impactWall = true;
            speedy = -speedy;
            posy = frame.canvas.getHeight() - 2 * radius - 1;
        }

        if(posy <= 0){
            impactWall = true;
            speedy = -speedy;
            posy = 1;
        }

        // position update ----------------------------------------------------------
        posx += speedx; posy += speedy;

    } // ---------------------------------------------------------------------------------------------------------------


    public void draw(Graphics2D graphics2D){
        super.draw(graphics2D);
        if(candrawline){
            graphics2D.setColor(color);
            graphics2D.drawLine((int)(posx + radius), (int)(posy + radius), clickx, clicky);
        }
        int alpha = transparent ? 64 : 255;
        graphics2D.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha));
        graphics2D.drawLine((int)(posx + radius), (int)(posy + radius),
                (int)(speedx * 10000 + posx + radius), (int)(speedy * 10000 + posy + radius));
    }

    /**
     * 撞墙之后采取的行动
     */
    private void wall() { // -------------------------------------------------------------------------------------------
        if(mute){
            return;
        }

        // 创建一个线程
        Thread t = new Thread(()-> {
            try {

                // file 是你的音频文件路径
                File file = files[Math.abs((new Random()).nextInt()) % files.length];
                // System.out.println(file.getName());
                /// get a file

                AudioInputStream stream;
                AudioFormat format;
                DataLine.Info info;
                Clip clip;

                // get stream of this file
                stream = AudioSystem.getAudioInputStream(file);
                format = stream.getFormat();
                info = new DataLine.Info(Clip.class, format);
                clip = (Clip) AudioSystem.getLine(info);
                clip.open(stream);
                clip.start();


                // 等待播放完成
                Thread.sleep(8000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // 开始线程
        t.start();
    } // ---------------------------------------------------------------------------------------------------------------

    /**
     * 小球相碰采取的行动
     */
    private void circle() { // -----------------------------------------------------------------------------------------

        if(mute){
            return;
        }
        Thread t = new Thread(()-> {
            try {

                File file = files[Math.abs((new Random()).nextInt()) % files.length];
                // System.out.println(file.getName());
                AudioInputStream stream;
                AudioFormat format;
                DataLine.Info info;
                Clip clip;

                stream = AudioSystem.getAudioInputStream(file);
                format = stream.getFormat();
                info = new DataLine.Info(Clip.class, format);
                clip = (Clip) AudioSystem.getLine(info);
                clip.open(stream);
                clip.start();
                // 等待播放完成
                Thread.sleep(8000);
            } catch (Exception e) {

                e.printStackTrace();
            }
        });
        t.start();
    } // ---------------------------------------------------------------------------------------------------------------

}
