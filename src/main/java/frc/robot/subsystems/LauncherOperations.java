package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.RobotHardware;

import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

public class LauncherOperations implements Subsystem{
    
    RobotHardware robotHardware;
    int output;

    public LauncherOperations(){
       robotHardware = RobotHardware.getInstance();
    }

    public void startMoveTest(double rpm){
        robotHardware.leftLauncherMotor.getClosedLoopController().setSetpoint(rpm, SparkMax.ControlType.kVelocity);
        robotHardware.rightLauncherMotor.getClosedLoopController().setSetpoint(rpm, SparkMax.ControlType.kVelocity);
    }

    public void endMoveTest(){
        robotHardware.leftLauncherMotor.set(0);
        robotHardware.rightLauncherMotor.set(0);
    }

    public void setSpeed(int rpm){
        output = Math.min(rpm, 5000);
        output = Math.max(rpm, 0);
        // robotHardware.leftLauncherMotor.set(output);
        // robotHardware.rightLauncherMotor.set(output);
    }

    // create new methods for changing rpm plz

    // public void launchAtRPM
}
