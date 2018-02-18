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

  // sensors
  public static final int 
  	CLAW_LSWITCH_CHNL = 6, 
  	AUTO_SWITCH = 7,
    UARM_DOWN_LSWITCH_CHNL = 9, 
    LARM_DOWN_LSWITCH_CHNL = 8,

    POSITIONPOT_CHNL = 0,
    DELAYPOT_CHNL = 1;

  // speeds
  public static final double 
	ELBOW_RELATIVE_SPD = 0.7,
	ARM_LERP_T = 0.85,
  
  	INTAKE_SPEED = .4,
  	OUTTAKE_SPEED = -1.0,
  	
  	LOWER_MAST_SPEED = -0.4,
    RAISE_MAST_SPEED = 0.4;

  // encoder values for the arm
  public static final int  
  	SHOULDER_EXTENDED = 165000, //163, 164, 174, 179, 184, 
  	ELBOW_EXTENDED = 850000, //106, 106, 105
  	SHOULDER_TO_BAR = 130000, //144000, 123000, 130000, 123000, 115000, 128000, 121000, 123000
  	ELBOW_TO_BAR = 60000, // 88, 98, 98, 97, 
    LOWER_ARM_INCRAMENTS = 40000;


  // inverts
  public static final int 
  	INVERT_JOYSTICK = -1;

  // Camera resolution
  public static final int 
  	LENGTH = 320,
  	HEIGHT = 240, 
  	FRAMES_PER_SECOND = 5;

}
