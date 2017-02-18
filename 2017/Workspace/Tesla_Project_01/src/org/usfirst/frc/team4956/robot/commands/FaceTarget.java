package org.usfirst.frc.team4956.robot.commands;

import org.usfirst.frc.team4956.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class FaceTarget extends Command {

    public FaceTarget() {
    	requires(Robot.drivetrain);
    	requires(Robot.camera);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double centerX = Robot.camera.centerX();

    	double speed = 0.0;
    	double driveSpeed = 0.0;
    	
    	double turn = centerX - (Robot.camera.IMG_WIDTH / 2.0);
    	
       	
    	if (Robot.camera.totalRects() < 2 || Math.abs(turn) > 11) {
    		speed = turn * -0.003225;
    		//speed = turn * -0.0034;
    		
    		// min turn speed
    		if (speed < 0) {
    			speed = -0.28;
    		}	
    		else {
    			speed = 0.28;
    		}
    	}
    	
    	if (Robot.camera.totalWidth() > 130 || Robot.camera.totalRects() == 1) {
    		driveSpeed = 0;
    	}
    	else if (Robot.camera.totalRects() == 2) {
    		driveSpeed = .31;
    	}
    	
    	Robot.drivetrain.arcadeDrive(driveSpeed, speed);
    	//Robot.drivetrain.arcadeDrive(0.0, 0.0);
    	SmartDashboard.putString("DB/String 7", "ts:"+Double.toString(speed)+ ", ds"+driveSpeed);
    	SmartDashboard.putString("DB/String 5", "centerX:"+centerX);
    	SmartDashboard.putString("DB/String 6", "turn:"+turn+" , tw:"+Robot.camera.totalWidth());
    	//SmartDashboard.putString("DB/String 8", Integer.toString(Robot.camera.getNContours()));
    	//SmartDashboard.putString("DB/String 9", "dives speed"+driveSpeed);
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