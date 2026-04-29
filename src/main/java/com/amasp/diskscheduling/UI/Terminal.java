package com.amasp.diskscheduling.UI;

import com.amasp.diskscheduling.DiskScheduling;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import javax.swing.SwingUtilities;

public class Terminal extends javax.swing.JFrame {

    DiskScheduling parent;

    public Terminal(DiskScheduling parent) {
        this.parent = parent;
        initComponents();

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        setSize(350, 500);  // first

        Rectangle bounds = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getMaximumWindowBounds();

        int margin = 10;

        setLocation(
                bounds.x + bounds.width - getWidth() - margin,
                bounds.y + bounds.height - getHeight() - margin
        );
    }

    public void setText(String text) {
        SwingUtilities.invokeLater(() -> {
            textArea.setText(text + "\n");
            textArea.setCaretPosition(0);
        });
    }

    public void clear() {
        SwingUtilities.invokeLater(() -> {
            textArea.setText("");
        });
    }

    public void append(String str) {
        SwingUtilities.invokeLater(() -> {
            textArea.append(str + "\n");
            textArea.setCaretPosition(textArea.getDocument().getLength()); // auto scroll
        });
    }

    public void setDefaultText() {
        String defaultText = """
                                ════════════════════════════
                                DISK SCHEDULING SIMULATOR
                                ════════════════════════════

                                Knovengel :D

                                Welcome!

                                This application simulates disk scheduling algorithms used in Operating Systems to optimize disk head movement.

                                AVAILABLE ALGORITHMS:
                                • FCFS
                                • SSTF
                                • SCAN
                                • C-SCAN
                                • LOOK
                                • C-LOOK

                                ════════════════════════════
                                SAMPLE EXECUTION
                                ════════════════════════════

                                Request Queue: 98, 183, 37, 122, 14, 124, 65, 67
                                Initial Head: 50

                                FCFS:
                                Sequence → 98 → 183 → 37 → 122 → 14 → 124 → 65 → 67
                                Total Head Movement → 643

                                SCAN (Right):
                                Sequence → 65 → 67 → 98 → 122 → 124 → 183 → 199 → 37 → 14 → 0
                                Total Head Movement → 334

                                C-SCAN (Right):
                                Sequence → 65 → 67 → 98 → 122 → 124 → 183 → 199 → 0 → 14 → 37
                                Total Head Movement → 385
                                
                                SSTF:
                                Sequence → 65 → 67 → 37 → 14 → 98 → 122 → 124 → 183
                                Total Head Movement → 205

                                LOOK (Right):
                                Sequence → 65 → 67 → 98 → 122 → 124 → 183 → 37 → 14
                                Total Head Movement → 302

                                C-LOOK (Right):
                                Sequence → 65 → 67 → 98 → 122 → 124 → 183 → 14 → 37
                                Total Head Movement → 325

                                ════════════════════════════

                                Press HELP for detailed explanation.
                                Press CLEAR to reset the terminal.

                                ════════════════════════════
                                """;

        setText(defaultText);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonClear = new javax.swing.JButton();
        buttonHelp = new javax.swing.JButton();
        scrollPaneText = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);

        buttonClear.setText("Clear");
        buttonClear.addActionListener(this::buttonClearActionPerformed);

        buttonHelp.setText("Help");
        buttonHelp.addActionListener(this::buttonHelpActionPerformed);

        textArea.setColumns(20);
        textArea.setRows(5);
        scrollPaneText.setViewportView(textArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneText, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneText, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonHelp)
                    .addComponent(buttonClear))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void help() {
        textArea.setText("");
        String helpText = """
                            ════════════════════════════
                            DISK SCHEDULING SIMULATOR HELP
                            ════════════════════════════

                            ABOUT:
                            This application simulates Disk Scheduling Algorithms used in Operating Systems to optimize disk head movement and improve performance.

                            Developed by: Aryan Anand Patil(AKA: Knovengel)


                            ════════════════════════════
                            HOW TO USE THE APPLICATION
                            ════════════════════════════

                            STEP 1: ENTER REQUESTS
                            • Enter disk request values one by one
                            • Click "Add" to insert into the request list
                            • Requests will appear in the list and terminal

                            STEP 2: PROCEED
                            • Click "Done" after entering all requests

                            STEP 3: CONFIGURE SIMULATION
                            • Enter Initial Head Position (default = 50)
                            • Select Algorithm:
                                - FCFS
                                - SSTF
                                - SCAN
                                - C-SCAN
                                - LOOK
                                - C-LOOK
                            • Select Direction (for SCAN / C-SCAN / LOOK / C-LOOK):
                                - Left
                                - Right

                            STEP 4: RUN SIMULATION
                            • Click "Simulate"
                            • The result will display:
                                - Algorithm sequence
                                - Total head movement
                                - Graphical visualization


                            ════════════════════════════
                            ALGORITHMS EXPLAINED
                            ════════════════════════════

                            1. FCFS (First Come First Serve)
                            • Processes requests in the order they arrive
                            • Simple but inefficient
                            • Can cause high head movement

                            2. SCAN (Elevator Algorithm)
                            • Head moves in one direction servicing requests
                            • Reaches end (0 or 199), then reverses
                            • More efficient than FCFS

                            3. C-SCAN (Circular SCAN)
                            • Head moves in one direction only
                            • After reaching end, jumps to other side
                            • Provides uniform wait time
                          
                            4. SSTF (Shortest Seek Time First)
                            • Selects the request closest to current head
                            • Reduces total head movement
                            • May cause starvation

                            5. LOOK
                            • Similar to SCAN but does NOT go to disk ends
                            • Reverses at last request instead of boundary
                            • More efficient than SCAN

                            6. C-LOOK
                            • Similar to C-SCAN but only goes between requests
                            • Jumps from last request to first request
                            • Avoids unnecessary travel to disk edges


                            ════════════════════════════
                            NOTES
                            ════════════════════════════

                            • Disk range assumed: 0 – 199
                            • Direction is ignored in FCFS and SSTF
                            • Visualization helps understand head movement


                            ════════════════════════════
                            CONTROLS
                            ════════════════════════════

                            • HELP  → Show this guide
                            • CLEAR → Clear terminal output

                            ════════════════════════════
                            """;

        setText(helpText);
    }

    private void buttonHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHelpActionPerformed
        help();
    }//GEN-LAST:event_buttonHelpActionPerformed

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
        textArea.setText("");
    }//GEN-LAST:event_buttonClearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonHelp;
    private javax.swing.JScrollPane scrollPaneText;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
