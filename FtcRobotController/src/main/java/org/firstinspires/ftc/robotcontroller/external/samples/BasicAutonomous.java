package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous (name= "BasicAutonomous")
public class BasicAutonomous extends LinearOpMode {
    DcMotor leftFront, rightFront;
    DcMotor leftRear, rightRear;

    Servo claw;
    @Override
    public void runOpMode() throws InterruptedException {

        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");

        leftRear = hardwareMap.get(DcMotor.class, "leftRear");
        rightRear = hardwareMap.get(DcMotor.class, "rightRear");

        claw = hardwareMap.get(Servo.class, "claw");

        waitForStart();

        //This will make it moveeee in a loop!!!
        while (opModeIsActive()){
                if(//sesnor too close to wall) turn blah blah blah)
            moveForward(1.0,30);

            //stopMotor() after every move (?)

        }


}
    public void moveForward(double power, long time){

        leftFront.setPower(power);
        leftRear.setPower(power);
        rightFront.setPower(power);
        rightRear.setPower(power);

        sleep(time);

    }

    public void turnRight(double power, long time){

        leftFront.setPower(-power);
        leftRear.setPower(-power);
        rightFront.setPower(power);
        rightRear.setPower(power);

        sleep(time);

    }

    public void turnLeft(double power, long time){

        leftFront.setPower(power);
        leftRear.setPower(power);
        rightFront.setPower(-power);
        rightRear.setPower(-power);

        sleep(time);

    }

}
