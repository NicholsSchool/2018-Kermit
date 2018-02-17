package org.usfirst.frc4930.Kermit.commands;

import org.usfirst.frc4930.Kermit.Constants;
import org.usfirst.frc4930.Kermit.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RaiseMast extends Command
{
  public RaiseMast() {
    requires(Robot.mast);
  }

  protected void initialize() {}

  protected void execute() {
    Robot.mast.set(Constants.RAISE_MAST_SPEED);
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    Robot.mast.stop();
  }

  protected void interrupted() {
    end();
  }
}
