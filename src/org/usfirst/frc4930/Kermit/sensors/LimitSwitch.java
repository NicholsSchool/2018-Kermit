package org.usfirst.frc4930.Kermit.sensors;

import org.usfirst.frc4930.Kermit.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class LimitSwitch extends Subsystem{

	  public boolean lowerArmDown;
	  public boolean upperArmDown;
	  public boolean toggleSwitch;
	  public boolean upperArmUp;
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public LimitSwitch() {
	    lowerArmDown = RobotMap.lArmDownLSwitch.get();
	    upperArmDown = RobotMap.uArmDownLSwitch.get();
	    toggleSwitch = RobotMap.toggleSwitch.get();
	    upperArmUp = RobotMap.uArmUpLSwitch.get();
	}
	
	public void checkForChange() {
		if(lowerArmDown != RobotMap.lArmDownLSwitch.get()){
			lowerArmDown = !lowerArmDown;
		}
		if(upperArmDown != RobotMap.uArmDownLSwitch.get()){
			upperArmDown = !upperArmDown;
		}
		if(upperArmUp != RobotMap.uArmUpLSwitch.get()){
		    upperArmUp = upperArmUp;
		}
		if(toggleSwitch != RobotMap.toggleSwitch.get()){
			toggleSwitch = !toggleSwitch;
		}
		
	}
}
