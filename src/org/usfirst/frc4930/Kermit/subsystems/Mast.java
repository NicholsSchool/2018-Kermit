package org.usfirst.frc4930.Kermit.subsystems;

import org.usfirst.frc4930.Kermit.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Mast extends Subsystem {

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	
	public void set(double speed){
		RobotMap.mast.set(speed);
	}
	
	public void stop() {
		RobotMap.mast.stopMotor();
	}
	
}