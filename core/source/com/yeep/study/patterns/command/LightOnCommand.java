package com.yeep.study.patterns.command;

/**
 * Concrete Command for Light On
 */
public class LightOnCommand implements Command
{
  private Light light;

  public LightOnCommand(Light light)
  {
    this.light = light;
  }

  /**
   * @see com.study.patterns.command.Command#execute();
   */
  public void execute()
  {
    this.light.on();
  }
}
