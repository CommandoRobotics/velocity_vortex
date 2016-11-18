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
    public DcMotor leftFrontMotor;
    public DcMotor leftRearMotor;
    public DcMotor rightFrontMotor;
    public DcMotor rightRearMotor;

    HardwareMap hwMap = null;

    //Constructor
    public MecanumWheelAPI (HardwareMap hwMap){
        init(hwMap);
    }

    //initialization function to set variables
    public void init (HardwareMap tempHwMap){
        hwMap = tempHwMap;

        leftFrontMotor = hwMap.dcMotor.get("leftFrontMotor");
        leftRearMotor = hwMap.dcMotor.get("leftRearMotor");
        rightFrontMotor = hwMap.dcMotor.get("rightFrontMotor");
        rightRearMotor = hwMap.dcMotor.get("rightRearMotor");
        rightFrontMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightRearMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        drive(0f, 0f);
    }

    //used to drive takes two joystick values to control each side independently
    public void drive(float leftPercentage,float rightPercentage){
        leftFrontMotor.setPower(leftPercentage);
        leftRearMotor.setPower(leftPercentage);
        rightFrontMotor.setPower(leftPercentage);
        rightRearMotor.setPower(leftPercentage);
    }

    //used to move horizontally to the left
    public void strafeLeft(float percentage){
        leftFrontMotor.setPower(percentage);
        leftRearMotor.setPower(-percentage);
        rightFrontMotor.setPower(-percentage);
        rightRearMotor.setPower(percentage);
    }

    //used to move horizontally to the right
    public void strafeRight(float percentage){
        strafeLeft(-percentage);
    }

    //used to move diagonally to the left
    public void leftDiagonal(float percentage){
        leftFrontMotor.setPower(0);
        leftRearMotor.setPower(percentage);
        rightFrontMotor.setPower(0);
        rightRearMotor.setPower(percentage);
    }

    public void autonomousTurnLeft(float percentage){
        leftFrontMotor.setPower(percentage);
        leftRearMotor.setPower(percentage);
        rightFrontMotor.setPower(-percentage);
        rightRearMotor.setPower(-percentage);
    }

    public void autonomousTurnRight(float percentage) {
        autonomousTurnLeft(-percentage);
    }

    public void turnLeft(float percentage){
        autonomousTurnLeft(percentage);
    }

    public void turnRight(float percentage) {
        autonomousTurnRight(percentage);
    }

    //used to move diagonally to the right
    public void rightDiagonal(float percentage){
        leftFrontMotor.setPower(percentage);
        leftRearMotor.setPower(0);
        rightFrontMotor.setPower(percentage);
        rightRearMotor.setPower(0);
    }

    public void setLeftMotor(float power) {

    }

    public void setRightMotor(float power) {


    }

    public void setReverse(boolean red) {
        if(red) reverse = 1;
        else reverse = -1;
    }
}
