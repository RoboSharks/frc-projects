package org.usfirst.frc.team4956.robot.subsystems;


import org.usfirst.frc.team4956.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;

public class EdDriveTrain extends DriveTrain {
    
	Talon front_left_motor, front_right_motor;
	public Encoder left_encoder, right_encoder;
	boolean fast = false;

	public EdDriveTrain() {
		super();
	}
	
	public void  initMotors() {
		front_left_motor = new Talon(RobotMap.edFrontLeftMotor);
		front_right_motor = new Talon(RobotMap.edFrontRightMotor);
		
		drive = new RobotDrive(front_left_motor,front_right_motor);
		
		// This is sensitivity.
		drive.setMaxOutput(RobotMap.normalSpeedPercent);
	}
	
	public void initEncoders() {
		//Ed has no encoders
	}
    
    
	//Reset the robots sensors to the zero states.
	 
	public void reset() {
		//gyro.reset();
		//left_encoder.reset();
		//right_encoder.reset();
	}
	
	
	//The log method puts interesting information to the SmartDashboard.
	public void log() {
	
	}
	
}