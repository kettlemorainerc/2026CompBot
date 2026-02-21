package frc.robot.command;

import frc.robot.RobotHardware;
import frc.robot.subsystems.Roomba;

import frc.robot.subsystems.Roomba;

public class RoombaControls extends NewRepeatedCommand {
    public enum RoombaDirection{
        START,
        REVERSE
    }

    private final RoombaDirection direction;
    private final Roomba roomba;

    public RoombaControls(RoombaDirection direction){
        this.direction = direction;
        roomba = RobotHardware.getInstance().roomba;
    }


    @Override
    public void execute() {
        if(direction == RoombaDirection.START){
            roomba.startRoomba();
        }
        if(direction == RoombaDirection.REVERSE){
            roomba.reverseRoomba();
        }
    }

    @Override
    public void end(boolean interrupted) {
        roomba.stopRoomba();
    }
    
}
