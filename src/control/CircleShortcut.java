package control;

import java.awt.*;

public class CircleShortcut extends Panel {

    public ShortcutUnit shortcutUnit;

    public Label speedLabel;
    public Label speedxValue;
    public Label speedyValue;

    public Label positionLabel;
    public Label positionxValue;
    public Label positionyValue;

    public Label radiusLabel;
    public Label radiusValue;

    public Color color;

    public GridBagLayout layout;
    public GridBagConstraints constraints;

    public CircleShortcut() {
        layout = new GridBagLayout();
        color = Color.BLACK;
        setBackground(Color.LIGHT_GRAY);

        ui();
        place();
    }

    private void ui() {

        setLayout(layout);
        shortcutUnit = new ShortcutUnit(color);

        positionLabel = new Label("Position: ");
        positionxValue = new Label("");
        positionyValue = new Label("");

        speedLabel = new Label("Speed: ");
        speedxValue = new Label("");
        speedyValue = new Label("");

        radiusLabel = new Label("Radius: ");
        radiusValue = new Label("");

    }

    private void place() {

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 3; constraints.gridwidth = 3;
        constraints.weightx = 1; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        layout.addLayoutComponent(shortcutUnit, constraints);
        add(shortcutUnit, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 1; constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        layout.addLayoutComponent(positionLabel, constraints);
        add(positionLabel, constraints);


        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 1; constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        layout.addLayoutComponent(positionxValue, constraints);
        add(positionxValue, constraints);


        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 1; constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        layout.addLayoutComponent(positionyValue, constraints);
        add(positionyValue, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 1; constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        layout.addLayoutComponent(speedLabel, constraints);
        add(speedLabel, constraints);


        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 1; constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        layout.addLayoutComponent(speedxValue, constraints);
        add(speedxValue, constraints);


        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 4;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 1; constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        layout.addLayoutComponent(speedyValue, constraints);
        add(speedyValue, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 1; constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        layout.addLayoutComponent(radiusLabel, constraints);
        add(radiusLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridheight = 1; constraints.gridwidth = 2;
        constraints.weightx = 1; constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        layout.addLayoutComponent(radiusValue, constraints);
        add(radiusValue, constraints);


    }

}

//
//class circle {
//    public static void main(String[] args) {
//        Frame frame = new Frame();
//        frame.add(new CircleShortcut());
//        frame.setVisible(true);
//    }
//}