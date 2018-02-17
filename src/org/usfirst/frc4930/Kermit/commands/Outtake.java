package org.usfirst.frc4930.Kermit.commands;

import org.usfirst.frc4930.Kermit.Constants;
import org.usfirst.frc4930.Kermit.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Outtake extends Command
{

  protected void initialize() {

  }

  protected void execute() {
    Robot.gripper.grip(Constants.OUTTAKE_SPEED);
  }

  @Override
  protected boolean isFinished() {

    return false;
  }

  protected void end() {
    Robot.gripper.stop();
  }

  protected void interrupted() {
    end();
  }

}
