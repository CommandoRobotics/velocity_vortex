package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by casciarobotics on 10/6/16.
 */
public class HopperAPI {
    //The central motor for turning the hopper and the servo for closing it. There also is a backup motor that runs at the same time.
    DcMotor mainMotor;
//    Servo door;

    //opening and closing the doors; change these to change all references
    private final float OPEN = 1;
    private final float CLOSED = 0;

    private boolean on = false;
    private float percentage = 0.0f;

    public HopperAPI (HardwareMap hardwareMap){
        init(hardwareMap);
        on = false;
    }

    public void init (HardwareMap hw){
        HardwareMap map = hw;

        mainMotor = hw.dcMotor.get("hopperMain");

        mainMotor.setDirection(DcMotorSimple.Direction.FORWARD);

//        door = hw.servo.get("hopperDoor");
    }

//    public void openDoor() {
//        door.setPosition(OPEN);
//    }

//    public void closeDoor() {
//        door.setPosition(CLOSED);
//    }

    public void beginLifting() {
        mainMotor.setPower(-percentage);
    }

    public void beginLowering() {
        mainMotor.setPower(percentage);
    }

    public void stop() {
        mainMotor.setPower(0.0f);
    }

    public void toggleOn(float percentage) {
        this.percentage = Math.abs(percentage);

        if(on) {
            mainMotor.setPower(0);
            on = false;
        } else {
            on = true;
            mainMotor.setPower(percentage);
        }
    }

    public boolean getOn() {
        return on;
    }

}
