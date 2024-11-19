import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class FilterController {
    private FilterGUI gui;
    private FilterController filter;

    public FilterController(FilterGUI gui, Filter filter) {

        gui.setQuitButton(e -> System.exit(0));

        gui.setLoadButton(e -> {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                filter.loadFile(selectedFile);
                try {
                    gui.setOriginalTextArea(filter.getOriginalText());
                } catch (IOException ex) {
                    gui.throwException("Error reading file");
                    ex.printStackTrace();
                }
            }
        });

        gui.setSearchButton(e -> {
            String search = gui.getSearchField();
            try { gui.setFilteredTextArea(filter.getFilteredText(search));
            } catch (IOException ex) {
                gui.throwException("Error reading file");
                ex.printStackTrace();
            }
        });
    }


}
