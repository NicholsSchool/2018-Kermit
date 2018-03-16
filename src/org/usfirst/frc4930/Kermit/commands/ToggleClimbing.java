package org.usfirst.frc4930.Kermit.commands;

import org.usfirst.frc4930.Kermit.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleClimbing extends Command {
	  protected void initialize() {}

	  protected void execute() {
		  Robot.isClimbing = !Robot.isClimbing;
	  }

	  protected boolean isFinished() {
	    return true;
	  }

	  protected void end() {}

	  protected void interrupted() {
	    end();
	  }
}
