package org.usfirst.frc.team1165.robot.commands;


import org.usfirst.frc.team1165.robot.subsystems.NavX;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Resets the gyroscope on an IMU Digital Combo Board.
 */
public class ResetNavXHeading extends Command
{
	private NavX ahrs;
	
	public ResetNavXHeading(NavX ahrs)
	{
		this.ahrs = ahrs;
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		ahrs.resetHeading();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return true;
	}

	// Called once after isFinished returns true
	protected void end()
	{
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
	}
}
