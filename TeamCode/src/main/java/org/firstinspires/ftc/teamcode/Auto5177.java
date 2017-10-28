package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Code on 10/28/2017.
 */

public class Auto5177 extends OpMode
{
    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();
    private boolean stopMotors = false;
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
        telemetry.addData("Status", "Initialized");
        telemetry.addData("Time Elapsed:",runtime.toString());
    }

    /*
    * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
    */
    @Override
    public void init_loop() {


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
        telemetry.addData("Status", "Running: " + runtime.toString());
        robot.leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotor.setTargetPosition(500);
        robot.rightMotor.setTargetPosition(500);

        telemetry.addData("StopMotors", stopMotors);
        if (autoState == 2) {
            requestOpModeStop();
        }
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