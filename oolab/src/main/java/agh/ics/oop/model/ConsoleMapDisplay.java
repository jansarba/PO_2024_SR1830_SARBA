package agh.ics.oop.model;

import agh.ics.oop.model.MapChangeListener;
import agh.ics.oop.model.WorldMap;

public class ConsoleMapDisplay implements MapChangeListener{
    private static int i = 1;

    private static final String GWIAZDKI = "***";
    private static final String OTRZYMANO_WIADOMOSC = "Otrzymano wiadomosc: %s";
    private static final String WORLDMAP_ID = "WorldMap ID: %s";
    private static final String TO_WIADOMOSC = "To %d wiadomosc";

    @Override
    public void mapChanged(WorldMap worldMap,String message) {
        String mapId = worldMap.getID().toString();

        System.out.println(GWIAZDKI);
        System.out.println(String.format(OTRZYMANO_WIADOMOSC, message));
        System.out.println(String.format(WORLDMAP_ID, mapId));
        System.out.println(worldMap);
        System.out.println(String.format(TO_WIADOMOSC, i));
        System.out.println(GWIAZDKI);
        i++;
    }
}