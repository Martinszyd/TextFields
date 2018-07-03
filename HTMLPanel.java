package TextFields;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HTMLPanel extends JPanel {

    //pole do wpisywania kodu html
    private final JTextArea textArea = new JTextArea();
    //pole z wygenerowanym kodem
    private final JEditorPane editorPane = new JEditorPane();

    public HTMLPanel() {
        super();
        setLayout(new BorderLayout());
        createPanels();
    }

    private void createPanels() {
        //nie chcemy, aby można było edytować wygenerowany html
        editorPane.setEditable(false);
        //ustawiamy nasz editorPane, aby rozpoznawa znaczniki html
        editorPane.setContentType("text/html");
        //przycisk generowania podglądu
        //  JButton actionButton = new JButton("View");
        //  actionButton.addActionListener(new ConvertListener());
        //panel pomocniczy do rozkładu elementów
        JPanel helpPanel = new JPanel();
        helpPanel.setLayout(new GridLayout(1, 2));
        textArea.setBackground(Color.lightGray);
        //dodajemy komponenty tekstowe do pomocniczego panelu
        helpPanel.add(textArea);
        textArea.addKeyListener(new MyKeyListener());
        helpPanel.add(editorPane);
        //dodajemy wszystko do głównego panelu
        this.add(helpPanel, BorderLayout.CENTER);
        //  this.add(actionButton, BorderLayout.SOUTH);
    }
/*
    class ConvertListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            //zmiany wyglądu wywołujemy w wątku dystrybucji zdarzeń
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    String text = textArea.getText();
                    editorPane.setText(text);
                    editorPane.revalidate();
                }
            });*/

    class MyKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent arg0) {
            //zmiany wyglądu wywołujemy w wątku dystrybucji zdarzeń
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    String text = textArea.getText();
                    editorPane.setText(text);
                }
            });
        }
    }
}
