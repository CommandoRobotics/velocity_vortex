package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by CHHS on 10/25/2016.
 */
public class MecanumWheelTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        MecanumWheelAPI drivetrain = new MecanumWheelAPI(hardwareMap);
        drivetrain.init(hardwareMap);

        waitForStart();

        drivetrain.drive(0f,0f);

        sleep(100);

        drivetrain.leftMotor.setPower(-0.5);
        drivetrain.bottomLeftMotor.setPower(0.5);
        drivetrain.rightMotor.setPower(0.5);
        drivetrain.bottomRightMotor.setPower(-0.5);
        sleep(2000);

        drivetrain.strafeRight(0);
        drivetrain.strafeLeft(0.5f);

        sleep(2000);

        drivetrain.strafeLeft(0);

    }
}
