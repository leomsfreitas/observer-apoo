package weather;

public class Main {

    public static void main(String[] args) {
        WeatherSensor sensor = new WeatherSensor();
        Observer phone = new PhoneDisplay();
        Observer thermost
        at = new ThermostatDisplay();
        Observer heatAlert = new HeatAlert();

        sensor.subscribe(phone);
        sensor.subscribe(thermostat);
        sensor.subscribe(heatAlert);

        changeTemperature(sensor, 22.0);
        changeTemperature(sensor, 29.5);
        changeTemperature(sensor, 36.0);

        System.out.println("--- Removendo o celular ---");
        sensor.unsubscribe(phone);

        changeTemperature(sensor, 30.0);
    }

    private static void changeTemperature(WeatherSensor sensor, double temperature) {
        System.out.println("--- Temperatura para " + temperature + " ---");
        sensor.setTemperature(temperature);
    }
}