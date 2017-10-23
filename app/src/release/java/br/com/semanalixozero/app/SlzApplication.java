package br.com.semanalixozero.app;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;

import io.fabric.sdk.android.Fabric;
import timber.log.Timber;

/**
 * @author Filipe Bezerra
 */
public class SlzApplication extends BaseApplication {

    @Override protected void initializeLogging() {
        Timber.plant(new ReleaseTree());
    }

    @Override protected void initializeFabric() {
        Fabric.with(this, new Crashlytics(), new Answers());
    }
}
