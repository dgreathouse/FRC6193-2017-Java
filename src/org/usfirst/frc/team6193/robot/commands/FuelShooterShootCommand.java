package org.usfirst.frc.team6193.robot.commands;

import org.usfirst.frc.team6193.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FuelShooterShootCommand extends Command {

	private double m_speed;
	private double m_angle;
	private boolean m_loaderActive_1;
	private boolean m_loaderActive_2;
	private boolean m_loaderActive_3;	
	private boolean m_loaderActive_4;

	/** Constructor for class
	 * 
	 * @param speed Speed of the shooters from -1.0 to 1.0
	 * @param angle Angle of the deflector from ? to ?
	 * @param loaderActive_1 boolean to have Loader 1 active
	 * @param loaderActive_2 boolean to have Loader 2 active
	 * @param loaderActive_3 boolean to have Loader 3 active
	 * @param loaderActive_4 boolean to have Loader 4 active
	 * @param timeout Number of seconds to shoot.
	 */
	public FuelShooterShootCommand(double speed, double angle, boolean loaderActive_1, boolean loaderActive_2,
			boolean loaderActive_3, boolean loaderActive_4, double timeout) {

		super(timeout);
		requires(Robot.fuelShooter);
		m_speed = speed;
		m_angle = angle;
		m_loaderActive_1 = loaderActive_1;
		m_loaderActive_2 = loaderActive_2;
		m_loaderActive_3 = loaderActive_3;
		m_loaderActive_4 = loaderActive_4;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.fuelShooter.Shoot(m_angle, m_speed, m_loaderActive_1, m_loaderActive_2, m_loaderActive_3,
				m_loaderActive_4);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {

		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {

	}
}
