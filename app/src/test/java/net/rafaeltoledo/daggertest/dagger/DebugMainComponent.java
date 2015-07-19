package net.rafaeltoledo.daggertest.dagger;

import net.rafaeltoledo.daggertest.MainComponent;

import dagger.Component;

@Component(modules = DebugMainModule.class)
public interface DebugMainComponent extends MainComponent{
}
