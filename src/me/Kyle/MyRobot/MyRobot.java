package me.Kyle.MyRobot;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;

public class MyRobot {
	
	static DifferentialPilot p = new DifferentialPilot(5.6, 5.6, 17.7, Motor.A, Motor.C, false);
	static UltrasonicSensor u1 = new UltrasonicSensor(SensorPort.S1);
	static UltrasonicSensor u2 = new UltrasonicSensor(SensorPort.S2);
	static Jukebox j = new Jukebox();
	static boolean isMoving;
	static boolean isRotating;
	
	public static void main(String[] args)
	{ 
		isMoving=false;
		isRotating=false;
		u2.ping();
		while(!Button.ESCAPE.isDown())
		{
			if(u1.getDistance() < 15)
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
			if(u2.getDistance() < 10)
			{
				rotateOrNah();
				try
				{
					Thread.sleep(500);
				} 
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void goOrStop()
	{
		if(!isMoving)
		{
			p.forward();
			isMoving = true;
		}
		else if(isMoving)
		{
			p.stop();
			isMoving = false;
			u1.ping();
			u2.continuous();
		}
	}
	
	public static void rotateOrNah()
	{
		if(!isRotating)
		{
			//p.rotateLeft();
			j.play(Jukebox.fixTheMelody(Jukebox.MISSERY_BUSINESS), false);
			isRotating=true;
			//j.play(Jukebox.fixTheMelody(Jukebox.M_B), false);
		}
		else if(isRotating)
		{
			p.stop();
			j.off();
			u2.ping();
			u1.continuous();
			isRotating=false;
		}
	}
}
