package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by CHHS on 10/29/2016.
 */
public class ControllerTest extends OpMode{
    MecanumWheelAPI driveTrain;
    HopperAPI hopper;
    CollecterAPI collector;
    ShooterAPI shooter;
    FingerAPI fingers;

    public void init() {
//        driveTrain = new MecanumWheelAPI(hardwareMap);
//        hopper = new HopperAPI(hardwareMap);
//        collector = new CollecterAPI(hardwareMap);
//        shooter = new ShooterAPI(hardwareMap);
//        fingers = new FingerAPI(hardwareMap);
    }

    public void loop() {
        moveRobot();
    }

    private void moveRobot() {
        //for those who want to control with the joysticks
        telemetry.addData("LeftX: ", gamepad1.left_stick_x);
        telemetry.addData("LeftY: ", gamepad1.left_stick_y);
        telemetry.addData("RightX: ", gamepad1.right_stick_x);
        telemetry.addData("RightY: ", gamepad1.right_stick_y);

        telemetry.addData("Left Trigger:", gamepad1.left_trigger);
        telemetry.addData("Right Trigger:", gamepad1.right_trigger);
    }
}
