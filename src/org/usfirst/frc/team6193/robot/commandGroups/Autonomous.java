package org.usfirst.frc.team6193.robot.commandGroups;

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
    	case 0: // Default, do nothing
    		// SAMPLE CODE, Remove when plays are complete
    		addSequential(new DrivelineDriveCommand(48,0.6));
    		addSequential(new DrivelineSlideCommand(48, -0.6));
    		addSequential(new DrivelineRotateCommand(45, 0.4, 2));
    		addSequential(new FuelShooterShootCommand(0.6, 0.1, true, false, true, false, 7.0));
    		addSequential(new GearHandlerAutoCommand(0.4, 0.5, 4, 4, 5));
    		break;
    	case 10: // Position 1 play 1
    		break;
    	case 15: // Position 1 play 5 on opposite side
    		break;
    	case 20: // Position 2 play 1
    		break;
    	case 25: // Position 2 play 5 on opposite side
    		break;
    	case 30: // Position 3 play 1
    		break;
    	case 35: // Position 3 play 5 on opposite side
    		break;
    		
    	}
    }
}
