package org.usfirst.frc4930.Kermit.autonomous;

import org.usfirst.frc4930.Kermit.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DRDropWheel extends Command{
	
	double time;
	boolean goLeft;
	double speed; 
	  public DRDropWheel(double seconds, boolean left, double speed){
		  time = seconds;
		  goLeft = left;
		  this.speed = speed;
		  requires(Robot.dropWheel);
	  }
	
	  protected void initialize() {
		  Robot.dropWheel.drop();
	  }

	  protected void execute() {
		  if(goLeft){
			  Robot.dropWheel.set(-speed);
		  }
		  else {
			  Robot.dropWheel.set(speed);
		  }
	  }

	  protected boolean isFinished() {
	    return timeSinceInitialized() > time;
	  }

	  protected void end() {
		  Robot.dropWheel.stop();
		  Robot.dropWheel.raise();
	  }

	  protected void interrupted() {
	    end();
	  }
}
