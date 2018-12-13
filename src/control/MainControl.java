package control;

import canvas.Circle;
import main.MainFrame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 控制区
 * 在这里添加控制区的组件
 * 可以是其他类型的组件 不一定要继承Panel
 */

public class MainControl extends ScrollPane {

    public GridBagLayout layout;
    public GridBagConstraints constraints;
    public ColorChooser colorChooser;
    public CircleShortcut circleShortcut;
    public SpeedChooser speedChooser;
    public PositionChooser positionChooser;
    public RadiusChooser radiusChooser;
    public NameEntry nameEntry;

    public CheckboxGroup checkboxGroup;
    public Checkbox addCircleCheckBox;
    public Checkbox editCircleCheckBox;

    public Choice circlesList;

    public Button addOrModifyCircleButton;
    public Button deleteOrResetCircleButton;

    public Panel panel;
    public MainFrame frame;

    public MainControl(MainFrame frame){
        this.frame = frame;
        ui();
        place();
        action();
        circlesList.setBackground(Color.LIGHT_GRAY);
       // dark();
        //light();
    }

    private void ui(){
        layout = new GridBagLayout();
        panel = new Panel();
        panel.setLayout(layout);
        add(panel);

        checkboxGroup = new CheckboxGroup();
        addCircleCheckBox = new Checkbox("Add a circle", checkboxGroup, true);
        editCircleCheckBox = new Checkbox("Edit a circle", checkboxGroup, false);

        circlesList = new Choice();

        circleShortcut = new CircleShortcut();
        colorChooser = new ColorChooser(circleShortcut);
        positionChooser = new PositionChooser();
        speedChooser = new SpeedChooser();
        radiusChooser = new RadiusChooser();
        nameEntry = new NameEntry();

        addOrModifyCircleButton = new Button("Add");
        deleteOrResetCircleButton = new Button("Reset");

    }

