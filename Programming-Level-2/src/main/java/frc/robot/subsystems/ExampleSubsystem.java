/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class ExampleSubsystem extends Subsystem {
  private SpeedControllerGroup r;
  private SpeedControllerGroup l;

  public WPI_TalonSRX r0, r1, l0, l1;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public DriveTrain(){
    this.r0 = new WPI_TalonSRX(RobotMap.rightDriveMotor1);
    this.r1 = new WPI_TalonSRX(RobotMap.rightDriveMotor2);
    this.l0 = new WPI_TalonSRX(RobotMap.leftDriveMotor1);
    this.l1 = new WPI_TalonSRX(RobotMap.leftDriveMotor2);

    this.r = new SpeedControllerGroup(r0, r1);
    this.l = new SpeedControllerGroup(l0, l1);
    r1.follow(r0);
    l1.follow(l0);
    this.r.setInverted(false);
    this.l.setInverted(false);
    this.drive = new DifferentialDrive(l0, r0);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void arcade(double moveValue, double rotateValue){
      tank(moveValue-rotateValue, moveValue + rotateValue);
  }
  /*
  public void tank(double LeftMoveValue, double rightMoveValue){
    this.drive.tankDrive();
  }
  */
  public void arcadeNoConstants(double moveValue, double RotateValue){
      drive.arcadeDrive(moveValue, rotateValue);
  }
}
