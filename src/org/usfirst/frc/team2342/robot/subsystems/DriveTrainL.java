package org.usfirst.frc.team2342.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrainL extends Subsystem {

	TalonSRX motorBL = new TalonSRX(1);
	TalonSRX motorFL = new TalonSRX(3);
	public boolean executingCommand = false;

	double maxPower = 0.5;

	public void goForwardL() {
		motorFL.set(ControlMode.PercentOutput, -0.5);
		motorBL.set(ControlMode.PercentOutput, -0.5);
		executingCommand = true;
	}

	public void goBackwardL() {
		motorFL.set(ControlMode.PercentOutput, 0.5);
		motorBL.set(ControlMode.PercentOutput, 0.5);
		executingCommand = true;

	}

	public void goL(double power) {
		motorFL.set(ControlMode.PercentOutput, -power * maxPower);
		motorBL.set(ControlMode.PercentOutput, -power * maxPower);
		executingCommand = true;
	}

	public void stopL() {
		motorFL.set(ControlMode.PercentOutput, 0);
		motorBL.set(ControlMode.PercentOutput, 0);
		executingCommand = false;
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
