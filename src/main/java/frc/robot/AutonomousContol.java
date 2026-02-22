package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.commands.PathPlannerAuto;

public class AutonomousContol {

private final SendableChooser<Command> autoChooser;

    public AutonomousContol(){
        AutoBuilder autoBuilder = new AutoBuilder();

        

        autoChooser = AutoBuilder.buildAutoChooser();

        SmartDashboard.putData("Auto Chooser", autoChooser);

    }

    public Command getAuntonomousCommand(){
        return autoChooser.getSelected();
    }
}
