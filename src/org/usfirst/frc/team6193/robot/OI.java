package org.usfirst.frc.team6193.robot;

import org.usfirst.frc.team6193.robot.triggers.FuelIntakeInstantCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// Joystick port setting
	public static final int JOYSTICKMADCATZID = 0;
	public static final int JOYSTICKLOGITECHID = 1;
	public static final int JOYSTICKXBOX = 2;
	
	// Joystick creation of new object based off the class
	public Joystick MadCatz = new Joystick(JOYSTICKMADCATZID);  // Driver
	public Joystick Logitech = new Joystick(JOYSTICKLOGITECHID); // CoPilot
	public Joystick XBOX = new Joystick(JOYSTICKXBOX); // Unknown
	
	// Gear Handler Button mapping
	public static final int GEARHANDLERSPINNERBUTTONNUM = 0;
	
	// Fuel Intake Button mapping
	public static final int FUELINTAKESPEEDDOWNBUTTON = 3;
	public static final int FUELINTAKESPEEDUPBUTTON = 4;
	private Button fuelIntakeSpeedUpButton = new JoystickButton(Logitech, FUELINTAKESPEEDUPBUTTON);
	private Button fuelIntakeSpeedDownButton = new JoystickButton(Logitech, FUELINTAKESPEEDDOWNBUTTON);
	
	// Rope Climber Button Mapping
	public static final int ROPECLIMBERSLOWBUTTONBUTTONID = 0;
	public static final int ROPECLIMBERFASTALLOWBUTTONID = 0;
	public static final int GEARHANDLERREVERSESPINNERBUTTONNUM = 3;

	// Constructor for class OI
	public OI(){
		fuelIntakeSpeedUpButton.whenPressed(new FuelIntakeInstantCommand(Cals.k_fuelIntakeSpeedChange));
		fuelIntakeSpeedDownButton.whenPressed(new FuelIntakeInstantCommand(-Cals.k_fuelIntakeSpeedChange));
	}

}
