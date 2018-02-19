package org.usfirst.frc4930.Kermit.commands;

import org.usfirst.frc4930.Kermit.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClawOpen extends Command{
	  public ClawOpen() {
		    requires(Robot.claw);
		  }

		  protected void initialize() {}

		  protected void execute() {
		    Robot.claw.toggle();
		  }

		  protected boolean isFinished() {
		    return true;
		  }

		  protected void end() {}

		  protected void interrupted() {
		    end();
		  }
}
