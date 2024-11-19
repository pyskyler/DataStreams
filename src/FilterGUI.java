import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FilterGUI extends JFrame {
    private JTextArea originalTextArea;
    private JTextArea filteredTextArea;
    private JTextField searchField;
    private JButton loadButton;
    private JButton searchButton;
    private JButton quitButton;

    public FilterGUI() {
        setTitle("Filter GUI");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        setLocationRelativeTo(null);

        JPanel topPanel = new JPanel(new FlowLayout());

        searchField = new JTextField(20);
        topPanel.add(searchField);

        loadButton = new JButton("Load File");
        topPanel.add(loadButton);

        searchButton = new JButton("Search");
        topPanel.add(searchButton);

        quitButton = new JButton("Quit");
        topPanel.add(quitButton);

        add(topPanel, BorderLayout.NORTH);


        JPanel centerPanel = new JPanel(new GridLayout(1, 2));

        originalTextArea = new JTextArea(20, 30);
        JScrollPane originalScrollPane = new JScrollPane(originalTextArea);
        centerPanel.add(originalScrollPane);

        filteredTextArea = new JTextArea(20, 30);
        JScrollPane filteredScrollPane = new JScrollPane(filteredTextArea);
        centerPanel.add(filteredScrollPane);

        add(centerPanel, BorderLayout.CENTER);
    }

    public void setLoadButton(ActionListener actionListener) {
        loadButton.addActionListener(actionListener);
    }

    public void setSearchButton(ActionListener actionListener) {
        searchButton.addActionListener(actionListener);
    }

    public void setQuitButton(ActionListener actionListener) {
        quitButton.addActionListener(actionListener);
    }

    public void setOriginalTextArea(String text) {
        originalTextArea.setText(text);
    }

    public void setFilteredTextArea(String text) {
        filteredTextArea.setText(text);
    }

    public String getSearchField() {
        return searchField.getText();
    }

    public void throwException(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }


}