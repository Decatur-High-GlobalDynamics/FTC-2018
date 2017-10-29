package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Code on 10/3/2017.
 */
@TeleOp(name="Teleop", group = "Iterative OpMode")
@Disabled
public class Teleop5177 extends OpMode{
    private ElapsedTime runtime = new ElapsedTime();

    private double leftThrottle;
    private double rightThrottle;
    private double liftThrottle;
    private double lGrabberValue;
    private double rGrabberValue;
    private double averageEncoders;

    Hardware5177 robot = new Hardware5177();
    @Override
    public void init(){
        telemetry.addData("Status", "Initialized");

        robot.init(hardwareMap);
        //For Tank Drive
        leftThrottle = 0;
        rightThrottle = 0;
        //For Manipulators
        liftThrottle = 0;
        lGrabberValue = 1;
        rGrabberValue = 1;
    }

    @Override
    public void init_loop(){
        robot.leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void start(){
    runtime.reset();
    }

    @Override
    public void loop() {
        telemetry.addData("Status", "Running: " + runtime.toString());
        telemetry.addData("Status", "Left Throttle: " + leftThrottle);
        telemetry.addData("Status", "Right Throttle: " + rightThrottle);
        telemetry.addData("Status", "Left Motors Speed: " + robot.leftMotor.getPower());
        telemetry.addData("Status", "Right Motors Speed: " + robot.rightMotor.getPower());
        telemetry.addData("Status", "Left Motor Encoder: " + robot.leftMotor.getCurrentPosition());
        telemetry.addData("Status", "Right Motor Encoder: " + robot.rightMotor.getCurrentPosition());
        telemetry.addData("Status", "Average Encoders: " + averageEncoders);

        leftThrottle = -gamepad1.left_stick_y;
        rightThrottle = -gamepad1.right_stick_y;
        lGrabberValue = -gamepad2.left_trigger+.5;
        rGrabberValue = gamepad2.right_trigger +.5;
        liftThrottle = -gamepad2.left_stick_y/2;

        robot.rightMotor.setPower(rightThrottle);
        robot.leftMotor.setPower(leftThrottle);
        robot.liftMotor.setPower(liftThrottle);
        robot.leftGrabber.setPosition(lGrabberValue);
        robot.rightGrabber.setPosition(rGrabberValue);
        averageEncoders = ((robot.leftMotor.getCurrentPosition()+robot.rightMotor.getCurrentPosition())/2);
    }

    @Override
    public void stop(){
        robot.leftMotor.setPower(0);
        robot.rightMotor.setPower(0);
        robot.liftMotor.setPower(0);
    }
}

