package org.usfirst.frc.team4956.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MidGear extends CommandGroup {

    public MidGear() {
    	//Goes to target,  drops gear,  drives back
    	addSequential(new AutoDriveStraight(0.5, 3));
    	addSequential(new FaceTarget());
    	addSequential(new AutoTurn(.4, 0.2));
    	addSequential(new AutoDriveStraight(0.4, 1.2));
    	addSequential(new AutoDropGear()); 
    	addSequential(new AutoDriveStraight(-0.5, 1.75));
    	
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
