package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by CHHS on 10/16/2016.
 */
public class VelocityTeleOp extends OpMode {

    HDriveAPI driveTrain;
    HopperAPI hopper;
    CollecterAPI collector;
//    ShooterAPI shooter;
    FingerAPI fingers;

    boolean slow;
    boolean yPressed;
    boolean xPressed;
    boolean bPressed;

    public void init() {
        driveTrain = new HDriveAPI(hardwareMap);
        hopper = new HopperAPI(hardwareMap);
        collector = new CollecterAPI(hardwareMap);
//        shooter = new ShooterAPI(hardwareMap);
        fingers = new FingerAPI(hardwareMap);

        if(collector.getOn()) collector.toggleOn(0.8f);
        collector.collect();
        if(hopper.getOn()) hopper.toggleOn(0.8f);

        slow = false;
        yPressed = false;
        xPressed = false;
        bPressed = false;
    }

    public void loop() {
        moveRobot();
        collect();
        moveBalls();
//        shoot();
        thrustFingers();
    }

    private void moveRobot() {
        if(gamepad1.y && !yPressed) {
           slow = !slow;
            yPressed = true;
        } else if(!gamepad1.y) {
            yPressed = false;
        }

        float leftPowerY = -gamepad1.left_stick_y; float rightPowerY = -gamepad1.right_stick_y;
        float leftPowerX = gamepad1.left_stick_x; float rightPowerX = gamepad1.right_stick_x;

//        telemetry.addData("LeftX: ", leftPowerX);
//        telemetry.addData("LeftY: ", leftPowerY);
//        telemetry.addData("RightX: ", rightPowerX);
//        telemetry.addData("RightY: ", rightPowerY);

        if(Math.abs(leftPowerX) < 0.1) leftPowerX = 0;
        if(Math.abs(rightPowerX) < 0.1) rightPowerX = 0;
        if(Math.abs(leftPowerY) < 0.1) leftPowerY = 0;
        if(Math.abs(rightPowerY) < 0.1) rightPowerY = 0;

        if(Math.abs(leftPowerY) + Math.abs(rightPowerY) > Math.abs(leftPowerX) + Math.abs(rightPowerX)) {
            if (!slow) driveTrain.drive(leftPowerY, rightPowerY);
            else driveTrain.driveSlower(leftPowerY, rightPowerY);
        } else {
            driveTrain.strafe((leftPowerX + rightPowerX) / 2);
        }
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

   private void thrustFingers() {
        //TODO: Set this to the d-pad for gamepad1
        if(gamepad1.left_bumper) {
            fingers.setLeftFingerTarget((float)(fingers.getLeftFingerPosition()) - 0.1f);
        }

       if(gamepad1.right_bumper) {
            fingers.setRightFingerTarget((float)(fingers.getRightFingerPosition()) - 0.1f);
        }

       fingers.updateFingers();
       telemetry.addData("Left Bumper: ", gamepad1.left_bumper);
       telemetry.addData("Right Bumper: ", gamepad1.right_bumper);
       telemetry.addData("Left Finger Position: ", fingers.getLeftFingerPosition());
       telemetry.addData("Right Finger Position: ", fingers.getRightFingerPosition());
       telemetry.addData("Left Finger Target: ", fingers.getLeftFingerTarget());
       telemetry.addData("Right Finger Target: ", fingers.getRightFingerTarget());
    }
}
