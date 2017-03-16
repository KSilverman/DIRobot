package me.Kyle.MyRobot;

public class Debug {
	
	public static void main(String args[])
	{
		/**
		TouchSensor t = new TouchSensor(SensorPort.S4);
		DifferentialPilot p = new DifferentialPilot(5.6, 5.6, 17.7, Motor.A, Motor.C, false);
		while(!Button.ESCAPE.isDown())
		{
			if(t.isPressed())
				p.rotate(165);
		}
		//p.rotate(180);
		**/
		Jukebox j = new Jukebox();
		j.play(Jukebox.fixTheMelody(Jukebox.FIRST_MOSTER), false);
		
		try
		{
			Thread.sleep(6400);//TOTAL SONG GOES FOR 25 SECONDS!!!
		}
		catch(Exception e)
		{
		
		}
		
		j.play(Jukebox.fixTheMelody(Jukebox.SCARY_MONSTERS), false);
		
		/*
		j.play(Jukebox.fixTheMelody(Jukebox.MISSERY_BUSINESS), false);
		try
		{
			Thread.sleep(27490);//27500
		}
		catch(Exception e)
		{
		
		}
		
		j.play(Jukebox.fixTheMelody(Jukebox.M_B), false);
		
		try
		{
			Thread.sleep(24870);
		}
		catch(Exception e)
		{
		
		}
		j.play(Jukebox.fixTheMelody(Jukebox.MB_3), false);
		*/
		
	}

}
