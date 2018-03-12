package org.usfirst.frc4930.Kermit.commands;

import org.usfirst.frc4930.Kermit.Constants;
import org.usfirst.frc4930.Kermit.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class HoldCube extends Command {

    public HoldCube() {
        requires(Robot.gripper);
    }

    protected void initialize() {
    }

    protected void execute() {
    	if(!Robot.clawOpen) {
        	Robot.gripper.grip(Constants.GRIPPER_HOLD_SPD);
    	} else {
    		Robot.gripper.stop();
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.gripper.stop();
    }

    protected void interrupted() {
    	end();
    }
}
