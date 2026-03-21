package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Pose3d;
import frc.robot.LimelightHelpers;
import frc.robot.subsystems.EstimateDistance;

public class LauncherCalculator {

    public static double getRPMFromDistance() {

        Pose3d targetPose = LimelightHelpers.getTargetPose3d_CameraSpace("limelight");

        // The 'z' translation in camera space is the direct distance to the tag
        double distanceInMeters = targetPose.getZ(); 
        System.out.println(distanceInMeters);

        // Inputs
        double distanceToTarget = distanceInMeters; // meters
        double launchAngleDegrees = 25.0; // degrees
        double wheelDiameter = 0.1016; // 100mm, in meters
            
        // 1. Calculate Required Velocity (v)
        double angleRad = Math.toRadians(launchAngleDegrees);
        double gravity = 9.81;
        // Simplified formula: v = sqrt(d * g / sin(2 * theta))
        double velocityRequired = Math.sqrt((distanceToTarget * gravity) / Math.sin(2 * angleRad));
            
        // 2. Convert Velocity to RPM
        // RPM = (v * 60) / (pi * Diameter)
        double distanceRPM = (velocityRequired * 60) / (Math.PI * wheelDiameter);
            
        System.out.println("Required Velocity: " + String.format("%.2f", velocityRequired) + " m/s");
        System.out.println("Required RPM: " + String.format("%.0f", distanceRPM));

        return distanceRPM + 2000;


    }
}
