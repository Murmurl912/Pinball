package main;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;

/**
 *  这是程序入口
 */
public class Main {

    public static File path;
    public static File[] files;

    public static  void main(String[] args) {

        path = new File("res/piano");
        files = path.listFiles();


        MainFrame frame = new MainFrame();
        frame.setSize(1200, 800);
        frame.setTitle("Circle Server");

        Image image = Toolkit.getDefaultToolkit().getImage("res/icon.png");

        frame.setIconImage(image);

        Thread t = new Thread(()-> {
            try {

                File file = files[files.length - 20];
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
                Thread.sleep(500);
                clip.start();
                // 等待播放完成
                Thread.sleep(8000);
            } catch (Exception e) {

                e.printStackTrace();
            }
        });
        t.start();

        frame.setVisible(true);

        Thread canvasThread = new Thread(frame.canvas);
        canvasThread.setPriority(Thread.MAX_PRIORITY);
        frame.canvas.createBufferStrategy(2);
        canvasThread.start();

        Thread statusThread = new Thread(frame.status);
        statusThread.setPriority(Thread.MIN_PRIORITY);
        statusThread.start();


    }

}
