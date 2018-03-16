package org.usfirst.frc4930.Kermit.autonomous;

import org.usfirst.frc4930.Kermit.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DRGoDistance extends Command{
		
	double time;
	double speed;
	public DRGoDistance(double sec, double spd) {
		time = sec;
		speed = spd;
	}
	
	  protected void initialize() {}

	  protected void execute() {
	
			  Robot.driveTrain.move(speed, speed);
		  
	  }

	  protected boolean isFinished() {
	    return timeSinceInitialized() > time;
	  }

	  protected void end() {
		  Robot.driveTrain.stop();
	  }

	  protected void interrupted() {
	    end();
	  }
}
