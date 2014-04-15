package com.yeep.study.patterns.command;

public class Client
{
  public static void main(String[] args)
  {
    Light light = new Light();
    LightOnCommand lightOnCommand = new LightOnCommand(light);

    RemoteControl remote = new RemoteControl();
    remote.setCommand(lightOnCommand);
    remote.buttonPressed();
  }
}
