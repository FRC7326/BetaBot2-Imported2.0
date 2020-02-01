package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.ElevatorPositions;
import frc.robot.Robot;

import static frc.robot.Robot.oi;
import static frc.robot.Robot.kDriveTrain;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
 
public class DriveManuallyCommand extends Command {
   public DriveManuallyCommand() { requires(kDriveTrain); }

  @Override
  protected void initialize() {}
  XboxController P1 = oi.Controller0; 
  DoubleSolenoid.Value Piston = Value.kOff;
  
  @Override
  protected void execute() {
    kDriveTrain.manualDrive(-1*oi.LeftY(P1), oi.RightX(P1));
    if(oi.StartButton(P1)) { kDriveTrain.ResetElevator(); }
    ElevatorPositions.MoveElevators();

    if(oi.XButton(P1)){Piston = Value.kForward;}
    
    else if(oi.YButton(P1)){Piston = Value.kReverse; }
    
    else{Piston = Value.kOff; } kDriveTrain.setPiston(Piston);
    SmartDashboard.putNumber("ElevatorPosition: ", kDriveTrain.getLiftPosition());
  }
  @Override
  protected boolean isFinished() { return false; }
  @Override
  protected void end() {}
  @Override
  protected void interrupted() { end(); }

  protected void subsystems() {
    SmartDashboard.putNumber("Sensor Value", Robot.kDriveTrain.returnSensorOutput());
  }


}
