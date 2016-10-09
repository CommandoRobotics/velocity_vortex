package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by CHHS on 10/4/2016.
 */
public class FingerAPI {
    public Servo finger_Left = null;
    public Servo finger_Right = null;
    HardwareMap hw_Map = null;
    public FingerAPI(){
    }
    public void init(HardwareMap temp_Hw_Map){
        hw_Map = temp_Hw_Map;
        finger_Left = hw_Map.servo.get("right_finger");
        finger_Right = hw_Map.servo.get("left_finger");
        finger_Right.setDirection(Servo.Direction.REVERSE);
        finger_Left.setDirection(Servo.Direction.FORWARD);
        finger_Left.setPosition(0);
        finger_Right.setPosition(0);



    }


    public void Right_Finger (float percentage){
        finger_Right.setPosition(percentage);

    }
    public void Left_Finger (float percentage){
        finger_Left.setPosition(percentage);
    }







}
