package org.usfirst.frc.team6193.robot.subsystems;

import org.usfirst.frc.team6193.robot.Robot;
import org.usfirst.frc.team6193.robot.RobotMap;
import org.usfirst.frc.team6193.robot.commands.DrivelineDefaultCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/** Driveline class
 * The driveline uses 4 independent motors with 4 inch mecacnum wheels.<br>
 * The motors are attached to a gearbox with a 8.45:1 gear ratio.<br>
 * A Gyro is available and plugged into the SPI port of the RoboRIO<br><br>
 * 
 * Functionality available for this class are:<br>
 * 1. Drive using a flight stick style joystick.<br>
 * 2. Drive using given X,Y speeds and rotation speed.<br>
 *
 */
public class Driveline extends Subsystem {

	private CANTalon m_drivelineLeftFrontMotorController;
	private CANTalon m_drivelineLRightFrontMotorController;
	private CANTalon m_drivelineLeftRearMotorController;
	private CANTalon m_drivelineRightRearMotorController;
	private RobotDrive m_robotDrive;
	private ADXRS450_Gyro m_gyro;
    // Constructor for class
    public Driveline() {
    	DrivelineInit();
    }

    private void DrivelineInit(){
    	m_drivelineLeftFrontMotorController = new CANTalon(RobotMap.DRIVELINELEFTFRONTCANTALONCANID);
    	m_drivelineLRightFrontMotorController = new CANTalon(RobotMap.DRIVELINERIGHTFRONTCANTALONCANID);
    	m_drivelineLeftRearMotorController = new CANTalon(RobotMap.DRIVELINELEFTREARCANTALONCANID);
    	m_drivelineRightRearMotorController = new CANTalon(RobotMap.DRIVELINERIGHTREARCANTALONCANID);
    	m_gyro = new ADXRS450_Gyro();
    	m_robotDrive = new RobotDrive(m_drivelineLeftFrontMotorController, m_drivelineLeftRearMotorController, m_drivelineLRightFrontMotorController, m_drivelineRightRearMotorController);
    }
    public double getDrivelineAngle(){
    	return m_gyro.getAngle();
    }
    /**
     * Drive using the flightstick style of joystick
     * To rotate the trigger button (1) must be pressed
     */
    public void Drive(){
    	double twist = Robot.oi.MadCatz.getRawAxis(3);
    	if(!Robot.oi.MadCatz.getRawButton(1)){
    		twist = 0;
    	}
    	m_robotDrive.mecanumDrive_Cartesian(Robot.oi.MadCatz.getX(), -Robot.oi.MadCatz.getY(), twist, 0);
    }

    /** Used for Autonomous
     * 
     * @param X Speed to slide left and right
     * @param Y Speed to move forward and backward
     * @param Rotate Speed to rotate
     */
    public void Drive(double X, double Y, double Rotate){
    	m_robotDrive.mecanumDrive_Cartesian(X, Y, Rotate, 0);
    }
    /**
     * Set the default command that will be run in nothing else is using this subsystem
     */
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DrivelineDefaultCommand());
    }


}
