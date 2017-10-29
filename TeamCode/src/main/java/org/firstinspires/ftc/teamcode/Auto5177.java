package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Code on 10/28/2017.
 */
@Autonomous(name="Example Teleop", group = "Iterative OpMode")
@Disabled
public class Auto5177 extends LinearOpMode

{
    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();
    private boolean stopMotors = false;
    private int autoState = 0;
    Hardware5177 robot = new Hardware5177();
    // private DcMotor leftMotor = null;
    // private DcMotor rightMotor = null;

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.addData("Time Elapsed:",runtime.toString());

        waitForStart();

        runtime.reset();

        if (opModeIsActive()){
            telemetry.addData("Status", "Running: " + runtime.toString());
            telemetry.addData("Status", "left encoder: " + robot.leftMotor.getCurrentPosition());
            telemetry.addData("Status", "right encoder: " + robot.rightMotor.getCurrentPosition());
            telemetry.addData("STatus","runmode" + robot.leftMotor.getMode());
            robot.leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.leftMotor.setTargetPosition(150);
            robot.rightMotor.setTargetPosition(150);
            robot.leftMotor.setPower(0);
            robot.rightMotor.setPower(0);
        }
    }



}