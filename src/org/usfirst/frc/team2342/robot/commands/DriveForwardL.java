package org.usfirst.frc.team2342.robot.commands;

import org.usfirst.frc.team2342.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForwardL extends Command {
	public DriveForwardL(int seconds) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.kDriveTrainL);
		setTimeout(seconds);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.kDriveTrainL.goForwardL();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.kDriveTrainL.stopL();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
