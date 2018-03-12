package org.usfirst.frc4930.Kermit.subsystems;

import org.usfirst.frc4930.Kermit.Robot;
import org.usfirst.frc4930.Kermit.RobotMap;
import org.usfirst.frc4930.Kermit.Constants;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Claw extends Subsystem{

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void open() {
		RobotMap.solenoid3.set(Constants.CLAW_OPEN);
		Robot.clawOpen = true;
	}
	
	public void close() {
		RobotMap.solenoid3.set(Constants.CLAW_CLOSE);
		Robot.clawOpen = false;
	}

}
