// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import org.photonvision.PhotonCamera;

import com.revrobotics.spark.SparkMax;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.FieldObject2d;
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
  double timeRemaining = Timer.getMatchTime();

  private int autoTick;

  private double testdirection;


  public static final Field2d m_field = new Field2d();
  PhotonCamera camera = new PhotonCamera("Camera_Module_v1");
  private SparkMax leftLaucherMotor;



  // private final RobotContainer m_robotContainer;

  @Override public void robotInit() {
    hardware = new RobotHardware();
    driveStation = new DriveStation(hardware);

// TODO: THIS IS FINE, WE WILL MOVE THIS

    CommandSwerveDrivetrain drivetrain = hardware.drivetrain;
    leftLaucherMotor = hardware.leftLauncherMotor;

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
        
      }
    });


    // TODO: We will also move this
  // public void Field2d(){
  //   public FieldObject2d getObject();
  // }
    // Do this in either robot or subsystem init
    SmartDashboard.putData("Field", m_field);

    // ADDDDD elastic widget for motor rpm
    
    


  }

  public Robot() {
    Shuffleboard.getTab("Teleoperated").addCamera("DriverCamera", "testCamera","http://10.20.77.200:1181/stream.mjpg");
    // m_robotContainer = new RobotContainer();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run(); 
    // Do this in either robot periodic or subsystem periodic
    
    SmartDashboard.putNumber("Match Timer", Timer.getMatchTime());
    SmartDashboard.putNumber("Motor Rpm", leftLaucherMotor.getEncoder().getVelocity());


    var results = camera.getAllUnreadResults();
    for (var result : results) {
      var multiTagResult = result.getMultiTagResult();
      if (multiTagResult.isPresent()) {
        var fieldToCamera = multiTagResult.get().estimatedPose.best;
        m_field.setRobotPose(new Pose2d(fieldToCamera.getX(),fieldToCamera.getY(), fieldToCamera.getRotation().toRotation2d()));
      }
    }
    
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
