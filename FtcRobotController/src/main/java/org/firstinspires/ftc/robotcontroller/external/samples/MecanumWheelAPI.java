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
    public DcMotor leftMotor;
    public DcMotor rightMotor;

    HardwareMap hwMap = null;

    //Constructor
    public MecanumWheelAPI (HardwareMap hwMap){
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

    //used to move horizontally to the left
    public void strafeLeft(float percentage){
        leftMotor.setPower(percentage);
        rightMotor.setPower(-percentage);
    }

    //used to move horizontally to the right
    public void strafeRight(float percentage){
        leftMotor.setPower(-percentage);
        rightMotor.setPower(percentage);
    }

    //used to move diagonally to the left
    public void leftDiagonal(float percentage){
        percentage = percentage * reverse;
        rightMotor.setPower(percentage);
    }

    public void autonomousStrafeLeft(float percentage){
        percentage = percentage * reverse;
        leftMotor.setPower(percentage);
        rightMotor.setPower(-percentage);
    }

    public void autonomousStrafeRight(float percentage) {
        percentage = percentage * reverse;
        leftMotor.setPower(-percentage);
        rightMotor.setPower(percentage);
    }

    //used to move diagonally to the right
    public void rightDiagonal(float percentage){
        percentage = percentage * reverse;
        leftMotor.setPower(percentage);
    }

    public void setLeftMotor(float power) {
        leftMotor.setPower(power);
    }

    public void setRightMotor(float power) {
        rightMotor.setPower(power);
    }

}
