package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class ArmMeat extends LinearOpMode {

    private double initPos;
    //private float armLevPer;
    //private double targetPos;

    @Override
    public void runOpMode() throws InterruptedException {
        // Declare our motors
        // Make sure your ID's match your configuration
        DcMotor fl = hardwareMap.dcMotor.get("wheelFL");
        DcMotor bl = hardwareMap.dcMotor.get("wheelBL");
        DcMotor fr = hardwareMap.dcMotor.get("wheelFR");
        DcMotor br = hardwareMap.dcMotor.get("wheelBR");
        Servo LClaw = hardwareMap.get(Servo.class, "LServo");
        Servo RClaw = hardwareMap.get(Servo.class, "RServo");
        Servo armServo = hardwareMap.get(Servo.class, "armServo");

        DcMotorEx armMot = hardwareMap.get(DcMotorEx.class, "armMotor");
        armMot.setTargetPosition(0);
        armMot.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        initPos = armMot.getCurrentPosition();

        fr.setDirection(DcMotorSimple.Direction.FORWARD);
        fl.setDirection(DcMotorSimple.Direction.REVERSE);
        bl.setDirection(DcMotorSimple.Direction.FORWARD);
        br.setDirection(DcMotorSimple.Direction.FORWARD);

        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //UwU
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //UwU
        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //UwU
        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //UwU
        waitForStart();


        while (opModeIsActive()) {


            //ARCADE DRIVE
            double lefty1 = gamepad1.left_stick_y;
            double leftx1 = gamepad1.left_stick_x;
            double rightx1 = gamepad1.right_stick_x;
            fl.setPower((1 * -lefty1) + (1*leftx1) + 1*rightx1);
            br.setPower((1 * lefty1) - (1*leftx1) + 1*rightx1);
            fr.setPower((1 * lefty1) + (1*leftx1) + 1*rightx1);
            bl.setPower((1 * lefty1) - (1*-leftx1) + 1*-rightx1);

            //arm

            if(gamepad1.x){
                armMot.setTargetPosition((int)(20 + initPos));
            }
            if (gamepad1.y){
                armMot.setTargetPosition((int)(2000 + initPos));
            }
            armMot.setPower(1);
            armMot.setTargetPositionTolerance(10);
            armMot.setVelocity(1700);

            //open claw
            if(gamepad1.left_bumper) {
                LClaw.setPosition(0); // values iterable
                RClaw.setPosition(0);
            }
            if(gamepad1.right_bumper) {
                LClaw.setPosition(0.5); //values iterable
                RClaw.setPosition(0.5);
            }

            //arm wrist
            if(gamepad1.a){
                armServo.setPosition(0); //iterable
            }
            if(gamepad1.b){
                armServo.setPosition(1);
            }
        }

    }

}
