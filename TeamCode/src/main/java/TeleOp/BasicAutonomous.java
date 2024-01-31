package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;


@Autonomous (name= "BasicAutonomous")
public class BasicAutonomous extends LinearOpMode {
    DcMotor leftFront, rightFront;
    DcMotor leftRear, rightRear;
    public ModernRoboticsI2cColorSensor frontColorSensor = null;


    //Servo claw;
    @Override
    public void runOpMode() {

        leftFront = hardwareMap.get(DcMotor.class, "wheelFL");
        rightFront = hardwareMap.get(DcMotor.class, "wheelFR");

        leftRear = hardwareMap.get(DcMotor.class, "wheelBL");
        rightRear = hardwareMap.get(DcMotor.class, "wheelBR");

        //claw = hardwareMap.get(Servo.class, "claw");

        frontColorSensor = hardwareMap.get(ModernRoboticsI2cColorSensor.class, "sensor_color");
        waitForStart();

        //This will make it moveeee in a loop!!!
        while (opModeIsActive()){
            frontColorSensor.enableLed(true);

            telemetry.addData("Color Number", frontColorSensor.readUnsignedByte(ModernRoboticsI2cColorSensor.Register.COLOR_NUMBER));
            telemetry.update();

            if(frontColorSensor.readUnsignedByte(ModernRoboticsI2cColorSensor.Register.COLOR_NUMBER) == 10){
                turnRight(1.0, 1);
            } else {
                turnLeft(1.0, 1);
            }
            moveForward(1.0,3);
            stopMotor();



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

    public void stopMotor() {
        leftFront.setPower(0);
        leftRear.setPower(0);
        rightFront.setPower(0);
        rightRear.setPower(0);

    }

}