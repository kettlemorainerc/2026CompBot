package frc.robot.command;

import frc.robot.RobotHardware;
import frc.robot.subsystems.MagicCarpet;

public class MagicCarpetControls extends NewRepeatedCommand {
    public enum CarpetDirection{
        FLY,
        FALL,
        STOP
    }

    private final CarpetDirection direction;
    private final MagicCarpet carpet;
    private final boolean auto;

    public MagicCarpetControls(CarpetDirection direction){
        this.direction = direction;
        carpet = RobotHardware.getInstance().carpet;
        this.auto = false;
    }
    public MagicCarpetControls(CarpetDirection direction, Boolean auto){
        this.direction = direction;
        carpet = RobotHardware.getInstance().carpet;
        this.auto = auto;
    }


    @Override
    public void initialize(){
        switch (direction) {
            case FLY:
                carpet.carpetFly();
                break;
            case FALL:
                carpet.carpetFall();
                break;
            case STOP:
                carpet.stopCarpet();
                break;
        }
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
        if(!auto){
            carpet.stopCarpet();
        }
    }
    
}
