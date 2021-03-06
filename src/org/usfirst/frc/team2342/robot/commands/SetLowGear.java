package org.usfirst.frc.team2342.robot.commands;

import org.usfirst.frc.team2342.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetLowGear extends Command {
	public SetLowGear() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.kPCMHandler);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.kPCMHandler.setLowGear();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
