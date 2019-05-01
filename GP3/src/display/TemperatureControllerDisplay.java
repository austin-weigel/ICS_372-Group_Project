package display;

/**
 * Specifies what the display system should do. Note that the implementation has
 * a lot of freedom to choose its display.
 */
public interface TemperatureControllerDisplay {

	public void showNoDeviceOn();

	public void showFanOn();

	public void showAcOn();

	public void showHeaterOn();

	public void showCurrentTemp(int currentTemp);

	/**
	 * indicate the Desired room temp
	 */
	public void showDesiredTemp(int desiredTemp);

	/**
	 * indicate the outside temp
	 */
	public void showOutsideTemp(int outsideTemp);

	public int getEnteredTemp();

}