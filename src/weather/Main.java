package weather;

public class Main {

    public static void main(String[] args) {
        WeatherSensor sensor = new WeatherSensor();
        PhoneDisplay phone = new PhoneDisplay();
        ThermostatDisplay thermostat = new ThermostatDisplay();
        HeatAlert heatAlert = new HeatAlert();

        sensor.addPhoneDisplay(phone);
        sensor.addThermostatDisplay(thermostat);
        sensor.addHeatAlert(heatAlert);

        changeTemperature(sensor, 22.0);
        changeTemperature(sensor, 29.5);
        changeTemperature(sensor, 36.0);

        System.out.println("--- Removendo o celular ---");
        sensor.removePhoneDisplay();

        changeTemperature(sensor, 30.0);
    }

    private static void changeTemperature(WeatherSensor sensor, double temperature) {
        System.out.println("--- Temperatura para " + temperature + " ---");
        sensor.setTemperature(temperature);
    }
}
