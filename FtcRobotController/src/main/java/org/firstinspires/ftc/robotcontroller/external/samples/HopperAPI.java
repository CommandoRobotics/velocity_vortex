package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by casciarobotics on 10/6/16.
 */
public class HopperAPI {
    //The central motor for turning the hopper and the servo for closing it. There also is a backup motor that runs at the same time.
    DcMotor mainMotor;
    DcMotor supportMotor;
    Servo door;

    //opening and closing the doors; change these to change all references
    private final float OPEN = 1;
    private final float CLOSED = 0;

    public void init (HardwareMap hw){
        HardwareMap map = hw;

        mainMotor = hw.dcMotor.get("hopperMain");
        supportMotor = hw.dcMotor.get("hopperMain");

        mainMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        supportMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        door = hw.servo.get("hopperDoor");
    }

    public void openDoor() {
        door.setPosition(OPEN);
    }

    public void closeDoor() {
        door.setPosition(CLOSED);
    }

    public void beginLifting() {
        mainMotor.setPower(0.75f);
        supportMotor.setPower(0.75f);
    }

    public void beginLowering() {
        mainMotor.setPower(-0.75f);
        supportMotor.setPower(-0.75f);
    }

    public void stop() {
        mainMotor.setPower(0.0f);
        supportMotor.setPower(0.0f);
    }

}
