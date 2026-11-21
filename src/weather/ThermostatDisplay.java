package weather;

public class ThermostatDisplay {

    private static final double COOLING_THRESHOLD = 28.0;

    public void update(double temperature) {
        String state = temperature > COOLING_THRESHOLD ? "LIGADO" : "DESLIGADO";
        System.out.println("[THERMOSTAT] Ar-condicionado " + state + " (" + temperature + "°C)");
    }
}
