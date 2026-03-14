package frc.robot.command;

import edu.wpi.first.networktables.DoubleSubscriber;
import edu.wpi.first.networktables.FloatSubscriber;
import edu.wpi.first.networktables.FloatTopic;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotHardware;
import frc.robot.subsystems.CommandSwerveDrivetrain;

public class PIDHURTSMYHEAD extends NewRepeatedCommand {

    NetworkTableInstance netTableInst = NetworkTableInstance.getDefault();
    FloatTopic p1Topic;  
    FloatSubscriber p1Sub;
    FloatTopic i1Topic;  
    FloatSubscriber i1Sub;
    FloatTopic d1Topic;  
    FloatSubscriber d1Sub;
    FloatTopic p2Topic;  
    FloatSubscriber p2Sub;
    FloatTopic i2Topic;  
    FloatSubscriber i2Sub;
    FloatTopic d2Topic;  
    FloatSubscriber d2Sub;
    

    private final CommandSwerveDrivetrain drivetrain;


    DoubleSubscriber dblSub;

    public PIDHURTSMYHEAD(){
        this.drivetrain = RobotHardware.getInstance().drivetrain;
        this.p1Topic = netTableInst.getFloatTopic("P1");  
        this.p1Sub = p1Topic.subscribe(0.0f);
        this.i1Topic = netTableInst.getFloatTopic("I1");  
        this.i1Sub = i1Topic.subscribe(0.0f);
        this.d1Topic = netTableInst.getFloatTopic("D1");  
        this.d1Sub = d1Topic.subscribe(0.0f);
        this.p2Topic = netTableInst.getFloatTopic("P2");  
        this.p2Sub = p2Topic.subscribe(0.0f);
        this.i2Topic = netTableInst.getFloatTopic("I2");  
        this.i2Sub = i2Topic.subscribe(0.0f);
        this.d2Topic = netTableInst.getFloatTopic("D2");  
        this.d2Sub = d2Topic.subscribe(0.0f);
                           
    }

    @Override
    public void initialize(){
        drivetrain.configureAuto(p1Sub.get(), i1Sub.get(), d1Sub.get(), p2Sub.get(), i2Sub.get(), d2Sub.get());
    }

    @Override
    public void execute() {
        
    }

    @Override
    public void end(boolean interrupted) {
        
    }

}
