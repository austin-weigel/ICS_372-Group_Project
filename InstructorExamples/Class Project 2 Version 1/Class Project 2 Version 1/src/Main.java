import javafx.application.Application;

public class Main {
    public static void main(String[] args) {
        Clock.instance();
        new Thread() {
            public void run() {
                Application.launch(GUIDisplay.class, null);
            }
        }.start();
    }
}
