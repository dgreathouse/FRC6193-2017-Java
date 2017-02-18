package org.usfirst.frc.team6193.robot.commands;

import org.usfirst.frc.team6193.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DrivelineCalCommand extends Command {
	double m_time; double m_speed;
    public DrivelineCalCommand(double time, double speed) {
    	m_time = time;
    	m_speed = speed;		
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveline);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveline.Drive(0, m_speed, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (timeSinceInitialized()>m_time)
    		return true;
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
