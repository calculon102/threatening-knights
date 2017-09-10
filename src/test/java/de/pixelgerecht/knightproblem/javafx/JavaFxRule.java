package de.pixelgerecht.knightproblem.javafx;

import javafx.application.Application;
import javafx.stage.Stage;
import org.junit.rules.ExternalResource;

/**
 * Runs a dummy FX-Thread.
 */
public class JavaFxRule extends ExternalResource {
    @Override
    protected void before() throws Throwable {
        super.before();

        Thread t = new Thread("JavaFX Init Thread") {
            public void run() {
                Application.launch(DummyApp.class);
            }
        };
        t.setDaemon(true);
        t.start();
    }

    public static class DummyApp extends Application
    {
        @Override
        public void start(Stage primaryStage) throws Exception {
            // NOP
        }
    }
}
