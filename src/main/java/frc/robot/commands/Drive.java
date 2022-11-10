// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;


public class Drive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain drivetrain;
  private final XboxController driverController;

  public Drive(Drivetrain drivetrain, XboxController driverController) {
    this.driverController = driverController;
    this.drivetrain = drivetrain;
  
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    final double fwd_rev = driverController.getRawAxis(Constants.Xbox.DRIVE_FWD_REV);
    final double left_right = driverController.getRawAxis(Constants.Xbox.DRIVE_LEFT_RIGHT);
  
    final double fwd_rev_controlled = fwd_rev * fwd_rev * fwd_rev * Constants.MotorController.SPEED_FACTOR;
    final double left_right_controlled = left_right * left_right * left_right * Constants.MotorController.SPEED_FACTOR;
  
    drivetrain.arcadeDrive(fwd_rev_controlled, left_right_controlled);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
