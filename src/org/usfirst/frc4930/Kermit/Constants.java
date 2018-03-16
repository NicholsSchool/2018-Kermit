package org.usfirst.frc4930.Kermit;

public class Constants
{
  // drive train speed controllers
  public static final int
  	 L_DRV_MSTR_ID = 22, L_DRV_SLV1_ID = 26, L_DRV_SLV2_ID = 30,

     R_DRV_MSTR_ID = 28, R_DRV_SLV1_ID = 24, R_DRV_SLV2_ID = 32,

     DROP_WHL_ID = 34;

  // arm speed controllers
  public static final int
    L_SHOULDER_ID = 21, R_SHOULDER_ID = 23,

    L_ELBOW_ID = 25, R_ELBOW_ID = 27,

    L_INTAKE_ID = 29, R_INTAKE_ID = 31;

  // other speed controllers
  public static final int 
  	MAST_ID = 33;

  public static final boolean 
  	SHIFTER_LOW_GEAR = true,
  	SHIFTER_HIGH_GEAR = false,
  	
  	PTO_OFF = false,
  	PTO_ON = true,
  	
  	DROPWHEEL_DROP = true,
  	DROPWHEEL_RAISE = false,
  	
  	CLAW_OPEN = true,
  	CLAW_CLOSE = false;
  	
  
  // sensors
  //CHECK THESE INPUTS
  public static final int 
  	UARM_UP_LSWITCH_CHNL = 6,
  	TOGGLE_SWITCH_CHNL = 7,
    UARM_DOWN_LSWITCH_CHNL = 9, 
    LARM_DOWN_LSWITCH_CHNL = 8,

    PREFERENCE1_POT_CHNL = 0,
    PREFERENCE2_POT_CHNL = 1;

  // speeds
  public static final double 
	ELBOW_RELATIVE_SPD = 0.6,
	ARM_LERP_T = 0.85,
  
  	INTAKE_SPEED = -1.0,
  	OUTTAKE_SPEED = 1.0,
  	
    GRIPPER_HOLD_SPD = -0.1,
  	
  	LOWER_MAST_SPEED = -0.4,
    RAISE_MAST_SPEED = 0.4,
    
    
    ELBOW_RAISE_SPD = 0.5, //changed from .9
    ELBOW_LOWER_SPD = -0.4,
    SHOULDER_RAISE_SPD = 0.8,
    SHOULDER_LOWER_SPD = -0.1,
  	
  	//============CHANGE THESE============
    ELBOW_RAISE_SPD_CUBE = 0.9, //changed from 1
    ELBOW_LOWER_SPD_CUBE = -0.4,
    SHOULDER_RAISE_SPD_CUBE = 0.8,
    SHOULDER_LOWER_SPD_CUBE = -0.05;

  // encoder values for the arm
  public static final int  
  ELBOW_START_POSITION = 90000, //NEEDS TO BE TESTED
  
  	SHOULDER_EXTENDED = 145000, //163, 164, 174, 179, 184,    **165
  	ELBOW_EXTENDED = 100000, //106, 106, 105     **85
  	SHOULDER_TO_BAR = 75000, //144000, 123000, 130000, 123000, 115000, 128000, 121000, 123000    **130************
  	ELBOW_TO_BAR = 75000; // 88, 98, 98, 97,    **60
  //Other arm values
  public static final double 
  	ARM_JOYSTICK_OFFSET = 0.2;
  
  
  // values for Auto
  public static final int
         // v NEEDS TO BE TESTED v
  	TICKS_PER_REVOULTION_LOW_GEAR = 1300, 
  	TICKS_PER_REVOLUTION_HIGH_GEAR = 350,
  	
  	
  	WHEEL_DIAMETER = 4,
  
  	BB_G0_TO_ANGLE_OFFSET = 5,
  	TURN_RIGHT = 90,
  	TURN_LEFT = -90;

  public static final double 
	BB_GO_DISTANCE_OFFSET = 0.015;
  
  
  // speeds for Auto
  public static final double
  	BB_GO_DISTANCE_SPEED = 0.9,
  	BB_GO_TO_ANGLE_SPEED = 0.6;
  
  
  // inverts
  public static final int 
  	INVERT_JOYSTICK = -1;

  // Camera resolution
  public static final int 
  	LENGTH = 320,
  	HEIGHT = 240, 
  	FRAMES_PER_SECOND = 5;

}
