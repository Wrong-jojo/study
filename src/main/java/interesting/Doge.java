package interesting;

import javax.swing.*;
import java.awt.*;

/**
 * 精神污染doge
 */
public class Doge extends JFrame {
    ImageIcon imageIcon = new ImageIcon("/Users/gaozengrong/Downloads/doge-min.jpg"); // Icon由图片文件形成
    Image img = imageIcon.getImage();
    private int w;
    private int h;

    public Doge() {
        this.setTitle("精神污染doge");
        Toolkit tool = this.getToolkit();
        Dimension d = tool.getScreenSize();
        setSize(d);
        w = d.width;
        h = d.height;
//        this.setBackground(new Color(0, 0, 0, 0));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, (int) (Math.random() * w), (int) (Math.random() * h), null);
    }

    public static void main(String[] args) throws InterruptedException {
        Doge doge = new Doge();
        while (true) {
            doge.repaint();
            Thread.sleep(1);
        }
    }
}
