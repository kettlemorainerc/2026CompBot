package frc.robot;

import frc.robot.generated.TunerConstants;
import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.Test;

public class RobotHardware{

    private static RobotHardware instance = null;
    public static CommandSwerveDrivetrain drivetrain = null;

    /* CAN Ordering:
     * 0-20 (Avoided to exclude legacy setups)
     * 21-30 (Swerve Drive Modules)
     *     - Even: Magnitude
     *     - Odd: Angle
     * 31-40 (Encoders+)
     * 41-50 (Reserved for future uses)
     * 50-70 (Other Motors)
     */

    //  TODO: Turn into enums swapappable 
    /**
     * Even = Drive
     * Odd = Steer
     * A = 20 = Front Right
     * B = 22 = Back Right
     * C = 24 = Front Left
     * D = 26 = Back Left
     * 
     * 
     */

    public static RobotHardware getInstance(){
        if(instance == null) instance = new RobotHardware();
        return instance;
    }

    public final Test test;

    public RobotHardware(){
        instance = this;

        test = new Test();
        drivetrain = TunerConstants.createDrivetrain();
    }



}
