// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.command.DriveDistance;
import frc.robot.generated.TunerConstants;
import frc.robot.subsystems.CommandSwerveDrivetrain;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  private DriveStation driveStation;
  private RobotHardware hardware;
  private final Command testAuto = new DriveDistance();

  private int autoTick;

  private double testdirection;

  // private final RobotContainer m_robotContainer;

  @Override public void robotInit() {
    hardware = new RobotHardware();
    driveStation = new DriveStation(hardware);
    

// TODO: THIS IS FINE, WE WILL MOVE THIS

    CommandSwerveDrivetrain drivetrain = hardware.drivetrain;


    CameraServer.startAutomaticCapture();
    SmartDashboard.putData("Swerve Drive", new Sendable() {

  @Override
  public void initSendable(SendableBuilder builder) {
    builder.setSmartDashboardType("SwerveDrive");

    builder.addDoubleProperty("Back Right Angle", () -> drivetrain.getModule(0).getSteerMotor().getPosition().getValueAsDouble(), null);
    builder.addDoubleProperty("Back Right Velocity", () -> drivetrain.getModule(0).getDriveMotor().getVelocity().getValueAsDouble(), null);

    builder.addDoubleProperty("Back Left Angle", () -> drivetrain.getModule(1).getSteerMotor().getPosition().getValueAsDouble(), null);
    builder.addDoubleProperty("Back Left Velocity", () -> drivetrain.getModule(1).getDriveMotor().getVelocity().getValueAsDouble(), null);
    builder.addDoubleProperty("Front Left Angle", () -> drivetrain.getModule(2).getSteerMotor().getPosition().getValueAsDouble(), null);
    builder.addDoubleProperty("Front Left Velocity", () -> drivetrain.getModule(2).getDriveMotor().getVelocity().getValueAsDouble(), null);

    builder.addDoubleProperty("Front Right Angle", () -> drivetrain.getModule(3).getSteerMotor().getPosition().getValueAsDouble(), null);
    builder.addDoubleProperty("Front Right Velocity", () -> drivetrain.getModule(3).getDriveMotor().getVelocity().getValueAsDouble(), null);

    builder.addDoubleProperty("Robot Angle", () -> drivetrain.getRotation3d().getAngle(), null);

    // builder.addDoubleProperty("Front Left Angle", () -> 1, null);
    // builder.addDoubleProperty("Front Left Velocity", () -> 1, null);

    // builder.addDoubleProperty("Front Right Angle", () -> 1, null);
    // builder.addDoubleProperty("Front Right Velocity", () -> 1, null);

    // builder.addDoubleProperty("Back Left Angle", () -> 1, null);
    // builder.addDoubleProperty("Back Left Velocity", () -> 1, null);

    // builder.addDoubleProperty("Back Right Angle", () -> 1, null);
    // builder.addDoubleProperty("Back Right Velocity", () -> 1, null);
  }
});
  }

  public Robot() {
    Shuffleboard.getTab("Teleoperated").addCamera("DriverCamera", "testCamera","http://10.20.77.200:1181/stream.mjpg");
    // m_robotContainer = new RobotContainer();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run(); 
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void disabledExit() {}

  @Override
  public void autonomousInit() {
    autoTick = 0;
    // m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // if (m_autonomousCommand != null) {
    //   m_autonomousCommand.schedule();
    // }

    
  }

  @Override
  public void autonomousPeriodic() {
    // autoTick++;
    // if(autoTick == 1){
    //     SequentialCommandGroup auto = new SequentialCommandGroup();
    //         auto.addCommands(
    //             new AutoLaunch()
    //         );
    //     }

    //     auto.schedule();
    // }
  }

  @Override
  public void autonomousExit() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {}

  @Override
  public void teleopExit() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void testExit() {}

  @Override
  public void simulationPeriodic() {}
}
