package canvas;

import main.MainFrame;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Iterator;
/*
 * 主绘图面板
 * 用来绘制各种图形
 *
 */

public class MainCanvas extends Canvas implements Runnable {

    public Image darkImage; private Image darkScaled;

    public Image lightImage;    private Image lightScaled;
    public boolean darkMode;

    // public ArrayBlockingQueue<Circle> circles;
    public MainFrame frame;
    public PopupMenu popupMenu;
    public MenuItem pauseItem; // 暂停
    public MenuItem resumeItem; // 恢复
    public MenuItem restartItem; // 重新开始
    public CheckboxMenuItem muteItem;
    public CheckboxMenuItem transparentMode;


    // 鼠标点击位置 ------------------------------------------------------------------------------------------------------
    protected Point clickedpos;
    protected Color mousecolor;
    protected double radius;

    public boolean transparent = false;



    public MainCanvas(MainFrame frame) {
        this.frame = frame;
        clickedpos = new Point(-100, -100);
        mousecolor = Color.ORANGE;
        radius = 5;
        popupmenu();
        listener();
        lightImage = Toolkit.getDefaultToolkit().getImage("res/night.jpg");
        darkImage = Toolkit.getDefaultToolkit().getImage("res/image.png");

    }

    public void popupmenu() {
        popupMenu = new PopupMenu();
        pauseItem = new MenuItem("Pause"); // 暂停
        resumeItem = new MenuItem("Resume"); // 恢复
        resumeItem.setEnabled(false);
        restartItem = new MenuItem("Restart"); // 清屏
        muteItem = new CheckboxMenuItem("Mute", false);
        transparentMode = new CheckboxMenuItem("Transparent Mode");

        popupMenu.add(pauseItem);
        popupMenu.add(resumeItem);
        popupMenu.add(restartItem);
        popupMenu.addSeparator();
        popupMenu.add(muteItem);
        popupMenu.add(transparentMode);
        add(popupMenu);

        pauseItem.addActionListener((e)->{
            pause();
            resumeItem.setEnabled(true);
            pauseItem.setEnabled(false);
        });

        restartItem.addActionListener((e)->{
            restart();
            pauseItem.setEnabled(true);
            resumeItem.setEnabled(false);
        });

        resumeItem.addActionListener((e)->{
            resume();
            pauseItem.setEnabled(true);
            resumeItem.setEnabled(false);
        });

        muteItem.addItemListener((e)->{
            if(e.getStateChange() == ItemEvent.SELECTED){
                mute();
            } else {
                sound();
            }
        });

        transparentMode.addItemListener((e)->{
            if(e.getStateChange() == ItemEvent.SELECTED){
                transparent();
                transparent = true;
            } else {
                normal();
                transparent = false;
            }
        });
    }

    public void pause() {

        for(Circle circle : frame.circles){
            circle.alive = false;
            circle.transparent = transparent;
        }
    }

    public void resume() {
        for(Circle circle : frame.circles){
            circle.alive = true;
            circle.transparent = transparent;
            Thread t = new Thread(circle);
            t.setPriority(Thread.MAX_PRIORITY);
            t.start();
        }
    }

    public void restart() {
        Iterator<Circle> iterator = frame.circles.iterator();
        while(iterator.hasNext()){
            iterator.next().alive = false;
            iterator.remove();
        }
    }

    public void mute() {
        for(Circle circle : frame.circles){
            circle.mute = true;
        }
    }

    public void sound() {
        for(Circle circle : frame.circles){
            circle.mute = false;
        }
    }

    public void normal() {
        for(Circle circle : frame.circles){
            circle.transparent = false;
        }
    }

    public void transparent() {
        for(Circle circle : frame.circles){
            circle.transparent = true;
        }
    }

    // 绘制线程
    public void run(){

        while(true){
            // System.out.println("MainCanvas: repaint()");
            repaint();
        }
    }

    // 重写的方法 --------------------------------------------------------------------------------------------------------
    @Override
    public void repaint() {
        Graphics g = this.getGraphics();
        update(g);
    }

    // 重写的方法 --------------------------------------------------------------------------------------------------------
    @Override
    public void update(Graphics g) {
        draw(g); // 不用paint(g) 用自己写的draw(g)
    }

    // 重写的方法 --------------------------------------------------------------------------------------------------------
    @Override
    public void paint(Graphics g){

        g.clearRect(0, 0, getWidth(), getHeight()); // 清空画板

        if(darkMode && darkScaled != null){
            g.drawImage(darkScaled, 0, 0, this);
        } else if (!darkMode && lightScaled != null){
            g.drawImage(lightScaled, 0, 0, this);
        }

        Graphics2D graphics2D = (Graphics2D)g;

        // 绘制鼠标点击位置
        Shape mouse = new Ellipse2D.Double(
                clickedpos.getX() - radius,
                clickedpos.getY() - radius,
                radius * 2, radius * 2);

        graphics2D.setColor(mousecolor);
        graphics2D.fill(mouse);


        if(frame.circles == null){
            return;
        }
        // 绘制小球
        for(Circle o : frame.circles) {
            o.draw((Graphics2D)g);
        }

    }

    // 采用双缓冲区的绘制方法 在update中 调用
    private void draw(Graphics g) {

        Graphics2D graphics2D = null;
        BufferStrategy bs = getBufferStrategy();

        do {
            try{
                if(bs == null){
                    return;
                }
                graphics2D = (Graphics2D) bs.getDrawGraphics();

                // drawWhatEver(g2); 你自己的绘制

                graphics2D.clearRect(0, 0, getWidth(), getHeight()); // 清空画布

                // do the image draw // 绘制背景图形
                if(darkMode && darkScaled != null){

                    graphics2D.drawImage(darkScaled, 0, 0, this);
                }  else if (!darkMode && lightScaled != null){
                    graphics2D.drawImage(lightScaled, 0, 0, this);
                }

                // 绘制鼠标点
                // do the drawing jobs ---------------------------------------------------
                // call each item's paint() method
                Shape mouse = new Ellipse2D.Double(
                        clickedpos.getX() - radius, clickedpos.getY() - radius,
                        radius * 2, radius * 2);
                graphics2D.setColor(mousecolor);
                graphics2D.fill(mouse);

                // 绘制小球
                if(frame.circles != null){
                    for(Circle o : frame.circles) {
                        o.draw(graphics2D);
                    }
                }

                //------------------------------------------------------------------------

            } finally {
                if(graphics2D != null){
                    graphics2D.dispose();
                }
            }
            bs.show();
        } while (bs.contentsLost());

    }

    // 鼠标点击事件监听
    private void listener() {
        MainCanvas canvas = this;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(e.isPopupTrigger()){
                    popupMenu.show(canvas, e.getX(), e.getY());
                } else {
                    clickedpos = e.getPoint();
                    // System.out.println("Clicked: " + clickedpos);
                    // repaint();
                    if(frame.circles == null){
                       return;
                    }
                    for(Circle o : frame.circles) {
                        o.mouseclicked = true;
                        o.clickx = clickedpos.x;
                        o.clicky = clickedpos.y;
                    }
                }
            }
        });

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {

                darkScaled = darkImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
                lightScaled = lightImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);

            }
        });
    }

}
