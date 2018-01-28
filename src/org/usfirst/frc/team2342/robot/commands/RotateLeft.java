package org.usfirst.frc.team2342.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RotateLeft extends CommandGroup {
	
	public RotateLeft(int seconds) {
		addParallel(new DriveForwardR(seconds));
		addParallel(new DriveBackwardL(seconds));
	}
}
