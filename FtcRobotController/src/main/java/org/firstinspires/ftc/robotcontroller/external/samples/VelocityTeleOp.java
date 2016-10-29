package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by CHHS on 10/16/2016.
 */
public class VelocityTeleOp extends OpMode {

    MecanumWheelAPI driveTrain;
    HopperAPI hopper;
    CollecterAPI collector;
    ShooterAPI shooter;
    FingerAPI fingers;

    public void init() {
        driveTrain = new MecanumWheelAPI(hardwareMap);
        hopper = new HopperAPI(hardwareMap);
        collector = new CollecterAPI(hardwareMap);
        shooter = new ShooterAPI(hardwareMap);
        fingers = new FingerAPI(hardwareMap);

        collector.toggleOn(0.8f);
        hopper.toggleOn(0.8f);
    }

    public void loop() {
        moveRobot();
        collect();
        moveBalls();
        shoot();
        thrustFingers();
    }

    private void moveRobot() {
        //for those who want to control with the joysticks
        telemetry.addData("LeftX: ", gamepad1.left_stick_x);
        telemetry.addData("LeftY: ", gamepad1.left_stick_y);
        telemetry.addData("RightX: ", gamepad1.right_stick_x);
        telemetry.addData("RightY: ", gamepad1.right_stick_y);

        float leftPower = -gamepad1.left_stick_y; float rightPower = -gamepad1.right_stick_y;

        if(Math.abs(leftPower) < 0.1) leftPower = 0;
        if(Math.abs(rightPower) < 0.1) rightPower = 0;

        driveTrain.drive(leftPower, rightPower);
    }

    private void collect() {
        if(gamepad2.x) collector.toggleOn(0.8f);
    }

    private void moveBalls() {
        if(gamepad2.y) hopper.beginLifting();
        else if(gamepad2.a) hopper.beginLowering();
        else if(gamepad2.x) hopper.toggleOn(0.8f);
    }

    private void shoot() {
        if(gamepad2.b) shooter.toggleOn(0.8f);
    }

    private void thrustFingers() {
        if(gamepad2.left_bumper || gamepad2.left_trigger > 0.5) {
            fingers.setLeftFingerTarget(0.8f);
        } else if(gamepad2.right_bumper || gamepad2.right_trigger > 0.5) {
            fingers.setRightFingerTarget(0.8f);
        }

        fingers.updateFingers();
    }
}
