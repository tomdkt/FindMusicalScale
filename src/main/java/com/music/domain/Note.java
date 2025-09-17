package com.music.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Note {
    private final String name;
    private final int value; // 0 for C, 1 for C#/Db, etc.
}