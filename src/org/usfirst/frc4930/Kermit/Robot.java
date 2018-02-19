
package org.usfirst.frc4930.Kermit;

import org.usfirst.frc4930.Kermit.autonomous.*;
import org.usfirst.frc4930.Kermit.commands.EngagePTO;
import org.usfirst.frc4930.Kermit.sensors.*;
import org.usfirst.frc4930.Kermit.subsystems.*;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot
{

  Command autonomousCommand;
  SendableChooser<Command> chooser = new SendableChooser<>();

  public static OI oi;
  public static DriveTrain driveTrain;
  public static Gripper gripper;
  public static LowerArm lowerArm;
  public static UpperArm upperArm;
  public static PTO pto;
  public static Claw claw;
  public static Shifter shifter;
  public static DropWheel dropWheel;
  public static Dial positionDial;
  public static Dial timeDelayDial;
  public static Arm arm;
  public static Cameras cameras;
  public static LimitSwitch limitSwitch;
  public static Mast mast;

  // ALL THESE VALUES NEED TO BE CHECKED TO SEE HOW SOLENOID STATE RELATES TO ROBOT
  public static boolean shifterInLowGear = true;
  public static boolean ptoOn = false;
  public static boolean dropped = false;
  public static boolean clawOpen = false;


  @Override
  public void robotInit() {
    RobotMap.init();
    driveTrain = new DriveTrain();
    gripper = new Gripper();
    pto = new PTO();
    claw = new Claw();
    dropWheel = new DropWheel();
    shifter = new Shifter();
    lowerArm = new LowerArm();
    upperArm = new UpperArm();
    positionDial = new Dial(RobotMap.positionPot);
    timeDelayDial = new Dial(RobotMap.timeDelayPot);
    arm = new Arm();
    cameras = new Cameras();
    limitSwitch = new LimitSwitch();
    mast = new Mast();
    // OI must be constructed after subsystems.
    oi = new OI();

  }

  @Override
  public void disabledInit() {

  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    autonomousCommand = chooser.getSelected();
    // schedule the autonomous command (example)
    if (autonomousCommand != null)
      autonomousCommand.start();
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
    limitSwitch.checkForChange();
  }

  @Override
  public void teleopInit() {
    if (autonomousCommand != null)
      autonomousCommand.cancel();
    RobotMap.lDrvMSTR.setSelectedSensorPosition(0, 0, 100);
    RobotMap.rDrvMSTR.setSelectedSensorPosition(0, 0, 100);
    RobotMap.dropWhl.setSelectedSensorPosition(0, 0, 100);
	  // upperarm starts halfway up
	  arm.setEncoders(20000, 0);
	  arm.updatePosition();
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    limitSwitch.checkForChange();
//    SmartDashboard.putBoolean("Compressor Enabled: ", RobotMap.compressor.enabled());
//    SmartDashboard.putBoolean("Shifter (Solenoid 0)", RobotMap.solenoid0.get());
//    SmartDashboard.putBoolean("PTO (Solenoid 1)", RobotMap.solenoid1.get());
//    SmartDashboard.putBoolean("DropWheel (Solenoid 2)", RobotMap.solenoid2.get());
//    SmartDashboard.putBoolean("Claw (Solenoid 4)", RobotMap.solenoid3.get());

//    SmartDashboard.putNumber("LeftShoulder", RobotMap.lShoulder.get());
//    
//    SmartDashboard.putNumber("Right Master",RobotMap.rDrvMSTR.get());
//    SmartDashboard.putNumber("Right Slave 1",RobotMap.rDrvSlv1.get());
//    System.out.println("Elbow" + RobotMap.lElbow.getSelectedSensorPosition(0));
//    System.out.println("Shoulder" + RobotMap.lShoulder.getSelectedSensorPosition(0));
    
//    SmartDashboard.putString("r-elbow ControlMode", RobotMap.rElbow.getControlMode().toString());
   
    
    SmartDashboard.putNumber("SHOULDER ENCODER: ",
        RobotMap.lShoulder.getSelectedSensorPosition(0));
    SmartDashboard.putNumber("ELBOW ENCODER: ",
        RobotMap.lElbow.getSelectedSensorPosition(0));
//    SmartDashboard.putNumber("Left Master Encoder(22):",
//        RobotMap.lDrvMSTR.getSelectedSensorPosition(0));
//    SmartDashboard.putNumber("Right Master Encoder(28):",
//        RobotMap.rDrvMSTR.getSelectedSensorPosition(0));
//    SmartDashboard.putNumber("Drop Wheel Encoder(34):",
//        RobotMap.dropWhl.getSelectedSensorPosition(0));

//    SmartDashboard.putNumber("UpperArmState: ", Robot.upperArm.getState());
//    SmartDashboard.putNumber("LowerArmState: ", Robot.lowerArm.getState());

//    SmartDashboard.putNumber("Gyro", RobotMap.ahrs.getAngle());

//    SmartDashboard.putNumber("PositionPot Raw: ", RobotMap.positionPot.get());
//    SmartDashboard.putNumber("DelayPot Raw: ", RobotMap.timeDelayPot.get());
//    SmartDashboard.putNumber("PositionPot", Robot.positionDial.getPosition());
//    SmartDashboard.putNumber("DelayPot", Robot.timeDelayDial.getPosition());
        
    SmartDashboard.putBoolean("LARMDOWNSWITCH: ", limitSwitch.lowerArmDown);
    SmartDashboard.putBoolean("UARMDOWNSWITCH: ", limitSwitch.upperArmDown);
//    SmartDashboard.putBoolean("autoSwitch", limitSwitch.autoSwitch);
//    SmartDashboard.putBoolean("clawLSwitch", limitSwitch.hasCube);
    
    // two button engage for the pto
    if(oi.j0b7.get() && oi.j0b8.get())
    {
    	new EngagePTO().start();
    }
    
    if(oi.j0b10.get()){
    	RobotMap.lElbow.setSelectedSensorPosition(0, 0, 0);
    	Robot.arm.resetElbowPosition();
    }
    if(oi.j0b9.get()){
    	RobotMap.lShoulder.setSelectedSensorPosition(0, 0, 0);
    	Robot.arm.resetShoulderPosition();
    }
  }
  

  
}