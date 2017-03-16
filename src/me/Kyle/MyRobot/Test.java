package me.Kyle.MyRobot;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;

public class Test {
	static Jukebox j = new Jukebox();
	static UltrasonicSensor u1 = new UltrasonicSensor(SensorPort.S1);//movement
	static UltrasonicSensor u2 = new UltrasonicSensor(SensorPort.S2);//yes or no
	static UltrasonicSensor u3 = new UltrasonicSensor(SensorPort.S3);//open mouth to eat
	static TouchSensor s1 = new TouchSensor(SensorPort.S4);
	static DifferentialPilot p = new DifferentialPilot(5.6, 5.6, 11.2, Motor.A, Motor.C, false);
	static boolean isMoving;
	static boolean initialMovement;
	static boolean desision;
	static boolean firstTime;
	static boolean firstStop;
	static boolean secondStop;
	static boolean firstTimeEat;
	static int EATING_COUNTER;
	static int MOVEMENT_RANGE;
	static int YES_OR_NO_RANGE;
	static int OPEN_MOUTH_RANGE;
	public static void main(String args[])
	{
		firstStop = false;
		secondStop = false;
		isMoving = false;
		initialMovement = true;
		desision = true;
		firstTime = true;
		firstTimeEat = false;
		EATING_COUNTER = 0;
		MOVEMENT_RANGE = 25;
		YES_OR_NO_RANGE = 10;
		OPEN_MOUTH_RANGE = 10;
		while(!Button.ESCAPE.isDown())
		{
			if(SensorPort.S1.readBooleanValue()==false && u1.getDistance() <= MOVEMENT_RANGE)
			{
				goOrStop();
				try
				{
					Thread.sleep(500);
				} 
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			if(u2.getDistance() <= YES_OR_NO_RANGE)
			{
				yesOrNo();
			}
			if(u3.getDistance() <= OPEN_MOUTH_RANGE)
			{
				eat();
			}
			if(s1.isPressed())
			{
				p.rotate(190);
			}
		}
	}
	
	public static void goOrStop()
	{
		if(!isMoving)
		{
			if(!initialMovement)
			{
				p.travel(70);//robot needs to be 1 foot parallel to the board for the start
				p.rotate(91);
				p.travel(100);
				p.rotate(91);
				p.forward();
				initialMovement = true;
			}
			else
			{
				p.forward();
				isMoving = true;
			}
		}
		else if(isMoving)
		{
			p.stop();
			isMoving = false;
			//u1.ping();
			if(!firstStop)
			{
				firstStop=true;
				return;
			}
			if(firstStop)
			{
				if(!secondStop)
				{
					secondStop=true;
					p.rotate(190);
					return;
				}
			}
		}
	}
	
	public static void yesOrNo()
	{
		if(!firstTime)
		{
			j.play(Jukebox.YES_SONG, false);
			return;
		}
		else if(!desision)
		{
			j.play(Jukebox.NO_SONG, false);
			desision = true;
			if(firstTime)
				firstTime=false;
		}
		else if(desision)
		{
			j.play(Jukebox.YES_SONG, false);
			desision = false;
		}
	}
	
	public static void eat()
	{
		if(!firstTimeEat || EATING_COUNTER==2)
		{
			playCreatureSong();
			firstTimeEat=true;
		}
		else
		{
			Motor.B.rotate(-50);
			Sound.beepSequenceUp();
			try 
			{ 
				Thread.sleep(2500);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			Motor.B.rotate(50);
			Sound.buzz();
			EATING_COUNTER++;
		}
	}
	
	public static void stage()
	{
		p.travel(140);
		p.rotate(-91);
		p.travel(75);
		p.rotate(-91);
		p.travel(70);
		p.rotate(181);
		try 
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		p.travel(70);
		p.rotate(91);
		p.travel(75);
		p.rotate(91);
		p.travel(165);
		p.rotate(-91);
		goCrazy();
		p.rotate(-91);
		p.forward();
	}
	
	public static void goCrazy()
	{
		j.play(Jukebox.fixTheMelody(Jukebox.FIRST_MOSTER), false);
		p.rotateLeft();
		
		try
		{
			Thread.sleep(6400);//TOTAL SONG GOES FOR 25 SECONDS!!!
		}
		catch(Exception e)
		{
		
		}
		
		j.play(Jukebox.fixTheMelody(Jukebox.SCARY_MONSTERS), false);
		p.rotateRight();
	}
	
	public static void playCreatureSong()
	{
		j.play(Jukebox.fixTheMelody(Jukebox.FIRST_MOSTER), false);
		
		try
		{
			Thread.sleep(6400);//TOTAL SONG GOES FOR 25 SECONDS!!!
		}
		catch(Exception e)
		{
		
		}
		
		j.play(Jukebox.fixTheMelody(Jukebox.SCARY_MONSTERS), false);
	}
	
	public static void fixGoForward(DifferentialPilot dp)
	{
		dp.forward();
		while(dp.isMoving())
		{
			if(Motor.A.getTachoCount() > Motor.C.getTachoCount() && ((Motor.A.getTachoCount() - Motor.C.getTachoCount()) > 0))
			{
				Motor.C.setSpeed(Motor.C.getSpeed()*(Motor.A.getTachoCount()/Motor.C.getTachoCount()));
			}
			else if(Motor.A.getTachoCount() < Motor.C.getTachoCount() && ((Motor.C.getTachoCount() - Motor.A.getTachoCount()) > 0))
			{
				Motor.A.setSpeed(Motor.A.getSpeed()*(Motor.C.getTachoCount()/Motor.A.getTachoCount()));
			}
		}
	}
	
	public static void fixTrvaelForward(DifferentialPilot dp, int distance)
	{
		dp.travel(distance);
		while(dp.isMoving())
		{
			if(Motor.A.getTachoCount() > Motor.C.getTachoCount() && ((Motor.A.getTachoCount() - Motor.C.getTachoCount()) > 0))
			{
				Motor.C.setSpeed(Motor.C.getSpeed()*(Motor.A.getTachoCount()/Motor.C.getTachoCount()));
			}
			else if(Motor.A.getTachoCount() < Motor.C.getTachoCount() && ((Motor.C.getTachoCount() - Motor.A.getTachoCount()) > 0))
			{
				Motor.A.setSpeed(Motor.A.getSpeed()*(Motor.C.getTachoCount()/Motor.A.getTachoCount()));
			}
		}
	}
}
