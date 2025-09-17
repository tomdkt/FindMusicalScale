package com.music.domain;

public class Note {
    private final String name;
    private final int value; // 0 for C, 1 for C#/Db, etc.

    public Note(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}