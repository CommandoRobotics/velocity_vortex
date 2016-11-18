package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by CHHS on 10/16/2016.
 */
public class VelocityTeleOp extends OpMode {

    WheelAPI driveTrain;
    HopperAPI hopper;
    CollecterAPI collector;
//    ShooterAPI shooter;
 //   FingerAPI fingers;

    boolean xPressed;
    boolean bPressed;

    public void init() {
        driveTrain = new WheelAPI(hardwareMap);
        hopper = new HopperAPI(hardwareMap);
        collector = new CollecterAPI(hardwareMap);
//        shooter = new ShooterAPI(hardwareMap);
      //  fingers = new FingerAPI(hardwareMap);

        collector.toggleOn(0.8f);
        collector.collect();
        hopper.toggleOn(0.8f);

        xPressed = false;
        bPressed = false;
    }

    public void loop() {
        moveRobot();
        collect();
        moveBalls();
//        shoot();
//        thrustFingers();
    }

    private void moveRobot() {
        telemetry.addData("LeftX: ", gamepad1.left_stick_x);
    telemetry.addData("LeftYAX: ", gamepad1.left_stick_y);
        telemetry.addData("RightX: ", gamepad1.right_stick_x);
        telemetry.addData("RightY: ", gamepad1.right_stick_y);

        float leftPower = -gamepad1.left_stick_y; float rightPower = -gamepad1.right_stick_y;

        if(Math.abs(leftPower) < 0.1) leftPower = 0;
        if(Math.abs(rightPower) < 0.1) rightPower = 0;

        driveTrain.drive(leftPower, rightPower);
    }

    private void collect() {
        //bumpers for collector
//        if(gamepad1.left_bumper) {
//            if(!collector.getOn()) collector.toggleOn(0.80f);
//            collector.collect();
//        } else if(gamepad1.right_bumper) {
//            if (!collector.getOn()) collector.toggleOn(0.80f);
//            collector.expel();
//        } else
        if(gamepad1.b && !bPressed) {
            collector.toggleOn(0.8f);
            bPressed = true;
        } else if(!gamepad1.b) {
            bPressed = false;
        }
    }

    private void moveBalls() {
        if(gamepad1.left_trigger > 0.1) {
            if(!hopper.getOn()) hopper.toggleOn(0.80f);
            hopper.beginLifting();
            collector.collect();
        } else if(gamepad1.right_trigger > 0.1) {
            if (!hopper.getOn()) hopper.toggleOn(0.8f);
            hopper.beginLowering();
            collector.expel();
        } else if(gamepad1.x && !xPressed) {
            hopper.toggleOn(0.8f);
            xPressed = true;
        } else if(!gamepad1.x) {
            xPressed = false;
        }
    }

    private void shoot() {
//        if(gamepad1.y) shooter.toggleOn(0.8f);
    }

   /* private void thrustFingers() {
        //TODO: Set this to the d-pad for gamepad1
        if(gamepad2.left_bumper) {
            fingers.setLeftFingerTarget(fingers.getLeftFingerTarget() - 0.1f);
        } else if(gamepad2.right_bumper) {
            fingers.setRightFingerTarget(fingers.getRightFingerTarget() - 0.1f);
        }

        fingers.updateFingers();
    }*/
}
