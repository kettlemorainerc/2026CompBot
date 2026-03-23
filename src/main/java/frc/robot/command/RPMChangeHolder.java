package frc.robot.command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class RPMChangeHolder{
    
    private double targetRPM;

    public RPMChangeHolder(int rpm){
        this.targetRPM = rpm;

    }

    public void changeRPMTarget(Double rpm){
        this.targetRPM += rpm;
        this.targetRPM = Math.min(targetRPM, 5000);
        this.targetRPM = Math.max(targetRPM, 2000);
        SmartDashboard.putNumber("Motor Max", targetRPM);
    }
    public void setRPMTarget(Double RPM){
        this.targetRPM = RPM;
        SmartDashboard.putNumber("Auto speed", targetRPM);
    }

    public double getTargetRPM(){        
        return targetRPM;
    }

}