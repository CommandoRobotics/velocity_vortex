package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by CHHS on 10/6/2016.
 */
public class CollecterAPI {
    //get hardware
    public DcMotor rightCollector = null;
    public DcMotor leftCollector = null;
    HardwareMap hwMap = null;
    //tell what other opmodes will call it

    public CollecterAPI (HardwareMap hardwareMap){
        init(hardwareMap);
    }

//tell what to do at init and find motors
    public void init(HardwareMap tempHwMap){
        hwMap = tempHwMap;
        rightCollector = hwMap.dcMotor.get("rightCollector");
        leftCollector = hwMap.dcMotor.get("leftCollector");
       rightCollector.setDirection(DcMotor.Direction.FORWARD);
       leftCollector.setDirection(DcMotor.Direction.REVERSE);

        rightCollector.setPower(0);
        leftCollector.setPower(0);

    }
//tell what to use in other classes to use the collector
    public void runCollecter(float percentage){
        rightCollector.setPower(percentage);
        leftCollector.setPower(percentage);
    }

    public void toggleOn(float percentage) {
        if(rightCollector.getPower() > 0 || leftCollector.getPower() > 0) {
            rightCollector.setPower(0);
            leftCollector.setPower(0);
        } else {
            rightCollector.setPower(percentage);
            leftCollector.setPower(percentage);
        }
    }
}

