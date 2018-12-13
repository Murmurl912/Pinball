package main;

import canvas.Circle;
import canvas.MainCanvas;
import control.MainControl;
import image.StaticImage;
import status.MainStatus;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 主frame是容纳所有组件的窗口
 */
public class MainFrame extends Frame {

// ------------------------------------------------------------------------------

    public Panel panel; // frame 层的panel
    public GridBagLayout layout; // frame 层的布局管理器

    public Panel controlPanel;  // 控制区的panel
    public Panel canvasPanel;   // 画布区的panel
    public Panel statusPanel;   // 状态去的panel

    public MainCanvas canvas;   // 画板区的 画板Canvas
    public MainControl control; // 控制区的 控制Panel
    public MainStatus status;   // 状态区的 状态Panel


    public ArrayBlockingQueue<Circle> circles;   // 存储所有的小球

    public MenuBar menubar = new MenuBar();     // frame的 菜单栏

    // -----------------------------------------------------------------------------------------------------------------

    public Menu help =new Menu("Help");
    public Menu color =new Menu("Color");
    public Menu size =new Menu("Size");
    public Menu about =new Menu("About");

    public MenuItem dark =new MenuItem("Dark mode");
    public MenuItem light =new MenuItem("Light Mode");

    //创建exitItem的菜单项，指定使用“Ctrl Q”快捷键
    public MenuItem exitItem = new MenuItem("Quit", new MenuShortcut(KeyEvent.VK_Q ));
    public MenuItem max = new MenuItem("Maximum");
    public MenuItem min =new MenuItem("Minimum");
    public MenuItem  normal =new MenuItem("Normal");

    //创建help的菜单项
    public MenuItem usageItem =new MenuItem("Usage");

    //创建aboutItem的菜单项
    public MenuItem authors = new MenuItem("Authors");
    public MenuItem credits = new MenuItem("Credits");

    //创建commentItem菜单栏，指定使用“Ctrl Shift+/”快捷键

    public Panel checkPanel1 =new Panel();
    public Panel checkPanel2 =new Panel();
    public Panel checkPanelExit=new Panel();
    public Checkbox name1 =new Checkbox("ZhaoWen",true);
    public Checkbox name2 =new Checkbox("LuChengTong ",false);
    public Checkbox name3 =new Checkbox("LiuZheSheng",false);


    public void init() {

        checkPanel1.add(name1);
        checkPanel1.add(name2);
        checkPanel1.add(name3);
    }



