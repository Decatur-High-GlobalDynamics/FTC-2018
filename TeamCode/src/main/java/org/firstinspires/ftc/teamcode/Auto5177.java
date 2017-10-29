package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Code on 10/28/2017.
 */
@Autonomous(name="Example Teleop", group = "Iterative OpMode")
@Disabled
public class Auto5177 extends OpMode

{
    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();
    private boolean stopMotors = false;
    private double lGrabberValue;
    private double rGrabberValue;
    private double averageEncoders;
    private int autoState = 0;
    Hardware5177 robot = new Hardware5177();
    // private DcMotor leftMotor = null;
    // private DcMotor rightMotor = null;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override

    public void init() {
        robot.init(hardwareMap);
        lGrabberValue = 1;
        rGrabberValue = 1;
        telemetry.addData("Status", "Initialized");
        telemetry.addData("Time Elapsed:",runtime.toString());
    }

    /*
    * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
    */
    @Override
    public void init_loop() {
        robot.leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);


    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        runtime.reset();
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        robot.leftGrabber.setPosition(lGrabberValue);
        robot.rightGrabber.setPosition(rGrabberValue);
        telemetry.addData("Status", "Running: " + runtime.toString());
        telemetry.addData("Status", "left encoder: " + robot.leftMotor.getCurrentPosition());
        telemetry.addData("Status", "right encoder: " + robot.rightMotor.getCurrentPosition());
        telemetry.addData("STatus","runmode" + robot.leftMotor.getMode());
        robot.leftMotor.setTargetPosition(150);
        robot.rightMotor.setTargetPosition(150);
        robot.leftMotor.setPower(.5);
        robot.rightMotor.setPower(.5);
        //set power on
        while (robot.rightMotor.isBusy() && robot.leftMotor.isBusy()){

        }
        telemetry.addData("StopMotors", stopMotors);
    }
    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
        robot.leftMotor.setPower(0);
        robot.rightMotor.setPower(0);
    }
}