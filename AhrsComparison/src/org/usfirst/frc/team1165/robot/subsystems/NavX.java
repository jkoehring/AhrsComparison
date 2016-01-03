package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.commands.Reporter;
import org.usfirst.frc.team1165.robot.commands.ResetNavXHeading;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * A subsystem that provides access to the navX-MXP.
 */
public class NavX extends ReportableSubsystem
{
	private AHRS ahrs;
	
	public NavX()
	{
        ahrs = new AHRS(SPI.Port.kMXP);
        resetHeading();
	}
	
	/**
	 * Re-calibrates the navX.
	 */
	public void calibrate()
	{
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand()
	{
		setDefaultCommand(new Reporter(this));
		SmartDashboard.putData("Reset navX Heading", new ResetNavXHeading(this));
	}
	
	public void report()
	{
		SmartDashboard.putNumber("navX Heading", ahrs.getAngle());
	}
	
	/**
	 * Resets the .
	 */
	public void resetHeading()
	{
		ahrs.reset();
	}
}
