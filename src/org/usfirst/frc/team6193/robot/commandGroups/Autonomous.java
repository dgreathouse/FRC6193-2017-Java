package org.usfirst.frc.team6193.robot.commandGroups;

import org.usfirst.frc.team6193.robot.commands.DrivelineCalCommand;
import org.usfirst.frc.team6193.robot.commands.DrivelineDriveCommand;
import org.usfirst.frc.team6193.robot.commands.DrivelineRotateCommand;
import org.usfirst.frc.team6193.robot.commands.DrivelineSlideCommand;
import org.usfirst.frc.team6193.robot.commands.FuelShooterShootCommand;
import org.usfirst.frc.team6193.robot.commands.GearHandlerAutoCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Autonomous extends CommandGroup {
	// Constructor for class
    public Autonomous() {
    	
    }
    public void AutonomousInit(){
    	int Auto = (int)SmartDashboard.getNumber("Auto", 0);
    	switch(Auto){
    	case 100:
    		addSequential(new DrivelineCalCommand(5,0.1));
    		break;
    	case 102:
    		addSequential(new DrivelineCalCommand(5,0.2));
    		break;
    	case 10: // Position 1R Play 1
    		addSequential(new FuelShooterShootCommand(0.6, 0.1, true, false, true, false, 7.0));
    		addSequential(new DrivelineSlideCommand(48, -0.6));
    		addSequential(new DrivelineRotateCommand(45, 0.4, 2));
    		addSequential(new DrivelineDriveCommand(48,0.6));
    		addSequential(new DrivelineRotateCommand(45, 0.4, 2));
    		addSequential (new DrivelineDriveCommand(45,0.5));
    		addSequential (new DrivelineDriveCommand(45,0.5));
    		break;
    	case 20: // Position 2R Play 1
    		addSequential (new FuelShooterShootCommand(0.5,0.1,true,true,true,true, 7.0) );
    		addSequential (new DrivelineSlideCommand(48,0.5));
    		addSequential (new DrivelineRotateCommand(45,0.5,2));
    		addSequential (new DrivelineDriveCommand(45,0.5));
    		addSequential (new DrivelineDriveCommand(45,0.5));
    		break;
    	case 30: // Position 3R Play 1
    		addSequential (new FuelShooterShootCommand(0.5,0.1,true,true,true,true, 7.0) );
    		addSequential (new DrivelineSlideCommand(48,0.5));
    		addSequential (new DrivelineRotateCommand(45,0.5,2));
    		addSequential (new DrivelineDriveCommand(45,0.5));
    		addSequential (new DrivelineDriveCommand(45,0.5));
    		break;
    	case 16: // Position 1L Play 1
    		addSequential (new FuelShooterShootCommand(0.5,0.1,true,true,true,true, 7.0) );
    		addSequential (new DrivelineSlideCommand(48,0.5));
    		addSequential (new DrivelineRotateCommand(45,0.5,2));
    		addSequential (new DrivelineDriveCommand(45,0.5));
    		addSequential (new DrivelineRotateCommand(48,0.5, 2));
    		addSequential (new DrivelineDriveCommand(45,0.5));
    		addSequential (new DrivelineDriveCommand(45,0.5));
    		break;
    	case 26: // Position 2L play 1
    		addSequential (new FuelShooterShootCommand(0.5,0.1,true,true,true,true, 7.0) );
    		addSequential (new DrivelineSlideCommand(48,0.5));
    		addSequential (new DrivelineRotateCommand(45,0.5,2));
    		addSequential (new DrivelineDriveCommand(45,0.5));
    		addSequential (new DrivelineDriveCommand(45,0.5));
    		break;
    	case 36: // Position 2L play 5 on opposite side
    		addSequential (new FuelShooterShootCommand(0.5,0.1,true,true,true,true, 7.0) );
    		addSequential (new DrivelineSlideCommand(48,0.5));
    		addSequential (new DrivelineRotateCommand(45,0.5,2));
    		addSequential (new DrivelineDriveCommand(45,0.5));
    		addSequential (new DrivelineDriveCommand(45,0.5));
    		break;
    	
    		
    	}
    }
}
