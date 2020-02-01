package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Notifier;

public class ElevatorModule {    
  private TalonSRX mLift;
  private Notifier SteeringPID;
  private double PIDOutput;
  private boolean on;
  private double setPoint;
  static final double kP = .000008;
  public ElevatorModule(int kDriveID) {
    mLift = new TalonSRX(kDriveID);
    SteeringPID = new Notifier(() -> {
      PIDOutput = kP * getError();
      PIDOutput = Math.min(.8, PIDOutput);
      PIDOutput = Math.max(-1, PIDOutput); 
      if(on) { mLift.set(ControlMode.PercentOutput, PIDOutput); }
  });
  SteeringPID.startPeriodic(0.01);
  mLift.enableVoltageCompensation(true);
  mLift.setNeutralMode(NeutralMode.Brake);
  }
  public double getError(){ return setPoint - getLiftPosition(); }
  public double getLiftVelocity() { return -mLift.getSelectedSensorVelocity(0); }
  public double getLiftPosition() { return -mLift.getSelectedSensorPosition(0); }
  public void setPosition(double position){ setPoint = position; }
  public void setRawElev(double speed){ mLift.set(ControlMode.PercentOutput, speed); }
  public void setTalonStatus()       { mLift.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1);       }
	public void configFeedbackSensor() { mLift.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative); }
  public void ElevatorReset()        { mLift.setSelectedSensorPosition(0, 0, 0); }
  public void setOn(boolean flipOn) { on = flipOn; }

  public void MoveElevator(double move){
    mLift.set(ControlMode.PercentOutput, move);
  }
}