package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


/**
 * Created by casciarobotics on 10/4/16.
 */
public class WheelAPI {
    //TODO: This will be set to -1 if our team color is (red/blue).
    public int reverse = 1;

    //define Motors
    public DcMotor leftMotor;
    public DcMotor rightMotor;

    HardwareMap hwMap = null;

    //Constructor
    public WheelAPI(HardwareMap hwMap){
        init(hwMap);
    }

    //initialization function to set variables
    public void init (HardwareMap tempHwMap){
        hwMap = tempHwMap;

        leftMotor = hwMap.dcMotor.get("leftMotor");
        rightMotor = hwMap.dcMotor.get("rightMotor");
        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        drive(0f, 0f);
    }

    //used to drive takes two joystick values to control each side independently
    public void drive(float leftPercentage,float rightPercentage){
        leftMotor.setPower(leftPercentage);
        rightMotor.setPower(rightPercentage);
    }


    public void autonomousTurnLeft(float percentage){ //This is based on Red
        leftMotor.setPower(-percentage);
        rightMotor.setPower(percentage);
    }

    public void autonomousTurnRight(float percentage) {
        autonomousTurnLeft(-percentage);
    }

    public void setReverse(boolean red) {
        if(red) reverse = 1;
        else reverse = -1;
    }
}
