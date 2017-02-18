package org.usfirst.frc.team4956.robot.commands;

import org.usfirst.frc.team4956.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GearLiftAuton extends Command {
	double direction = 0;
	double seconds = 0;
	Timer timer = new Timer();
	
	//1 is down -1 is up
    public GearLiftAuton(double direction, double seconds) {
    	requires(Robot.gearlift);
    	this.direction = direction; 
    	this.seconds = seconds;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putString("DB/String 8", "FaceTarget Shutdown");
    	Robot.gearlift.setSpeed(0.45 * direction);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (timer.hasPeriodPassed(seconds) 				
        		|| (Robot.gearlift.upperLimitSwitch.get() && direction == -1) 
				 || (Robot.gearlift.lowerLimitSwitch.get() && direction == 1)) 
    		return true;
    	else
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
