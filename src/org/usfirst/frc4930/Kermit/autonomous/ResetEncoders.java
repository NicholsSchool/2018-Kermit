package org.usfirst.frc4930.Kermit.autonomous;

import org.usfirst.frc4930.Kermit.Robot;
import org.usfirst.frc4930.Kermit.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ResetEncoders extends Command{
	  protected void initialize() {
		  
	  }
	  
	  protected void execute() {
		  Robot.driveTrain.resetEncoders();
	  }

	  protected boolean isFinished() {
	    return true;
	  }

	  protected void end() {}

	  protected void interrupted() {
	    end();
	  }
}