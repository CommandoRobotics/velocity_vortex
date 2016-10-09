package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by CHHS on 10/6/2016.
 */
public class CollecterAPI {
    //get hardware
    public DcMotor collecter_Right = null;
    public DcMotor collector_Left = null;
    HardwareMap hw_Map = null;
    //tell what other opmodes will call it
    public CollecterAPI (){

    }
//tell what to do at init and find motors
    public void init(HardwareMap temp_Hw_Map){
        hw_Map = temp_Hw_Map;
        collecter_Right = hw_Map.dcMotor.get("right_shooter");
        collector_Left = hw_Map.dcMotor.get("left_shooter");
       collecter_Right.setDirection(DcMotor.Direction.FORWARD);
       collector_Left.setDirection(DcMotor.Direction.REVERSE);

        collecter_Right.setPower(0);
        collector_Left.setPower(0);

    }
//tell what to use in other classes to use the collecter
    public void Run_Collecter(float percentage){
        collecter_Right.setPower(percentage);
        collector_Left.setPower(percentage);}}
