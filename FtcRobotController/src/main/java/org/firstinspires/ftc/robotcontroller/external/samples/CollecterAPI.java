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

    private boolean on = false;
    private float percentage = 0.0f;

    public CollecterAPI (HardwareMap hardwareMap){
        init(hardwareMap);
        on = false;
    }

//tell what to do at init and find motors
    public void init(HardwareMap tempHwMap){
        hwMap = tempHwMap;
        rightCollector = hwMap.dcMotor.get("rightCollector");
        leftCollector = hwMap.dcMotor.get("leftCollector");
       leftCollector.setDirection(DcMotor.Direction.FORWARD);
       rightCollector.setDirection(DcMotor.Direction.REVERSE);

        rightCollector.setPower(0);
        leftCollector.setPower(0);

    }
//tell what to use in other classes to use the collector
    public void collect() {
        rightCollector.setPower(-percentage);
        leftCollector.setPower(-percentage);
    }

    public void expel() {
        rightCollector.setPower(percentage);
        leftCollector.setPower(percentage);
    }

    public void toggleOn(float percentage) {
        this.percentage = Math.abs(percentage);
        if(on) {
            on = false;
            rightCollector.setPower(0);
            leftCollector.setPower(0);
        } else {
            on = true;
            rightCollector.setPower(percentage);
            leftCollector.setPower(percentage);
        }
    }

    public boolean getOn() {
        return on;
    }
}

