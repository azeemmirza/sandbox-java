package Laboratory06.Problem61;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Problem61 extends JFrame {
    private TextField txt_name;
    private TextField txt_street;
    private TextField txt_city;
    private TextField txt_state;
    private TextField txt_zip;

    public Problem61(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Address Form");
        setSize(600,250);
        centerFrameOnDesktop(this);

        //set the form
        JPanel panel_main = new JPanel();
        panel_main.setLayout(new BoxLayout(panel_main,BoxLayout.Y_AXIS));

        JPanel row1 = getJPanel_row1();

        JPanel row2 = getPanel_row2("State", "Zip");
        row2.setLayout(new GridBagLayout());

        Button btn_submit = new Button("Submit");
        //btn onclick
        btn_submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txt_name.getText();
                String street = txt_street.getText();
                String city = txt_city.getText();
                String state = txt_state.getText();
                String zip = txt_zip.getText();

                System.out.println(name +"\n" + street +"\n" + city+ ", "+ state +" "+ zip);
            }
        });

        JPanel panel_btn = new JPanel();
        panel_btn.add(btn_submit);

        panel_main.add(row1);
        panel_main.add(Box.createVerticalStrut(20)); // 10px space

        panel_main.add(row2);
        panel_main.add(Box.createVerticalStrut(20)); // 10px space

        panel_main.add(panel_btn);
        //make the content center
        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.add(panel_main);

        getContentPane().add(wrapper);

    }

    private JPanel getPanel_row2(String State, String Zip) {
        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // state
        txt_state = new TextField(14); // assign to class field
        Label lbl_state = new Label(State);

        JPanel panel_state = new JPanel();
        panel_state.add(lbl_state);
        panel_state.add(txt_state);
        row2.add(panel_state);

        // zip
        txt_zip = new TextField(14); // assign to class field
        Label lbl_zip = new Label(Zip);

        JPanel panel_zip = new JPanel();
        panel_zip.add(lbl_zip);
        panel_zip.add(txt_zip);
        row2.add(panel_zip);

        return row2;
    }


    private JPanel getJPanel_row1() {
        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // name
        txt_name = new TextField(14); // assign to class field
        Label lbl_name = new Label("Name");

        JPanel panel_name = new JPanel();
        panel_name.add(lbl_name);
        panel_name.add(txt_name);
        row1.add(panel_name);

        // street
        txt_street = new TextField(14);
        Label lbl_street = new Label("Street");

        JPanel panel_street = new JPanel();
        panel_street.add(lbl_street);
        panel_street.add(txt_street);
        row1.add(panel_street);

        // city
        txt_city = new TextField(14);
        Label lbl_city = new Label("City");

        JPanel panel_city = new JPanel();
        panel_city.add(lbl_city);
        panel_city.add(txt_city);
        row1.add(panel_city);

        return row1;
    }



    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Problem61 frame  = new Problem61();
                frame.setVisible(true);
            }



        });


    }

    public static void centerFrameOnDesktop(Component f) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int height = toolkit.getScreenSize().height;
        int width = toolkit.getScreenSize().width;
        int frameHeight = f.getSize().height;
        int frameWidth = f.getSize().width;
        int xpos = (width - frameWidth) / 2;
        int ypos = (height - frameHeight) / 3;
        f.setLocation(xpos, ypos);
    }

}

