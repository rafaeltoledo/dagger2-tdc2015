package net.rafaeltoledo.daggertest;

public class Repo {

    private final String name;

    public Repo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
