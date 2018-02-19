package org.usfirst.frc4930.Kermit.subsystems;

import org.usfirst.frc4930.Kermit.Constants;
import org.usfirst.frc4930.Kermit.Robot;
import org.usfirst.frc4930.Kermit.RobotMap;
import org.usfirst.frc4930.Kermit.commands.MoveArm;
import org.usfirst.frc4930.Kermit.sensors.Encoder;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Arm extends Subsystem
{

  WPI_TalonSRX lShoulder = RobotMap.lShoulder;
  WPI_TalonSRX rShoulder = RobotMap.rShoulder;
  WPI_TalonSRX lElbow = RobotMap.lElbow;
  WPI_TalonSRX rElbow = RobotMap.rElbow;
  Encoder encoder = new Encoder();

  private double elbowPos = 0;
  private double shoulderPos = 0;

  // DigitalInput uArmDownLSwitch = RobotMap.uArmDownLSwitch;
  DigitalInput lArmDownLSwitch = RobotMap.lArmDownLSwitch;

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveArm());
  }

  @Override
  public void periodic() {
    // if the lower arm is down, reset the encoders
	// limit switches return false when pressed
    if(!Robot.limitSwitch.lowerArmDown) {
    	lShoulder.setSelectedSensorPosition(0, 0, 100);
    }
    if(!Robot.limitSwitch.upperArmDown) {
    	lElbow.setSelectedSensorPosition(0, 0, 100);
    }
  }
  
  public void setEncoders(int elbowPos, int shoulderPos) {
	  lElbow.setSelectedSensorPosition(elbowPos, 0, 100);
	  lShoulder.setSelectedSensorPosition(shoulderPos, 0, 100);
  }

  public void set(double speed) {
    if (speed > 0.2) {
      updatePosition();
      if(!Robot.limitSwitch.hasCube) {
    	  extendWithCube();
      } else {
    	  extend();
      }
    } else if (speed < -0.2) {
      updatePosition();
      if(!Robot.limitSwitch.hasCube) {
    	  retractWithCube();
      } else {
    	  retract();
      }
    } else {
    	if(!Robot.limitSwitch.hasCube) {
    		adjustElbowWithCube(elbowPos);
    		adjustShoulderWithCube(shoulderPos);
    	} else {
    		adjustElbow(elbowPos);
    		adjustShoulder(shoulderPos);
    	}
    }

  }

  // right motor will follow the left
  public void stop() {
    lShoulder.set(0.0);
    lElbow.set(0.0);
  }

  private void adjustElbow(double position) {
    lElbow.config_kP(0, 0.3, 0);
    lElbow.config_kI(0, 0.0, 0);
    lElbow.config_kD(0, 0.0, 0);

    lElbow.set(ControlMode.Position, position);
  }

  private void adjustShoulder(double position) {
    lShoulder.config_kP(0, 0.3, 0);
    lShoulder.config_kI(0, 0.0, 0);
    lShoulder.config_kD(0, 0.0, 0);

    lShoulder.set(ControlMode.Position, position);
  }
  
  private void adjustElbowWithCube(double position) {
	    lElbow.config_kP(0, 0.5, 0);
	    lElbow.config_kI(0, 0.0, 0);
	    lElbow.config_kD(0, 0.0, 0);

	    lElbow.set(ControlMode.Position, position);
	  }

  private void adjustShoulderWithCube(double position) {
	  lShoulder.config_kP(0, 0.5, 0);
	  lShoulder.config_kI(0, 0.0, 0);
	  lShoulder.config_kD(0, 0.0, 0);

	  lShoulder.set(ControlMode.Position, position);
  }

  public void updatePosition() {
    elbowPos = encoder.lElbow_Raw();// lElbow.getSelectedSensorPosition(0);
    shoulderPos = encoder.lShoulder_Raw();
  }

  private void extend() {
    // limit switches return false when pressed
    // if the upper arm is not fully extended, extend upper arm
    if (encoder.lElbow_Raw() < Constants.ELBOW_TO_BAR) {
    	System.out.println("EXTENDING ELBOW");
    	// 0.05 will maintain the position
    	lShoulder.set(0.05);
    	// elbow moves faster than the shoulder
    	lElbow.set(Constants.ELBOW_RAISE_SPD_BELOW_BAR);
    } else if (encoder.lShoulder_Raw() < Constants.SHOULDER_TO_BAR) {
    	System.out.println("EXTENDING SHOULDER");
    	// else if lower arm is not fully extended, extend lower arm
    	lShoulder.set(Constants.SHOULDER_RAISE_SPD_BELOW_BAR);
    	lElbow.set(0.2);
    } else {
      System.out.println("EXTENDING BOTH");

      	// if both arms are past the bar, run each until they reach the limit
      	if (encoder.lElbow_Raw() < Constants.ELBOW_EXTENDED) {
      		lElbow.set(Constants.ELBOW_RAISE_SPD_ABOVE_BAR);
      	} else {
      		// maintain if at the max
      		lElbow.set(0.05);
      	}

      	if (encoder.lShoulder_Raw() < Constants.SHOULDER_EXTENDED) {
      		lShoulder.set(Constants.SHOULDER_RAISE_SPD_ABOVE_BAR);

      	} else {
      		// maintain if at the max
      		lShoulder.set(0.05);
      	}
    }
  }

  private void retract() {
    // limit switches return false when pressed
    // if both are above the bar, move both at once
    if (encoder.lShoulder_Raw() > Constants.SHOULDER_TO_BAR
        && encoder.lElbow_Raw() > Constants.ELBOW_TO_BAR) {
      System.out.println("RETRACTING BOTH");
      lShoulder.set(Constants.SHOULDER_LOWER_SPD_ABOVE_BAR);
      lElbow.set(Constants.ELBOW_LOWER_SPD_ABOVE_BAR);

    } else {
      // if they are below the bar, move one at a time
      // if lower arm is not retracted, retract lower arm
      if (encoder.lShoulder_Raw() > 0) {
    	  System.out.println("RETRACTING SHOULDER");
        lShoulder.set(Constants.SHOULDER_LOWER_SPD_BELOW_BAR);
        lElbow.set(0.05);
      } else if (encoder.lElbow_Raw() > 0) {
    	  System.out.println("RETRACTING ELBOW");
        // else if upper arm is not retracted, retract upper arm
        lShoulder.set(0.05);
        // elbow moves faster than the shoulder
        lElbow.set(Constants.ELBOW_LOWER_SPD_BELOW_BAR);
      }

    }
  }
  
  private void extendWithCube() {
	    // limit switches return false when pressed
	    // if the upper arm is not fully extended, extend upper arm
	    if (encoder.lElbow_Raw() < Constants.ELBOW_TO_BAR) {
	    	System.out.println("EXTENDING ELBOW");
	    	// 0.05 will maintain the position
	    	lShoulder.set(0.05);
	    	// elbow moves faster than the shoulder
	    	lElbow.set(Constants.ELBOW_RAISE_SPD_BELOW_BAR_CUBE);
	    } else if (encoder.lShoulder_Raw() < Constants.SHOULDER_TO_BAR) {
	    	System.out.println("EXTENDING SHOULDER");
	    	// else if lower arm is not fully extended, extend lower arm
	    	lShoulder.set(Constants.SHOULDER_RAISE_SPD_BELOW_BAR_CUBE);
	    	lElbow.set(0.2);
	    } else {
	      System.out.println("EXTENDING BOTH");

	      	// if both arms are past the bar, run each until they reach the limit
	      	if (encoder.lElbow_Raw() < Constants.ELBOW_EXTENDED) {
	      		lElbow.set(Constants.ELBOW_RAISE_SPD_ABOVE_BAR_CUBE);
	      	} else {
	      		// maintain if at the max
	      		lElbow.set(0.05);
	      	}

	      	if (encoder.lShoulder_Raw() < Constants.SHOULDER_EXTENDED) {
	      		lShoulder.set(Constants.SHOULDER_RAISE_SPD_ABOVE_BAR_CUBE);

	      	} else {
	      		// maintain if at the max
	      		lShoulder.set(0.05);
	      	}
	    }
	  }

	  private void retractWithCube() {
	    // limit switches return false when pressed
	    // if both are above the bar, move both at once
	    if (encoder.lShoulder_Raw() > Constants.SHOULDER_TO_BAR
	        && encoder.lElbow_Raw() > Constants.ELBOW_TO_BAR) {
	      System.out.println("RETRACTING BOTH");
	      lShoulder.set(Constants.SHOULDER_LOWER_SPD_ABOVE_BAR_CUBE);
	      lElbow.set(Constants.ELBOW_LOWER_SPD_ABOVE_BAR_CUBE);

	    } else {
	      // if they are below the bar, move one at a time
	      // if lower arm is not retracted, retract lower arm
	      if (encoder.lShoulder_Raw() > 0) {
	    	  System.out.println("RETRACTING SHOULDER");
	        lShoulder.set(Constants.SHOULDER_LOWER_SPD_BELOW_BAR_CUBE);
	        lElbow.set(0.05);
	      } else if (encoder.lElbow_Raw() > 0) {
	    	  System.out.println("RETRACTING ELBOW");
	        // else if upper arm is not retracted, retract upper arm
	        lShoulder.set(0.05);
	        // elbow moves faster than the shoulder
	        lElbow.set(Constants.ELBOW_LOWER_SPD_BELOW_BAR_CUBE);
	      }

	    }
	  }

  public void resetEncoders() {
    encoder.ArmReset();
  }
  
  public void resetElbowPosition(){
	  elbowPos = 0;
	
  }
  public void resetShoulderPosition(){
	  shoulderPos = 0;
  }

}
