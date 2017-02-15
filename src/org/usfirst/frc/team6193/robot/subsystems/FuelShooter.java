package org.usfirst.frc.team6193.robot.subsystems;

import org.usfirst.frc.team6193.robot.Cals;
import org.usfirst.frc.team6193.robot.Robot;
import org.usfirst.frc.team6193.robot.RobotMap;
import org.usfirst.frc.team6193.robot.commands.FuelShooterDefaultCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/** FuelShooter class
 * The fuel shooter 1 or 2 motors to spin four 4 inch wheels at high speed. These <br>
 * high speed wheels are used to make the fuel travel on 90 degree arc and shoot straight up.<br>
 * Two servos are used to move a deflector panel to angle the ball trajectory in front of the robot.<br>
 * Four other small motors are used to hold the fuel back from the high speed spinners until the<br>
 * drivers decide to allow the small motors to spin and load a ball into the high speed spinner.<br><br>
 * 
 * The Drivers have control of the deflector angle and speed of the high speed spinners. The drivers also<br>
 * control which loader is actively turning to load fuel. <br><br>
 * 
 * Functionality of the FuelShooter class<br>
 * 1. Shoot the ball using information from the drive station and the driver joystick throttle<br>
 * 2. Shoot the ball using autonomous information as arguments for <br>
 *    Angle<br>
 *    Speed<br>
 *    1-4 active loader booleans<br>
 */
public class FuelShooter extends Subsystem {

	private CANTalon m_FuelShooter1MotorController;
	private CANTalon m_FuelShooter2MotorController;
	private VictorSP m_FuelLoader1MotorController;
	private VictorSP m_FuelLoader2MotorController;
	private Spark m_FuelLoader3MotorController;
	private Spark m_FuelLoader4MotorController;
	private Servo m_FuelDeflectorServo1;
	private Servo m_FuelDeflectorServo2;
	// Constructor for class
	public FuelShooter(){
		FuelShooterInit();
	}
	

    private void FuelShooterInit() {
		m_FuelShooter1MotorController = new CANTalon(RobotMap.FUELSHOOTER1CANTALONCANID);
		m_FuelShooter2MotorController = new CANTalon(RobotMap.FUELSHOOTER2CANTALONCANID);
		m_FuelLoader1MotorController = new VictorSP(RobotMap.FUELLOADER1VICTORSPPWMPORT);
		m_FuelLoader2MotorController = new VictorSP(RobotMap.FUELLOADER2VICTORSPPWMPORT);
		m_FuelLoader3MotorController = new Spark(RobotMap.FUELLOADER3SPARKPWMPORT);
		m_FuelLoader4MotorController = new Spark(RobotMap.FUELLOADER4SPARKPWMPORT);
		m_FuelDeflectorServo1 = new Servo(RobotMap.FUELSHOOTERDEFELCTORSERVO1PWMPORT);
		m_FuelDeflectorServo2 = new Servo(RobotMap.FUELSHOOTERDEFELCTORSERVO2PWMPORT);
		
	}
    public void Shoot(){
    	
    	double angle = SmartDashboard.getNumber("DeflectorAngle", Cals.k_fuelShooterDefaultDeflectorAngle);
    	Deflect(angle);
    	boolean active_1 = SmartDashboard.getBoolean("FuelShooterActive_1", false);
    	boolean active_2 = SmartDashboard.getBoolean("FuelShooterActive_2", false);
    	boolean active_3 = SmartDashboard.getBoolean("FuelShooterActive_3", false);
    	boolean active_4 = SmartDashboard.getBoolean("FuelShooterActive_4", false);
    	double speed = Robot.oi.MadCatz.getRawAxis(4);
    	Spin(speed);
    	Load(active_1,active_2,active_3,active_4);
    }
    /**
     * 
     * @param angle The angle of the deflector
     * @param speed The speed of the spinners from -1.0 to 1.0
     * @param active_1 true if loader 1 should be running
     * @param active_2 true if loader 2 should be running
     * @param active_3 true if loader 3 should be running
     * @param active_4 true if loader 4 should be running
     */
    public void Shoot(double angle, double speed, boolean active_1, boolean active_2, boolean active_3, boolean active_4){
    	Deflect(angle);
    	Spin(speed);
    	Load(active_1,active_2,active_3,active_4);
    }
    public void Deflect(double angle){
    	if(angle > Cals.k_fuelShooterDeflectorAngleMax || angle < Cals.k_fuelShooterDeflectorAngleMin){
    		m_FuelDeflectorServo1.setPosition(angle);
    		m_FuelDeflectorServo2.setPosition(angle);
    	}
    }
    public void Spin(double speed){
    	m_FuelShooter1MotorController.set(speed);
    	m_FuelShooter2MotorController.set(speed);
    }
    
    public void Load(boolean active_1, boolean active_2, boolean active_3, boolean active_4){
    	if(active_1){
    		m_FuelLoader1MotorController.set(Cals.k_fuelLoaderSingleLoaderSpeed);
    	}else {
    		m_FuelLoader1MotorController.set(Cals.k_fuelLoaderReverseSpeed);
    	}
    	if(active_2){
    		m_FuelLoader2MotorController.set(Cals.k_fuelLoaderSingleLoaderSpeed);
    	}else {
    		m_FuelLoader2MotorController.set(Cals.k_fuelLoaderReverseSpeed);
    	}
    	if(active_3){
    		m_FuelLoader3MotorController.set(Cals.k_fuelLoaderSingleLoaderSpeed);
    	}else {
    		m_FuelLoader3MotorController.set(Cals.k_fuelLoaderReverseSpeed);
    	}
    	if(active_4){
    		m_FuelLoader4MotorController.set(Cals.k_fuelLoaderSingleLoaderSpeed);
    	}else {
    		m_FuelLoader4MotorController.set(Cals.k_fuelLoaderReverseSpeed);
    	}
    }

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new FuelShooterDefaultCommand());
    }
}

