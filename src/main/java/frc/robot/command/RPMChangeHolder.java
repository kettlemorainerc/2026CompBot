package frc.robot.command;

public class RPMChangeHolder{
    
    private int targetRPM;

    public RPMChangeHolder(int rpm){
        this.targetRPM = rpm;

    }

    public void changeRPMTarget(int rpm){
        this.targetRPM = rpm;
    }

    public int getTargetRPM(){
        
        return targetRPM;
    }

}