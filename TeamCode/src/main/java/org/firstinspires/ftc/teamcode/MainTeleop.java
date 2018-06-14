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
        robot.arm.setPosition(0);
    }

    @Override
    public void loop() {
        leftThrottle = -gamepad1.left_stick_y;
        rightThrottle = -gamepad1.right_stick_y;

        servoPos = 1;

        if(gamepad2.a){
            servoPos = 0;
        }
        if(gamepad2.y){
            servoPos = 1;
        }
        if(gamepad2.b){
            robot.gyro.calibrate();
        }
        robot.arm.setPosition(servoPos);
        robot.leftMotor.setPower(leftThrottle);
        robot.rightMotor.setPower(rightThrottle);
        telemetry.addData("Left Throttle", leftThrottle);
        telemetry.addData("Right Throttle", rightThrottle);
        telemetry.addData("Gyro", robot.gyro.getHeading());
        telemetry.addData("Red", robot.color.red());
        telemetry.addData("Green", robot.color.green());
        telemetry.addData("Blue", robot.color.blue());
        telemetry.update();

    }

    @Override
    public void stop(){
        robot.leftMotor.setPower(0);
        robot.rightMotor.setPower(0);
    }


}