    private void usageDialog(String message) {
        Frame frame = this; // 窗口，那个窗口上

        GridBagLayout layout = new GridBagLayout();
        Dialog dialog = new Dialog(frame);
        dialog.setLayout(layout);
        dialog.setLocationRelativeTo(frame);
        dialog.setTitle("Usage");


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

    private void AuthorDialog() {
        Dialog dialog;
        GridBagLayout layout;
        GridBagConstraints constraints;
        Panel panel;

        Label Author;
        Label IconImage;
        StaticImage image;

        Label linea;
        Label lineb;
        Label linec;
        Label lined;

        dialog = new Dialog(this);
        layout = new GridBagLayout();
        panel = new Panel();

        panel.setLayout(layout);
        dialog.add(panel);

        Author = new Label("Author");
        IconImage = new Label("    Icon Image");

        image = new StaticImage("res/icon.png");

        linea = new Label("    Our Team Composition");
        linea.setFont(new Font("楷体",Font.PLAIN,20));
        lineb = new Label("    Group Leader : ZhaoWen");
        linec = new Label("    Group Number : LuChengTong LiuZeSheng");
        lined = new Label("    Group Name : SQL Server");

        constraints = new GridBagConstraints();
        constraints.gridx = 0;  constraints.gridy = 0;
        constraints.gridwidth = 1; constraints.gridheight = 1;
        constraints.weightx = 1; constraints.weighty = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        layout.addLayoutComponent(linea, constraints);
        panel.add(linea, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;  constraints.gridy = 1;
        constraints.gridwidth = 1; constraints.gridheight = 1;
        constraints.weightx = 1; constraints.weighty = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        layout.addLayoutComponent(lined, constraints);
        panel.add(lined, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;  constraints.gridy = 2;
        constraints.gridwidth = 1; constraints.gridheight = 1;
        constraints.weightx = 1; constraints.weighty = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        layout.addLayoutComponent(lineb, constraints);
        panel.add(lineb, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;  constraints.gridy = 3;
        constraints.gridwidth = 1; constraints.gridheight = 1;
        constraints.weightx = 1; constraints.weighty = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        layout.addLayoutComponent(linec, constraints);
        panel.add(linec, constraints);


        constraints = new GridBagConstraints();
        constraints.gridx = 0;  constraints.gridy = 4;
        constraints.gridwidth = 1; constraints.gridheight = 1;
        constraints.weightx = 1; constraints.weighty = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        layout.addLayoutComponent(IconImage, constraints);
        panel.add(IconImage, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;  constraints.gridy = 5;
        constraints.gridwidth = 1; constraints.gridheight = 1;
        constraints.weightx = 1; constraints.weighty = 0.2;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        layout.addLayoutComponent(image, constraints);
        panel.add(image, constraints);


        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dialog.dispose();
            }
        });

        dialog.setSize(new Dimension(300, 500));
        dialog.setLocationRelativeTo(this);
        dialog.setTitle("Author");
        dialog.setVisible(true);

    }

    private void myDialog(String message, String myTitle,Panel checkPanel ,int index) {

        GridBagLayout layout = new GridBagLayout();
        Dialog dialog = new Dialog(this);
        dialog.setLayout(layout);
        dialog.setLocationRelativeTo(this);
        dialog.setTitle(myTitle);

        Button buttonOk = new Button("   Ok   ");
        Button buttonCancel =new Button("Cancel");
        buttonOk.addActionListener((e)->{
            this.setEnabled(true);
            if(index==1)
            {
                System.exit(0);
            }
            dialog.dispose();
        });
        buttonCancel.addActionListener((e)->{
            this.setEnabled(true);
            dialog.dispose();
        });

        Label  labelMessage = new Label(message);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1; constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.weightx = 1; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(10, 10, 10, 10);
        layout.addLayoutComponent(labelMessage, constraints);
        dialog.add(labelMessage, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridheight = 1; constraints.gridwidth = 2;
        constraints.weightx = 1; constraints.weighty = 1;
        constraints.insets = new Insets(15, 10, 15, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        layout.addLayoutComponent(checkPanel, constraints);
        dialog.add(checkPanel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 2;
        constraints.gridheight = 1; constraints.gridwidth = 1;
        constraints.weightx = 1; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);
        layout.addLayoutComponent(buttonOk, constraints);
        layout.addLayoutComponent(buttonCancel, constraints);
        dialog.add(buttonOk, constraints);
        constraints = new GridBagConstraints();
        constraints.gridx = 4;
        constraints.gridy = 2;
        constraints.gridheight = 1; constraints.gridwidth = 2;
        constraints.weightx = 1; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);
        dialog.add(buttonCancel, constraints);


        dialog.setSize(new Dimension(500, 200));
        dialog.setVisible(true);
        this.setEnabled(false);


        MainFrame frame = this;
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setEnabled(true);
                dialog.dispose();

            }
        });



    }

