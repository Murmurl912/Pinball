package status;

import control.ShortcutUnit;
import canvas.Circle;
import java.awt.*;

public class StatusUnit extends Panel {

    public Image offscreen;
    public Color color;
    public GridBagConstraints constraints;
    public GridBagLayout layout;

    public ShortcutUnit shortcutUnit;
    public Label nameLabel;
    public Label nameValue;
    public Label positionLabel;
    public Label positionValue;
    public Label speedLabel;
    public Label speedValue;
    public DestroyButton destroyButton;
    public Circle circle;

    public StatusUnit(){
        ui();
        place();
    }

    private void ui() {
        layout = new GridBagLayout();
        setLayout(layout);
        shortcutUnit = new ShortcutUnit(Color.BLACK);
        nameLabel = new Label("Name: ");
        nameValue = new Label("orange");
        positionLabel = new Label("Position: ");
        positionValue = new Label("[0, 0]");
        speedLabel = new Label("Speed: ");
        speedValue = new Label("[0, 0]");
        destroyButton = new DestroyButton(Color.RED);
    }

    private void place() {

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 0.5; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        layout.addLayoutComponent(shortcutUnit, constraints);
        add(shortcutUnit, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 0.5; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        layout.addLayoutComponent(nameLabel, constraints);
        add(nameLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 0.5; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        layout.addLayoutComponent(nameValue, constraints);
        add(nameValue, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 0.5; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        layout.addLayoutComponent(speedLabel, constraints);
        add(speedLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 4;
        constraints.gridy = 0;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 0.5; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        layout.addLayoutComponent(speedValue, constraints);
        add(speedValue, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 5;
        constraints.gridy = 0;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 0.5; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        layout.addLayoutComponent(positionLabel, constraints);
        add(positionLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 6;
        constraints.gridy = 0;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 0.5; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        layout.addLayoutComponent(positionValue, constraints);
        add(positionValue, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 7;
        constraints.gridy = 0;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 0.5; constraints.weighty = 1;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.fill = GridBagConstraints.BOTH;
        layout.addLayoutComponent(destroyButton, constraints);
        add(destroyButton, constraints);

    }

    public void invalidate() {
        super.invalidate();
        offscreen = null;
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void paint(Graphics g) {
        // setBackground(color);
        shortcutUnit.color = color;
        g.setColor(color);
        if(offscreen == null) {
            offscreen = createImage(getSize().width, getSize().height);
        }
        Graphics og = offscreen.getGraphics();
        og.setColor(color);
        og.setClip(0,0,getSize().width, getSize().height);
        super.paint(og);
        shortcutUnit.repaint();
        g.drawImage(offscreen, 0, 0, null);
        og.dispose();
    }

}


//class unit {
//    public static void main(String[] args){
//        Frame frame = new Frame();
//        GridLayout layout = new GridLayout(15, 2, 0, 0);
//        frame.setLayout(layout);
//        StatusUnit unit = new StatusUnit();
//        unit.setBackground(Color.ORANGE);
//        frame.add(unit);
//
//        unit = new StatusUnit();
//        unit.setBackground(Color.YELLOW);
//        frame.add(unit);
//
//        unit = new StatusUnit();
//        unit.setBackground(Color.PINK);
//        frame.add(unit);
//
//        unit = new StatusUnit();
//        unit.setBackground(Color.RED);
//        frame.add(unit);
//
//        unit = new StatusUnit();
//        unit.setBackground(Color.ORANGE);
//        frame.add(unit);
//        unit.setVisible(false);
//
//        unit = new StatusUnit();
//        unit.setBackground(Color.GREEN);
//        frame.add(unit);
//
//        frame.pack();
//        frame.setVisible(true);
//    }
//}