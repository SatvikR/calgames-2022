// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooting;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class Latch extends CommandBase {
  private final Shooter m_shooter;

  /** Creates a new Latch. */
  public Latch(Shooter shooter) {
    m_shooter = shooter;

    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("IN LATCH");
    m_shooter.closeServo();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shooter.setMotor(-Shooter.kRunningSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shooter.setMotor(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_shooter.getUpperLimit();
  }
}
