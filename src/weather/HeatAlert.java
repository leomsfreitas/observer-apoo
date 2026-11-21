package weather;

public class HeatAlert {

    private static final double EXTREME_HEAT_THRESHOLD = 35.0;

    public void update(double temperature) {
        if (temperature >= EXTREME_HEAT_THRESHOLD) {
            System.out.println("[ALERTA] Calor extremo: " + temperature + "°C");
        }
    }
}
