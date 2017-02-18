package org.usfirst.frc.team4956.robot.subsystems;

import org.usfirst.frc.team4956.robot.RobotMap;
import org.usfirst.frc.team4956.robot.commands.GearLifter;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearLift extends Subsystem {
	CANTalon gear_motor;


    public void initDefaultCommand() {
    	setDefaultCommand(new GearLifter()); 
    }
    
    public GearLift() {
    	super();
    	gear_motor = new CANTalon(RobotMap.liftMotor);
    }
    
    public void setSpeed(double speed) {
    	gear_motor.set(speed);
    }
    
}

