package frc.robot.command;

import frc.robot.RobotHardware;
import frc.robot.subsystems.Test;
// import frc.robot.command.newRepeatedCommand;
import frc.robot.util.Elastic;



public class TestControl extends NewRepeatedCommand{
    private final Test test;
    private Elastic.Notification notification = new Elastic.Notification(Elastic.NotificationLevel.ERROR, "OH MY GOD ITS ON FIRE", "WE ARE ALL GOING TO DIE");

    public TestControl(){
        test = RobotHardware.getInstance().test;
    }
    
    @Override
    public void initialize(){
        Elastic.sendNotification(notification);
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
        // test.endMoveTest();
    }


}
