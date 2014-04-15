package com.yeep.study.patterns.command;

public class RemoteControl
{
  private Command command;

  public RemoteControl() {}

  public void setCommand(Command command)
  {
    this.command = command;
  }

  public void buttonPressed()
  {
    command.execute();
  }
}
