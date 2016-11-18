package org.firstinspires.ftc.robotcontroller.external.samples;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;


/**
 * Created by CHHS on 11/16/2016.
 */
public class AutonomousFunctions extends LinearOpMode{

    WheelAPI driveTrain;
    HopperAPI hopper;
    CollecterAPI collector;
    //    ShooterAPI shooter;
   // FingerAPI fingers;
//    ColorSensorAPI colors;


    public void init(HardwareMap hMap){
        driveTrain = new WheelAPI(hMap);
        hopper = new HopperAPI(hMap);
        collector = new CollecterAPI(hMap);
       // fingers = new FingerAPI(hMap);
        //colors = new ColorSensorAPI(hardwareMap);
        //shooter = new ShooterAPI(hMap);
    }

    @Override
    public void runOpMode() throws InterruptedException {

    }

    public void collectorPositioning(){
        //If we are on the blue team, we need to reverse our turn controls.
//        driveTrain.setReverse(colors.getTeamRed() >= 180);

        if(hopper.getOn()) hopper.toggleOn(0f);

        //rotate the collector outwards to knock the cap ball away
        if(!collector.getOn()) collector.toggleOn(0.8f);
        collector.collect();

    }

    public void driveToCornerGoalClose() throws InterruptedException {
        driveTrain.drive(1f, 1f);
        sleep(300);
        driveTrain.autonomousTurnLeft(.75f);
        sleep(1550);
        driveTrain.drive(1f,1f);
        sleep(900);
        driveTrain.autonomousTurnLeft(.75f);
        sleep(900);
    }

    public void driveToCornerGoalAlt() throws InterruptedException {
        driveTrain.drive(1f, 1f);
        sleep(300);
        driveTrain.autonomousTurnLeft(.75f);
        sleep(1550);
        driveTrain.drive(1f,1f);
        sleep(1500);
        driveTrain.autonomousTurnLeft(.75f);
        sleep(900);
    }

    public void driveUpRamp() throws InterruptedException{
        driveTrain.drive(.75f,.75f);
        sleep(1000);
    }

    public void rampToCapBall() throws InterruptedException{
        driveTrain.drive(-.75f, -.75f);
        sleep(2500);
    }

    public void knockOffCapBall(int time) throws InterruptedException{
        driveTrain.autonomousTurnLeft(1f);
        sleep(time);
    }

    public void parkCenterGoal() throws InterruptedException{
        driveTrain.drive(.75f,.75f);
        sleep(500);
    }

    public void expel(int time) throws InterruptedException {
        driveTrain.drive(.5f,5f);
        if(!collector.getOn()) collector.toggleOn(0.8f);
        collector.expel();
        if(!hopper.getOn()) hopper.toggleOn(.75f);
        hopper.beginLowering();
        sleep(time);
    }

    public void stopDriving(){

        driveTrain.drive(0f,0f);
        if(collector.getOn())
        collector.toggleOn(0f);

        if(hopper.getOn())
            hopper.toggleOn(0f);
    }


}