    private void place() {

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1; constraints.gridwidth = 3;
        constraints.weightx = 1; constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(4, 4, 0, 0);
        layout.addLayoutComponent(addCircleCheckBox, constraints);
        panel.add(addCircleCheckBox, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridheight = 1; constraints.gridwidth = 3;
        constraints.weightx = 1; constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(4, 4, 0, 4);
        layout.addLayoutComponent(editCircleCheckBox, constraints);
        panel.add(editCircleCheckBox, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridheight = 1; constraints.gridwidth = 6;
        constraints.weightx = 1; constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(4, 4, 4, 4);
        layout.addLayoutComponent(circlesList, constraints);
        panel.add(circlesList, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridheight = 6; constraints.gridwidth = 6;
        constraints.weightx = 1; constraints.weighty = 0.9;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(4, 4, 0, 4);
        layout.addLayoutComponent(circleShortcut, constraints);
        panel.add(circleShortcut, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.gridheight = 6; constraints.gridwidth = 6;
        constraints.weightx = 1; constraints.weighty = 0.9;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(4, 4, 0, 4);
        layout.addLayoutComponent(colorChooser, constraints);
        panel.add(colorChooser, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 14;
        constraints.gridheight = 1; constraints.gridwidth = 6;
        constraints.weightx = 1; constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(4, 4, 0, 4);
        layout.addLayoutComponent(speedChooser, constraints);
        panel.add(speedChooser, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 15;
        constraints.gridheight = 1; constraints.gridwidth = 6;
        constraints.weightx = 1; constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(4, 4, 0, 4);
        layout.addLayoutComponent(positionChooser, constraints);
        panel.add(positionChooser, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 16;
        constraints.gridheight = 1; constraints.gridwidth = 6;
        constraints.weightx = 1; constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(4, 4, 4, 4);
        layout.addLayoutComponent(radiusChooser, constraints);
        panel.add(radiusChooser, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 17;
        constraints.gridheight = 1; constraints.gridwidth = 6;
        constraints.weightx = 1; constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(4, 4, 4, 4);
        layout.addLayoutComponent(nameEntry, constraints);
        panel.add(nameEntry, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 18;
        constraints.gridheight = 1; constraints.gridwidth = 2;
        constraints.weightx = 1; constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(4, 4, 4, 4);
        layout.addLayoutComponent(addOrModifyCircleButton, constraints);
        panel.add(addOrModifyCircleButton, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 5;
        constraints.gridy = 18;
        constraints.gridheight = 1; constraints.gridwidth = 6;
        constraints.weightx = 1; constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(4, 4, 4, 4);
        layout.addLayoutComponent(deleteOrResetCircleButton, constraints);
        panel.add(deleteOrResetCircleButton, constraints);
    }

    private void action(){

        addCircleCheckBox.addItemListener((e)->{
            circlesList.setEnabled(false);
            addOrModifyCircleButton.setLabel("Add");
            deleteOrResetCircleButton.setLabel("Reset");
        });

        editCircleCheckBox.addItemListener((e)->{
            circlesList.setEnabled(true);
            circlesList.removeAll();
            for(Circle circle : frame.circles){
                circlesList.add(circle.name);
            }
            addOrModifyCircleButton.setLabel("Modify");
            deleteOrResetCircleButton.setLabel("Delete");
            displayShortcut();
        });

        circlesList.addItemListener((e)->{
            displayShortcut();
        });

        addOrModifyCircleButton.addActionListener((e)->{

            if(checkboxGroup.getSelectedCheckbox().equals(addCircleCheckBox)){
                // add circle action
                addcircle();
            } else {
                modifycircle();
                // modify circle action
            }

        });

        deleteOrResetCircleButton.addActionListener((e)->{

            if(checkboxGroup.getSelectedCheckbox().equals(addCircleCheckBox)){
                // reset the default
                resetpanel();
            } else {
                // delete action
                deletecircle();
            }
        });

        speedChooser.speedxScrollBar.addAdjustmentListener((e)->{
            circleShortcut.speedxValue.setText(e.getValue() + "");
        });

        speedChooser.speedyScrollBar.addAdjustmentListener((e)->{
            circleShortcut.speedyValue.setText(e.getValue() + "");
        });

        positionChooser.positionxScrollBar.addAdjustmentListener((e)->{
            circleShortcut.positionxValue.setText(e.getValue() + "");
        });

        positionChooser.positionyScrollBar.addAdjustmentListener((e)->{
            circleShortcut.positionyValue.setText(e.getValue() + "");
        });

        radiusChooser.radiusScrollBar.addAdjustmentListener((e)->{
            circleShortcut.radiusValue.setText(e.getValue() + "");
            circleShortcut.shortcutUnit.radius = e.getValue();
            circleShortcut.shortcutUnit.repaint();
        });

    }

    private void addcircle() {

        String name = nameEntry.nameEntry.getText();
        // System.out.println(name);
        if(name == null){
            errorDialog("Name cannot be empty!");
            return;
        }

        char[] chars = name.toCharArray();
        name = "";
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '\t' || chars[i] == '\n' || chars[i] == ' ' || chars[i] == '\r'){
                continue;
            }
            name += chars[i];
        }

        if("".equals(name)){
            errorDialog("Name cannot be empty!");
            return;
        } else {
            for(Circle circle : frame.circles){
                if(circle.name.equals(name)){
                    errorDialog("Name must be unique!");
                    return;
                }
            }
        }
        int posx = positionChooser.positionx;
        int posy = positionChooser.positiony;
        int speedx = speedChooser.speedx;
        int speedy = speedChooser.speedy;
        int radius = radiusChooser.radius;
        Color color = colorChooser.currentColor;
        Circle circle = new Circle(frame, name, posx, posy, speedx / 200.0, speedy / 200.0, radius, color);
        circle.maxspeed = Math.sqrt(speedx * speedx  + speedy * speedy) / 200.0;
        circlesList.add(name);
        circlesList.select(name);
        displayShortcut();

        circle.transparent = frame.canvas.transparent;
        frame.circles.add(circle);
        Thread thread = new Thread(circle);
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }

    private void deletecircle() {

        String name = circlesList.getSelectedItem();
        if(name == null || "".equals(name)){
            errorDialog("You must selected a circle");
            return;
        }
        boolean flag = true;
        for(Circle circle : frame.circles){
            if(circle.name.equals(name)){
                flag = false;
                deleteConfirm(circle);
            }
        }
        if(flag){
            errorDialog("No such circle named + " + name + "!");
        }
    }

    private void resetpanel() {

        circleShortcut.shortcutUnit.radius = 10;
        circleShortcut.shortcutUnit.color = Color.BLACK;
        circleShortcut.shortcutUnit.repaint();
        circleShortcut.positionxValue.setText("");
        circleShortcut.positionyValue.setText("");
        circleShortcut.speedxValue.setText("");
        circleShortcut.speedyValue.setText("");
        circleShortcut.radiusValue.setText("");

        colorChooser.currentColor = Color.BLACK;

        positionChooser.positionxScrollBar.setValue(positionChooser.positionxScrollBar.getMinimum());
        positionChooser.positionxValue.setText(positionChooser.positionxScrollBar.getMinimum() + "");
        positionChooser.positionx = positionChooser.positionxScrollBar.getMaximum();

        positionChooser.positionyScrollBar.setValue(positionChooser.positionyScrollBar.getMinimum());
        positionChooser.positionyValue.setText(positionChooser.positionyScrollBar.getMinimum() + "");
        positionChooser.positiony = positionChooser.positionyScrollBar.getMinimum();

        speedChooser.speedxScrollBar.setValue(0);
        speedChooser.speedxValue.setText("0");
        speedChooser.speedx = 0;

        speedChooser.speedyScrollBar.setValue(0);
        speedChooser.speedyValue.setText("0");
        speedChooser.speedy = 0;

        radiusChooser.radiusScrollBar.setValue(radiusChooser.radiusScrollBar.getMinimum());
        radiusChooser.radiusValue.setText(radiusChooser.radiusScrollBar.getMinimum() + "");
        radiusChooser.radius = radiusChooser.radiusScrollBar.getMinimum();

        nameEntry.nameEntry.setText("");

    }

    private void modifycircle() {

        String oldname = circlesList.getSelectedItem();
        if(oldname == null || "".equals(oldname)){
            errorDialog("The modify circle not found!");
            return;
        }
        String name = nameEntry.nameEntry.getText();
        char[] chars = name.toCharArray();
        name = "";
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '\t' || chars[i] == '\n' || chars[i] == ' ' || chars[i] == '\r'){
                continue;
            }
            name += chars[i];
        }

        if("".equals(name) || name == null){
            errorDialog("New name must not be empty!");
            return;
        }
        Circle c = null;
        for(Circle circle : frame.circles){
            if(circle.name.equals(name) && ! circle.name.equals(oldname)){
                errorDialog("New name must be unique!");
                return;
            }
            if(circle.name.equals(oldname)){
                c = circle;
            }
        }

        if(c == null){
            errorDialog("The modify circle not found!");
            return;
        }


        modifyConfirm(c);
    }

    private void errorDialog(String message) {
        GridBagLayout layout = new GridBagLayout();
        Dialog dialog = new Dialog(frame);
        dialog.setLayout(layout);
        dialog.setLocationRelativeTo(frame);
        dialog.setTitle("Error");

        Button buttonOk = new Button("Ok");
        buttonOk.addActionListener((e)->{
            frame.setEnabled(true);
            dialog.dispose();
        });
        Label  labelMessage = new Label(message);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 1; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(10, 10, 10, 10);
        layout.addLayoutComponent(labelMessage, constraints);
        dialog.add(labelMessage, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 1; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);
        layout.addLayoutComponent(buttonOk, constraints);
        dialog.add(buttonOk, constraints);

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setEnabled(true);
                dialog.dispose();
            }
        });
        dialog.setSize(new Dimension(300, 200));
        dialog.setVisible(true);
        frame.setEnabled(false);
    }

    private void deleteConfirm(Circle circle) {

        GridBagLayout layout = new GridBagLayout();
        Dialog dialog = new Dialog(frame);
        dialog.setLayout(layout);
        dialog.setLocationRelativeTo(frame);
        dialog.setTitle("Delete Confirm");

        Button buttonDelete = new Button("Delete");
        buttonDelete.addActionListener((e)->{
            frame.setEnabled(true);
            // action
            frame.circles.remove(circle);
            circle.alive = false;
            circlesList.removeAll();
            for(Circle c : frame.circles){
                circlesList.add(c.name);
            }
            displayShortcut();
            dialog.dispose();
        });
        Button buttonCancel = new Button("Cancel");
        buttonCancel.addActionListener((e)->{
            frame.setEnabled(true);
            dialog.dispose();
        });
        Label  labelMessage = new Label("Are you sure?");

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 1; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(10, 10, 10, 10);
        layout.addLayoutComponent(labelMessage, constraints);
        dialog.add(labelMessage, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 1; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);
        layout.addLayoutComponent(buttonDelete, constraints);
        dialog.add(buttonDelete, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 1; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);
        layout.addLayoutComponent(buttonCancel, constraints);
        dialog.add(buttonCancel, constraints);

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setEnabled(true);
                dialog.dispose();
            }
        });
        dialog.setSize(new Dimension(300, 200));
        dialog.setVisible(true);
        frame.setEnabled(false);

    }

