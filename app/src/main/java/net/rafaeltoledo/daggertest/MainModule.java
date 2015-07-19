package net.rafaeltoledo.daggertest;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

@Module
public class MainModule {

    @Provides @Singleton
    public ApiService provideApiService() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .build();

        return restAdapter.create(ApiService.class);
    }
}
