
package org.usfirst.frc.team6193.robot;

import org.usfirst.frc.team6193.robot.commandGroups.Autonomous;
import org.usfirst.frc.team6193.robot.subsystems.Driveline;
import org.usfirst.frc.team6193.robot.subsystems.FuelIntake;
import org.usfirst.frc.team6193.robot.subsystems.FuelShooter;
import org.usfirst.frc.team6193.robot.subsystems.GearHandler;
import org.usfirst.frc.team6193.robot.subsystems.RopeClimber;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {

	public static OI oi;
	public static Driveline driveline;
	public static FuelIntake fuelIntake;
	public static FuelShooter fuelShooter;
	public static RopeClimber ropeClimber;
	public static GearHandler gearHandler;
	public Autonomous auto;
	
	@Override
	public void robotInit() {
		oi = new OI();
		driveline = new Driveline();
		fuelIntake = new FuelIntake();
		fuelShooter = new FuelShooter();
		ropeClimber = new RopeClimber();
		gearHandler = new GearHandler();
		CameraServer.getInstance().startAutomaticCapture();
		CameraServer.getInstance().addAxisCamera("10.61.93.11");
		auto = new Autonomous();
	}


	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}


	@Override
	public void autonomousInit() {
		auto.AutonomousInit();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().removeAll();
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
