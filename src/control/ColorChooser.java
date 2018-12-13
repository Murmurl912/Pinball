package control;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ColorChooser extends Panel {

    public Color currentColor;
    private Color defaultColor;

    public ArrayList<Color> colors;
    public ArrayList<ColorUnit> colorUnits;

    public GridLayout layout;
    public CircleShortcut circleShortcut;

    public ColorChooser(CircleShortcut circleShortcut) {
        this.circleShortcut = circleShortcut;
        colors = new ArrayList<>();
        colorUnits = new ArrayList<>();
        currentColor = defaultColor = Color.BLACK;
        layout = new GridLayout(6, 6, 4, 2);
        setLayout(layout);
        colors();
        units();
        setBackground(Color.LIGHT_GRAY);

    }

    public void colors() {

        colors.add(new Color(0,0,0));
        colors.add(new Color(223, 80, 57));
        colors.add(new Color(196, 32, 104));
        colors.add(new Color(138, 173, 32));
        colors.add(new Color(24, 58, 103));
        colors.add(new Color(30, 118, 185));
        colors.add(new Color(44, 184, 243));
        colors.add(new Color(159, 112, 187));
        colors.add(new Color(249, 156, 61));
        colors.add(new Color(254, 212, 114));
        colors.add(new Color(64, 64, 64));
        colors.add(new Color(130, 130, 130));
        colors.add(new Color(170, 170, 170));
        colors.add(new Color(218, 218, 218));
        colors.add(new Color(255, 255, 255));
        colors.add(new Color(255, 205, 87));
        colors.add(new Color(199, 205, 86));
        colors.add(new Color(104, 178, 210));
        colors.add(new Color(32, 157, 174));
        colors.add(new Color(123, 122, 11));
        colors.add(new Color(235, 212, 104));
        colors.add(new Color(43, 22, 3));
        colors.add(new Color(99, 59, 29));
        colors.add(new Color(184, 131, 84));
        colors.add(new Color(163, 56, 104));
        colors.add(new Color(250, 169, 125));
        colors.add(new Color(253, 232, 197));
        colors.add(new Color(51, 44, 34));
        colors.add(new Color(114, 96, 76));
        colors.add(new Color(95, 62, 96));
        colors.add(new Color(103, 125, 56));
        colors.add(new Color(147, 57, 57));
        colors.add(new Color(49, 75, 86));
        colors.add(new Color(168, 181, 127));
        colors.add(new Color(198, 141, 141));
        colors.add(new Color(99, 143, 158));

    }

    public void units() {
        for(Color color : colors){
            ColorUnit unit = new ColorUnit(color);
            unit.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(unit.shape.contains(e.getPoint())){
                        currentColor = color;
                        circleShortcut.shortcutUnit.color = color;
                        circleShortcut.shortcutUnit.repaint();
                    }
                }
            });
            unit.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if(unit.shape.contains(e.getPoint())){
                        currentColor = color;
                        unit.range = 2;
                        unit.paint(unit.getGraphics());
                        circleShortcut.shortcutUnit.color = color;
                        circleShortcut.shortcutUnit.repaint();
                    }
                }
            });
            unit.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    if(unit.shape.contains(e.getPoint())){
                        currentColor = color;
                        unit.range = 0;
                        unit.paint(unit.getGraphics());
                        circleShortcut.shortcutUnit.color = color;
                        circleShortcut.shortcutUnit.repaint();
                    }
                }
            });
            add(unit);
        }
    }

}

