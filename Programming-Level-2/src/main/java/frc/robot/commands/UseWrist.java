/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class UseWrist extends Command {
  public final OI drivetrigger;
  public Wrist wrist;
  public UseWrist() {
    requires();
    this.drivetrigger = new OI();
    this.wrist = new Wrist();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
     if (drivetrigger.isWristDownButtonDown == true){
        hand.WristUp();
    }
    else if (drivetrigger.isWristUpButtonDown == true){
        hand.WristDown();
    }
    else{
      hand.stopWrist();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
