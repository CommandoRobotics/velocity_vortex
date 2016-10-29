package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by CHHS on 10/4/2016.
 */
public class ShooterAPI {
    //get hardware
    public DcMotor rightShooter = null;
    public DcMotor leftShooter = null;

    HardwareMap hwMap = null;
    //tell what other opmodes will call it
    public ShooterAPI (HardwareMap hardwareMap){
        init(hardwareMap);
    }

    public void init(HardwareMap tempHwMap){
        hwMap = tempHwMap;
        rightShooter = hwMap.dcMotor.get("rightShooter");
        leftShooter = hwMap.dcMotor.get("leftShooter");
        rightShooter.setDirection(DcMotor.Direction.FORWARD);
        leftShooter.setDirection(DcMotor.Direction.REVERSE);

        leftShooter.setPower(0);
        rightShooter.setPower(0);
    }

    public void runShooter(float percentage){
        rightShooter.setPower(percentage);
        leftShooter.setPower(percentage);
    }

    public void toggleOn(float percentage) {
        if(rightShooter.getPower() > 0 || leftShooter.getPower() > 0) {
            rightShooter.setPower(0);
            leftShooter.setPower(0);
        } else {
            rightShooter.setPower(percentage);
            leftShooter.setPower(percentage);
        }
    }
}
