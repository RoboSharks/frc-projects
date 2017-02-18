package org.usfirst.frc.team4956.robot.subsystems;

import org.usfirst.frc.team4956.robot.RobotMap;
import org.usfirst.frc.team4956.robot.commands.BallSpinControlWithJoystick;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;


public class BallSpinner extends Subsystem {
	CANTalon motor1;
	CANTalon motor2;
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new BallSpinControlWithJoystick());
    }
    
    public BallSpinner() {
    	motor1 = new CANTalon(RobotMap.ballSpinMotor1);
    	motor2 = new CANTalon(RobotMap.ballSpinMotor2);
    }
    public void setSpeed(double speed) {
    	motor1.set(speed);
    	motor2.set(speed);
    }
}

	

