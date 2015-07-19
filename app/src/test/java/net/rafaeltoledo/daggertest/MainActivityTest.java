package net.rafaeltoledo.daggertest;

import android.widget.ListAdapter;
import android.widget.ListView;

import junit.framework.Assert;

import net.rafaeltoledo.daggertest.dagger.DaggerDebugMainComponent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = 21, constants = BuildConfig.class)
public class MainActivityTest {

    @Before
    public void setUp() {
        MainComponent component = DaggerDebugMainComponent.create();
        ((MainApplication) RuntimeEnvironment.application).setComponent(component);
    }

    @Test
    public void loadRepositoriesTest() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        ListAdapter adapter = ((ListView) activity.findViewById(android.R.id.list)).getAdapter();
        Assert.assertEquals(2, adapter.getCount());
    }
}
