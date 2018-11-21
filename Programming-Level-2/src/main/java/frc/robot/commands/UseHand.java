/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class UseHand extends Command {
  public final OI drivetrigger;
  public Hand hand;
  public UseHand() {
    requires(hand);
    this.drivetrigger = new OI();
    this.hand = new Hand();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
     if (drivetrigger.isOpenHandDown == true){
        hand.OpenUp();
    }
    else if (drivetrigger.isCloseHandDown == true){
        hand.CloseUp();
    }
    else{
      hand.StayStill();
    }


    if (drivetrigger.isHandsucButtonDown == true){
        hand.startHandSuction();
    }
    else if (drivetrigger.isHandejecDown == true){
        hand.startHandEjection();
    }
    else{
      hand.stopHand();
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
