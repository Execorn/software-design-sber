package ru.mipt.bit.platformer.gameobject;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Interpolation;
import ru.mipt.bit.platformer.Direction;
import ru.mipt.bit.platformer.util.TileMovement;

import static com.badlogic.gdx.math.MathUtils.isEqual;
import static ru.mipt.bit.platformer.util.GdxGameUtils.continueProgress;

public class Tank extends GameObject {

    private static final float MOVEMENT_SPEED = 0.4f;

    private final TileMovement tileMovement;
    private final GridPoint2 destinationCoordinates;
    private float movementProgress = 1f;
    private float rotation = 0f;

    public Tank(TiledMapTileLayer tileLayer, TextureRegion graphics, GridPoint2 initialCoordinates) {
        super(tileLayer, graphics, initialCoordinates);
        this.destinationCoordinates = new GridPoint2(initialCoordinates);
        this.tileMovement = new TileMovement(tileLayer, Interpolation.smooth);
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch, rotation);
    }

    public void update(float deltaTime) {
        tileMovement.moveRectangleBetweenTileCenters(rectangle, coordinates, destinationCoordinates, movementProgress);

        movementProgress = continueProgress(movementProgress, deltaTime, MOVEMENT_SPEED);
        if (isEqual(movementProgress, 1f)) {
            coordinates.set(destinationCoordinates);
        }
    }

    public void startMoving(Direction direction) {
        if (isMoving()) {
            return;
        }
        destinationCoordinates.set(coordinates).add(direction.getDelta());
        movementProgress = 0f;
        rotation = direction.getRotation();
    }

    public boolean isMoving() {
        return !isEqual(movementProgress, 1f);
    }
}
