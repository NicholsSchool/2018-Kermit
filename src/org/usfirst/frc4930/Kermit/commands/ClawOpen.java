package org.usfirst.frc4930.Kermit.commands;

import org.usfirst.frc4930.Kermit.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClawOpen extends Command{
	  public ClawOpen() {
		    requires(Robot.claw);
		  }

		  protected void initialize() {
			  Robot.claw.open();
		  }

		  protected void execute() {
		if(timeSinceInitialized() > 0.25){
			new Intake().execute();
		      }
		  }

		  protected boolean isFinished() {
		    return !Robot.clawOpen;
		  }

		  protected void end() {}

		  protected void interrupted() {
		    end();
		  }
}
