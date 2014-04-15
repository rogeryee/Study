package com.yeep.study.patterns.command;

/**
 * Concrete Command for Light Off
 */
public class LightOffCommand implements Command
{
  private Light light;

  public LightOffCommand(Light light)
  {
    this.light = light;
  }

  /**
   * @see com.study.patterns.command.Command#execute();
   */
  public void execute()
  {
    this.light.off();
  }
}
