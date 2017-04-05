package org.usfirst.frc.team4956.robot.commands;

import org.usfirst.frc.team4956.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BallSpinControlWithJoystick extends Command {

    public BallSpinControlWithJoystick() {
    	requires(Robot.ballspinner);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.oi.ballForward.get()) {
    		Robot.ballspinner.forward();
    		Robot.agitator.setSpeed(1);
    	}
    	else if (Robot.oi.ballBackward.get()) {
    		Robot.ballspinner.reverse();
    		Robot.agitator.setSpeed(1);
    	}
    	else {
    		Robot.ballspinner.off();
    		Robot.agitator.setSpeed(0);
    	}
    	
    	//Robot.ballspinner.reverse();
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
