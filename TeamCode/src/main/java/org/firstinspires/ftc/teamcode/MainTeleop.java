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

@TeleOp(name="Main Teleop", group = "Iterative OpMode")
//46ELW4oa 192.168.49.1

public class MainTeleop extends OpMode {
    private double leftThrottle;
    private double rightThrottle;
    private double servoPos;
    Hardware4232 robot = new Hardware4232();
    @Override
    public void init(){
        robot.init(hardwareMap);
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
        leftThrottle = -gamepad1.left_stick_y;
        rightThrottle = -gamepad1.right_stick_y;

        robot.grabWheels.setPower(0);
        servoPos = 1;
        if(gamepad2.left_bumper){
            robot.grabWheels.setPower(-.75);
        }
        if(gamepad2.right_bumper){
            robot.grabWheels.setPower(.75);
        }
        robot.Lifter.setPower(0);
        if(gamepad2.dpad_up){
            robot.Lifter.setPower(.5);
        }
        if(gamepad2.dpad_down){
            robot.Lifter.setPower(-.5);
        }
        if(gamepad2.a){
            servoPos = 0;
        }
        if(gamepad2.y){
            servoPos = 1;
        }
        robot.servo.setPosition(servoPos);
        robot.leftMotor.setPower(leftThrottle);
        robot.rightMotor.setPower(rightThrottle);
        telemetry.addData("Left Throttle", leftThrottle);
        telemetry.addData("Right Throttle", rightThrottle);
        telemetry.addData("Lifter Throttle", robot.Lifter.getPower());
        telemetry.addData("Wheels Throttle", robot.grabWheels.getPower());
        telemetry.addData("Servo Position", robot.servo.getPosition());
        telemetry.update();

    }

    @Override
    public void stop(){
        robot.leftMotor.setPower(0);
        robot.rightMotor.setPower(0);
    }


}
