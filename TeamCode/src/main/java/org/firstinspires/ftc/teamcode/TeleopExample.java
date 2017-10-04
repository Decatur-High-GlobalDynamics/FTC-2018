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
@Disabled

public class TeleopExample extends OpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private double leftThrottle;
    private double rightThrottle;
    Hardware5177 robot = new Hardware5177();
    @Override
    public void init(){
        telemetry.addData("Status", "Initialized");
        leftThrottle = 0;
        rightThrottle = 0;
    }

    @Override
    public void init_loop(){
    }

    @Override
    public void start(){
    runtime.reset();
}

    @Override
    public void loop() {
        telemetry.addData("Status", "Running: " + runtime.toString());
        leftThrottle = gamepad1.left_stick_y;
        rightThrottle = gamepad1.right_stick_y;

        if(gamepad1.a){
            robot.frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
            robot.backLeftMotor.setDirection(DcMotor.Direction.REVERSE);
            robot.backRightMotor.setDirection(DcMotor.Direction.FORWARD);
            robot.frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
        }
        else {
            robot.frontLeftMotor.setDirection(DcMotor.Direction.FORWARD);
            robot.backLeftMotor.setDirection(DcMotor.Direction.FORWARD);
            robot.backRightMotor.setDirection(DcMotor.Direction.REVERSE);
            robot.frontRightMotor.setDirection(DcMotor.Direction.REVERSE);
        }
        robot.frontLeftMotor.setPower(leftThrottle);
        robot.backLeftMotor.setPower(leftThrottle);
        robot.frontRightMotor.setPower(rightThrottle);
        robot.backRightMotor.setPower(rightThrottle);
    }

    @Override
    public void stop(){
        robot.frontLeftMotor.setPower(0);
        robot.frontRightMotor.setPower(0);
        robot.backLeftMotor.setPower(0);
        robot.backRightMotor.setPower(0);

    }


}
