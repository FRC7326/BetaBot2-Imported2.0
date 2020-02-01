package frc.robot;
import edu.wpi.first.wpilibj.XboxController;
import static frc.robot.Robot.oi;

public class ElevatorPositions {
  public static XboxController P1 = oi.Controller0; 
  static int heightB0 = 0, heightB1 = -140064, heightB2 = -280129, heightB3 = -431205, heightH2 = 18033, heightH3 = 30973; 
  static double throttle = .3; 

  public static void MoveElevators() {
		if(oi.Dpad(P1) >= 0) { 
      Robot.kDriveTrain.ElevOn(true);
      if     (oi.DpadDown(P1))   {Robot.kDriveTrain.setElevatorPosition(heightB0);}
      else if(oi.DpadRight(P1))  {Robot.kDriveTrain.setElevatorPosition(heightB1);}
      else if(oi.DpadUp(P1))     {Robot.kDriveTrain.setElevatorPosition(heightB2);}
      else if(oi.DpadLeft(P1))   {Robot.kDriveTrain.setElevatorPosition(heightB3);} 
    } else{ Robot.kDriveTrain.setRawElevator(0.3*oi.LeftTrigger(P1) - 0.7*oi.RightTrigger(P1)); Robot.kDriveTrain.ElevOn(false); }
  }
}