    private void creditsDialog() {
        Dialog dialog;
        GridBagLayout layout;
        GridBagConstraints constraints;
        Panel panel;

        Label credits;
        Label bgImage;
        Label bgImageAuthor;
        StaticImage image;
        StaticImage image1;
        Label specialThanks;
        Label linea;
        Label lineb;

        dialog = new Dialog(this);
        layout = new GridBagLayout();
        panel = new Panel();

        panel.setLayout(layout);
        dialog.add(panel);

        credits = new Label("Credits");
        bgImage = new Label("Background Image");
        bgImageAuthor = new Label("Aynı Göğün Altında");
        image = new StaticImage("res/image.png");
        image1 = new StaticImage("res/night.jpg");

        specialThanks = new Label("Special Thanks");
        linea = new Label("To those who post helpful");
        lineb = new Label("responses on Stack Overflow");

        constraints = new GridBagConstraints();
        constraints.gridx = 0;  constraints.gridy = 0;
        constraints.gridwidth = 1; constraints.gridheight = 1;
        constraints.weightx = 1; constraints.weighty = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        layout.addLayoutComponent(credits, constraints);
        panel.add(credits, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;  constraints.gridy = 1;
        constraints.gridwidth = 1; constraints.gridheight = 1;
        constraints.weightx = 1; constraints.weighty = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        layout.addLayoutComponent(bgImage, constraints);
        panel.add(bgImage, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;  constraints.gridy = 2;
        constraints.gridwidth = 1; constraints.gridheight = 1;
        constraints.weightx = 1; constraints.weighty = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        layout.addLayoutComponent(bgImageAuthor, constraints);
        panel.add(bgImageAuthor, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;  constraints.gridy = 3;
        constraints.gridwidth = 1; constraints.gridheight = 1;
        constraints.weightx = 1; constraints.weighty = 0.2;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        layout.addLayoutComponent(image, constraints);
        panel.add(image, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;  constraints.gridy = 4;
        constraints.gridwidth = 1; constraints.gridheight = 1;
        constraints.weightx = 1; constraints.weighty = 0.2;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        layout.addLayoutComponent(image1, constraints);
        panel.add(image1, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;  constraints.gridy = 5;
        constraints.gridwidth = 1; constraints.gridheight = 1;
        constraints.weightx = 1; constraints.weighty = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        layout.addLayoutComponent(specialThanks, constraints);
        panel.add(specialThanks, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;  constraints.gridy = 6;
        constraints.gridwidth = 1; constraints.gridheight = 1;
        constraints.weightx = 1; constraints.weighty = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        layout.addLayoutComponent(linea, constraints);
        panel.add(linea, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;  constraints.gridy = 7;
        constraints.gridwidth = 1; constraints.gridheight = 1;
        constraints.weightx = 1; constraints.weighty = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        layout.addLayoutComponent(lineb, constraints);
        panel.add(lineb, constraints);

        Label label = new Label();
        constraints = new GridBagConstraints();
        constraints.gridx = 0;  constraints.gridy = 8;
        constraints.gridwidth = 1; constraints.gridheight = 1;
        constraints.weightx = 1; constraints.weighty = 0.2;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        layout.addLayoutComponent(label, constraints);
        panel.add(label, constraints);

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dialog.dispose();
            }
        });

        dialog.setSize(new Dimension(300, 800));
        dialog.setLocationRelativeTo(this);
        dialog.setTitle("Credits");
        dialog.setVisible(true);

    }

    /**
     * 菜单栏 生成菜单并添加到frame上
     */
    private void menubar(){ // ---------------------------------------------------------------------------------------


        checkPanel1.add(name1);
        checkPanel1.add(name2);
        checkPanel1.add(name3);
        //       checkPanel1.add(class4);

        //为help菜单添加菜单单项
        help.add(usageItem);
        help.add(exitItem);
        help.addSeparator();

        //为commentItem菜单项添加事件监听器
        // commentItem.addActionListener(menuListener1);
        // exitItem.addActionListener(menuListener1);
        //为color菜单添加菜单单项
        color.add(new MenuItem("-"));
        color.add(dark);
        color.add(light);
        color.addSeparator();
        //color.add(new MenuItem("-"));

        //为size菜单添加菜单项
        size.add(max);
        size.add(min);
        size.add(normal);
        //使用addSeparator方法来添加菜单分割线
        size.addSeparator();

        //为format菜单添加菜单项

        //使用添加new MenuItem("-")的方式添加菜单分割线
        //size.add(new MenuItem("-"));
        //将format菜单组合到edit菜单中，从而形成二级菜单

        //为about菜单添加菜单项
        about.add(authors);
        about.add(credits);
        about.addSeparator();


        //将help、color、size菜单添加到menubar菜单条中
        menubar.add(help);
        menubar.add(color);
        menubar.add(size);
        menubar.add(about);



    } // ---------------------------------------------------------------------------------------------------------------

    private void menubarUI() {

        this.setMenuBar(menubar);

    }


    public MainFrame(){ // ---------------------------------------------------------------------------------------------
        circles = new ArrayBlockingQueue<>(1000);
        //init();
        menubar();
        menubarUI();
        ui();
        action();
    } // ---------------------------------------------------------------------------------------------------------------

    /**
     *
     */
    private void ui(){// ----------------------------------------------------------------------------------------------

        panel = new Panel();
        layout = new GridBagLayout();
        panel.setLayout(layout);
        panel.setBackground(new Color(220, 220, 220));
        add(panel);
        //-------------------------------------------------------------------
        menubarUI();        // 生成并添加菜单
        controlPanel();     // 生成control区
        canvasPanel();      // 生成canvas区
        statusPanel();   // 生成status区
        place();            // 摆放controlPanel statusPanel canvasPanel

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                doLayout();
            }
        });
    } // ---------------------------------------------------------------------------------------------------------------

    /**
     * 左侧控制栏 用于生成控制栏并不添加到frame
     * 只是底层的空白panel 用于容纳ControlPanel
     * 在这里添加Control到controlPanel
     */
    private void controlPanel(){ // ------------------------------------------------------------------------------------
        controlPanel = new Panel();
        BorderLayout controlPanelLayout = new BorderLayout();
        controlPanel.setLayout(controlPanelLayout);
        controlPanel.setPreferredSize(new Dimension(0, 0));
        control = new MainControl(this);
        controlPanelLayout.addLayoutComponent(control, BorderLayout.CENTER);
        controlPanel.add(control, BorderLayout.CENTER);
    } // ---------------------------------------------------------------------------------------------------------------

    /**
     * 右侧绘图区 用于绘图
     * 底层panel 用于容纳 MainCanvas
     * 在这里添加MainCanvas到canvasPanel
     */
    private void canvasPanel(){ // -------------------------------------------------------------------------------------
        canvasPanel = new Panel();
        BorderLayout canvasPanelLayout = new BorderLayout();
        canvasPanel.setLayout(canvasPanelLayout);
        canvasPanel.setPreferredSize(new Dimension(0, 0));
        canvas = new MainCanvas(this);
        canvasPanelLayout.addLayoutComponent(canvas, BorderLayout.CENTER);
        canvasPanel.add(canvas, BorderLayout.CENTER);
    } // ---------------------------------------------------------------------------------------------------------------

    /**
     * 底部状态区 用于显示小球状态信息
     * 底层panel 用于容纳StatusBar
     * 在这里添加Statusbar到statusPanel
     */
    private void statusPanel() { // ---------------------------------------------------------------------------------
        statusPanel = new Panel();
        BorderLayout statusPanelLayout = new BorderLayout();
        statusPanel.setLayout(statusPanelLayout);
        statusPanel.setPreferredSize(new Dimension(0, 0));
        status = new MainStatus(this);
        statusPanelLayout.addLayoutComponent(status, BorderLayout.CENTER);
        statusPanel.add(status, BorderLayout.CENTER);
    } // ---------------------------------------------------------------------------------------------------------------

    /**
     * 摆放 底层panel 控制区的controlPanel 绘图区的canvasPanel
     * 状态去区的statusPanel
     */
    private void place(){ // -------------------------------------------------------------------------------------------
        GridBagConstraints constraints;

        controlPanel.setBackground(Color.WHITE);
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 10; constraints.gridwidth = 2;
        constraints.weightx = 0.2; constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(4, 4, 4, 4);
        layout.addLayoutComponent(controlPanel, constraints);
        panel.add(controlPanel, constraints);

        canvasPanel.setBackground(Color.WHITE);
        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridheight = 8; constraints.gridwidth = 8;
        constraints.weightx = 0.8; constraints.weighty = 0.4;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(4, 0, 4, 4);
        layout.addLayoutComponent(canvasPanel, constraints);
        panel.add(canvasPanel, constraints);

        statusPanel.setBackground(Color.WHITE);
        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 8;
        constraints.gridheight = 2; constraints.gridwidth = 8;
        constraints.weightx = 0.8; constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 4, 4);
        layout.addLayoutComponent(statusPanel, constraints);
        panel.add(statusPanel, constraints);

    } // ---------------------------------------------------------------------------------------------------------------


