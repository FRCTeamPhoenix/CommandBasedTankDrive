/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2342.robot;

import org.usfirst.frc.team2342.robot.commands.DriveForwardR;
import org.usfirst.frc.team2342.robot.commands.DriveL;
import org.usfirst.frc.team2342.robot.commands.DriveR;
import org.usfirst.frc.team2342.robot.subsystems.DriveTrainL;
import org.usfirst.frc.team2342.robot.subsystems.DriveTrainR;
import org.usfirst.frc.team2342.robot.subsystems.PCMHandler;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	public static final DriveTrainR kDriveTrainR = new DriveTrainR();
	public static final DriveTrainL kDriveTrainL = new DriveTrainL();
	public static final PCMHandler kPCMHandler = new PCMHandler();

	public static final Joystick kLeftJoystick = new Joystick(2);
	public static final Joystick kRightJoystick = new Joystick(1);

	public static OI m_oi;

	Command m_autonomousCommand;

	SendableChooser<Command> m_chooser = new SendableChooser<>();

	@Override
	public void robotInit() {
		m_oi = new OI();
		m_chooser.addDefault("Drive", new DriveForwardR(3));
		// chooser.addObject("My Auto", new MyAutoCommand());

		System.out.println("Debug: made it to robotInit");
	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString code to get the
	 * auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons to
	 * the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		 * switch(autoSelected) { case "My Auto": autonomousCommand = new
		 * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
		 * ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		if (Math.abs(kLeftJoystick.getY()) > 0.05) {
			Command driveL = new DriveL(kLeftJoystick.getY());
			driveL.start();
		} else if (kDriveTrainL.executingCommand) {
			Command driveL = new DriveL(0.0);
			driveL.start();
			kDriveTrainL.executingCommand = false;
		}

		if (Math.abs(kRightJoystick.getY()) > 0.05) {
			Command driveR = new DriveR(kRightJoystick.getY());
			driveR.start();
		} else if (kDriveTrainR.executingCommand) {
			Command driveR = new DriveR(0.0);
			driveR.start();
			kDriveTrainR.executingCommand = false;
		}

		SmartDashboard.putString("DB/String 0", "Right: " + kRightJoystick.getY());
		SmartDashboard.putString("DB/String 1", "Left: " + kLeftJoystick.getY());

		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
