package control;

import java.awt.*;

public class SpeedChooser extends Panel {

    public int speedx;
    public int speedy;

    public Scrollbar speedxScrollBar;
    public Scrollbar speedyScrollBar;

    public Label speedxLabel;
    public Label speedyLabel;
    public Label speedxValue;
    public Label speedyValue;

    public GridBagLayout layout;
    public GridBagConstraints constraints;

    public SpeedChooser() {
        ui();
        action();
    }

    private void ui(){

        layout = new GridBagLayout();setLayout(layout);
        speedxLabel = new Label("Speed X");
        speedyLabel = new Label("Speed Y");

        speedxValue = new Label("0");
        speedyValue = new Label("0");

        speedxScrollBar = new Scrollbar();speedxScrollBar.setOrientation(Scrollbar.HORIZONTAL);
        speedyScrollBar = new Scrollbar();speedyScrollBar.setOrientation(Scrollbar.HORIZONTAL);

        speedxScrollBar.setValue(0);
        speedxScrollBar.setBlockIncrement(1);
        speedxScrollBar.setUnitIncrement(1);
        speedxScrollBar.setValues(0, 1, -100, 100 + 1);
        // speedxScrollBar.setUnitIncrement(1);
        // speedxScrollBar.setBlockIncrement(1);

        speedyScrollBar.setMinimum(0);
        speedyScrollBar.setMaximum(100);
        speedyScrollBar.setBlockIncrement(1);
        speedyScrollBar.setUnitIncrement(1);
        speedyScrollBar.setValue(0);
        speedyScrollBar.setValues(0, 1, -100, 100 + 1);

        // speedyScrollBar.setBlockIncrement(1);
        // speedyScrollBar.setUnitIncrement(1);

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
        layout.addLayoutComponent(speedxLabel, constraints);
        add(speedxLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 0; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(2, 2, 0, 0);
        layout.addLayoutComponent(speedxValue, constraints);
        add(speedxValue, constraints);


        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridheight = 1; constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.weightx = 1; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(2, 2, 0, 2);
        layout.addLayoutComponent(speedxScrollBar, constraints);
        add(speedxScrollBar, constraints);


        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 0; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(2, 2, 0, 0);
        layout.addLayoutComponent(speedyLabel, constraints);
        add(speedyLabel, constraints);


        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 0; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(2, 2, 0, 0);
        layout.addLayoutComponent(speedyValue, constraints);
        add(speedyValue, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridheight = 1; constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.weightx = 1; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(2, 2, 2, 2);
        layout.addLayoutComponent(speedyScrollBar, constraints);
        add(speedyScrollBar, constraints);
    }

    public void action() {
        speedxScrollBar.addAdjustmentListener(e->{
            speedxValue.setText(speedxScrollBar.getValue() + " ");
            speedx = speedxScrollBar.getValue();
        });
        speedyScrollBar.addAdjustmentListener(e->{
            speedyValue.setText(speedyScrollBar.getValue() + " ");
            speedy = speedyScrollBar.getValue();
        });
    }
}
