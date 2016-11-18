package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by CHHS on 10/4/2016.
 */
public class FingerAPI {
    public Servo fingerLeft;
    public Servo fingerRight;
    HardwareMap hwMap;

    private float leftFingerTarget;
    private float rightFingerTarget;

    public FingerAPI (HardwareMap hardwareMap){
        init(hardwareMap);
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


    public void setRightFingerTarget (float percentage){
        rightFingerTarget = percentage;
    }
    public void setLeftFingerTarget (float percentage){
        leftFingerTarget = percentage;
    }

    public void updateFingers() {
        if(fingerRight.getPosition() > rightFingerTarget) {
            rightFingerTarget = 0;
            fingerRight.setPosition(rightFingerTarget);
        }

        if(fingerLeft.getPosition() > leftFingerTarget) {
            leftFingerTarget = 0;
            fingerLeft.setPosition(leftFingerTarget);
        }
    }
    public float getLeftFingerTarget() {
        return leftFingerTarget;
    }

    public float getRightFingerTarget() {
        return rightFingerTarget;
    }
}
