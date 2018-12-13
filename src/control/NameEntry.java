package control;

import java.awt.*;

public class NameEntry extends Panel {
    public Label nameLabel;
    public TextField nameEntry;

    public GridBagLayout layout;
    public GridBagConstraints constraints;

    public NameEntry() {
        ui();
    }

    private void ui() {
        nameLabel = new Label("Name");
        nameEntry = new TextField();
        layout = new GridBagLayout();
        setLayout(layout);
        place();
        setBackground(Color.LIGHT_GRAY);

    }

    private void place() {

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 0; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(2, 2, 0, 0);
        layout.addLayoutComponent(nameLabel, constraints);
        add(nameLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 1; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(2, 2, 2, 2);
        layout.addLayoutComponent(nameEntry, constraints);
        add(nameEntry, constraints);

    }
}
