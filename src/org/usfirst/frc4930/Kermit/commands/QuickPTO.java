package org.usfirst.frc4930.Kermit.commands;

import org.usfirst.frc4930.Kermit.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class QuickPTO extends Command {
	  protected void initialize() {
		  Robot.pto.turnOn();
	  }

	  protected void execute() {
		 if( timeSinceInitialized() > 0.5) {
			 Robot.pto.turnOff();
		 }
	  }

	  protected boolean isFinished() {
	    return true;
	  }

	  protected void end() {}

	  protected void interrupted() {
	    end();
	  }
}
