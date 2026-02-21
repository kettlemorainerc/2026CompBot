package frc.robot.command;

import frc.robot.RobotHardware;
import frc.robot.subsystems.MagicCarpet;

public class MagicCarpetControls extends NewRepeatedCommand {
    public enum CarpetDirection{
        FLY,
        FALL
    }

    private final CarpetDirection direction;
    private final MagicCarpet carpet;

    public MagicCarpetControls(CarpetDirection direction){
        this.direction = direction;
        carpet = RobotHardware.getInstance().carpet;
    }


    @Override
    public void execute() {
        if(direction == CarpetDirection.FLY){
            carpet.carpetFly();
        }
        if(direction == CarpetDirection.FALL){
            carpet.carpetFall();
        }
    }

    @Override
    public void end(boolean interrupted) {
        carpet.stopCarpet();
    }
    
}
