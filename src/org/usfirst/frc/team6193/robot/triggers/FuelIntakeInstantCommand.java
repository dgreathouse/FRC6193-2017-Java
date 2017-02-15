package org.usfirst.frc.team6193.robot.triggers;

import org.usfirst.frc.team6193.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;


/**
 *
 */
public class FuelIntakeInstantCommand extends InstantCommand {

	private double speed;

    public FuelIntakeInstantCommand(double speed) {

        this.speed = speed;

        // Use requires() here to declare subsystem dependencies
        //requires(Robot.fuelIntake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
   		Robot.fuelIntake.setFuelIntakeSpeed(Robot.fuelIntake.getFuelIntakeSpeed() + speed);

    }

    // Called once after timeout
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
