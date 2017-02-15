package org.usfirst.frc.team6193.robot.commands;

import org.usfirst.frc.team6193.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearHandlerAutoCommand extends Command {

	private double m_spinSpeed;
	private double m_rotateSpeed;
	private int m_currentLimitSpin;
	private int m_currentLimitRotate;
	
	/** Constructor for class
	 * 
     * @param spinSpeed The gears spinner speed to spin -1.0 (CCW) to 1.0 (CW)
     * @param rotateSpeed The rotate speed from -1.0 (CCW) to 1.0 (CW)
     * @param currentLimitSpin The current limit to set on the CANTalon in amps and integer, 1,2,3,4,5...
     * @param currentLimitRotate The current limit to set on the CANTalon in amps and integer, 1,2,3,4,5...
	 * @param timeout The time in seconds to end this command
	 */
    public GearHandlerAutoCommand(double spinSpeed, double rotateSpeed, int currentLimitSpin, int currentLimitRotate, double timeout) {
        super(timeout);
        requires(Robot.gearHandler);
        m_spinSpeed = spinSpeed;
        m_rotateSpeed = rotateSpeed;
        m_currentLimitSpin = currentLimitSpin;
        m_currentLimitRotate = currentLimitRotate;
        		
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.gearHandler.HandleGear(m_spinSpeed, m_rotateSpeed, m_currentLimitSpin, m_currentLimitRotate);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.gearHandler.HandleGear(0,0,10,10);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
