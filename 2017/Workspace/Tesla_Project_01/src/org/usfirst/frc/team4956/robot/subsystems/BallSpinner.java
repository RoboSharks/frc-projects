package org.usfirst.frc.team4956.robot.subsystems;

import org.usfirst.frc.team4956.robot.commands.BallSpinControlWithJoystick;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;


public class BallSpinner extends Subsystem {
	Relay relay1;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new BallSpinControlWithJoystick());
    }
    
    public BallSpinner() {
    	relay1 = new Relay(0);
    	off();
    }
    public void forward() {
    	relay1.set(Relay.Value.kForward);
    }
    public void reverse() {
    	relay1.set(Relay.Value.kReverse);
    }
    public void off() {
    	relay1.set(Relay.Value.kOff);
    }
    
}
