package org.usfirst.frc4930.Kermit.subsystems;

import org.usfirst.frc4930.Kermit.Robot;
import org.usfirst.frc4930.Kermit.RobotMap;
import org.usfirst.frc4930.Kermit.Constants;

import edu.wpi.first.wpilibj.command.Subsystem;

public class PTO extends Subsystem {

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void turnOff() {
		RobotMap.solenoid1.set(Constants.PTO_OFF);
		Robot.ptoOn = false;
		
	}
	
	public void turnOn() {
		RobotMap.solenoid1.set(Constants.PTO_ON);
		Robot.ptoOn = true;
	}

}
