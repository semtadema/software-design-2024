package com.LexiFlash.app.Interfaces;

public interface Editable<T> {
    public void edit(T instance);
    public T create();
}
