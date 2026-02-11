package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.Subsystem;

import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

public class Test implements Subsystem{
    
    private final SparkMax motor;
    // private final SparkClosedLoopController motorPid;

    public Test(){
        motor = new SparkMax(40, MotorType.kBrushless);
        // motorPid = motor.getClosedLoopController();
        SparkMaxConfig config = new SparkMaxConfig();
        config
            .inverted(false)
            .idleMode(IdleMode.kBrake);
        config.encoder
            .positionConversionFactor(1000)
            .velocityConversionFactor(1000);
        config.closedLoop
            .feedbackSensor(com.revrobotics.spark.FeedbackSensor.kPrimaryEncoder)
            .pid(1.0, 0.1, 0.0);

        motor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    }

    public void startMoveTest(){
        motor.set(0.2);
    }

    public void endMoveTest(){
        motor.set(0);
    }

}