    public void action() {

        canvas.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                control.positionChooser.positionxScrollBar.setMaximum(canvas.getWidth() - 100);
                control.positionChooser.positionx = control.positionChooser.positionxScrollBar.getValue();

                control.positionChooser.positionyScrollBar.setMaximum(canvas.getHeight() - 100);
                control.positionChooser.positiony = control.positionChooser.positionyScrollBar.getValue();
            }

        });


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                myDialog("Are you sure to closing ?", "Tips",checkPanelExit,1);
                ActionListener exitDialog = E -> {
                    String cmdQuitAll =E.getActionCommand();
                    if(cmdQuitAll.equals("   Ok   ")) {
                        System.exit(0);
                    }

                };
                //System.exit(0);
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowIconified(WindowEvent e) {
                canvas.pause();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowDeiconified(WindowEvent e) {
                canvas.resume();
            }
        });

        exitItem.addActionListener((e)->{
            String cmdQuit =e.getActionCommand();
            if(cmdQuit.equals("Quit")) {
                System.exit(0);
            }
        });

        authors.addActionListener((e)->{
            String cmdClass =e.getActionCommand();
            if(cmdClass.equals("Authors")) {
                AuthorDialog();
                // myDialog("Something about us ","Class",checkPanel1,0);
            }
        });

        credits.addActionListener((e)->{
            String cmdClass =e.getActionCommand();
            if(cmdClass.equals("Credits")) {
                creditsDialog();
            }
        });


        usageItem.addActionListener((e)->{
            usageDialog("The maximum capacity is 100 circle");
        });


        MainFrame frame = this;
        max.addActionListener((e)->{
            frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        });

        min.addActionListener((e)->{
            frame.setExtendedState(Frame.ICONIFIED);
        });

        normal.addActionListener((e)->{
            frame.setExtendedState(Frame.NORMAL);
        });

        dark.addActionListener((e)->{
            frame.setBackground(Color.BLACK);
            frame.control.dark();
            frame.canvas.setBackground(Color.BLACK);
            frame.canvas.darkMode = true;
            frame.status.dark();
            frame.doLayout();
        });

        light.addActionListener((e)->{
            frame.setBackground(Color.LIGHT_GRAY);
            frame.control.light();
            frame.canvas.setBackground(Color.WHITE);
            frame.canvas.darkMode = false;
            frame.canvas.normal();
            frame.status.light();
            frame.doLayout();
        });

    }

} // -------------------------------------------------------------------------------------------------------------------






