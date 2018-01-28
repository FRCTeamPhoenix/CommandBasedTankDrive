package org.usfirst.frc.team2342.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveForward extends CommandGroup {
	
	public DriveForward(int seconds) {
		System.out.println("Debug: made it to DriveForward command group");
		
		addParallel(new DriveForwardR(seconds));
		addParallel(new DriveForwardL(seconds));
	}
}
