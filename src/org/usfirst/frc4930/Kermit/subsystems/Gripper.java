
package org.usfirst.frc4930.Kermit.subsystems;

import org.usfirst.frc4930.Kermit.RobotMap;
import org.usfirst.frc4930.Kermit.commands.HoldCube;

import edu.wpi.first.wpilibj.command.Subsystem;


public class Gripper extends Subsystem {

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new HoldCube());
	}

	public void grip(double speed) {
		RobotMap.lIntake.set(speed);
		RobotMap.rIntake.set(speed);
	}
	
	public void stop() {
		RobotMap.lIntake.set(0.0);
		RobotMap.rIntake.set(0.0);
	}
}

