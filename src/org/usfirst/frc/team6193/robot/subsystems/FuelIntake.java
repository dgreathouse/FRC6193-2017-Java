package org.usfirst.frc.team6193.robot.subsystems;

import org.usfirst.frc.team6193.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/** FuelIntake class<br>
 * This class represents the fuel intake subsystem<br>
 * The fuel intake uses 1 motor to turn and conveyer system that make the Fuel travel up the tank and into the tank.<br>
 *
 * Functionality available in this class are:<br>
 * 1. Change the speed of the intake motor based on a module level variable.<br>
 *    Commands will call functions in this class to get the current speed and set the speed.<br>
 *    
 */
public class FuelIntake extends Subsystem {


	private CANTalon m_fuelIntakeMotorController;
	private double m_fuelIntakeSpeed;

	// Constructor for class
	public FuelIntake(){
		FuelIntakeInit();
	}
	private void FuelIntakeInit(){
		m_fuelIntakeMotorController = new CANTalon(RobotMap.FUELINTAKECANTALONID);
		m_fuelIntakeSpeed = 0;
	}
	public void Lift(){
		m_fuelIntakeMotorController.set(m_fuelIntakeSpeed);
	}
	public double getFuelIntakeSpeed() {
		return m_fuelIntakeSpeed;
	}
	public void setFuelIntakeSpeed(double m_fuelIntakeSpeed) {
		this.m_fuelIntakeSpeed = m_fuelIntakeSpeed;
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

