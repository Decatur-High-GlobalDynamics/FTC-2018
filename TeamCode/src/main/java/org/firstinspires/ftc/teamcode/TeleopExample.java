package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
/**
 * Created by knxtdoor on 8/27/2017.
 */

@TeleOp(name="Example Teleop", group = "Iterative OpMode")

public class TeleopExample extends OpMode {
    private double leftThrottle;
    private double rightThrottle;
    Hardware5177 robot = new Hardware5177();
    @Override
    public void init(){

        leftThrottle = 0;
        rightThrottle = 0;
    }

    @Override
    public void init_loop(){
    }

    @Override
    public void start(){

}

    @Override
    public void loop() {
        leftThrottle = gamepad1.left_stick_y;
        rightThrottle = gamepad1.right_stick_y;

        if(gamepad1.a){
            robot.leftMotor.setDirection(DcMotor.Direction.REVERSE);
            robot.rightMotor.setDirection(DcMotor.Direction.FORWARD);
        }
        else {
            robot.leftMotor.setDirection(DcMotor.Direction.FORWARD);
            robot.rightMotor.setDirection(DcMotor.Direction.REVERSE);
        }

        robot.leftMotor.setPower(leftThrottle);
        robot.rightMotor.setPower(rightThrottle);
    }

    @Override
    public void stop(){
        robot.leftMotor.setPower(0);
        robot.rightMotor.setPower(0);
    }


}
