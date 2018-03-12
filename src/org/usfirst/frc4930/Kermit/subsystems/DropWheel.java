package org.usfirst.frc4930.Kermit.subsystems;

import org.usfirst.frc4930.Kermit.Robot;
import org.usfirst.frc4930.Kermit.RobotMap;
import org.usfirst.frc4930.Kermit.commands.MoveDropWheel;
import org.usfirst.frc4930.Kermit.Constants;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DropWheel extends Subsystem {

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		//setDefaultCommand(new MoveDropWheel());
	}

	public void drop() {
		RobotMap.solenoid2.set(Constants.DROPWHEEL_DROP);
		Robot.dropped = true;
	}
	
	public void raise() {
		RobotMap.solenoid2.set(Constants.DROPWHEEL_RAISE);
		Robot.dropped = false;
	}
	
	public void set(double speed) {
		RobotMap.dropWhl.set(speed);
	}
	
	public void pivot() {
		double speed = Robot.oi.j1.getX();
	    if (Robot.dropped = true) {
	        speed = Robot.oi.j1.getX();
	        set(speed);
	      }
		set(speed);
	}
	
	public void stop() {
		RobotMap.dropWhl.stopMotor();
	}
}
