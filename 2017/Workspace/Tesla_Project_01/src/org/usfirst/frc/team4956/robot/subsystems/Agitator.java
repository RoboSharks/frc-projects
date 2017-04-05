package org.usfirst.frc.team4956.robot.subsystems;

import org.usfirst.frc.team4956.robot.RobotMap;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Agitator extends Subsystem {
	CANTalon ballAgitatorMotor;

    public void initDefaultCommand() {
    	
    }
    
    public Agitator() {
    	ballAgitatorMotor = new CANTalon(RobotMap.ballAgitatorMotor);
    	
    }
    public void setSpeed(double speed) {
    	ballAgitatorMotor.set(speed); 
    
    	 
    }
}

