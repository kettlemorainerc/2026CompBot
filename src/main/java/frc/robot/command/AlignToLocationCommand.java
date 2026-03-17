package frc.robot.command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.RobotHardware;
import frc.robot.subsystems.LauncherOperations;
import frc.robot.subsystems.MagicCarpet;
// import frc.robot.command.newRepeatedCommand;


public class AlignToLocationCommand extends NewRepeatedCommand{

    double targetX;
    double targetY;

    public AlignToLocationCommand(double x, double y) {
        // Used for doing things based on global field pose
        targetX = x;
        targetY = y;
    }
    
    @Override
    public void initialize(){

    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {

    }
}
