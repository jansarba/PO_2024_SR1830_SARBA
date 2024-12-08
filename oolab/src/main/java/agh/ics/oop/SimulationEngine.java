package agh.ics.oop;

import agh.ics.oop.exceptions.IncorrectPositionException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine {
    private final List<Simulation> simulations;
    private final List<Thread> threads = new ArrayList<>();
    private ExecutorService threadPool;

    public SimulationEngine(List<Simulation> simulations) {
        this.simulations = simulations;
    }

    public void runSync() throws IncorrectPositionException {
        for (Simulation simulation : simulations) {
            simulation.run();
        }
    }

    public void runAsync() {
        threads.clear();
        for (Simulation simulation : simulations) {
            Thread thread = new Thread(simulation);
            threads.add(thread);
            thread.start();
        }
    }

    public void runAsyncInThreadPool() {
        threadPool = Executors.newFixedThreadPool(4);
        for (Simulation simulation : simulations) {
            threadPool.submit(simulation);
        }
    }

    public void awaitSimulationsEnd() throws InterruptedException {
        if (threadPool != null) {
            threadPool.shutdown();
            if (!threadPool.awaitTermination(10, TimeUnit.SECONDS)) {
                System.err.println("Timeout: Nie wszystkie symulacje zdolaly sie skonczyc");
                threadPool.shutdownNow();
            }
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }
}