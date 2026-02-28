package frc.robot.command;

public class RPMChangeHolder{
    
    private int targetRPM;

    public RPMChangeHolder(int rpm){
        this.targetRPM = rpm;

    }

    public void changeRPMTarget(int rpm){
        this.targetRPM += rpm;
        this.targetRPM = Math.min(targetRPM, 5000);
        this.targetRPM = Math.max(targetRPM, 2000);
    }

    public int getTargetRPM(){
        
        return targetRPM;
    }

}