package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;

public class Robot extends TimedRobot {
  public static final DriveSubsystem kDriveTrain = new DriveSubsystem();
  public static final OI oi = new OI();
  Compressor c0 = new Compressor(0);
  
  XboxController P1 = oi.Controller0; 
  
  //UsbCamera cameras0 = new UsbCamera("cam0", 0);
  //UsbCamera cameras1 = new UsbCamera(null, 1);
  //CameraServer server; 
  //Boolean cam0Boolean = true; 
  
  @Override
  public void robotInit() {
    c0.setClosedLoopControl(true);
    //CameraServer.getInstance().startAutomaticCapture();
    //server = CameraServer.getInstance();gf
    //server.startAutomaticCapture(cameras0);
  }
  public void SwitchCams() {
    //if(cam0Boolean){server.startAutomaticCapture(cameras0);}
    //else{server.startAutomaticCapture(cameras0);}
  }
  @Override
  public void robotPeriodic() {
    if(oi.AButton(P1)){ SwitchCams(); }
  }
  @Override
  public void disabledInit() {}
  @Override
  public void disabledPeriodic() {}
  @Override
  public void autonomousInit() {}
  @Override
  public void autonomousPeriodic() { Scheduler.getInstance().run();}
  @Override
  public void teleopInit() {}
  @Override
  public void teleopPeriodic() { Scheduler.getInstance().run(); }
  @Override
  public void testPeriodic() { }
}
