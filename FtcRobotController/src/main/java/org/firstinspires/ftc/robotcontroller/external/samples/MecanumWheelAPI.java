package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


/**
 * Created by casciarobotics on 10/4/16.
 */
public class MecanumWheelAPI {
    //TODO: This will be set to -1 if our team color is (red/blue).
    public int reverse = 1;

    //define Motors
    public DcMotor topLeftMotor;
    public DcMotor bottomLeftMotor;
    public DcMotor topRightMotor;
    public DcMotor bottomRightMotor;

    HardwareMap hwMap = null;

    //Constructor
    public MecanumWheelAPI (){

    }

    //initialization function to set variables
    public void init (HardwareMap tempHwMap){
        hwMap = tempHwMap;

        topLeftMotor = hwMap.dcMotor.get("topLeftMotor");
        topRightMotor = hwMap.dcMotor.get("topRightMotor");
        bottomLeftMotor = hwMap.dcMotor.get("bottomLeftMotor");
        bottomRightMotor = hwMap.dcMotor.get("bottomRightMotor");
        topRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        bottomRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        drive(0f, 0f);
    }

    //used to drive takes two joystick values to control each side independently
    public void drive(float leftPercentage,float rightPercentage){
        leftPercentage *= reverse;
        rightPercentage *= reverse;
        bottomLeftMotor.setPower(leftPercentage);
        topLeftMotor.setPower(leftPercentage);
        bottomRightMotor.setPower(rightPercentage);
        topRightMotor.setPower(rightPercentage);
    }

    //used to move horizontally to the left
    public void strafeLeft(float percentage){
        percentage = percentage * reverse;
        topLeftMotor.setPower(-percentage);
        bottomLeftMotor.setPower(percentage);
        topRightMotor.setPower(percentage);
        bottomRightMotor.setPower(-percentage);
    }

    //used to move horizontally to the right
    public void strafeRight(float percentage){
        percentage = percentage * reverse;
        topLeftMotor.setPower(percentage);
        bottomLeftMotor.setPower(-percentage);
        topRightMotor.setPower(-percentage);
        bottomRightMotor.setPower(percentage);
    }

    //used to move diagonally to the left
    public void leftDiagonal(float percentage){
        percentage = percentage * reverse;
        bottomLeftMotor.setPower(percentage);
        topRightMotor.setPower(percentage);
    }

    //used to move diagonally to the right
    public void rightDiagonal(float percentage){
        percentage = percentage * reverse;
        topLeftMotor.setPower(percentage);
        bottomRightMotor.setPower(percentage);
    }

}
