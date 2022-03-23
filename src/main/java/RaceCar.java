
public class RaceCar implements Observer{
	
	private int metersTravelled = 0;
	private Subject	raceWeather;
	private String manufacturer;
	private String carName;
	private WeatherType weather;
	private DrivingBehaviour drivingBehaviour;
	
	public RaceCar(String manufacturer, String carName, DrivingBehaviour drivingBehaviour, Subject raceWeather)
	{
		this.raceWeather = raceWeather;
		raceWeather.registerObserver(this);
		this.drivingBehaviour = drivingBehaviour;
		this.manufacturer = manufacturer;
		this.carName = carName;
	}

	public void driveCar()
	{
		metersTravelled+=drivingBehaviour.distance(weather);
	}
	
	public void changeDrivingBehaviour(DrivingBehaviour behaviour)
	{
		this.drivingBehaviour = behaviour;
	}

	
	public String getStatus()
	{
		return carName + " built by " + manufacturer + " has travelled " + metersTravelled +" meters";
	}

	public int getMetersTravelled()
	{
		return metersTravelled;
	}

	public String getCarName()
	{
		return carName;
	}

	public String getManufacturer()
	{
		return manufacturer;
	}

	@Override
	public void update(WeatherType weather)
	{
		this.weather = weather;
	}
}
