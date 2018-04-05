import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

class Class {
    private ArrayList<Student> students;
    private String name;
    private int count;
    private JLabel label_count;

    private String getName() {
        return name;
    }

    private int getCount() {
        return count;
    }

    Class(String name) {
        this.name = name;
        students = new ArrayList<>();
        this.count = 0;
        show();
    }

    void show() {
        JPanel jPanel = createPanel();
        new Window("班级信息", 300, 200, jPanel, JFrame.EXIT_ON_CLOSE);
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel name = new JLabel("班级名：" + getName());
        name.setBounds(10, 20, 100, 25);
        panel.add(name);

        label_count = new JLabel("人数：" + getCount());
        label_count.setBounds(10, 50, 100, 25);
        panel.add(label_count);

        JButton addStudent = new JButton("添加学生");
        addStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add();
            }
        });
        addStudent.setBounds(150, 80, 90, 25);
        panel.add(addStudent);

        JButton showStudent = new JButton("学生信息");
        showStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (count == 0) {
                    JOptionPane.showMessageDialog(null, "没有信息", "错误", JOptionPane.ERROR_MESSAGE);
                } else {
                    for (Student stu : students) {
                        stu.show();
                    }
                }
            }
        });
        showStudent.setBounds(50, 80, 90, 25);
        panel.add(showStudent);

        JButton saveButton = new JButton("保存文件");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
        saveButton.setBounds(50, 110, 90, 25);
        panel.add(saveButton);

        JButton loadButton = new JButton("载入文件");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                load();
            }
        });
        loadButton.setBounds(150, 110, 90, 25);
        panel.add(loadButton);

        return panel;
    }

    private void add() {
        Student stu = new Student();
        stu.add();
        students.add(stu);
        count++;
        label_count.setText("人数：" + getCount());

    }

    private void save() {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jFileChooser.showDialog(new JLabel(), "选择文件夹");
        File file = jFileChooser.getSelectedFile();
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file.getAbsolutePath() + "/" + name + ".txt"));
            for (Student student : students) {
                out.writeObject(student);
            }
            out.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "保存失败", "错误", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, "保存成功", "成功", JOptionPane.WARNING_MESSAGE);
    }

    private void load() {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jFileChooser.showDialog(new JLabel(), "选择文件");
        try {
            File file = jFileChooser.getSelectedFile();
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file.getAbsolutePath()));
            students = new ArrayList<>();
            count = 0;
            while (true) {
                students.add((Student) in.readObject());
                count++;
            }
        } catch (FileNotFoundException | ClassNotFoundException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "载入失败", "错误", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "载入成功", "成功", JOptionPane.WARNING_MESSAGE);
            label_count.setText("人数：" + getCount());
        }
    }

    public static void main(String[] args) {
        new Class("Class_1");
    }
}