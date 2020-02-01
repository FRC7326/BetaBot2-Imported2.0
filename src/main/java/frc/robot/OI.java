package frc.robot;
import edu.wpi.first.wpilibj.XboxController;
public class OI {
  public static final double DEADZONE_LIMIT = 0.1;
  public XboxController Controller0 = new XboxController(0);
  public double LeftX (XboxController Controller){double raw = Controller.getRawAxis(0);return Math.abs(raw)< DEADZONE_LIMIT ? 0.0 : raw;}
  public double LeftY (XboxController Controller){double raw = Controller.getRawAxis(1);return Math.abs(raw)< DEADZONE_LIMIT ? 0.0 : raw;}
  public boolean AButtonDown(XboxController Controller){return Controller.getAButton();}
  public boolean BButtonDown(XboxController Controller){return Controller.getBButton();}
  public boolean AButton (XboxController Controller){ return Controller.getAButtonPressed(); }
  public boolean XButton (XboxController Controller){ return Controller.getXButtonPressed(); }
  public boolean YButton (XboxController Controller){ return Controller.getYButtonPressed(); }
  public double LeftTrigger (XboxController Controller){ double raw = Controller.getRawAxis(2); return Math.abs(raw) < DEADZONE_LIMIT ? 0.0 : raw; }
  public double RightTrigger(XboxController Controller){ double raw = Controller.getRawAxis(3); return Math.abs(raw) < DEADZONE_LIMIT ? 0.0 : raw; }
  public double RightX (XboxController Controller){ double raw = Controller.getRawAxis(4); return Math.abs(raw) < DEADZONE_LIMIT ? 0.0 : raw; }
  public double  Dpad (XboxController Controller){ return Controller.getPOV(); }
  public boolean DpadUp(XboxController Controller){ double POV = Controller.getPOV(); 
    if((POV >= 0 && POV < 45) || (POV >= 315 && POV < 360)) { return true; } else { return false; } 
} public boolean DpadRight(XboxController Controller){ double POV = Controller.getPOV(); 
    if(POV >= 45 && POV < 135) { return true; } else { return false; }
} public boolean DpadDown(XboxController Controller){ double POV = Controller.getPOV(); 
    if(POV >= 135 && POV < 225) { return true; } else { return false; }
} public boolean DpadLeft(XboxController Controller){ double POV = Controller.getPOV(); 
    if(POV >= 225 && POV < 315) { return true; } else { return false; }
} public boolean StartButton    (XboxController Controller){ return Controller.getStartButtonPressed(); }
}