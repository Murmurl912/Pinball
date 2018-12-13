package control;

import java.awt.*;

public class RadiusChooser extends Panel {

    public int radius = 10;
    public Scrollbar radiusScrollBar;

    public Label radiusLabel;
    public Label radiusValue;

    public GridBagLayout layout;
    public GridBagConstraints constraints;

    public RadiusChooser() {
        ui();
        action();
    }

    private void ui(){

        layout = new GridBagLayout();setLayout(layout);
        radiusLabel = new Label("Radius");
        radiusValue = new Label("10");

        radiusScrollBar = new Scrollbar();radiusScrollBar.setOrientation(Scrollbar.HORIZONTAL);
        radiusScrollBar.setValues(10, 10, 10, 100 + 10);


        place();
        setBackground(Color.LIGHT_GRAY);

    }

    public void place() {

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 0; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(2, 2, 0, 0);
        layout.addLayoutComponent(radiusLabel, constraints);
        add(radiusLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 0; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(2, 2, 0, 0);
        layout.addLayoutComponent(radiusValue, constraints);
        add(radiusValue, constraints);


        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridheight = 1; constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.weightx = 1; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(2, 2, 2, 2);
        layout.addLayoutComponent(radiusScrollBar, constraints);
        add(radiusScrollBar, constraints);

    }

    public void action() {
        radiusScrollBar.addAdjustmentListener(e->{
            radiusValue.setText(radiusScrollBar.getValue() + " ");
            radius = radiusScrollBar.getValue();
        });
    }

}
