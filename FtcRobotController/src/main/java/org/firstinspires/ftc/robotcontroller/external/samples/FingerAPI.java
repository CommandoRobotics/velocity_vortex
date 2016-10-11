package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by CHHS on 10/4/2016.
 */
public class FingerAPI {
    public Servo fingerLeft = null;
    public Servo fingerRight = null;
    HardwareMap hwMap = null;
    public FingerAPI(){
    }
    public void init(HardwareMap tempHwMap){
        hwMap = tempHwMap;
        fingerLeft = hwMap.servo.get("leftFinger");
        fingerRight = hwMap.servo.get("rightFinger");
        fingerRight.setDirection(Servo.Direction.REVERSE);
        fingerLeft.setDirection(Servo.Direction.FORWARD);
        fingerLeft.setPosition(0);
        fingerRight.setPosition(0);



    }


    public void rightFinger (float percentage){
        fingerRight.setPosition(percentage);

    }
    public void leftFinger (float percentage){
        fingerLeft.setPosition(percentage);
    }







}
