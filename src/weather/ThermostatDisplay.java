package weather;

public class ThermostatDisplay implements Observer {

    private static final double COOLING_THRESHOLD = 28.0;

    @Override
    public void update(double temperature) {
        String state = temperature > COOLING_THRESHOLD ? "LIGADO" : "DESLIGADO";
        System.out.println("[THERMOSTAT] Ar-condicionado " + state + " (" + temperature + "°C)");
    }
}