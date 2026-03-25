// package frc.robot.subsystems;

// import edu.wpi.first.math.geometry.Pose3d;
// import edu.wpi.first.networktables.NetworkTable;
// import edu.wpi.first.networktables.NetworkTableEntry;
// import edu.wpi.first.networktables.NetworkTableInstance;
// import edu.wpi.first.units.measure.Distance;
// import frc.robot.LimelightHelpers;
// import frc.robot.command.NewRepeatedCommand;

// public class EstimateDistance extends NewRepeatedCommand{
//     @Override
//     public void execute() {
//     // Get the 3D pose of the target relative to the camera
//     Pose3d targetPose = LimelightHelpers.getTargetPose3d_CameraSpace("limelight");

//     // The 'z' translation in camera space is the direct distance to the tag
//     double distanceInMeters = targetPose.getZ(); 

//     System.out.println(distanceInMeters);
//     System.out.println(LauncherCalculator.getRPMFromDistance());

//     }

//     @Override
//     public void end(boolean interrupted) {
       
//     }
// }
