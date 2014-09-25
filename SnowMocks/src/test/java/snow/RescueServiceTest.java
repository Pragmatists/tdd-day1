package snow;

import org.junit.Before;
import org.junit.Test;
import snow.dependencies.MunicipalServices;
import snow.dependencies.SnowplowMalfunctioningException;
import snow.dependencies.WeatherForecastService;

import static org.mockito.Mockito.*;

public class RescueServiceTest {

    private WeatherForecastService weatherForecastService;
    private MunicipalServices municipalServices;
    private SnowRescueService snowRescueService;

    @Before
    public void setup() {
        weatherForecastService = mock(WeatherForecastService.class);
        municipalServices = mock(MunicipalServices.class);
        snowRescueService = new SnowRescueService(weatherForecastService, municipalServices, null);
    }

    @Test
    public void shouldSendSander() {
        whenTemperatureIs(-20);

        snowRescueService.checkForecastAndRescue();

        verify(municipalServices).sendSander();
    }

    private void whenTemperatureIs(int temp) {
        when(weatherForecastService.getAverageTemperatureInCelsius()).thenReturn(temp);
    }

    @Test
    public void shoulNotsendSander() {
        whenTemperatureIs(20);

        snowRescueService.checkForecastAndRescue();

        verify(municipalServices, never()).sendSander();
    }

    @Test
    public void shouldSendSnowPlow() {
        snowFallIs(4);

        snowRescueService.checkForecastAndRescue();

        verify(municipalServices).sendSnowplow();
    }

    private void snowFallIs(int snowFall) {
        when(weatherForecastService.getSnowFallHeightInMM()).thenReturn(snowFall);
    }

    @Test
    public void shouldNotSendSnowPlow() {
        snowFallIs(3);

        snowRescueService.checkForecastAndRescue();

        verify(municipalServices, never()).sendSnowplow();
    }

    @Test
    public void shouldSendAnotherSnowPlow() {
        snowFallIs(5);
        doThrow(SnowplowMalfunctioningException.class).doNothing().when(municipalServices).sendSnowplow();
        snowRescueService.checkForecastAndRescue();

        verify(municipalServices, times(2)).sendSnowplow();
    }

    @Test
    public void shouldSendTwoSnowPlows() {

        snowFallIs(6);
        snowRescueService.checkForecastAndRescue();
        verify(municipalServices, times(2)).sendSnowplow();
    }
}
