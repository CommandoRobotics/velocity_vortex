package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by CHHS on 10/29/2016.
 */
public class AutoBeaconPress extends LinearOpMode{

    public void runOpMode() throws InterruptedException{

        //Call a class containing all the functions we need for autonomous
        AutonomousFunctions func = new AutonomousFunctions();
        func.init(hardwareMap, false);

        func.waitForStart();

        //Make sure Collector is turned off
        func.collectorPositioning();
        telemetry.addLine("Finished collectorPositioning");

        //TODO: Redo function func.backwardsToBeacon();
        telemetry.addLine("Finished backwardsToBeacon");

        func.stopDriving();

        //TODO: Redo function func.extrudeLeftFinger();

//        func.extrudeLeftFinger(fingers);

        // Stop driving
        func.stopDriving();

        //TODO: Add a color sensor so the bot knows if it needs to stop.
    }

}