    private void modifyConfirm(Circle circle){
        GridBagLayout layout = new GridBagLayout();
        Dialog dialog = new Dialog(frame);
        dialog.setLayout(layout);
        dialog.setLocationRelativeTo(frame);
        dialog.setTitle("Modify Confirm");

        Button buttonModify = new Button("Modify");
        buttonModify.addActionListener((e)->{
            frame.setEnabled(true);
            // action
            String oldname = circlesList.getSelectedItem();
            String name = nameEntry.nameEntry.getText();
            int posx = positionChooser.positionx;
            int posy = positionChooser.positiony;
            int speedx = speedChooser.speedx;
            int speedy = speedChooser.speedy;
            int radius = radiusChooser.radius;
            Color color = colorChooser.currentColor;

            circle.name = name;
            circle.posx = posx;
            circle.posy = posy;
            circle.speedx = speedx / 200.0;
            circle.speedy = speedy / 200.0;
            circle.maxspeed = Math.sqrt(speedx * speedx + speedy * speedy) / 200.0;
            circle.radius = radius;
            circle.color = color;
            circlesList.remove(oldname);
            circlesList.add(name);
            displayShortcut();

            dialog.dispose();
        });
        Button buttonCancel = new Button("Cancel");
        buttonCancel.addActionListener((e)->{
            frame.setEnabled(true);
            dialog.dispose();
        });
        Label  labelMessage = new Label("Are you sure?");

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 1; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(10, 10, 10, 10);
        layout.addLayoutComponent(labelMessage, constraints);
        dialog.add(labelMessage, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 1; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);
        layout.addLayoutComponent(buttonModify, constraints);
        dialog.add(buttonModify, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 1; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);
        layout.addLayoutComponent(buttonCancel, constraints);
        dialog.add(buttonCancel, constraints);

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setEnabled(true);
                dialog.dispose();
            }
        });

        dialog.setSize(new Dimension(300, 200));
        dialog.setVisible(true);
        frame.setEnabled(false);

    }

    public void displayShortcut() {

        String name = circlesList.getSelectedItem();
        if(name == null){
            return;
        }
        for(Circle circle : frame.circles){
            if(circle.name.equals(name)){
                circleShortcut.speedxValue.setText((int)(200*circle.speedx) + "");
                circleShortcut.speedyValue.setText((int)(200*circle.speedy) + "");
                circleShortcut.positionxValue.setText((int)(circle.posx) + "");
                circleShortcut.positionyValue.setText((int)(circle.posy) + "");
                circleShortcut.radiusValue.setText((int)(circle.radius) + "");
                circleShortcut.shortcutUnit.radius = circle.radius;
                circleShortcut.shortcutUnit.color = circle.color;
                circleShortcut.shortcutUnit.repaint();

                positionChooser.positionxValue.setText(((int)circle.posx) + "");
                positionChooser.positionx = (int)circle.posx;
                positionChooser.positionxScrollBar.setValue((int)circle.posx);
                positionChooser.positionyValue.setText(((int)circle.posy) + "");
                positionChooser.positiony = (int)circle.posy;
                positionChooser.positionyScrollBar.setValue((int)circle.posy);

                speedChooser.speedxValue.setText((int)(circle.speedx * 200) + "");
                speedChooser.speedx = (int)(circle.speedx * 200);
                speedChooser.speedxScrollBar.setValue((int)(circle.speedx * 200));
                speedChooser.speedyValue.setText(((int)(circle.speedy * 200)) + "");
                speedChooser.speedy = (int)(circle.speedy * 200);
                speedChooser.speedyScrollBar.setValue((int)(circle.speedy * 200));

                radiusChooser.radiusValue.setText(((int)circle.radius) + "");
                radiusChooser.radiusScrollBar.setValue((int)circle.radius);
                radiusChooser.radius = (int)circle.radius;


                nameEntry.nameEntry.setText(circle.name);

                break;
            }
        }
    }

    public void dark() {

        panel.setBackground(Color.BLACK);

        addCircleCheckBox.setBackground(Color.BLACK);
        addCircleCheckBox.setForeground(Color.LIGHT_GRAY);
        editCircleCheckBox.setBackground(Color.BLACK);
        editCircleCheckBox.setForeground(Color.LIGHT_GRAY);

        addOrModifyCircleButton.setBackground(Color.LIGHT_GRAY);
        deleteOrResetCircleButton.setBackground(Color.LIGHT_GRAY);

        setBackground(Color.BLACK);
    }

    public void light() {

        panel.setBackground(Color.WHITE);

        addCircleCheckBox.setBackground(Color.WHITE);
        addCircleCheckBox.setForeground(Color.BLACK);
        editCircleCheckBox.setBackground(Color.WHITE);
        editCircleCheckBox.setForeground(Color.BLACK);

        addOrModifyCircleButton.setBackground(Color.WHITE);
        deleteOrResetCircleButton.setBackground(Color.WHITE);

        setBackground(Color.WHITE);
    }

}

//
//class control {
//    public static void main(String[] args) {
//        Frame frame = new Frame();
//        frame.add(new MainControl());
//        frame.pack();
//        frame.setVisible(true);
//    }
//}