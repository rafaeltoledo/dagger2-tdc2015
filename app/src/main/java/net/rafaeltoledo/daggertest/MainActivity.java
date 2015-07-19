package net.rafaeltoledo.daggertest;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends ListActivity {

    @Inject ApiService api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainApplication.getComponent(this).inject(this);

        new Thread(new Runnable() {
            @Override
            public void run() {
                final List<Repo> repoList = api.listRepos();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setupAdapter(repoList);
                    }
                });
            }
        }).start();
    }

    private void setupAdapter(List<Repo> repoList) {
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, repoList));
    }
}
