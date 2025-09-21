package ru.mipt.bit.platformer.gameobject;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.GridPoint2;

public class Tree extends GameObject {
    public Tree(TiledMapTileLayer tileLayer, TextureRegion graphics, GridPoint2 initialCoordinates) {
        super(tileLayer, graphics, initialCoordinates);
    }
}
