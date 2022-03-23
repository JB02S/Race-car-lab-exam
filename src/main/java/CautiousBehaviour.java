public class CautiousBehaviour implements DrivingBehaviour
{
    @Override
    public int distance(WeatherType weather)
    {
        if (weather == WeatherType.DRY) {
            return 10;
        } else if (weather == WeatherType.MISTY) {
            return 10;
        } else if (weather == WeatherType.WET) {
            return 10;
        } else {
            return 0;
        }
    }
}
