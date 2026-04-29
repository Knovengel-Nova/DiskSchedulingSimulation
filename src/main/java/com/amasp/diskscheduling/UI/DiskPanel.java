package com.amasp.diskscheduling.UI;

import com.amasp.diskscheduling.DiskScheduling;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;

final class DiskPanel extends JPanel {

    private ArrayList<Integer> sequence;
    private int head;

    private Color textColor;
    private Color axisColor;
    private Color pointColor;
    private Color gradientStart;
    private Color gradientEnd;

    public DiskPanel(ArrayList<Integer> seq, int head) {
        this.sequence = seq;
        this.head = head;

        updateTheme();
    }

    public void updateTheme() {
        if (DiskScheduling.isDark) {
            setBackground(new Color(20, 20, 20));

            textColor = Color.WHITE;
            axisColor = new Color(180, 180, 180);
            pointColor = new Color(0, 200, 255);

            gradientStart = new Color(0, 200, 255);
            gradientEnd = new Color(255, 100, 200);

        } else {
            setBackground(new Color(245, 245, 245));

            textColor = Color.BLACK;
            axisColor = new Color(100, 100, 100);
            pointColor = new Color(0, 120, 200);

            gradientStart = new Color(0, 120, 200);
            gradientEnd = new Color(200, 80, 150);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (sequence == null || sequence.isEmpty()) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        int margin = 80;
        int top = 60;
        int stepY = 70;

        int max = head;
        for (int x : sequence) {
            max = Math.max(max, x);
        }

        double scale = (width - 2 * margin) / (double) max;

        // Axis line
        g2.setColor(axisColor);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(margin, top, width - margin, top);

        // Axis labels
        g2.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        for (int i = 0; i <= max; i += 20) {
            int x = (int) (margin + i * scale);

            g2.setColor(axisColor);
            g2.drawLine(x, top - 5, x, top + 5);

            g2.setColor(textColor);
            g2.drawString(String.valueOf(i), x - 10, top - 10);
        }

        // Head position
        int startX = (int) (margin + head * scale);
        int y = top + 40;

        g2.setColor(pointColor);
        g2.fillOval(startX - 6, y - 6, 12, 12);

        g2.setColor(textColor);
        g2.drawString("Head (" + head + ")", startX - 25, y - 15);

        int prev = head;

        // Draw movement lines
        for (int curr : sequence) {

            int x1 = (int) (margin + prev * scale);
            int x2 = (int) (margin + curr * scale);

            GradientPaint gp = new GradientPaint(
                    x1, y, gradientStart,
                    x2, y + stepY, gradientEnd
            );

            g2.setPaint(gp);
            g2.setStroke(new BasicStroke(3));
            g2.drawLine(x1, y, x2, y + stepY);

            // Point
            g2.setColor(textColor);
            g2.fillOval(x2 - 5, y + stepY - 5, 10, 10);

            // Label
            g2.setFont(new Font("Segoe UI", Font.BOLD, 13));
            g2.drawString(String.valueOf(curr), x2 - 10, y + stepY - 10);

            prev = curr;
            y += stepY;
        }

        // Title
        g2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        g2.setColor(pointColor);
        g2.drawString("Disk Head Movement Visualization", margin, 30);
    }
}