package ru.mipt.bit.platformer;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.GridPoint2;

public enum Direction {
    UP(90f, new GridPoint2(0, 1), Input.Keys.UP, Input.Keys.W),
    LEFT(-180f, new GridPoint2(-1, 0), Input.Keys.LEFT, Input.Keys.A),
    DOWN(-90f, new GridPoint2(0, -1), Input.Keys.DOWN, Input.Keys.S),
    RIGHT(0f, new GridPoint2(1, 0), Input.Keys.RIGHT, Input.Keys.D);

    private final float rotation;
    private final GridPoint2 delta;
    private final int[] keys;

    Direction(float rotation, GridPoint2 delta, int... keys) {
        this.rotation = rotation;
        this.delta = delta;
        this.keys = keys;
    }

    public float getRotation() {
        return rotation;
    }

    public GridPoint2 getDelta() {
        return delta;
    }

    public int[] getKeys() {
        return keys;
    }
}
