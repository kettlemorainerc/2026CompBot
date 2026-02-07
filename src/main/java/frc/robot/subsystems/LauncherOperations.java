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

    public LauncherOperations(){
       robotHardware = RobotHardware.getInstance();
    }

    public void startMoveTest(double rpm){
        robotHardware.leftLauncherMotor.getClosedLoopController().setSetpoint(rpm, SparkMax.ControlType.kVelocity);
    }

    public void endMoveTest(){
        robotHardware.leftLauncherMotor.set(0);
    }

}
