package com.amasp.diskscheduling.UI;

import com.amasp.diskscheduling.DiskScheduling;
import com.amasp.diskscheduling.Util;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class Input extends javax.swing.JFrame {

    DefaultListModel<String> listModel = new DefaultListModel<>();
    ArrayList<Integer> nums = new ArrayList<>();

    public Input() {
        initComponents();
        
        list.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listKeyPressed(evt);
            }
        });
        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        applyIcons();
        applyButtonTheme();
        list.setModel(listModel);
        textRequestText.requestFocus();
    }

    private void applyIcons() {
        buttonHelp.setIcon(Util.getThemedIcon("help.svg"));
        buttonAbout.setIcon(Util.getThemedIcon("info.svg"));
        buttonAutofill.setIcon(Util.getThemedIcon("pencil.svg"));

        if (DiskScheduling.isDark) {
            buttonTheme.setIcon(Util.getThemedIcon("light.svg"));
            buttonTheme.setToolTipText("Switch to Light Theme");
        } else {
            buttonTheme.setIcon(Util.getThemedIcon("dark.svg"));
            buttonTheme.setToolTipText("Switch to Dark Theme");
        }
    }

    private void applyButtonTheme() {
        boolean dark = DiskScheduling.isDark;
        Util.styleButton(buttonHelp, dark);
        Util.styleButton(buttonAbout, dark);
        Util.styleButton(buttonAutofill, dark);
        Util.styleButton(buttonTheme, dark);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneRequests = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        textRequestText = new javax.swing.JTextField();
        buttonAdd = new javax.swing.JButton();
        buttonProceed = new javax.swing.JButton();
        buttonAbout = new javax.swing.JButton();
        labelRequestSequence = new javax.swing.JLabel();
        labelRequest = new javax.swing.JLabel();
        buttonAutofill = new javax.swing.JButton();
        buttonHelp = new javax.swing.JButton();
        buttonTheme = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Disk Scheduling - Inputs");
        setResizable(false);

        list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMouseClicked(evt);
            }
        });
        scrollPaneRequests.setViewportView(list);

        textRequestText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textRequestText.setToolTipText("Type in the Request");
        textRequestText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textRequestTextKeyPressed(evt);
            }
        });

        buttonAdd.setText("Add");
        buttonAdd.setToolTipText("Add Request to Sequence");
        buttonAdd.addActionListener(this::buttonAddActionPerformed);

        buttonProceed.setText("Proceed");
        buttonProceed.setToolTipText("Proceed");
        buttonProceed.addActionListener(this::buttonProceedActionPerformed);

        buttonAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/error28.png"))); // NOI18N
        buttonAbout.setToolTipText("About Me");
        buttonAbout.addActionListener(this::buttonAboutActionPerformed);

        labelRequestSequence.setText("Requests Sequence");

        labelRequest.setText("Request");

        buttonAutofill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/error28.png"))); // NOI18N
        buttonAutofill.setToolTipText("Autofill Sample Requests");
        buttonAutofill.addActionListener(this::buttonAutofillActionPerformed);

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
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPaneRequests, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textRequestText, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonProceed, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelRequestSequence, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonAutofill, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 41, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonHelp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAbout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonTheme, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelRequestSequence)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPaneRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonTheme, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(labelRequest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textRequestText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAutofill, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonProceed, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        if (textRequestText.getText().trim().isBlank()) {
            textRequestText.requestFocus();
            DiskScheduling.getTerminal().append("Please type in a vaild request!");
            return;
        }
        if (Integer.parseInt(textRequestText.getText()) < 0 || Integer.parseInt(textRequestText.getText()) > 2000) {
            DiskScheduling.getTerminal().append("Please type in a vaild request!");
            return;
        }
        add(Integer.parseInt(textRequestText.getText()));
        textRequestText.setText("");
        textRequestText.requestFocus();
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProceedActionPerformed
        if(nums.isEmpty()){
            DiskScheduling.getTerminal().append("Please Add some Requests first!");
            textRequestText.requestFocus();
            return;
        }
        SecondInput si = new SecondInput(nums);
        si.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonProceedActionPerformed

    private void buttonAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAboutActionPerformed
        Info i = new Info();
        i.setVisible(true);
    }//GEN-LAST:event_buttonAboutActionPerformed

    private void textRequestTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textRequestTextKeyPressed
        if (textRequestText.getText().trim().isBlank()) {
            textRequestText.requestFocus();
            DiskScheduling.getTerminal().append("Please type in a vaild request first!");
            return;
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buttonAddActionPerformed(null);
        }
    }//GEN-LAST:event_textRequestTextKeyPressed

    private void buttonAutofillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAutofillActionPerformed
        add(98);
        add(183);
        add(37);
        add(122);
        add(14);
        add(124);
        add(65);
        add(67);
        DiskScheduling.getTerminal().append("Request Data Autofilled.");
    }//GEN-LAST:event_buttonAutofillActionPerformed

    private void buttonHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHelpActionPerformed
        DiskScheduling.getTerminal().help();
    }//GEN-LAST:event_buttonHelpActionPerformed

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

    private void editSelectedItem() {
        int index = list.getSelectedIndex();
        if (index < 0) {
            return;
        }

        int oldValue = nums.get(index);

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

            nums.set(index, newValue);
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

            int removed = nums.get(index);

            listModel.remove(index);
            nums.remove(index);

            DiskScheduling.getTerminal().append(
                    "Request " + removed + " removed"
            );

            return;
        }

        if (evt.getKeyCode() == KeyEvent.VK_F2 || evt.getKeyCode() == KeyEvent.VK_ENTER) {
            editSelectedItem();
        }
    }

    private void add(int num) {
        listModel.addElement(Integer.toString(num));
        nums.add(num);
        DiskScheduling.getTerminal().append(nums.size() + ". Request: " + num + " Added");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAbout;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonAutofill;
    private javax.swing.JButton buttonHelp;
    private javax.swing.JButton buttonProceed;
    private javax.swing.JButton buttonTheme;
    private javax.swing.JLabel labelRequest;
    private javax.swing.JLabel labelRequestSequence;
    private javax.swing.JList<String> list;
    private javax.swing.JScrollPane scrollPaneRequests;
    private javax.swing.JTextField textRequestText;
    // End of variables declaration//GEN-END:variables
}
