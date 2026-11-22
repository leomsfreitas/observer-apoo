package weather;

public class PhoneDisplay implements Observer {

    @Override
    public void update(double temperature) {
        System.out.println("[PHONE] Temperatura atual: " + temperature + "°C");
    }
}