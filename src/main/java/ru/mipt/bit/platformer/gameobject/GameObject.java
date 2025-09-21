package ru.mipt.bit.platformer.gameobject;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Rectangle;

import static ru.mipt.bit.platformer.util.GdxGameUtils.createBoundingRectangle;
import static ru.mipt.bit.platformer.util.GdxGameUtils.drawTextureRegionUnscaled;
import static ru.mipt.bit.platformer.util.GdxGameUtils.moveRectangleAtTileCenter;

public abstract class GameObject {
    protected final TiledMapTileLayer tileLayer;
    protected final TextureRegion graphics;
    protected final Rectangle rectangle;
    protected final GridPoint2 coordinates;

    public GameObject(TiledMapTileLayer tileLayer, TextureRegion graphics, GridPoint2 initialCoordinates) {
        this.tileLayer = tileLayer;
        this.graphics = graphics;
        this.rectangle = createBoundingRectangle(graphics);
        this.coordinates = new GridPoint2(initialCoordinates);
        moveRectangleAtTileCenter(tileLayer, this.rectangle, this.coordinates);
    }

    public void draw(Batch batch, float rotation) {
        drawTextureRegionUnscaled(batch, graphics, rectangle, rotation);
    }

    public void draw(Batch batch) {
        this.draw(batch, 0f);
    }

    public GridPoint2 getCoordinates() {
        // Возвращаем копию, чтобы избежать случайного изменения координат объекта извне
        return new GridPoint2(coordinates);
    }
}
