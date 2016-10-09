package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


/**
 * Created by casciarobotics on 10/4/16.
 */
public class MecanumWheelAPI {
    //Define Motors
    public DcMotor left_Top_Motor = null;
    public DcMotor left_Bottom_Motor = null;
    public DcMotor right_Top_Motor = null;
    public DcMotor right_Bottom_Motor = null;

    HardwareMap hw_Map = null;
    //Constructor
    public MecanumWheelAPI (){

    }

    public void init (HardwareMap temp_Hw_Map){
        hw_Map = temp_Hw_Map;

        left_Top_Motor = hw_Map.dcMotor.get("left_top_motor");
        right_Top_Motor = hw_Map.dcMotor.get("right_top_motor");
        left_Bottom_Motor = hw_Map.dcMotor.get("left_bottom_motor");
        right_Bottom_Motor = hw_Map.dcMotor.get("right_bottom_motor");
        right_Top_Motor.setDirection(DcMotorSimple.Direction.REVERSE);
        right_Bottom_Motor.setDirection(DcMotorSimple.Direction.REVERSE);

        Drive(0);
    }

    public void Drive(float percentage){
        left_Bottom_Motor.setPower(percentage);
        left_Top_Motor.setPower(percentage);
        right_Bottom_Motor.setPower(percentage);
        right_Top_Motor.setPower(percentage);
    }

    public void Strafe_Left(float percentage){
        left_Top_Motor.setPower(-percentage);
        left_Bottom_Motor.setPower(percentage);
        right_Top_Motor.setPower(percentage);
        right_Bottom_Motor.setPower(-percentage);
    }

    public void Strafe_Right(float percentage){
        left_Top_Motor.setPower(percentage);
        left_Bottom_Motor.setPower(-percentage);
        right_Top_Motor.setPower(-percentage);
        right_Bottom_Motor.setPower(percentage);
    }

    public void Left_Diagonal(float percentage){
        left_Bottom_Motor.setPower(percentage);
        right_Top_Motor.setPower(percentage);
    }

    public void Right_Diagonal(float percentage){
        left_Top_Motor.setPower(percentage);
        right_Bottom_Motor.setPower(percentage);
    }

    public void Turn(float percentage){
        left_Bottom_Motor.setPower(-percentage);
        left_Top_Motor.setPower(-percentage);
        right_Bottom_Motor.setPower(percentage);
        right_Top_Motor.setPower(percentage);
    }

}
