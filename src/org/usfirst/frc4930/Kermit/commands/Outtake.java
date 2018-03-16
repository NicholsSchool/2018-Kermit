package org.usfirst.frc4930.Kermit.commands;

import org.usfirst.frc4930.Kermit.Constants;
import org.usfirst.frc4930.Kermit.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Outtake extends Command
{

  private int runTime;
  private double speed;
  public Outtake(int seconds, double outtakeSpeed){
		  runTime = seconds;
		  speed = outtakeSpeed;
		  requires(Robot.gripper);
  }
	  
  public Outtake(){
		  runTime = 0;
		  speed = Constants.OUTTAKE_SPEED;
		  requires(Robot.gripper);
  } 
	
  protected void initialize() {

  }

  protected void execute() {
    Robot.gripper.grip(speed);
  }

  @Override
  protected boolean isFinished() {
	  if(runTime != 0){
		  return timeSinceInitialized() > runTime;
	  }
	  else{
		  return false;
	  }
  }

  protected void end() {
    Robot.gripper.stop();
    new HoldCube().start();
  }

  protected void interrupted() {
    end();
  }

}
