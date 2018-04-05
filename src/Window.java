import javax.swing.*;

public class Window extends JFrame {
    Window(String title, int width, int height, JPanel panel, int type) {
        setTitle(title);
        setSize(width, height);
        setDefaultCloseOperation(type);
        setVisible(true);
        add(panel);
    }
}
