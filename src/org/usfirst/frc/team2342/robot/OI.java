/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2342.robot;

import org.usfirst.frc.team2342.robot.commands.DriveBackward;
import org.usfirst.frc.team2342.robot.commands.DriveForward;
import org.usfirst.frc.team2342.robot.commands.RotateLeft;
import org.usfirst.frc.team2342.robot.commands.RotateRight;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI { //8 forward, 9 backward
	Joystick stick = new Joystick(2);
	
	Button forwardButton = new JoystickButton(stick, 8);
	Button backwardButton = new JoystickButton(stick, 9);
	Button rotateLeft = new JoystickButton(stick, 6);
	Button rotateRight = new JoystickButton(stick, 11);
	
	public OI() {
		forwardButton.whenPressed(new DriveForward(3));   //Button 8
		backwardButton.whenPressed(new DriveBackward(3));  //Button 9
		rotateLeft.whenPressed(new RotateLeft(3));       //Button 6
		rotateRight.whenPressed(new RotateRight(3));      //Button 11
	}

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
