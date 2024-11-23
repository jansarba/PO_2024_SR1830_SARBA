package agh.ics.oop.model;

import java.util.*;

public class GrassField extends AbstractWorldMap {
    private final int patches;
    private final Map<Vector2d, Grass> grassPatches = new HashMap<>();

    public GrassField(int patches) {
        this.patches = patches;
        this.placePatches(patches);
    }

    private void placePatches(int patches) {
        Random rand = new Random();
        int maxi = (int) Math.ceil(Math.sqrt(patches * 10));
        while (grassPatches.size() < patches) {
            Vector2d tempVec = new Vector2d(rand.nextInt(maxi), rand.nextInt(maxi));
            grassPatches.putIfAbsent(tempVec, new Grass(tempVec));
        }
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        WorldElement object = super.objectAt(position);
        if (object != null) return object;

        return grassPatches.get(position);
    }

    @Override
    public List<WorldElement> getElements() {
        List<WorldElement> elements = new ArrayList<>(super.getElements());
        elements.addAll(grassPatches.values());
        return elements;
    }

    @Override
    public Boundary getBoundary() {
        Vector2d bottom = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Vector2d top = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);

        List<WorldElement> elements = getElements();
        for (WorldElement element : elements) {
            bottom = bottom.lowerLeft(element.getPosition());
            top = top.upperRight(element.getPosition());
        }
        return new Boundary(bottom, top);
    }
}