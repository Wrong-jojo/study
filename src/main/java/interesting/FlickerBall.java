package interesting;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 数个跳动的小球
 */
class FlickerBall extends JFrame {
    private static int numBalls = 20;
    final static float SPEED = 5.0f;
    final static double EPSLION = 1.0E-5;
    private int w;
    private int h;
    private int radius = 20;
    private float[] dx;
    private float[] dy;
    private int[] lastx;
    private int[] lasty;
    private int[] x;
    private int[] y;
    Image offScreenImage = null;
    Graphics offG = null;

    public FlickerBall() {
        Toolkit tool = this.getToolkit();
        Dimension d = tool.getScreenSize();
        setSize(d);
        w = d.width;
        h = d.height;
        radius = Math.min(w, h) / 50;
        lastx = new int[numBalls];
        lasty = new int[numBalls];
        dx = new float[numBalls];
        dy = new float[numBalls];
        x = new int[numBalls];
        y = new int[numBalls];

        for (int i = 0; i < numBalls; i++) {
            lastx[i] = (int) (Math.random() * w);
            lasty[i] = (int) (Math.random() * h);
            dx[i] = (float) ((2 * Math.random()) - 1.0);
            dy[i] = (float) ((2 * Math.random()) - 1.0);

            double t = (dx[i] * dx[i]) + (dy[i] * dy[i]);

            if (Math.abs(t) < EPSLION) {
                dx[i] = 1;
                dy[i] = 0;
            } else {
                t = Math.sqrt(t);
                dx[i] = (float) (t - 0.1);
                dy[i] = (float) t;
            }
        }

        offScreenImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        offG = offScreenImage.getGraphics();
    }

    @Override
    public void paint(Graphics g) {
        offG.setColor(Color.black);
        offG.fillRect(0, 0, w, h);
        offG.setColor(Color.yellow);

        for (int i = 0; i < numBalls; i++) {
            offG.fillOval(lastx[i], lasty[i], radius, radius);
        }

        for (int i = 0; i < numBalls; i++) {
            x[i] = (int) (lastx[i] + (SPEED * dx[i]));
            y[i] = (int) (lasty[i] + (SPEED * dy[i]));

            if (x[i] < 0) {
                x[i] = 0;
                dx[i] = -dx[i];
            } else {
                if (x[i] > (w - radius)) {
                    x[i] = w - radius;
                    dx[i] = -dx[i];
                }
            }

            if (y[i] < 0) {
                y[i] = 0;
                dy[i] = -dy[i];
            } else {
                if (y[i] > (h - radius)) {
                    y[i] = h - radius;
                    dy[i] = -dy[i];
                }
            }

            lastx[i] = x[i];
            lasty[i] = y[i];
        }

        g.drawImage(offScreenImage, 0, 0, this);
        repaint(1000);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    public static void main(String[] args) {
        FlickerBall frame = new FlickerBall();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
