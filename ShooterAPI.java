package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by CHHS on 10/4/2016.
 */
public class ShooterAPI {
    //get hardware
    public DcMotor shooter_Right = null;
    public DcMotor shooter_Left = null;
    HardwareMap hw_Map = null;
    //tell what other opmodes will call it
    public ShooterAPI (){

    }

    public void init(HardwareMap temp_Hw_Map){
        hw_Map = temp_Hw_Map;
        shooter_Right = hw_Map.dcMotor.get("right_shooter");
        shooter_Left = hw_Map.dcMotor.get("left_shooter");
        shooter_Right.setDirection(DcMotor.Direction.FORWARD);
        shooter_Left.setDirection(DcMotor.Direction.REVERSE);

        shooter_Left.setPower(0);
        shooter_Right.setPower(0);

    }

public void Run_Shooter(float percentage){
    shooter_Right.setPower(percentage);
    shooter_Left.setPower(percentage);


}












}
