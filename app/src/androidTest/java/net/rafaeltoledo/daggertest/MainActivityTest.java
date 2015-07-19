package net.rafaeltoledo.daggertest;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ListAdapter;
import android.widget.ListView;

import junit.framework.Assert;

import net.rafaeltoledo.daggertest.dagger.DaggerDebugMainComponent;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class, false, false);

    @Before
    public void setUp() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        MainApplication app = (MainApplication) instrumentation.getTargetContext().getApplicationContext();

        app.setComponent(DaggerDebugMainComponent.create());

        rule.launchActivity(new Intent());
    }

    @Test
    public void loadRepositoriesTest() {
        MainActivity activity = rule.getActivity();

        ListAdapter adapter = ((ListView) activity.findViewById(android.R.id.list)).getAdapter();
        Assert.assertEquals(2, adapter.getCount());
    }
}
