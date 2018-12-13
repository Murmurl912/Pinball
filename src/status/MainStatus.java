package status;

import canvas.Circle;
import main.MainFrame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 状态区 在这里添加状态区的布局
 * 和组件
 * 可以是其他类型的组件 不一定要继承Panel
 */
public class MainStatus extends ScrollPane implements Runnable {

    public MainFrame frame;
    public Panel panel;
    public GridLayout layout;
    public ArrayList<StatusUnit> units;

    public MainStatus(MainFrame frame) {
        this.frame = frame;
        units = new ArrayList<>();
        ui();
        place();
        // dark mode
    }

    private void ui() {
        layout = new GridLayout(100, 2, 0, 0);
        panel = new Panel();
        add(panel);
        panel.setLayout(layout);
    }

    private void place(){
        units();
    }

    private void units() {
        for(int i = 0; i < 100; i++){
            StatusUnit unit = new StatusUnit();
            // unit.setVisible(false);
            unit.destroyButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(unit.isVisible() && unit.circle != null){
                        deleteConfirm(unit.circle);
                    }
                }
            });
            units.add(unit);
            panel.add(unit);
        }
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

            frame.control.circlesList.removeAll();
            for(Circle c : frame.circles){
                frame.control.circlesList.add(c.name);
            }
            frame.control.displayShortcut();
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

    public void status() {

        Iterator<Circle> circleIterator = frame.circles.iterator();
        Iterator<StatusUnit> unitIterator = units.iterator();
        while(circleIterator.hasNext() && unitIterator.hasNext()){
            Circle c = circleIterator.next();
            StatusUnit s = unitIterator.next();

            s.circle = c;
            s.nameValue.setText(c.name);
            s.positionValue.setText("[" + (int)c.posx + ", " + (int)c.posy + "]");
            s.speedValue.setText("[" + (int)(200*c.speedx) + ", " + (int)(200*c.speedy) + "]");

            s.color = c.color;
            s.positionValue.setForeground(c.color); s.positionLabel.setForeground(c.color);
            s.nameValue.setForeground(c.color); s.nameLabel.setForeground(c.color);
            s.speedValue.setForeground(c.color); s.speedLabel.setForeground(c.color);

            s.setVisible(true);
        }
        while(unitIterator.hasNext()){
            StatusUnit s = unitIterator.next();
            s.setVisible(false);
            s.circle = null;
        }
    }

    public void run() {
        while(true){
            status();
        }
    }

    public void dark() {
        this.setBackground(Color.BLACK);
        panel.setBackground(Color.BLACK);
        for(StatusUnit unit : units){
            unit.nameLabel.setBackground(Color.BLACK);
            unit.nameValue.setBackground(Color.BLACK);

            unit.speedLabel.setBackground(Color.BLACK);
            unit.speedValue.setBackground(Color.BLACK);

            unit.positionValue.setBackground(Color.BLACK);
            unit.positionLabel.setBackground(Color.BLACK);
            unit.destroyButton.setBackground(Color.BLACK);
            unit.doLayout();
        }
        doLayout();

    }

    public void light() {
        this.setBackground(Color.WHITE);
        panel.setBackground(Color.WHITE);

        for(StatusUnit unit : units){
            unit.nameLabel.setBackground(Color.WHITE);
            unit.nameValue.setBackground(Color.WHITE);

            unit.speedLabel.setBackground(Color.WHITE);
            unit.speedValue.setBackground(Color.WHITE);

            unit.positionValue.setBackground(Color.WHITE);
            unit.positionLabel.setBackground(Color.WHITE);

            unit.destroyButton.setBackground(Color.WHITE);
            unit.doLayout();
        }
        doLayout();
    }

}

//
//class status {
//
//    public static void main(String[] args){
//        Frame frame = new Frame();
//        frame.add(new MainStatus());
//        frame.setVisible(true);
//    }
//}
