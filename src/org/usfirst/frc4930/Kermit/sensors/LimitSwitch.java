package org.usfirst.frc4930.Kermit.sensors;

import org.usfirst.frc4930.Kermit.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class LimitSwitch extends Subsystem{

	  public boolean lowerArmDown;
	  public boolean upperArmDown;
	  public boolean autoSwitch;
	  public boolean hasCube;
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public LimitSwitch() {
	    lowerArmDown = RobotMap.lArmDownLSwitch.get();
	    upperArmDown = RobotMap.uArmDownLSwitch.get();
	    autoSwitch = RobotMap.autoSwitch.get();
	    hasCube = RobotMap.clawLSwitch.get();
	}
	
	public void checkForChange() {
		if(lowerArmDown != RobotMap.lArmDownLSwitch.get()){
			lowerArmDown = !lowerArmDown;
		}
		if(upperArmDown != RobotMap.uArmDownLSwitch.get()){
			upperArmDown = !upperArmDown;
		}
		if(hasCube != RobotMap.clawLSwitch.get()){
			hasCube = !hasCube;
		}
		if(autoSwitch != RobotMap.autoSwitch.get()){
			autoSwitch = !autoSwitch;
		}
		
	}
}
