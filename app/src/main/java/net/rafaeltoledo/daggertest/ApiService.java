package net.rafaeltoledo.daggertest;

import java.util.List;

import retrofit.http.GET;

public interface ApiService {

    @GET("/users/rafaeltoledo/repos")
    List<Repo> listRepos();
}
