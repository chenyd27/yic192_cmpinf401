
/**
 * Class Entree
 * author : Yida Chen
 * created: 12/04/2022
 */
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class MenuManagerGUI {

    private JFrame frame;
    private MenuManager manager;
    private List<Menu> menuList = new ArrayList<>();

    private HashMap<String,Entree> entreeHashMap = new HashMap<>();
    private HashMap<String,Side> sideHashMap = new HashMap<>();
    private HashMap<String,Salad> saladHashMap = new HashMap<>();
    private HashMap<String,Dessert> dessertHashMap = new HashMap<>();
    private HashMap<String,Menu> menuHashMap = new HashMap<>();

    private Menu menu = new Menu();

    private DefaultListModel listModel = new DefaultListModel();
    private JList jList;
    private String selectElement = "";
    private JComboBox entreeBox; // Entree selecting box
    private JComboBox sideBox; // Side selecting box
    private JComboBox saladBox; // Salad selecting box
    private JComboBox dessertBox; // Dessert selecting box



    /**
     * Launch the application.
     */
    public static void main(String[] args) throws IOException {

        MenuManagerGUI window = new MenuManagerGUI();
        window.frame.setVisible(true);

    }

    /**
     * Create the application.
     */
    public MenuManagerGUI() throws IOException {
        this.manager = new MenuManager("data/dishes.txt");
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Menu Manager");
        frame.setBounds(100, 100, 600, 360);
        frame.getContentPane().setLayout(new GridLayout(1,2));
        JPanel panelLeft = new JPanel();
        panelLeft.setLayout(new FlowLayout(FlowLayout.LEFT));
        JPanel panelRight = new JPanel(new CardLayout());
        // layout on the left up
        JPanel panelLeft_upUp = createPanelLeftUp();
        JLabel titleLeftUp = new JLabel("Create your own Menu");
        titleLeftUp.setBorder(BorderFactory.createEmptyBorder(5,5,0,0));
        // layout on the left down
        JPanel panelLeft_downDown = createPanelLeftDown();
        JLabel titleLeftDown = new JLabel("Generate a Menu");
        titleLeftDown.setBorder(BorderFactory.createEmptyBorder(5,5,0,0));
        panelLeft.add(titleLeftUp);
        panelLeft.add(panelLeft_upUp);
        panelLeft.add(titleLeftDown);
        panelLeft.add(panelLeft_downDown);
        frame.add(panelLeft);

        JPanel panelRight_sub = createPanelRight();
        panelRight_sub.setBorder(BorderFactory.createEmptyBorder(0,0,0,5));
        panelRight.add(panelRight_sub);
        frame.add(panelRight);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    /*
     * Create the up-left panel
     */
    private JPanel createPanelLeftUp(){
        // layout on the left up
        JPanel panelLeft_up = new JPanel(new GridLayout(5,1)); // the innermost
        JPanel panelLeft_upUp = new JPanel(); // the outermost
        panelLeft_upUp.setBackground(Color.WHITE);
        panelLeft_upUp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelLeft_up.setBackground(Color.WHITE);
        Panel entreePanel = new Panel(new BorderLayout());
        Label entreeLabel = new Label("Entree: ");
        entreeBox = new JComboBox();
        for(Entree entree : manager.getEntrees()){
            entreeBox.addItem(entree.getName());
            entreeHashMap.put(entree.getName(),entree);
        }
        entreeBox.setSelectedIndex(0);
        menu.setEntree(entreeHashMap.get((String) entreeBox.getSelectedItem()));
        entreeBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.SELECTED == e.getStateChange()){
                    String entreeName = (String) entreeBox.getSelectedItem();
                    menu.setEntree(entreeHashMap.get(entreeName));
                }
            }
        });
        entreePanel.add(entreeLabel,BorderLayout.WEST);
        entreePanel.add(entreeBox,BorderLayout.CENTER);
        Panel sidePanel = new Panel(new BorderLayout());
        Label sideLabel = new Label("Side:    ");
        sideBox = new JComboBox();
        for(Side side : manager.getSides()){
            sideBox.addItem(side.getName());
            sideHashMap.put(side.getName(),side);
        }
        sideBox.setSelectedIndex(0);
        menu.setSide(sideHashMap.get((String) sideBox.getSelectedItem()));
        sideBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String sideName = (String) sideBox.getSelectedItem();
                menu.setSide(sideHashMap.get(sideName));
            }
        });
        sidePanel.add(sideLabel,BorderLayout.WEST);
        sidePanel.add(sideBox,BorderLayout.CENTER);
        saladBox = new JComboBox();
        Panel saladPanel = new Panel(new BorderLayout());
        Label saladLabel = new Label("Salad:   ");
        for(Salad salad : manager.getSalads()){
            saladBox.addItem(salad.getName());
            saladHashMap.put(salad.getName(),salad);
        }
        saladBox.setSelectedIndex(0);
        menu.setSalad(saladHashMap.get((String) saladBox.getSelectedItem()));
        saladBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String saladName = (String) saladBox.getSelectedItem();
                menu.setSalad(saladHashMap.get(saladName));
            }
        });
        saladPanel.add(saladLabel,BorderLayout.WEST);
        saladPanel.add(saladBox,BorderLayout.CENTER);
        Panel dessertPanel = new Panel(new BorderLayout());
        Label dessertLabel = new Label("Dessert:");
        dessertBox = new JComboBox();
        for(Dessert dessert : manager.getDesserts()){
            dessertBox.addItem(dessert.getName());
            dessertHashMap.put(dessert.getName(),dessert);
        }
        dessertBox.setSelectedIndex(0);
        menu.setDessert(dessertHashMap.get((String) dessertBox.getSelectedItem()));
        dessertBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String dessertName = (String) dessertBox.getSelectedItem();
                menu.setDessert(dessertHashMap.get(dessertName));
            }
        });
        dessertPanel.add(dessertLabel,BorderLayout.WEST);
        dessertPanel.add(dessertBox,BorderLayout.CENTER);

        // MyActionListener myActionListener = new MyActionListener();
        Button createMenuDishes = new Button("Create Menu with these dishes");
        createMenuDishes.addActionListener(new MyActionListener());
        panelLeft_up.add(entreePanel);
        panelLeft_up.add(sidePanel);
        panelLeft_up.add(saladPanel);
        panelLeft_up.add(dessertPanel);
        panelLeft_up.add(createMenuDishes);
        panelLeft_upUp.add(panelLeft_up,BorderLayout.CENTER);
        return panelLeft_upUp;
    }
    
    /*
     * Create the down-left panel
     */
    private JPanel createPanelLeftDown(){
        // layout on the left down
        JPanel panelLeft_downDown = new JPanel();
        JPanel panelLeft_down = new JPanel(new GridLayout(3,1));
        panelLeft_down.setBackground(Color.WHITE);
        panelLeft_downDown.setBackground(Color.WHITE);
        panelLeft_downDown.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Button randomMenu = new Button("Generate a Random Menu");
        randomMenu.addActionListener(new MyActionListener());
        Button minMenu = new Button("Generate a Minimum Calories Menu");
        minMenu.addActionListener(new MyActionListener());
        Button maxMenu = new Button("Generate a Maximum Calories Menu");
        maxMenu.addActionListener(new MyActionListener());
        panelLeft_down.add(randomMenu);
        panelLeft_down.add(minMenu);
        panelLeft_down.add(maxMenu);
        panelLeft_downDown.add(panelLeft_down,BorderLayout.CENTER);
        return panelLeft_downDown;
    }
    
    /*
     * Create the right panel
     */
    private JPanel createPanelRight(){
        JPanel out = new JPanel(new BorderLayout());
        JPanel title = new JPanel(new FlowLayout(FlowLayout.LEFT));
        Label label = new Label("Created Menus:");
        title.setBorder(BorderFactory.createEmptyBorder(5,0,0,0));
        title.add(label);
        JPanel buttonPanel = new JPanel(new GridLayout(1,3));
        Button button1 = new Button("Details");
        Button button2 = new Button("Delete all");
        Button button3 = new Button("Save to file");
        buttonPanel.add(button1);
        button1.addActionListener(new MyButtonListener());
        buttonPanel.add(button2);
        button2.addActionListener(new MyButtonListener());
        buttonPanel.add(button3);
        button3.addActionListener(new MyButtonListener());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
        jList = new JList(listModel);
        jList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jList.addMouseListener(new MyMouseListener());
        out.add(title,BorderLayout.NORTH);
        out.add(jList,BorderLayout.CENTER);
        out.add(buttonPanel,BorderLayout.SOUTH);

        return out;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
    /*
     * listen to button from the left panel
     */
    class MyActionListener implements ActionListener{
        TextField input;
        @Override
        public void actionPerformed(ActionEvent a) {
            if(a.getActionCommand().equals("Generate a Random Menu")){
                menu = manager.randomMenu("");
            }else if(a.getActionCommand().equals("Generate a Minimum Calories Menu")){
                menu = manager.minCaloriesMenu("");
            }else if(a.getActionCommand().equals("Generate a Maximum Calories Menu")){
                menu = manager.maxCaloriesMenu("");
            }else{
                menu.setName("");
            }
            JFrame subframe = new JFrame();
            subframe.setVisible(true);
            subframe.setBounds(200,200,300,100);
            subframe.setTitle("Please input the name of the Menu");
            TextField textField = new TextField("Please input the name of the Menu",20);
            Button button = new Button("Submit");
            button.addActionListener(new NameListener(textField,subframe));
            Panel panel = new Panel(new FlowLayout(FlowLayout.LEFT));
            panel.add(textField);
            panel.add(button);
            subframe.add(panel);
        }
    }
    
    /*
     * listen to the name typing
     */
    class NameListener implements ActionListener{
        TextField input;
        JFrame subframe;
        public NameListener(TextField textField,JFrame subframe){
            this.input = textField;
            this.subframe = subframe;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
        	if(!input.getText().equals("Please input the name of the Menu") && !input.getText().equals("")) {
        		menu.setName(input.getText());
                Menu addMenu = new Menu(menu.getName(),menu.getEntree(),menu.getSide(),menu.getSalad(),menu.getDessert());
                menuList.add(addMenu);
                menuHashMap.put(addMenu.getName(),addMenu);
                listModel.addElement(addMenu.getName());
                input.setText("");
                subframe.setVisible(false);
                menu.setEntree(entreeHashMap.get((String)entreeBox.getSelectedItem()));
                menu.setSide(sideHashMap.get((String)sideBox.getSelectedItem()));
                menu.setSalad(saladHashMap.get((String)saladBox.getSelectedItem()));
                menu.setDessert(dessertHashMap.get((String)dessertBox.getSelectedItem()));
        	}else {
                JOptionPane.showMessageDialog(null,"Empty name is not accepted.");
        	}
        }
    }
    
    /*
     * listen to the mouse click
     */
    class MyMouseListener implements MouseListener  {
        @Override
        public void mouseClicked(MouseEvent event) {
            // single click
            if(event.getClickCount() >= 1){
                int index = jList.getSelectedIndex();
                if (index >= 0){
                    selectElement = listModel.getElementAt(index).toString();
                }

            }
        }
        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e){}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    }
    
    /*
     * listen to the right panel button
     */
    class MyButtonListener implements ActionListener{
        JFrame subframe;
        Menu showMenu;
        public JPanel getPanel(String type){
            JPanel panel = new JPanel();
            JTextArea label;
            if(type.equals("Total calories") || type.equals("Total price: $") ){
                label = new JTextArea(1,6);
            }else{
                label = new JTextArea(3,40);
            }
            label.setLineWrap(true);
            JLabel title;
            if(type.equals("Entree")) {
                title = new JLabel(type + '\t'+ '\t' + '\t');
                label.setText(showMenu.getEntree().toString());
            }
            else if(type.equals("Side")) {
                title = new JLabel(type + '\t'+ '\t' + '\t'+ '\t' + '\t'+ '\t');
                label.setText(showMenu.getSide().toString());
            }
            else if(type.equals("Salad")) {
                title = new JLabel(type + '\t' + '\t' + '\t' + '\t' + '\t');
                label.setText(showMenu.getSalad().toString());
            }
            else if(type.equals("Dessert")) {
                title = new JLabel(type + '\t' + '\t');
                label.setText(showMenu.getDessert().toString());
            }else if(type.equals("Total calories")){
                title = new JLabel(type + '\t');
                label.setText(showMenu.totalCalories() +"");
            }else{
                title = new JLabel(type + '\t');
                label.setText(showMenu.totalPrice() + "");
            }
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            label.setBackground(Color.WHITE);
            panel.add(title,BorderLayout.WEST);
            panel.add(label,BorderLayout.CENTER);
            return panel;
        }
        @Override
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            if(command.equals("Details") && !selectElement.equals("")){
                subframe = new JFrame();
                showMenu = menuHashMap.get(selectElement);
                subframe.setTitle("Menu: " + showMenu.getName());
                subframe.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
                subframe.setBounds(200,200,600,500);
                JPanel entreePanel = getPanel("Entree");
                JPanel sidePanel = getPanel("Side");
                JPanel saladPanel = getPanel("Salad");
                JPanel dessertPanel = getPanel("Dessert");
                JPanel calogories = getPanel("Total calories");
                JPanel price = getPanel("Total price: $");
                subframe.add(entreePanel);
                subframe.add(sidePanel);
                subframe.add(saladPanel);
                subframe.add(dessertPanel);
                subframe.add(calogories);
                subframe.add(price);
                subframe.setVisible(true);
            }else if(command.equals("Delete all")){
                listModel.clear();
                menuList.clear();
                menuHashMap.clear();
            }else if(command.equals("Save to file") && !menuList.isEmpty()){
                try{
                    FileManager.writeMenus("data/menus.txt",menuList);
                }catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        }
    }
}


