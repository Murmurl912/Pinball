package control;

import java.awt.*;

public class PositionChooser extends Panel {

    public int positionx;
    public int positiony;

    public Scrollbar positionxScrollBar;
    public Scrollbar positionyScrollBar;

    public Label positionxLabel;
    public Label positionyLabel;
    public Label positionxValue;
    public Label positionyValue;

    public GridBagLayout layout;
    public GridBagConstraints constraints;

    public PositionChooser() {
        ui();
        action();
    }
    private void ui(){

        layout = new GridBagLayout();setLayout(layout);
        positionxLabel = new Label("Position X");
        positionyLabel = new Label("Position Y");

        positionxValue = new Label("0");
        positionyValue = new Label("0");

        positionxScrollBar = new Scrollbar();positionxScrollBar.setOrientation(Scrollbar.HORIZONTAL);
        positionyScrollBar = new Scrollbar();positionyScrollBar.setOrientation(Scrollbar.HORIZONTAL);

        positionxScrollBar.setValue(0);
        positionxScrollBar.setMinimum(0);
        positionxScrollBar.setMaximum(100);
        positionxScrollBar.setUnitIncrement(1);
        positionxScrollBar.setBlockIncrement(1);

        positionyScrollBar.setValue(0);
        positionyScrollBar.setMinimum(0);
        positionyScrollBar.setMaximum(100);

        positionyScrollBar.setBlockIncrement(1);
        positionyScrollBar.setUnitIncrement(1);

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
        layout.addLayoutComponent(positionxLabel, constraints);
        add(positionxLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 0; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(2, 2, 0, 0);
        layout.addLayoutComponent(positionxValue, constraints);
        add(positionxValue, constraints);


        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridheight = 1; constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.weightx = 1; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(2, 2, 0, 2);
        layout.addLayoutComponent(positionxScrollBar, constraints);
        add(positionxScrollBar, constraints);


        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 0; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(2, 2, 0, 0);
        layout.addLayoutComponent(positionyLabel, constraints);
        add(positionyLabel, constraints);


        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 0; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(2, 2, 0, 0);
        layout.addLayoutComponent(positionyValue, constraints);
        add(positionyValue, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridheight = 1; constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.weightx = 1; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(2, 2, 2, 2);
        layout.addLayoutComponent(positionyScrollBar, constraints);
        add(positionyScrollBar, constraints);
    }

    public void action() {
        positionxScrollBar.addAdjustmentListener(e->{
            positionxValue.setText(positionxScrollBar.getValue() + " ");
            positionx = positionxScrollBar.getValue();
        });
        positionyScrollBar.addAdjustmentListener(e->{
            positionyValue.setText(positionyScrollBar.getValue() + " ");
            positiony = positionyScrollBar.getValue();
        });
    }

}

