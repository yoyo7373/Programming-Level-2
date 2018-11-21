/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Hand extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static final double MOTOR_SPEED = 0.25;
  public final OI driveTrigger;
  public WPI_TalonSRX r;
  
  public Hand() {
    this.r = new WPI_TalonSRX(RobotMap.wristMotor);
  }

  public void WristUp() {
    this.startHandDirection(1);
  }

  public void WristDown() {
    this.startHandDirection(-1);
  }

  private void startWristDirection(int direction) {
    this.r.set(direction * MOTOR_SPEED);
  }

  public void stopWrist() {
    this.r.set(0);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new UseHand());
  }
}
