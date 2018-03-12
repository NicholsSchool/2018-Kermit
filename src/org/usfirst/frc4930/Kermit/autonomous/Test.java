package org.usfirst.frc4930.Kermit.autonomous;

import org.usfirst.frc4930.Kermit.Constants;
import org.usfirst.frc4930.Kermit.commands.Outtake;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Test extends CommandGroup {
	
	public Test() {
		addSequential(new BBGoDistance(2));
		addSequential(new BBGoToAngle(90));
		addSequential(new BBGoDistance(5));
		addSequential(new Outtake(3, 0.8));
	}
}
