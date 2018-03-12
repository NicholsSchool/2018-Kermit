package org.usfirst.frc4930.Kermit.subsystems;

import org.usfirst.frc4930.Kermit.Robot;
import org.usfirst.frc4930.Kermit.RobotMap;
import org.usfirst.frc4930.Kermit.Constants;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shifter extends Subsystem {

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void setLowGear() {
		RobotMap.solenoid0.set(Constants.SHIFTER_LOW_GEAR);
		Robot.shifterInLowGear = true;
	}
	
	public void setHighGear() {
		RobotMap.solenoid0.set(Constants.SHIFTER_HIGH_GEAR);
		Robot.shifterInLowGear = false;
	}

}
