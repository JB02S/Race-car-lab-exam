public class FastBehaviour implements DrivingBehaviour
{
    @Override
    public int distance(WeatherType weather)
    {
        if (weather == WeatherType.DRY) {
            return 20;
        } else if (weather == WeatherType.MISTY) {
            return 5;
        } else if (weather == WeatherType.WET) {
            return 8;
        } else {
            return 0;
        }
    }
}
