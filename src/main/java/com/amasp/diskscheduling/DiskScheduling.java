package com.amasp.diskscheduling;

import com.amasp.diskscheduling.UI.Input;
import com.amasp.diskscheduling.UI.Terminal;
import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class DiskScheduling {

    public static Terminal terminal;
    public static boolean isDark = true;
    
    public static Terminal getTerminal() {
        return terminal;
    }

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            Util.printExitBanner();
        }));

        FlatDarkLaf.setup();
        Util.printBanner();

        UIManager.put("Component.arc", 20);
        UIManager.put("Button.arc", 20);
        UIManager.put("TextComponent.arc", 15);
        UIManager.put("ScrollBar.width", 10);

        SwingUtilities.invokeLater(() -> {
            DiskScheduling app = new DiskScheduling();

            terminal = new Terminal(app);
            terminal.setDefaultText();
            terminal.setVisible(true);

            Input init = new Input();
            init.setVisible(true);
        });
    }
}
