package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Code on 10/3/2017.
 */
@TeleOp(name="Example Teleop", group = "Iterative OpMode")
@Disabled
public class Teleop5177 extends OpMode{
    private ElapsedTime runtime = new ElapsedTime();
  /*  private double fLeftThrottle;
    private double fRightThrottle;
    private double bLeftThrottle;
    private double bRightThrottle;*/
    private double leftThrottle;
    private double rightThrottle;
    private double liftThrottle;
    private double lGrabberValue;
    private double rGrabberValue;
    private double averageEncoders;
    private boolean mecanumToggle;
    Hardware5177 robot = new Hardware5177();
    @Override
    public void init(){
        telemetry.addData("Status", "Initialized");
        //For Mecanum Drive
        robot.init(hardwareMap);
      /*  fLeftThrottle = 0;
        fRightThrottle = 0;
        bLeftThrottle = 0;
        bRightThrottle = 0;*/
        //For Tank Drive
        leftThrottle = 0;
        rightThrottle = 0;
        //For Manipulators
        liftThrottle = 0;
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
        telemetry.addData("Status", "Left Throttle: " + leftThrottle);
        telemetry.addData("Status", "Right Throttle: " + rightThrottle);
        telemetry.addData("Status", "Left Motors Speed: " + robot.leftMotor.getPower());
        telemetry.addData("Status", "Right Motors Speed: " + robot.rightMotor.getPower());
        /*telemetry.addData("Status", "Front Left Motor Speed: " + robot.frontLeftMotor.getPower());
        telemetry.addData("Status", "Back Left Motor Speed: " + robot.backLeftMotor.getPower());
        telemetry.addData("Status", "Front Right Motor Speed: " + robot.frontRightMotor.getPower());
        telemetry.addData("Status", "Back Right Motor Speed: " + robot.backRightMotor.getPower());
        telemetry.addData("Status", "Back Left Motor Encoder: " + robot.backLeftMotor.getCurrentPosition());
        telemetry.addData("Status", "Back Right Motor Encoder: " + robot.backRightMotor.getCurrentPosition());*/
        telemetry.addData("Status", "Left Motor Encoder: " + robot.leftMotor.getCurrentPosition());
        telemetry.addData("Status", "Right Motor Encoder: " + robot.rightMotor.getCurrentPosition());
        telemetry.addData("Status", "Average Encoders: " + averageEncoders);
        telemetry.addData("Status", "Mecanum Toggle:" + mecanumToggle);
        /*if (mecanumToggle) {
            if (gamepad1.right_bumper) {
                rStrafe();
            }
            if (gamepad1.left_bumper) {
                lStrafe();
            } else {

                if (gamepad1.y){
                    mecanumToggle = false;
                }

                leftThrottle = -gamepad1.left_stick_y;
                rightThrottle = -gamepad1.right_stick_y;
               // lStrafe();
                //rStrafe();
               /* robot.frontLeftMotor.setPower(leftThrottle);
                robot.backLeftMotor.setPower(leftThrottle);
                robot.frontRightMotor.setPower(rightThrottle);
                robot.backRightMotor.setPower(rightThrottle);
            //    robot.liftMotor.setPower(liftThrottle);
            //}
        } else {
            if (gamepad1.a) {
                mecanumToggle = true;
            }
            leftThrottle = -gamepad1.left_stick_y;
            rightThrottle = -gamepad1.right_stick_y;

            robot.rightMotor.setPower(rightThrottle);
            robot.leftMotor.setPower(leftThrottle);

           /* robot.frontLeftMotor.setPower(leftThrottle);
            robot.backLeftMotor.setPower(leftThrottle);
            robot.frontRightMotor.setPower(rightThrottle);
            robot.backRightMotor.setPower(rightThrottle);
           // robot.liftMotor.setPower(liftThrottle);
            //averageEncoders = ((robot.backLeftMotor.getCurrentPosition()+robot.backRightMotor.getCurrentPosition())/2);
            averageEncoders = ((robot.leftMotor.getCurrentPosition()+robot.rightMotor.getCurrentPosition())/2);
        }*/
        leftThrottle = -gamepad1.left_stick_y;
        rightThrottle = -gamepad1.right_stick_y;
        lGrabberValue = gamepad1.left_trigger;
        rGrabberValue = -gamepad1.right_trigger +1;

        robot.rightMotor.setPower(rightThrottle);
        robot.leftMotor.setPower(leftThrottle);
       /* robot.leftGrabber.setPosition(lGrabberValue);
        robot.rightGrabber.setPosition(rGrabberValue);*/
           /* robot.frontLeftMotor.setPower(leftThrottle);
            robot.backLeftMotor.setPower(leftThrottle);
            robot.frontRightMotor.setPower(rightThrottle);
            robot.backRightMotor.setPower(rightThrottle);*/
        // robot.liftMotor.setPower(liftThrottle);
        //averageEncoders = ((robot.backLeftMotor.getCurrentPosition()+robot.backRightMotor.getCurrentPosition())/2);
        averageEncoders = ((robot.leftMotor.getCurrentPosition()+robot.rightMotor.getCurrentPosition())/2);
    }

    @Override
    public void stop(){
        /*robot.frontLeftMotor.setPower(0);
        robot.frontRightMotor.setPower(0);
        robot.backLeftMotor.setPower(0);
        robot.backRightMotor.setPower(0);*/
        robot.leftMotor.setPower(0);
        robot.rightMotor.setPower(0);
      //  robot.liftMotor.setPower(0);
    }
    /*public void lStrafe(){
        fLeftThrottle = -gamepad1.left_trigger;
        fRightThrottle = gamepad1.left_trigger;
        bLeftThrottle = gamepad1.left_trigger;
        bRightThrottle = -gamepad1.left_trigger;
        robot.frontLeftMotor.setPower(fLeftThrottle);
        robot.frontRightMotor.setPower(fRightThrottle);
        robot.backLeftMotor.setPower(bLeftThrottle);
        robot.backRightMotor.setPower(bRightThrottle);
    }
    public void rStrafe(){
        fLeftThrottle = gamepad1.right_trigger;
        fRightThrottle = -gamepad1.right_trigger;
        bLeftThrottle = -gamepad1.right_trigger;
        bRightThrottle = gamepad1.right_trigger;
        robot.frontLeftMotor.setPower(fLeftThrottle);
        robot.frontRightMotor.setPower(fRightThrottle);
        robot.backLeftMotor.setPower(bLeftThrottle);
        robot.backRightMotor.setPower(bRightThrottle);
    }*/
}

