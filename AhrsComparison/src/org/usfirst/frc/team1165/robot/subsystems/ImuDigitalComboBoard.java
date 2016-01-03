package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.commands.CalibrateImuGyro;
import org.usfirst.frc.team1165.robot.commands.Reporter;
import org.usfirst.frc.team1165.robot.commands.ResetImuGyro;
import org.usfirst.frc.team1165.wpilibj.ADXL345_I2C;

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
	private ADXL345_I2C accelerometer;
	private ITG3200 gyro;
	
	private GyroAxis xGyro;
	private GyroAxis yGyro;
	private GyroAxis zGyro;
		
	private final double GYRO_CALIBRATION_TIME = 3.0; // seconds
	
	public ImuDigitalComboBoard(I2C.Port port, DigitalInput interrupt)
	{
		accelerometer = new ADXL345_I2C(port, Accelerometer.Range.k16G, true);
		gyro = new ITG3200(port, interrupt, false);
		
		xGyro = gyro.getXGyro();
		yGyro = gyro.getYGyro();
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
		SmartDashboard.putData("Calibrate IMU Gyro", new CalibrateImuGyro(this));
		SmartDashboard.putData("Reset IMU Gyro", new ResetImuGyro(this));
	}
	
	public void report()
	{
		if (accelerometer != null)
		{
			/*
			SmartDashboard.putNumber("IMU Accel X", accelerometer.getX());
			SmartDashboard.putNumber("IMU Accel Y", accelerometer.getY());
			SmartDashboard.putNumber("IMU Accel Z", accelerometer.getZ());
			*/
		}
		
		if (gyro != null)
		{
			/*
			SmartDashboard.putNumber("IMU Gyro Rate X", xGyro.getRate());
			SmartDashboard.putNumber("IMU Gyro Rate Y", yGyro.getRate());
			SmartDashboard.putNumber("IMU Gyro Rate Z", zGyro.getRate());
			*/
			/*
			SmartDashboard.putNumber("IMU Gyro Angle X", xGyro.getAngle());
			SmartDashboard.putNumber("IMU Gyro Angle Y", yGyro.getAngle());
			*/
			SmartDashboard.putNumber("IMU Gyro Angle Z", zGyro.getAngle());
				
			/*
			SmartDashboard.putNumber("IMU Gyro Sample Rate", gyro.getMeasuredSampleRate());
			*/
		}
	}
	
	/**
	 * Resets all gyro axes angles to 0.
	 */
	public void resetGyro()
	{
		gyro.reset();
	}
}
