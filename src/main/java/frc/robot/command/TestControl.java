package frc.robot.command;

import frc.robot.RobotHardware;
import frc.robot.subsystems.LauncherOperations;
// import frc.robot.command.newRepeatedCommand;

public class TestControl extends NewRepeatedCommand{
    private final LauncherOperations test;

    public TestControl(){
        test = RobotHardware.getInstance().launcherOperations;
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
