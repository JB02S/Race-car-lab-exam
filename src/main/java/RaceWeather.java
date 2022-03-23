import java.util.ArrayList;

public class RaceWeather implements Subject
{

	private WeatherType weather;
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public RaceWeather(WeatherType weather)
	{
		this.weather = weather;
		notifyObservers();
	}
	

	public void changeWeather()
	{
		weather = weather.next();
		notifyObservers();
	}
	
	
	public WeatherType getWeather()
	{
		return weather;
	}

	@Override
	public void registerObserver(Observer o)
	{
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o)
	{
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers()
	{
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = observers.get(i);
			observer.update(getWeather());
		}
	}
}
