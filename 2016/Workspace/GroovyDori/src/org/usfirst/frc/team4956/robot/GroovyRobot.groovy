package org.usfirst.frc.team4956.robot

import org.usfirst.frc.team4956.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.IterativeRobot
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

class GroovyRobot extends IterativeRobot {
	public void robotInit() {
		
		GroovyRobot.drivetrain = new DriveTrain();
		// OI is last since it needs the other subsystems
		oi = new OI();
	 
		
		SmartDashboard.putString("DB/String 1", "");
	}
}
