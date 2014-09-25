package snow;

import snow.dependencies.MunicipalServices;
import snow.dependencies.PressService;
import snow.dependencies.SnowplowMalfunctioningException;
import snow.dependencies.WeatherForecastService;
public class SnowRescueService {

    private WeatherForecastService weatherForecastService;
    private MunicipalServices municipalServices;

    public SnowRescueService(WeatherForecastService weatherForecastService, MunicipalServices municipalServices, PressService pressService) {
        this.weatherForecastService = weatherForecastService;
        this.municipalServices = municipalServices;
    }

    public void checkForecastAndRescue() {
        if (isMinusTemp()) {
            municipalServices.sendSander();
        }
        if (isSnowFallEnoughToSendSnowPlow()) {
            try {
                municipalServices.sendSnowplow();
            } catch (SnowplowMalfunctioningException s) {
                municipalServices.sendSnowplow();
            }
        }
        if (isSnowFallGreaterThan5()) {
            municipalServices.sendSnowplow();
        }
    }

    private boolean isSnowFallEnoughToSendSnowPlow() {
        return weatherForecastService.getSnowFallHeightInMM() > 3;
    }

    private boolean isMinusTemp() {
        return weatherForecastService.getAverageTemperatureInCelsius() < 0;
    }

    private boolean isSnowFallGreaterThan5() {
        return weatherForecastService.getSnowFallHeightInMM() > 5;
    }
}
