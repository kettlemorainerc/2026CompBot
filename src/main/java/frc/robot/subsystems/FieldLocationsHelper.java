package frc.robot.subsystems;

import java.lang.reflect.Field;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.LimelightHelpers;
import frc.robot.Robot;
import frc.robot.RobotHardware;

public class FieldLocationsHelper implements Subsystem {

    private static FieldLocationsHelper instance = null;

    private static CommandSwerveDrivetrain drivetrain;

    public static FieldLocationsHelper getInstance(){
        if(instance == null) instance = new FieldLocationsHelper();
        return instance;
    }

    public FieldLocationsHelper(){
        instance = this;
        
    }

    public static Pose2d getRobotFieldPose() {
        if (drivetrain == null) {
            drivetrain = RobotHardware.getInstance().drivetrain;
        }

        Pose2d limelightPose = LimelightHelpers.getBotPoseEstimate_wpiBlue("limelight").pose;
        Pose2d drivetrainPose = drivetrain.getState().Pose;
  
        if(limelightPose.getX() == 0 && limelightPose.getY() == 0){
            //If limelightPose is 0 it is assumed bad and uses pigeon
            return drivetrainPose;
        }else{
            drivetrain.resetPose(limelightPose);

            return limelightPose;
        }
    }

    public Distance getDistanceFromRobot(Pose2d targetPose) {
        Pose2d robotPose = getRobotFieldPose();
        Double deltaX = targetPose.getX()-robotPose.getX();
        Double deltaY = targetPose.getY()-robotPose.getY();
        Double calculation = Math.sqrt(Math.pow(deltaX, 2)+Math.pow(deltaY,2));

        return targetPose.getMeasureX().unit().of(calculation); 
    }

}