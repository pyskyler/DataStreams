import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Filter {

    private File searchFile;

    public void loadFile(File selectedFile) {
        this.searchFile = selectedFile;
    }

    public String getOriginalText() throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        Scanner in = new Scanner(searchFile);
        while (in.hasNextLine())
            sb.append(in.nextLine()).append("\n");
        return sb.toString();
    }

    public String getFilteredText(String search) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(searchFile.toURI()));
        StringBuilder sb = new StringBuilder();
        lines.filter(line -> line.toLowerCase().contains(search.toLowerCase())).forEach(line -> sb.append(line).append("\n"));

        return sb.toString();
    }
}
