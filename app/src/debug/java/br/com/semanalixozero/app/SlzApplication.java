package br.com.semanalixozero.app;

import timber.log.Timber;
import timber.log.Timber.DebugTree;

/**
 * @author Filipe Bezerra
 */
public class SlzApplication extends BaseApplication {

    @Override protected void initializeLogging() {
        Timber.plant(new DebugTree() {
            @Override
            protected String createStackElementTag(final StackTraceElement element) {
                return super.createStackElementTag(element) + ":" + element.getLineNumber();
            }
        });
    }
}
