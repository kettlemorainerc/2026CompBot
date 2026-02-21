package frc.robot.command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.RobotHardware;
import frc.robot.subsystems.LauncherOperations;
// import frc.robot.command.newRepeatedCommand;


//Max RPM of The Default NEO Spark Max's is 5,676 at 12Volts
//90% is 5,106.4


public class LauncherControl extends NewRepeatedCommand{
    private final LauncherOperations launcher;
    private final int changeByRPM;
    private final RPMChangeHolder holder;
    private final boolean isChanger;

    public LauncherControl(int rpm, RPMChangeHolder holder){
        launcher = RobotHardware.getInstance().launcherOperations;
        this.changeByRPM = rpm;
        this.holder = holder;
        isChanger = true;
    }

    public LauncherControl(RPMChangeHolder holder){
        launcher = RobotHardware.getInstance().launcherOperations;
        this.changeByRPM = 0;
        this.holder = holder;
        isChanger = false;
    }
    

    @Override
    public void initialize(){
        if(isChanger){
            holder.changeRPMTarget(changeByRPM);
        } else {
            launcher.startMoveTest(holder.getTargetRPM());
        }
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
        if(isChanger){
            
        } else {
            launcher.endMoveTest();
        }
    }
}
