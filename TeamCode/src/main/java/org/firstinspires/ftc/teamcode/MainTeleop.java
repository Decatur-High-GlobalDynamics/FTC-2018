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

public class MainTeleop extends OpMode {
    private double leftThrottle;
    private double rightThrottle;
    private ElapsedTime runtime = new ElapsedTime();
    Hardware4232 robot = new Hardware4232();
    private boolean brakes = false;
    @Override
    public void init(){

        leftThrottle = 0;
        rightThrottle = 0;
        robot.init(hardwareMap);
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
        leftThrottle = -gamepad1.left_stick_y;
        rightThrottle = -gamepad1.right_stick_y;
        robot.intakeLeft.setPower(0);
        robot.intakeRight.setPower(0);
        if(gamepad1.a){
            brakes = !brakes;
        }
        if(brakes == true && -gamepad1.left_stick_y == 0 && -gamepad1.right_stick_y == 0 && robot.leftMotor.getCurrentPosition() != 0 && robot.rightMotor.getCurrentPosition() != 0){
            leftThrottle = -.1;
            rightThrottle = -.1;
            resetDriveEncoders();
        }
        if(gamepad1.left_bumper){
            robot.intakeLeft.setPower(.5);
            robot.intakeRight.setPower(.5);
        }
        if(gamepad1.right_bumper){
            robot.intakeLeft.setPower(-.5);
            robot.intakeRight.setPower(-.5);
        }


      /*  if(gamepad1.a){

            robot.leftMotor.setDirection(DcMotor.Direction.REVERSE);
            robot.rightMotor.setDirection(DcMotor.Direction.FORWARD);
        }
        else {
            robot.leftMotor.setDirection(DcMotor.Direction.FORWARD);
            robot.rightMotor.setDirection(DcMotor.Direction.REVERSE);
        }
*/
        robot.leftMotor.setPower(leftThrottle);
        robot.rightMotor.setPower(rightThrottle);
    }

    @Override
    public void stop(){
        robot.leftMotor.setPower(0);
        robot.rightMotor.setPower(0);
    }
    void resetDriveEncoders(){
        robot.leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

}
