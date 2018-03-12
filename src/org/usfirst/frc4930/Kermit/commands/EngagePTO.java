package org.usfirst.frc4930.Kermit.commands;

import org.usfirst.frc4930.Kermit.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class EngagePTO extends Command {
	  
	public EngagePTO() {
		    requires(Robot.pto);	  
	}
  
	protected void initialize() {}
 
	protected void execute() {  
		if (Robot.oi.j1b7.get() || (Robot.oi.j2b7.get()))     
			Robot.pto.turnOn();
	}
	  
	protected boolean isFinished() {
		    return true;	  
	}
	  
	protected void end() {}
	  
	protected void interrupted() {
		    end();	
	}
}
