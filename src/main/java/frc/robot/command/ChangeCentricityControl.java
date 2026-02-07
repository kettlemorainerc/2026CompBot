package frc.robot.command;

import frc.robot.RobotHardware;
import frc.robot.subsystems.ChangeCentricity;
// import frc.robot.command.newRepeatedCommand;

public class ChangeCentricityControl extends NewRepeatedCommand{
    private final ChangeCentricity ChangeCentricity;

    private boolean isRobotCentric = false;

    public ChangeCentricityControl(){
        System.out.println("I WAS CALLED ChangeCentricityControlChangeCentricityControlChangeCentricityControl!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
        this.ChangeCentricity = RobotHardware.getInstance().changeCentricity;
    }
    
    @Override
    public void initialize(){
        System.out.println(isRobotCentric);
        if(isRobotCentric == true){
            ChangeCentricity.setFieldCentric();
            isRobotCentric = false;
            System.out.println("Set to field centric");
        }else{
            ChangeCentricity.setRobotCentric();
            isRobotCentric = true;
            System.out.println("Set to robot centric");
        }
        System.out.println(isRobotCentric);
    }

    @Override
    public void execute() {
                System.out.println("REALLY INEFICENT");
            ChangeCentricity.setFieldCentric();

    }

    @Override
    public void end(boolean interrupted) {
    }


}
