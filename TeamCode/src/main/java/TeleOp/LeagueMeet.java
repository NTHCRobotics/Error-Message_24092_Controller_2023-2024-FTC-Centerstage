package TeleOp;

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class LeagueMeet extends LinearOpMode {
    @Override
    public void runOpMode(){
        // Declare our motors
        // Make sure your ID's match your configuration
        DcMotor TLMotor = hardwareMap.dcMotor.get("wheelFL");
        DcMotor BLMotor = hardwareMap.dcMotor.get("wheelBL");
        DcMotor TRMotor = hardwareMap.dcMotor.get("wheelFR");
        DcMotor BRMotor = hardwareMap.dcMotor.get("wheelBR");

        // Reverse the right side motors. This may be wrong for your setup.
        // If your robot moves backwards when commanded to go forwards,
        // reverse the left side instead.
        // See the note about this earlier on this page.
        TRMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        TLMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        BLMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        BRMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            double vertical = gamepad1.left_stick_y;
            double horizontal = gamepad1.left_stick_x;
            double pivot = gamepad1.right_stick_x;

            TLMotor.setPower(pivot + (-vertical - horizontal));
            TRMotor.setPower(pivot + (-vertical + horizontal));
            BLMotor.setPower(pivot + (-vertical - horizontal));
            BRMotor.setPower(pivot + (-vertical + horizontal));


        }

    }
}
