package de.pixelgerecht.threateningknights.javafx;

import javafx.application.Application;
import javafx.stage.Stage;
import org.junit.rules.ExternalResource;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Runs a dummy FX-Thread.
 */
public class JavaFxRule extends ExternalResource {
    private static final AtomicBoolean isRunning = new AtomicBoolean(false);

    @Override
    protected void before() throws Throwable {
        super.before();

        boolean needsStart = isRunning.compareAndSet(false, true);
        if ( !needsStart) {
            return;
        }

        Thread t = new Thread("JavaFX Dummy Thread") {
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
