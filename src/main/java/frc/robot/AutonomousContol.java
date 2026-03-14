package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.command.LauncherControl;
import frc.robot.command.MagicCarpetControls;
import frc.robot.command.RPMChangeHolder;
import frc.robot.command.RoombaControls;
import frc.robot.command.MagicCarpetControls.CarpetDirection;
import frc.robot.command.RoombaControls.RoombaDirection;

import javax.sound.sampled.SourceDataLine;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.commands.PathPlannerAuto;

public class AutonomousContol {

private final SendableChooser<Command> autoChooser;

    public AutonomousContol(){
        RPMChangeHolder rpm = new RPMChangeHolder(3000);
        RPMChangeHolder stopSpeed = new RPMChangeHolder(0);

        NamedCommands.registerCommand("Debug", Commands.print("DEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUG"));
        NamedCommands.registerCommand("Start Intake", new RoombaControls(RoombaDirection.START, true).withTimeout(0));
        NamedCommands.registerCommand("Stop Intake", new RoombaControls(RoombaDirection.STOP, true).withTimeout(0));
        NamedCommands.registerCommand("Reverse Intake", new RoombaControls(RoombaDirection.REVERSE, true).withTimeout(0));
        NamedCommands.registerCommand("Start Launcher", new LauncherControl(rpm, true).withTimeout(0));
        NamedCommands.registerCommand("Stop Launcher", new LauncherControl(stopSpeed, false).withTimeout(0));
        NamedCommands.registerCommand("Feed The Beast", new MagicCarpetControls(CarpetDirection.FALL
        , true).withTimeout(0));
        NamedCommands.registerCommand("Starve The Beast", new MagicCarpetControls(CarpetDirection.STOP, true).withTimeout(0));



        autoChooser = AutoBuilder.buildAutoChooser();

        SmartDashboard.putData("Auto Chooser", autoChooser);

    }


    public Command getAuntonomousCommand(){
        Command selected = autoChooser.getSelected();
        return selected;
    }
}
