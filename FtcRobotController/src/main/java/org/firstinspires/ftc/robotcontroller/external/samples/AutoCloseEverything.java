package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by CHHS on 10/29/2016.
 */
public class AutoCloseEverything extends LinearOpMode{



    public void runOpMode() throws InterruptedException{

        //Call a class containing all the functions we need for autonomous
        AutonomousFunctions func = new AutonomousFunctions();
        func.init(hardwareMap);

        waitForStart();

        //Make sure Collector is turned off
        func.collectorPositioning();

        // Drive toward Corner Vortex
        func.driveToCornerGoalClose();

        //Drive up ramp
        func.driveUpRamp();

        // Shoot Particles
        func.expel(3000);

        //Back off ramp toward Cap Ball
        func.rampToCapBall();

        //Knock off Cap Ball
        func.knockOffCapBall(2000);

        //Park Center Goal
        func.parkCenterGoal();

        // Stop driving
        func.stopDriving();

        //TODO: Add a color sensor so the bot knows if it needs to stop.
    }

}
