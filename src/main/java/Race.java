import java.util.ArrayList;

public class Race 
{
	private RaceWeather raceWeather;
	private int raceTrackDistance;
	private ArrayList<RaceCar> racers = new ArrayList<RaceCar>();
	private final int numberOfStepsToChange = 5;
	
	public Race(WeatherType weather, int raceTrackDistance)
	{
		raceWeather = new RaceWeather(weather);
		this.raceTrackDistance = raceTrackDistance;
	}
	
	private String getOutcome() 
	{
		RaceCar largest = racers.get(0);
		for (RaceCar racer : racers) {
			if (racer.getMetersTravelled() > largest.getMetersTravelled()) {
				largest = racer;
			}
		}
		return "WINNER:"  + largest.getCarName() + ", " + largest.getManufacturer();
	}

	public void progressWeather() 
	{
		raceWeather.changeWeather();
	}
	
	public void changeCarBehaviour(int position, DrivingBehaviour newBehaviour)
	{
		racers.get(position).changeDrivingBehaviour(newBehaviour);
	}

	public void raceStep()
	{
		for (RaceCar racer : racers) {
			racer.driveCar();
			racer.getStatus();
		}
	}

	public boolean isFinished()
	{
		for (RaceCar racer : racers) {
			if (racer.getMetersTravelled() > raceTrackDistance) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	private void makeFourCars() 
	{
		racers.add(new RaceCar("Fjord", "Car 1", new CautiousBehaviour(), raceWeather));
		racers.add(new RaceCar("Fjord", "Car 2", new FastBehaviour(), raceWeather));
		racers.add(new RaceCar("Furbi", "Car 3", new CautiousBehaviour(), raceWeather));
		racers.add(new RaceCar("Furbi", "Car 4", new FastBehaviour(), raceWeather));
	}

	public void raceCars()
	{
		int stepCount = 0;
		while(!isFinished())
		{
			stepCount++;
			raceStep();
			if (stepCount%numberOfStepsToChange==0)
			{
				progressWeather();
			}
		}
	}

	public static void main(String[]args)
	{
		Race race = new Race(WeatherType.DRY, 100);
		race.makeFourCars();
		race.raceCars();
		System.out.println(race.getOutcome());
	}
}
