package org.usfirst.frc4930.Kermit.commands;

import org.usfirst.frc4930.Kermit.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RaiseDropWheel extends Command {

  public RaiseDropWheel() {
    requires(Robot.dropWheel);
  }

  protected void initialize() {
    Robot.dropWheel.raise();
  }

  protected void execute() {}

  @Override
  protected boolean isFinished() {
    return false;
  }

  protected void end() {}

  protected void interrupted() {
    end();
  }
}