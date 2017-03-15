package org.usfirst.frc.team4956.robot.subsystems;

import org.usfirst.frc.team4956.robot.RobotMap;
import org.usfirst.frc.team4956.robot.commands.GearLiftWithJoystick;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearLift extends Subsystem {
	CANTalon gear_motor;
	public DigitalInput upperLimitSwitch;
	public DigitalInput lowerLimitSwitch;

    public void initDefaultCommand() {
    	setDefaultCommand(new GearLiftWithJoystick()); 
    }
    
    public GearLift() {
    	super();
    	gear_motor = new CANTalon(RobotMap.liftMotor);
    	upperLimitSwitch = new DigitalInput(0);
    	lowerLimitSwitch = new DigitalInput(1);
    }
    
    public void setSpeed(double speed) {
    	if (upperLimitSwitch.get() && speed < 0) {
    		gear_motor.set(0);
    	}
    	else if (lowerLimitSwitch.get() && speed > 0) {
    		gear_motor.set(0);
    	}
    	else 
    		gear_motor.set(speed);
    }
}
