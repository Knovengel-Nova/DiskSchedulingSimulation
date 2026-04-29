package com.amasp.diskscheduling.UI;

import com.amasp.diskscheduling.Algorithm;
import com.amasp.diskscheduling.DiskScheduling;
import com.amasp.diskscheduling.Util;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class MainFrame extends javax.swing.JFrame {

    ArrayList<Integer> processes;
    int head;
    int dir;
    StringBuilder txt;
    int totalHead = 0;
    SecondInput parent;
    private DiskPanel panel;

    public MainFrame(SecondInput parent, ArrayList<Integer> arr, int head, int dir, int mode) {
        this.parent = parent;
        txt = new StringBuilder();
        initComponents();
        applyIcons();
        applyButtonTheme();
        buttonTheme.setToolTipText("Switch to Light Theme");
        panelDisplay.requestFocus();
        this.processes = arr;
        this.head = head;
        this.dir = dir;

        switch (mode) {
            case 0 ->
                FCFS();
            case 1 ->
                SCAN();
            case 2 ->
                C_SCAN();
            case 3 ->
                SSTF();
            case 4 ->
                LOOK();
            case 5 ->
                C_LOOK();
        }
    }

    private void applyIcons() {
        buttonHelp.setIcon(Util.getThemedIcon("help.svg"));
        buttonAbout.setIcon(Util.getThemedIcon("info.svg"));
        buttonHome.setIcon(Util.getThemedIcon("home.svg"));
        buttonRetry.setIcon(Util.getThemedIcon("retry.svg"));

        if (DiskScheduling.isDark) {
            buttonTheme.setIcon(Util.getThemedIcon("light.svg"));
        } else {
            buttonTheme.setIcon(Util.getThemedIcon("dark.svg"));
        }
    }

    private void applyButtonTheme() {
        boolean dark = DiskScheduling.isDark;

        Util.styleButton(buttonHelp, dark);
        Util.styleButton(buttonAbout, dark);
        Util.styleButton(buttonRetry, dark);
        Util.styleButton(buttonTheme, dark);
        Util.styleButton(buttonHome, dark);
    }

    private void showPanel(ArrayList<Integer> sequence) {
        txt.append("Algorithm Sequence: \n{ ");
        for (int i = 0; i < sequence.size(); i++) {
            txt.append(Integer.toString(sequence.get(i)));
            if (i < sequence.size() - 1) {
                txt.append(" => ");
            } else {
                txt.append(" }\n\n");
            }
        }
        txt.append("Total Head Movement: ").append(totalHead).append("\n");
        DiskScheduling.getTerminal().append(txt.toString());

        /*  
            X Algorithm Sequence: {a, b, c, d, e, .... }
            Total Head Movement: X
         */
        txt = new StringBuilder();
        panel = new DiskPanel(sequence, head);

        int height = 100 + sequence.size() * 80;
        panel.setPreferredSize(new Dimension(0, height));

        JScrollPane scrollPane = new JScrollPane(panel);

        JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
        verticalBar.setUnitIncrement(20);
        verticalBar.setBlockIncrement(50);  // page scroll speed

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        scrollPane.getViewport().addChangeListener(e -> {
            panel.setPreferredSize(
                    new Dimension(scrollPane.getViewport().getWidth(), height)
            );
            panel.revalidate();
        });

        panelDisplay.removeAll();
        panelDisplay.setLayout(new java.awt.BorderLayout());
        panelDisplay.add(scrollPane, BorderLayout.CENTER);

        panelDisplay.revalidate();
        panelDisplay.repaint();
    }

    public void FCFS() {
        ArrayList<Integer> seq = Algorithm.FCFS(processes, head);
        txt.append("FCFS ");
        totalHead = seq.get(seq.size() - 1);
        labelTitle.setText("FCFS | Total Head Movement: " + totalHead);
        seq.remove(seq.size() - 1);
        showPanel(seq);
    }

    public void SCAN() {
        ArrayList<Integer> seq = Algorithm.SCAN(processes, head, dir);
        txt.append("SCAN ");
        totalHead = seq.get(seq.size() - 1);
        labelTitle.setText("SCAN | Total Head Movement: " + totalHead);
        seq.remove(seq.size() - 1);
        showPanel(seq);
    }

    public void C_SCAN() {
        ArrayList<Integer> seq = Algorithm.C_SCAN(processes, head, dir);
        txt.append("C-SCAN ");
        totalHead = seq.get(seq.size() - 1);
        labelTitle.setText("C-SCAN | Total Head Movement: " + totalHead);
        seq.remove(seq.size() - 1);
        showPanel(seq);
    }

    public void SSTF() {
        ArrayList<Integer> seq = Algorithm.SSTF(processes, head);
        txt.append("SSTF ");
        totalHead = seq.get(seq.size() - 1);
        labelTitle.setText("SSTF | Total Head Movement: " + totalHead);
        seq.remove(seq.size() - 1);
        showPanel(seq);
    }

    public void LOOK() {
        ArrayList<Integer> seq = Algorithm.LOOK(processes, head, dir);
        txt.append("LOOK ");
        totalHead = seq.get(seq.size() - 1);
        labelTitle.setText("LOOK | Total Head Movement: " + totalHead);
        seq.remove(seq.size() - 1);
        showPanel(seq);
    }

    public void C_LOOK() {
        ArrayList<Integer> seq = Algorithm.C_LOOK(processes, head, dir);
        txt.append("C-LOOK ");
        totalHead = seq.get(seq.size() - 1);
        labelTitle.setText("C-LOOK | Total Head Movement: " + totalHead);
        seq.remove(seq.size() - 1);
        showPanel(seq);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitle = new javax.swing.JLabel();
        panelDisplay = new javax.swing.JPanel();
        buttonHome = new javax.swing.JButton();
        buttonAbout = new javax.swing.JButton();
        buttonRetry = new javax.swing.JButton();
        buttonTheme = new javax.swing.JButton();
        buttonHelp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Disk Scheduling - Simulation Result");

        labelTitle.setFont(new java.awt.Font("Liberation Sans", 3, 18)); // NOI18N
        labelTitle.setText("AMASP");

        javax.swing.GroupLayout panelDisplayLayout = new javax.swing.GroupLayout(panelDisplay);
        panelDisplay.setLayout(panelDisplayLayout);
        panelDisplayLayout.setHorizontalGroup(
            panelDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 973, Short.MAX_VALUE)
        );
        panelDisplayLayout.setVerticalGroup(
            panelDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        buttonHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/error28.png"))); // NOI18N
        buttonHome.setToolTipText("Home");
        buttonHome.addActionListener(this::buttonHomeActionPerformed);

        buttonAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/error28.png"))); // NOI18N
        buttonAbout.setToolTipText("About Me");
        buttonAbout.addActionListener(this::buttonAboutActionPerformed);

        buttonRetry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/error28.png"))); // NOI18N
        buttonRetry.setToolTipText("Try Other Algorithm");
        buttonRetry.addActionListener(this::buttonRetryActionPerformed);

        buttonTheme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/error28.png"))); // NOI18N
        buttonTheme.setToolTipText("Switch Theme");
        buttonTheme.addActionListener(this::buttonThemeActionPerformed);

        buttonHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/error28.png"))); // NOI18N
        buttonHelp.setToolTipText("Help");
        buttonHelp.addActionListener(this::buttonHelpActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(111, 111, 111)
                        .addComponent(buttonHelp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAbout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonTheme)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonRetry)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonHome)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(buttonHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonAbout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonRetry, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonTheme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(buttonHelp))
                .addGap(18, 18, 18)
                .addComponent(panelDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHomeActionPerformed
        DiskScheduling.getTerminal().clear();
        DiskScheduling.getTerminal().setDefaultText();
        Input in = new Input();
        in.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonHomeActionPerformed

    private void buttonAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAboutActionPerformed
        Info i = new Info();
        i.setVisible(true);
    }//GEN-LAST:event_buttonAboutActionPerformed

    private void buttonRetryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRetryActionPerformed
        parent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonRetryActionPerformed

    private void buttonThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonThemeActionPerformed
        Util.updateTheme(buttonTheme);
        applyButtonTheme();
        applyIcons();
        panel.updateTheme();
        panel.repaint();
    }//GEN-LAST:event_buttonThemeActionPerformed

    private void buttonHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHelpActionPerformed
        DiskScheduling.getTerminal().help();
    }//GEN-LAST:event_buttonHelpActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAbout;
    private javax.swing.JButton buttonHelp;
    private javax.swing.JButton buttonHome;
    private javax.swing.JButton buttonRetry;
    private javax.swing.JButton buttonTheme;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JPanel panelDisplay;
    // End of variables declaration//GEN-END:variables
}
