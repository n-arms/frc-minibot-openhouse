// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Drivetrain extends SubsystemBase {
  private final Spark left;
  private final Spark right;

  public Drivetrain(int leftChannel, int rightChannel) {
    left = new Spark(leftChannel);
    right = new Spark(rightChannel);
  
    left.setInverted(false);
    right.setInverted(true);
  }

  /*
    leftSpeed and rightSpeed are both values between -1 and 1.
  */
  public void setMotors(double leftSpeed, double rightSpeed) {
    left.set(leftSpeed);
    right.set(rightSpeed);
  }

  public void arcadeDrive(double fwd_rev, double left_right) {
    final double left = fwd_rev + left_right;
    final double right = fwd_rev - left_right;
  
    setMotors(left, right);
  }

  @Override
  public void periodic() {
    // probably check if the motors are overheated
  }
}
