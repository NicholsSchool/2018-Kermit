package org.usfirst.frc4930.Kermit.subsystems;

import org.usfirst.frc4930.Kermit.Robot;
import org.usfirst.frc4930.Kermit.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Claw extends Subsystem{

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	  public void toggle() {
		    if (!Robot.clawOpen) {
		    	open();
		    } else {
		    	close();
		    }
		  }
	
	public void open() {
		RobotMap.solenoid3.set(true);
		Robot.clawOpen = true;
	}
	
	public void close() {
		RobotMap.solenoid3.set(false);
		Robot.clawOpen = false;
	}

}
