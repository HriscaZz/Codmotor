package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "un motor" )

@Disabled
public class Motorcontrolclass extends LinearOpMode {
    public DcMotor motorTest;




    @Override
    public void runOpMode() {
//        overridden method called runOpMode. Every op mode of type LinearOpMode
//        must implement this method. This method gets called when a user selects and runs the op mode.
        motorTest = hardwareMap.get(DcMotor.class, "motorTest");

//        hardwareMap to get references to the hardware devices that are listed in the Robot Controller’s configuration file:
// The hardwareMap object is available to use in the runOpMode method. It is an object of type HardwareMap class.

//        Note that when you attempt to retrieve a reference to a specific device in your op mode,
//        the name that you specify as the second argument of the HardwareMap.get method must
//        match the name used to define the device in your configuration file. For example, if you created a
//        configuration file that had a DC motor named motorTest, then you must use this same name (it is case sensitive)
//        to retrieve this motor from the hardwareMap object. If the names do not match, the op mode will throw an exception
        telemetry.addData("Status", "Initialized");
        telemetry.update();


        // Wait for the game to start (driver presses PLAY)
        waitForStart();
//        all linear op modes should have a waitForStart statement
//        to ensure that the robot will not begin executing the op mode until the driver pushes the start button.


        // run until the end of the match (driver presses STOP)
        double putere = 0;
        while (opModeIsActive()) {
//            At the start of the while loop we set the variable tgtPower equal to the negative value of the gamepad1’s left joystick:
            putere = -this.gamepad1.left_stick_y;
            motorTest.setPower(putere);
            telemetry.addData("Target Power",putere);
            telemetry.addData("Motor Power", motorTest.getPower());
//            The next set of statements sets the power of motorTest to the value represented by the
//            variable tgtPower. The values for target power and actual motor power are then added to
//            the set of data that will be sent via the telemetry mechanism to the Driver Station.


            telemetry.addData("Status", "Running");
            telemetry.update();



        }
    }
}

//    Your example op mode is looking for input from the gamepad designated as the user or driver #1.
//        Press the Start button and the A button simultaneously on the Logictech F310 controller to designate your gamepad as user #1.
//        Note that pushing the Start button and the B button simultaneously would designate the gamepad as user #2.
/*
TeleOp
public class motor extends OpMode {
    DcMotor motor;
    @Override
    public void init() {
        motor = hardwareMap.get(DcMotor.class, "motor");
        telemetry.addData("Hardware: ", "Initialized");
    }

    @Override
    public void loop() {
        if(gamepad1.left_stick_y > 0){
            motor.setPower(0.5);
        }
        motor.setPower(0);

    }
}*/
