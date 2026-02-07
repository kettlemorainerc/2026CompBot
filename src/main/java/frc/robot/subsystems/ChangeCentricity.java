package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.generated.TunerConstants;

import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkMax;

import static edu.wpi.first.units.Units.MetersPerSecond;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.RotationsPerSecond;

import com.ctre.phoenix6.swerve.SwerveModule.DriveRequestType;
import com.ctre.phoenix6.swerve.SwerveRequest;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj2.command.button.*;
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine.Direction;
import frc.robot.RobotHardware;
import frc.robot.command.*;
import frc.robot.control.DriveJoystick;
import frc.robot.control.DriveStick;
import frc.robot.control.DriveXboxController;
import frc.robot.generated.TunerConstants;
import frc.robot.subsystems.CommandSwerveDrivetrain;

public class ChangeCentricity implements Subsystem{

    public static double MaxSpeed = TunerConstants.kSpeedAt12Volts.in(MetersPerSecond); // kSpeedAt12Volts desired top speed
    public static double MaxAngularRate = RotationsPerSecond.of(0.75).in(RadiansPerSecond); // 3/4 of a rotation per second max angular velocity

    public static final SwerveRequest.RobotCentric robotDrive = new SwerveRequest.RobotCentric()
        .withDeadband(MaxSpeed * 0.1).withRotationalDeadband(MaxAngularRate * 0.1) // Add a 10% deadband
        .withDriveRequestType(DriveRequestType.OpenLoopVoltage); // Use open-loop control for drive motors

    public static final SwerveRequest.FieldCentric fieldDrive = new SwerveRequest.FieldCentric()
        .withDeadband(MaxSpeed * 0.1).withRotationalDeadband(MaxAngularRate * 0.1) // Add a 10% deadband
        .withDriveRequestType(DriveRequestType.OpenLoopVoltage); // Use open-loop control for drive motors
    public static SwerveRequest.SwerveDriveBrake brake = new SwerveRequest.SwerveDriveBrake();
    public static SwerveRequest.PointWheelsAt point = new SwerveRequest.PointWheelsAt();


    private CommandSwerveDrivetrain drivetrain = RobotHardware.getInstance().drivetrain;
    private CommandXboxController driveNewJoystick = null;

    public void setDriveStick(CommandXboxController driveNewJoystick){
        this.driveNewJoystick = driveNewJoystick;
    }

    public void setFieldCentric(){
        System.out.println("I WAS CALLED !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
        drivetrain.setControl(
            fieldDrive.withVelocityX(-driveNewJoystick.getLeftY() * MaxSpeed * 0.1) // Drive forward with negative Y (forward)
                    .withVelocityY(-driveNewJoystick.getLeftX() * MaxSpeed * 0.1) // Drive left with negative X (left)
                    .withRotationalRate(-driveNewJoystick.getRightX() * MaxAngularRate * 0.5) // Drive counterclockwise with negative X (left)
            );

    }

    public void setRobotCentric(){
        drivetrain.setControl(
            robotDrive.withVelocityX(-driveNewJoystick.getLeftY() * MaxSpeed * 0.1) // Drive forward with negative Y (forward)
                    .withVelocityY(-driveNewJoystick.getLeftX() * MaxSpeed * 0.1) // Drive left with negative X (left)
                    .withRotationalRate(-driveNewJoystick.getRightX() * MaxAngularRate * 0.5) // Drive counterclockwise with negative X (left)
            );
    }


}
