package org.usfirst.frc.team4956.robot.commands;

import org.usfirst.frc.team4956.robot.Robot;
import org.usfirst.frc.team4956.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GearLifter extends Command {
	Timer timer = new Timer();
	boolean isTraveling = false;
	boolean up = false;
	double travelTime = 2;
	
    public GearLifter() {
    	requires(Robot.gearlift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	int POV = Robot.oi.supportStick.getPOV(); 
    	if (!isTraveling) {
	    	if ((POV == 0 || POV == 315 || POV == 45) && !up) {
	    		timer.reset();
	        	timer.start();
	        	up = true;
	        	isTraveling = true;
	    	}
	    	else if ((POV == 180 || POV == 225 || POV == 135) && up) {
	    		timer.reset();
	        	timer.start();
	        	up = false;
	        	isTraveling = true;
	    	}
    		else {
    			Robot.gearlift.setSpeed(0);
    		}
    	}
    	else {
    		if (timer.hasPeriodPassed(travelTime)) {
    			isTraveling = false;
    		}
    		else if (up) {
    			Robot.gearlift.setSpeed(-0.45);
    		}
    		else {
    			Robot.gearlift.setSpeed(.45);
    		}
    		
    	}
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
