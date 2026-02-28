package frc.robot.command;

import frc.robot.RobotHardware;
import frc.robot.subsystems.ChangeCentricity;
// import frc.robot.command.newRepeatedCommand;

public class ChangeCentricityControl extends NewRepeatedCommand{
    public enum Directionality{
        FIELD,
        BACKWARDS
    }

    private final ChangeCentricity ChangeCentricity;
    private Directionality direction;
    private boolean isRobotCentric = false;

    public ChangeCentricityControl(Directionality directionality){
        System.out.println("I WAS CALLED ChangeCentricityControlChangeCentricityControlChangeCentricityControl!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
        this.ChangeCentricity = RobotHardware.getInstance().changeCentricity;
        this.direction = directionality;
    }
    
    @Override
    public void initialize(){

    }

    @Override
    public void execute() {
        if(direction == Directionality.FIELD){
            ChangeCentricity.setFieldCentric();
        }else if(direction == Directionality.BACKWARDS){
            ChangeCentricity.setBackwards();
        }

    }

    @Override
    public void end(boolean interrupted) {
    }


}
