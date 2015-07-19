package net.rafaeltoledo.daggertest.dagger;

import net.rafaeltoledo.daggertest.ApiService;
import net.rafaeltoledo.daggertest.Repo;

import java.util.Arrays;
import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class DebugMainModule {

    @Provides
    public ApiService provideApiService() {
        return new ApiService() {
            @Override
            public List<Repo> listRepos() {
                return Arrays.asList(new Repo("my-test-repo"), new Repo("another-test-repo"));
            }
        };
    }
}
