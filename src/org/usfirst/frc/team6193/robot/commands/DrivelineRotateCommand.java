package org.usfirst.frc.team6193.robot.commands;


import org.usfirst.frc.team6193.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DrivelineRotateCommand extends Command {

	private double m_Angle;
	private double m_StartAngle;
	private double m_Speed;
	
	/** Constructor for class
	 * 
	 * @param angle The Angle in degrees to rotate from 0 to 720
	 * @param speed The speed to rotate from -1.0 CCW to 1.0 CW
	 * @param timeout The time to end if the angle is not reached. i.e. Stuck on a wall and can not reach the angle
	 */
    public DrivelineRotateCommand(double angle, double speed, double timeout) {
        // Use requires() here to declare subsystem dependencies
    	super(timeout);
        requires(Robot.driveline);
        m_Angle = angle;
        m_Speed = speed;

    }

    // Called just before this Command runs the first time
    protected void initialize() {
        m_StartAngle = Robot.driveline.getDrivelineAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveline.Drive(0, 0, m_Speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double currentAngle = Robot.driveline.getDrivelineAngle();
    	if(currentAngle > m_StartAngle + m_Angle || currentAngle < m_StartAngle - m_Angle){
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveline.Drive(0, 0, 0);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
