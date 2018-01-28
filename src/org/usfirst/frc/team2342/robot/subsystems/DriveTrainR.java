/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2342.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrainR extends Subsystem {
	
	TalonSRX motorFR = new TalonSRX(2);
	TalonSRX motorBR = new TalonSRX(4);
	
	public void goForwardR() {
		motorFR.set(ControlMode.PercentOutput, 0.5);
		motorBR.set(ControlMode.PercentOutput, 0.5);
	}
	
	public void goBackwardR() {
		motorFR.set(ControlMode.PercentOutput, -0.5);
		motorBR.set(ControlMode.PercentOutput, -0.5);
	}
	
	public void stopR() {
		motorFR.set(ControlMode.PercentOutput, 0);
		motorBR.set(ControlMode.PercentOutput, 0);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
	}
}
