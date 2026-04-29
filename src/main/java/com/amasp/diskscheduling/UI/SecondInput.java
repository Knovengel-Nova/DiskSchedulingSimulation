package com.amasp.diskscheduling.UI;

import com.amasp.diskscheduling.DiskScheduling;
import com.amasp.diskscheduling.Util;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class SecondInput extends javax.swing.JFrame {

    ArrayList<Integer> arr;
    DefaultListModel<String> listModel = new DefaultListModel<>();

    public SecondInput(ArrayList<Integer> al) {
        this.arr = al;
        initComponents();
        list.setModel(listModel);

        list.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listKeyPressed(evt);
            }
        });
        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        applyIcons();
        applyButtonTheme();

        if (dropAlgorithm.getSelectedIndex() == 0 || dropAlgorithm.getSelectedIndex() == 3) {
            dropDirection.setEnabled(false);
        } else {
            dropDirection.setEnabled(true);
        }

        textHead.requestFocus();

        for (int i = 0; i < al.size(); i++) {
            listModel.addElement(Integer.toString(arr.get(i)));
        }
    }

    private void applyIcons() {
        buttonHelp.setIcon(Util.getThemedIcon("help.svg"));
        buttonAbout.setIcon(Util.getThemedIcon("info.svg"));

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
        Util.styleButton(buttonTheme, dark);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneRequests = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        textHead = new javax.swing.JTextField();
        dropDirection = new javax.swing.JComboBox<>();
        dropAlgorithm = new javax.swing.JComboBox<>();
        buttonSimulate = new javax.swing.JButton();
        buttonAbout = new javax.swing.JButton();
        labelRequestsSequence = new javax.swing.JLabel();
        labelHeadPosition = new javax.swing.JLabel();
        labelHeadDirection = new javax.swing.JLabel();
        labelAlgorithm = new javax.swing.JLabel();
        buttonHelp = new javax.swing.JButton();
        buttonTheme = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Disk Scheduling - Select Algorithm");
        setResizable(false);

        list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMouseClicked(evt);
            }
        });
        scrollPaneRequests.setViewportView(list);

        textHead.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textHead.setToolTipText("Initial Head Position (Default 50)");
        textHead.addActionListener(this::textHeadActionPerformed);

        dropDirection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Right", "Left" }));
        dropDirection.setToolTipText("Select Head Direction (No need for FCFS)");

        dropAlgorithm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FCFS", "SCAN", "C-SCAN", "SSTF", "LOOK", "C-LOOK" }));
        dropAlgorithm.setToolTipText("Select Algorithm");
        dropAlgorithm.addActionListener(this::dropAlgorithmActionPerformed);

        buttonSimulate.setText("Simulate");
        buttonSimulate.setToolTipText("Simulate Result");
        buttonSimulate.addActionListener(this::buttonSimulateActionPerformed);

        buttonAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/error28.png"))); // NOI18N
        buttonAbout.setToolTipText("About Me");
        buttonAbout.addActionListener(this::buttonAboutActionPerformed);

        labelRequestsSequence.setText("Requests Sequence");

        labelHeadPosition.setText("Initial Head Position");

        labelHeadDirection.setText("Head Direction");

        labelAlgorithm.setText("Algorithm");

        buttonHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/error28.png"))); // NOI18N
        buttonHelp.setToolTipText("Help");
        buttonHelp.addActionListener(this::buttonHelpActionPerformed);

        buttonTheme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/error28.png"))); // NOI18N
        buttonTheme.setToolTipText("Switch Theme");
        buttonTheme.addActionListener(this::buttonThemeActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textHead)
                            .addComponent(labelHeadPosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrollPaneRequests, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(labelRequestsSequence, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(buttonAbout))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonHelp, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(buttonTheme, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonSimulate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(labelAlgorithm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dropAlgorithm, javax.swing.GroupLayout.Alignment.LEADING, 0, 134, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelHeadDirection, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dropDirection, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelRequestsSequence)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPaneRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonAbout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonHelp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonTheme)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelHeadPosition)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textHead, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelAlgorithm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dropAlgorithm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelHeadDirection)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dropDirection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(buttonSimulate, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSimulateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimulateActionPerformed
        int dirInt;
        int modeInt;
        int headInt;

        //  Head (headInt)
        if (textHead.getText().isBlank()) {
            headInt = 50;
        } else {
            if (Integer.parseInt(textHead.getText()) < 0 || Integer.parseInt(textHead.getText()) > 2000) {
                DiskScheduling.getTerminal().append("Please Enter a valid Initial Head Position!");
                return;
            }
            headInt = Integer.parseInt(textHead.getText());
        }

        //  Direction (dirInt)
        if (dropDirection.getModel().getSelectedItem().equals("Left")) {
            dirInt = 0;
        } else {
            dirInt = 1;
        }

        //  Algorithm (modeInt)
        if (dropAlgorithm.getModel().getSelectedItem().equals("FCFS")) {
            modeInt = 0;
        } else if (dropAlgorithm.getModel().getSelectedItem().equals("SCAN")) {
            modeInt = 1;
        } else if (dropAlgorithm.getModel().getSelectedItem().equals("C-SCAN")) {
            modeInt = 2;
        } else if (dropAlgorithm.getModel().getSelectedItem().equals("SSTF")) {
            modeInt = 3;
        } else if (dropAlgorithm.getModel().getSelectedItem().equals("LOOK")) {
            modeInt = 4;
        } else {
            modeInt = 5;
        }

        StringBuilder t = new StringBuilder();

        t.append("Request List: ");
        for (int i = 0; i < arr.size(); i++) {
            t.append(arr.get(i));
            if (i < arr.size() - 1) {
                t.append(", ");
            }
        }
        t.append("\n\n");

        t.append("Algorithm: ");
        switch (modeInt) {
            case 0:
                t.append("FCFS\n");
                break;
            case 1:
                t.append("SCAN\n");
                break;
            case 2:
                t.append("C-SCAN\n");
                break;
            case 3:
                t.append("SSTF\n");
                break;
            case 4:
                t.append("LOOK\n");
                break;
            default:
                t.append("C-LOOK\n");
                break;
        }

        t.append("Initial Head Position: ").append(headInt).append("\n");
        if (modeInt != 0 && modeInt != 3) {
            t.append("Direction: ");
            if (dirInt == 0) {
                t.append("Left\n");
            } else {
                t.append("Right\n");
            }
        }

        DiskScheduling.getTerminal().setText(t.toString());
        MainFrame m = new MainFrame(this, arr, headInt, dirInt, modeInt);
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_buttonSimulateActionPerformed

    private void buttonAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAboutActionPerformed
        Info i = new Info();
        i.setVisible(true);
    }//GEN-LAST:event_buttonAboutActionPerformed

    private void textHeadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textHeadActionPerformed

    }//GEN-LAST:event_textHeadActionPerformed

    private void dropAlgorithmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropAlgorithmActionPerformed
        if (dropAlgorithm.getSelectedIndex() == 0 || dropAlgorithm.getSelectedIndex() == 3) {
            dropDirection.setEnabled(false);
        } else {
            dropDirection.setEnabled(true);
        }
    }//GEN-LAST:event_dropAlgorithmActionPerformed

    private void buttonThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonThemeActionPerformed
        Util.updateTheme(buttonTheme);
        applyButtonTheme();
        applyIcons();
    }//GEN-LAST:event_buttonThemeActionPerformed

    private void listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseClicked
        if (evt.getClickCount() == 2) {
            editSelectedItem();
        }
    }//GEN-LAST:event_listMouseClicked

    private void buttonHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHelpActionPerformed
        DiskScheduling.getTerminal().help();
    }//GEN-LAST:event_buttonHelpActionPerformed

    private void editSelectedItem() {
        int index = list.getSelectedIndex();
        if (index < 0) {
            return;
        }

        int oldValue = arr.get(index);

        String input = javax.swing.JOptionPane.showInputDialog(
                this,
                "Edit Request:",
                oldValue
        );

        if (input == null) {
            return;
        }

        input = input.trim();

        if (input.isBlank()) {
            DiskScheduling.getTerminal().append("Invalid input!");
            return;
        }

        try {
            int newValue = Integer.parseInt(input);

            if (newValue < 0 || newValue > 2000) {
                DiskScheduling.getTerminal().append("Value must be between 0 and 2000!");
                return;
            }

            arr.set(index, newValue);
            listModel.set(index, Integer.toString(newValue));

            DiskScheduling.getTerminal().append(
                    "Request " + oldValue + " changed to " + newValue
            );

        } catch (NumberFormatException e) {
            DiskScheduling.getTerminal().append("Only numbers allowed!");
        }
    }

    private void listKeyPressed(java.awt.event.KeyEvent evt) {

        int index = list.getSelectedIndex();
        if (index < 0) {
            return;
        }

        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {

            int removed = arr.get(index);

            listModel.remove(index);
            arr.remove(index);

            DiskScheduling.getTerminal().append(
                    "Request " + removed + " removed"
            );

            return;
        }

        if (evt.getKeyCode() == KeyEvent.VK_F2 || evt.getKeyCode() == KeyEvent.VK_ENTER) {
            editSelectedItem();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAbout;
    private javax.swing.JButton buttonHelp;
    private javax.swing.JButton buttonSimulate;
    private javax.swing.JButton buttonTheme;
    private javax.swing.JComboBox<String> dropAlgorithm;
    private javax.swing.JComboBox<String> dropDirection;
    private javax.swing.JLabel labelAlgorithm;
    private javax.swing.JLabel labelHeadDirection;
    private javax.swing.JLabel labelHeadPosition;
    private javax.swing.JLabel labelRequestsSequence;
    private javax.swing.JList<String> list;
    private javax.swing.JScrollPane scrollPaneRequests;
    private javax.swing.JTextField textHead;
    // End of variables declaration//GEN-END:variables
}
