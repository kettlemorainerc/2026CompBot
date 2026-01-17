package frc.robot.command;

import frc.robot.RobotHardware;
import frc.robot.subsystems.Test;
// import frc.robot.command.newRepeatedCommand;

public class TestControl extends NewRepeatedCommand{
    private final Test test;

    public TestControl(){
        test = RobotHardware.getInstance().test;
    }
    
    @Override
    public void initialize(){
        test.startMoveTest();
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
        test.endMoveTest();
    }


}
