package org.usfirst.frc4930.Kermit.commands;

import org.usfirst.frc4930.Kermit.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClawClose extends Command {
	 public ClawClose() {
		    requires(Robot.claw);
		  }

		  protected void initialize() {
			    Robot.claw.close();
			    new Intake(2, 1.0).start();
		  }

		  protected void execute() {
		  }

		  protected boolean isFinished() {
			  return Robot.inAuto;
		  }

		  protected void end() {
			  Robot.gripper.stop();
		  }

		  protected void interrupted() {
		    end();
		  }
}
