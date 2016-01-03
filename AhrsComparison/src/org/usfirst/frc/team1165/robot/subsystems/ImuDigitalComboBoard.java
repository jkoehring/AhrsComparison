package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.commands.CalibrateImuGyro;
import org.usfirst.frc.team1165.robot.commands.Reporter;
import org.usfirst.frc.team1165.robot.commands.ResetImuGyro;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.ITG3200;
import edu.wpi.first.wpilibj.ITG3200.GyroAxis;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * A subsystem that provides access to the accelerometer and gyroscope on
 * the 6 DoF IMU Digital Combo Board.
 */
public class ImuDigitalComboBoard extends ReportableSubsystem
{
	private ITG3200 gyro;
	
	private GyroAxis zGyro;
		
	private final double GYRO_CALIBRATION_TIME = 3.0; // seconds
	
	public ImuDigitalComboBoard(I2C.Port port, DigitalInput interrupt)
	{
		gyro = new ITG3200(port, interrupt, false);
		zGyro = gyro.getZGyro();
	}
	
	/**
	 * Re-calibrates the gyroscope.
	 */
	public void calibrateGyro()
	{
		gyro.calibrate(GYRO_CALIBRATION_TIME);
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand()
	{
		setDefaultCommand(new Reporter(this));
		//SmartDashboard.putData("Calibrate IMU Gyro", new CalibrateImuGyro(this));
		SmartDashboard.putData("Reset IMU Heading", new ResetImuGyro(this));
	}
	
	public void report()
	{
		SmartDashboard.putNumber("IMU Heading", zGyro.getAngle());
	}
	
	/**
	 * Resets all gyro axes angles to 0.
	 */
	public void resetGyro()
	{
		gyro.reset();
	}
}
