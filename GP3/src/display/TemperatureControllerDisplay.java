package display;

/**
 * Specifies what the display system should do. Note that the implementation has
 * a lot of freedom to choose its display.
 */
public interface TemperatureControllerDisplay {

	/**
	 * Display no devices running.
	 */
	public void showNoDeviceOn();

	/**
	 * Display the fan is on.
	 */
	public void showFanOn();

	/**
	 * Display the AC is on.
	 */
	public void showAcOn();

	/**
	 * Display the Heater is on.
	 */
	public void showHeaterOn();

	/**
	 * Display the fan is idle.
	 */
	public void showFanIdle();

	/**
	 * Display the AC is idle.
	 */
	public void showAcIdle();

	/**
	 * Display the Heater is idle.
	 */
	public void showHeaterIdle();

	/**
	 * Display the current temperature.
	 */
	public void showCurrentTemp(int currentTemp);

	/**
	 * Display the desired temperature.
	 */
	public void showDesiredTemp(int desiredTemp);

	/**
	 * Display the outside temperature.
	 */
	public void showOutsideTemp(int outsideTemp);

	/**
	 * Retrieve the value in the text box.
	 * 
	 * @return The value, zero if the input was invalid.
	 */
	public int getEnteredTemp();

}