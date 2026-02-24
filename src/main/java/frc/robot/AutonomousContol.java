package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.command.LauncherControl;
import frc.robot.command.RPMChangeHolder;

import javax.sound.sampled.SourceDataLine;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.commands.PathPlannerAuto;

public class AutonomousContol {

private final SendableChooser<Command> autoChooser;

    public AutonomousContol(){
        RPMChangeHolder rpm = new RPMChangeHolder(4000);

        NamedCommands.registerCommand("Debug", Commands.print("DEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUG"));
        NamedCommands.registerCommand("Launcher Forward", new LauncherControl(rpm));

        autoChooser = AutoBuilder.buildAutoChooser();

        SmartDashboard.putData("Auto Chooser", autoChooser);

    }


    public Command getAuntonomousCommand(){
        return autoChooser.getSelected();
    }
}
