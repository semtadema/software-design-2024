package com.lexiflash.app.interfaces;

public interface Editable<T> {
    public void edit(T instance);
    public T create();
}
