package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by CHHS on 11/16/2016.
 */
public class AutoFarEverything extends LinearOpMode{

    @Override
    public void runOpMode() throws InterruptedException {

        //Call a class containing all the functions we need for autonomous
        AutonomousFunctions func = new AutonomousFunctions();
        func.init(hardwareMap);

        waitForStart();

        //Make sure Collector is turned off
        func.collectorPositioning();

        // Drive toward Corner Vortex
        func.driveToCornerGoalAlt();

        //Drive up ramp
        func.driveUpRamp();

        // Shoot Particles
        func.expel(3000);

        //Back off toward Cap Ball
        func.rampToCapBall();

        //Knock off Cap Ball
        func.knockOffCapBall(2000);

        //Park Center Goal
        func.parkCenterGoal();

        // Stop driving
        func.stopDriving();

    }
}
