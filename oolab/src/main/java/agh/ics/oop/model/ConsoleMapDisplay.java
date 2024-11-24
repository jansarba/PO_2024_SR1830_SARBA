package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {
    private static int i = 1;
    @Override
    public void mapChanged(WorldMap worldMap,String message){
        System.out.println("***\nOtrzymano wiadomosc: " + message);
        System.out.println(worldMap);
        System.out.println("To " + i + " wiadomosc\n***\n");
        i++;
    }
}
