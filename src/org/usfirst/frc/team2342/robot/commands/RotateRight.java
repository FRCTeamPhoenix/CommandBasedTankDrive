package org.usfirst.frc.team2342.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RotateRight extends CommandGroup {
	
	public RotateRight(int seconds) {
		addParallel(new DriveForwardL(seconds));
		addParallel(new DriveBackwardR(seconds));
	}
}
