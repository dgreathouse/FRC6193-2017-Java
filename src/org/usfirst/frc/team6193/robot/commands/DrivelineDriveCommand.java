package org.usfirst.frc.team6193.robot.commands;

import org.usfirst.frc.team6193.robot.InterpolateGetTime;
import org.usfirst.frc.team6193.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DrivelineDriveCommand extends Command {

	private double m_Distance;
	private double m_Speed;
	private InterpolateGetTime m_Interpolate;
	/**  Constructor for class
	 * 
	 * @param distance The distance to travel in inches
	 * @param speed The speed to travel from -1.0 (Backwards) to 1.0 (Forwards)
	 */
    public DrivelineDriveCommand(double distance, double speed) {

        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveline);
        m_Interpolate = new InterpolateGetTime();
        m_Distance = distance;
        m_Speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveline.Drive(0.0, m_Speed, 0.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(timeSinceInitialized() > m_Interpolate.getTimeDrive(m_Distance,m_Speed)){
    		return true;
    	}
    	
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveline.Drive(0,0,0);
    	
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
