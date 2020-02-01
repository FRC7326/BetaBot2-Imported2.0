package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.DriveManuallyCommand;
import frc.robot.ElevatorModule;

public class DriveSubsystem extends Subsystem {
  public Spark leftFrontmotor = new Spark(1);
  public Spark leftBackmotor = new Spark(2);
  public Spark RightFrontmotor = new Spark(4);
  public Spark RightBackmotor = new Spark(3);

  SpeedControllerGroup leftMotorGroup = new SpeedControllerGroup(leftFrontmotor, leftBackmotor);
  SpeedControllerGroup rightMotorGroup = new SpeedControllerGroup(RightFrontmotor, RightBackmotor);
  public DifferentialDrive drive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);

  public static ElevatorModule Elevator;
  public static DoubleSolenoid Piston;
  public DriveSubsystem(){
    Elevator = new ElevatorModule(0);
    Piston = new DoubleSolenoid(0, 1);
  }
  public void setPiston(DoubleSolenoid.Value value){ Piston.set(value);}
  
  public void manualDrive(double move, double turn){
    drive.arcadeDrive(move, turn);   
  }
  public void setRawElevator(double speed){ Elevator.setRawElev(speed); }
	public void setElevatorPosition(double position){ Elevator.setPosition(position); }
	public void ElevOn(boolean On) { Elevator.setOn(On); }
	public void ResetElevator() { Elevator.ElevatorReset(); }
	public void ConfigElevator() { Elevator.configFeedbackSensor(); }
	public void SetElevatorStatus() { Elevator.setTalonStatus(); }
	public double getLiftVelocity() { return Elevator.getLiftVelocity(); }
	public double getLiftPosition() { return Elevator.getLiftPosition(); }
	
  @Override
  public void initDefaultCommand(){
    setDefaultCommand(new DriveManuallyCommand());
  }
  public double returnSensorOutput() {
    return Math.random();
  } 



}
