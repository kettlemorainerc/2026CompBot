package frc.robot.command;

import frc.robot.RobotHardware;
import frc.robot.subsystems.MagicCarpet;

public class MagicCarpetControls extends NewRepeatedCommand {
    public enum CarpetDirection{
        FLY,
        FALL,
        WAIT
    }

    private final CarpetDirection direction;
    private final MagicCarpet carpet;
    private final RPMChangeHolder holder;

    public MagicCarpetControls(CarpetDirection direction, RPMChangeHolder holder){
        this.direction = direction;
        carpet = RobotHardware.getInstance().carpet;
        this.holder = holder;
    }


    @Override
    public void execute() {
        if(direction == CarpetDirection.FLY){
            carpet.carpetFly();
        }
        if(direction == CarpetDirection.FALL){
            carpet.carpetFall();
        }
        if(direction == CarpetDirection.WAIT){
            if(holder.getTargetRPM() > RobotHardware.getInstance().leftLauncherMotor.getEncoder().getVelocity()) {
            }
            if(holder.getTargetRPM() <= RobotHardware.getInstance().leftLauncherMotor.getEncoder().getVelocity()) {
                carpet.carpetFly();
            }
        }
    }

    @Override
    public void end(boolean interrupted) {
        carpet.stopCarpet();
    }
    
}
