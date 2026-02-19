package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import com.pathplanner.lib.commands.PathPlannerAuto;

public class AutonomousContol {
    public Command getAuntonomousCommand(){
        System.out.println("I be making a making thing to be made and now am going to ramble to make sure that I can find this thing because it is hurting my head.");
        return new PathPlannerAuto("Spin");
    }
}
