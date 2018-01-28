package org.usfirst.frc.team2342.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrainL extends Subsystem {
	
	TalonSRX motorBL = new TalonSRX(1);
	TalonSRX motorFL = new TalonSRX(3);
	
	public void goForwardL() {
		motorFL.set(ControlMode.PercentOutput, -0.5);
		motorBL.set(ControlMode.PercentOutput, -0.5);
	}
	
	public void goBackwardL() {
		motorFL.set(ControlMode.PercentOutput, 0.5);
		motorBL.set(ControlMode.PercentOutput, 0.5);
	}
	
	public void stopL() {
		motorFL.set(ControlMode.PercentOutput, 0);
		motorBL.set(ControlMode.PercentOutput, 0);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
