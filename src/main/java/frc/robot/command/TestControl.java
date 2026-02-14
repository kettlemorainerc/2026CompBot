package frc.robot.command;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotHardware;
import frc.robot.subsystems.LauncherOperations;
// import frc.robot.command.newRepeatedCommand;
import frc.robot.util.Elastic;



public class TestControl extends NewRepeatedCommand{
    private final LauncherOperations test;
    private Elastic.Notification notification = new Elastic.Notification(Elastic.NotificationLevel.ERROR, "OH MY GOD ITS ON FIRE", "WE ARE ALL GOING TO DIE");

    public TestControl(){
        test = RobotHardware.getInstance().launcherOperations;
    }
    
    @Override
    public void initialize(){
        test.startMoveTest(1000);
        Elastic.sendNotification(notification);
        SmartDashboard.putNumber("TestNumberKey", 1);
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
        // test.endMoveTest();
    }


}
