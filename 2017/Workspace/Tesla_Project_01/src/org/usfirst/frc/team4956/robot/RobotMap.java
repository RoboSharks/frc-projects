package org.usfirst.frc.team4956.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//drive Tesla
	public static int frontLeftMotor = 7, backLeftMotor = 8;
	public static int frontRightMotor = 6, backRightMotor = 5;
	
	//drive Edison
	public static int edFrontLeftMotor = 0, edFrontRightMotor = 1;
	
	//drive settings
	public static int maxSpeed = 3, minSpeed = 2; //max x min is b
	public static int invertDirection = 1;
	public static double maxSpeedPercent = 1;
	public static double normalSpeedPercent = 0.85;
	public static double minSpeedPercent = 0.6;
	
	//rope
	public static int ropeClimberMotor1 = 1, ropeClimberMotor2 = 4;
	public static int fastRope = 1;
	//lift motor
	public static int liftMotor = 3;
	
	//lift gear controller 
	public static int gearLiftAxis = 4;
	
	//controllers
	public static int driverStick = 1, supportStick = 2;
	public static int leftStickX = 0;
	public static int rightTrigger = 3, leftTrigger = 2;

	//ball spin
	public static int ballSpinForward = 5, ballSpinBackward = 6;
	public static int ballSpinMotor1 = 3, ballSpinMotor2 = 2; 
		
}
