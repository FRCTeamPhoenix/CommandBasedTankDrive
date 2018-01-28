package org.usfirst.frc.team2342.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveBackward extends CommandGroup {
	
	public DriveBackward(int seconds) {
		addParallel(new DriveBackwardR(seconds));
		addParallel(new DriveBackwardL(seconds));
	}
}
