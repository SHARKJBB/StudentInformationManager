import java.awt.event.*;
import java.io.Serializable;
import javax.swing.*;

class Student implements Serializable {
    private String name;
    private String age;
    private String gender;
    private String phone;
    private String address;
    private String email;
    private Window window;

    void show() {
        JPanel panel = showPanel();
        new Window("学生信息", 300, 300, panel, JFrame.HIDE_ON_CLOSE);
    }

    private JPanel showPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel name_label = new JLabel("姓名：" + name);
        name_label.setBounds(10, 20, 250, 25);
        panel.add(name_label);

        JLabel age_label = new JLabel("年龄：" + age);
        age_label.setBounds(10, 50, 250, 25);
        panel.add(age_label);

        JLabel gender_label = new JLabel("性别：" + gender);
        gender_label.setBounds(10, 80, 250, 25);
        panel.add(gender_label);

        JLabel phone_label = new JLabel("手机：" + phone);
        phone_label.setBounds(10, 110, 250, 25);
        panel.add(phone_label);

        JLabel address_label = new JLabel("地址：" + address);
        address_label.setBounds(10, 140, 250, 25);
        panel.add(address_label);

        JLabel email_label = new JLabel("邮箱：" + email);
        email_label.setBounds(10, 170, 250, 25);
        panel.add(email_label);

        return panel;
    }

    void add() {
        JPanel panel = addPanel();
        window = new Window("学生录入", 300, 300, panel, JFrame.HIDE_ON_CLOSE);
    }

    private JPanel addPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel name_label = new JLabel("姓名：");
        name_label.setBounds(10, 20, 60, 25);
        panel.add(name_label);
        JTextField nameIn = new JTextField(20);
        nameIn.setBounds(60, 20, 150, 25);
        panel.add(nameIn);

        JLabel age_label = new JLabel("年龄：");
        age_label.setBounds(10, 50, 60, 25);
        panel.add(age_label);
        JTextField ageIn = new JTextField(20);
        ageIn.setBounds(60, 50, 150, 25);
        panel.add(ageIn);

        JLabel gender_label = new JLabel("性别：");
        gender_label.setBounds(10, 80, 60, 25);
        panel.add(gender_label);
        JPanel genderGroup = new JPanel();
        genderGroup.setBounds(50, 75, 100, 25);
        ButtonGroup genderButtonGroup = new ButtonGroup();
        JRadioButton genderMale = new JRadioButton("男");
        genderMale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gender = "男";
            }
        });
        JRadioButton genderFemale = new JRadioButton("女");
        genderFemale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gender = "女";
            }
        });
        genderButtonGroup.add(genderMale);
        genderButtonGroup.add(genderFemale);
        genderGroup.add(genderMale);
        genderGroup.add(genderFemale);
        panel.add(genderGroup);

        JLabel phone_label = new JLabel("手机：");
        phone_label.setBounds(10, 110, 60, 25);
        panel.add(phone_label);
        JTextField phoneIn = new JTextField(20);
        phoneIn.setBounds(60, 110, 150, 25);
        panel.add(phoneIn);

        JLabel address_label = new JLabel("地址：");
        address_label.setBounds(10, 140, 60, 25);
        panel.add(address_label);
        JTextField addressIn = new JTextField(20);
        addressIn.setBounds(60, 140, 150, 25);
        panel.add(addressIn);

        JLabel email_label = new JLabel("邮箱：");
        email_label.setBounds(10, 170, 60, 25);
        panel.add(email_label);
        JTextField emailIn = new JTextField(20);
        emailIn.setBounds(60, 170, 150, 25);
        panel.add(emailIn);

        JButton ok_button = new JButton("确定");
        ok_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nameIn.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "姓名 未输入", "错误", JOptionPane.ERROR_MESSAGE);
                } else if (ageIn.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "年龄 未输入", "错误", JOptionPane.ERROR_MESSAGE);
                } else if (genderButtonGroup.getSelection() == null) {
                    JOptionPane.showMessageDialog(null, "性别 未选择", "错误", JOptionPane.ERROR_MESSAGE);
                } else if (phoneIn.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "手机 未输入", "错误", JOptionPane.ERROR_MESSAGE);
                } else if (addressIn.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "地址 未输入", "错误", JOptionPane.ERROR_MESSAGE);
                } else if (emailIn.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "邮箱 未输入", "错误", JOptionPane.ERROR_MESSAGE);
                } else if (!phoneIn.getText().matches("1\\d{10}")) {
                    JOptionPane.showMessageDialog(null, "手机 输入错误", "错误", JOptionPane.ERROR_MESSAGE);
                } else if (!emailIn.getText().contains("@")) {
                    JOptionPane.showMessageDialog(null, "邮箱 格式错误", "错误", JOptionPane.ERROR_MESSAGE);
                } else {
                    name = nameIn.getText();
                    age = ageIn.getText();
                    phone = phoneIn.getText();
                    address = addressIn.getText();
                    email = emailIn.getText();
                    window.dispose();
                }
            }
        });
        ok_button.setBounds(10, 220, 80, 25);
        panel.add(ok_button);

        JButton redo_button = new JButton("清空");
        redo_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameIn.setText("");
                ageIn.setText("");
                phoneIn.setText("");
                addressIn.setText("");
                emailIn.setText("");
            }
        });
        redo_button.setBounds(100, 220, 80, 25);
        panel.add(redo_button);

        return panel;
    }

}