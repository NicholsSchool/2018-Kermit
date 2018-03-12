package org.usfirst.frc4930.Kermit.autonomous;

import org.usfirst.frc4930.Kermit.Robot;
import org.usfirst.frc4930.Kermit.commands.MoveArm;

import edu.wpi.first.wpilibj.command.Command;


public class ArmToPosition extends Command {
	
	private int position;
	private double speed;

    public ArmToPosition(int position, double speed) {
    	requires(Robot.arm);
    	this.position = position;
    	this.speed = speed;
    }

    protected void initialize() {
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return Robot.arm.moveToPosition(position, speed);
    }

    protected void end() {
   // 	new MoveArm().start();
    }

    protected void interrupted() {
    	end();
    }
}
