package TextFields;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginListener implements ActionListener {
    //Główna ramka programu
    private final JFrame frame;
    //Panel logowania, potrzebny do pobrania loginu i hasła
    private LoginPanel loginPanel;

    public void setPanel(LoginPanel loginPanel) {
        this.loginPanel = loginPanel;
    }

    public LoginListener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String name = loginPanel.getName();
        String password = loginPanel.getPassword();
        if (UserValidator.authenticate(name, password)) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    // panel z edytorem html
                    JPanel htmlPanel = new HTMLPanel();
                    // usuwamy panel logowania
                    frame.getContentPane().removeAll();
                    // dodajemy panel html i odświeżamy widok
                    frame.add(htmlPanel);
                    frame.validate();
                }
            });
        }
    }
}
