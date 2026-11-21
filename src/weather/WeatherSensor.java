package weather;

public class WeatherSensor {

    private double temperature;

    private PhoneDisplay phoneDisplay;
    private ThermostatDisplay thermostatDisplay;
    private HeatAlert heatAlert;

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        notifyDisplays();
    }

    public void addPhoneDisplay(PhoneDisplay phoneDisplay) {
        this.phoneDisplay = phoneDisplay;
    }

    public void removePhoneDisplay() {
        this.phoneDisplay = null;
    }

    public void addThermostatDisplay(ThermostatDisplay thermostatDisplay) {
        this.thermostatDisplay = thermostatDisplay;
    }

    public void removeThermostatDisplay() {
        this.thermostatDisplay = null;
    }

    public void addHeatAlert(HeatAlert heatAlert) {
        this.heatAlert = heatAlert;
    }

    public void removeHeatAlert() {
        this.heatAlert = null;
    }

    private void notifyDisplays() {
        if (phoneDisplay != null) {
            phoneDisplay.update(temperature);
        }
        if (thermostatDisplay != null) {
            thermostatDisplay.update(temperature);
        }
        if (heatAlert != null) {
            heatAlert.update(temperature);
        }
    }
}
