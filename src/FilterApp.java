public class FilterApp {
    public static void main(String[] args) {
        FilterGUI gui = new FilterGUI();

        Filter filter = new Filter();
        FilterController controller = new FilterController(gui, filter);

        gui.setVisible(true);
    }
}
