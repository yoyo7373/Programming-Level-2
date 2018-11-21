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
  public WPI_TalonSRX r1, l1;
  public DoubleSolenoid compresscontrol;
  public Hand() {
    this.r1 = new WPI_TalonSRX(RobotMap.rightPickupMotor);
    this.l1 = new WPI_TalonSRX(RobotMap.leftPickupMotor);
    this.compresscontrol = new DoubleSolenoid(61, 0, 1);
  }

  public void startHandEjection() {
    this.startHandDirection(1);
  }

  public void startHandSuction() {
    this.startHandDirection(-1);
  }
  public void OpenUp(){
    this.compresscontrol.set(kForward);
  }
  public void CloseUp(){
    this.compresscontrol.set(kReverse);
  }
  public void StayStill(){
    this.compresscontrol.set(kOff);
  }
  private void startHandDirection(int direction) {
    this.r1.set(direction * MOTOR_SPEED);
    this.l1.set(direction * MOTOR_SPEED);
  }

  public void stopHand() {
    this.r1.set(0);
    this.l1.set(0);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new UseHand());
  }
}
