package me.Kyle.MyRobot;

import lejos.nxt.Sound;

public class Jukebox extends Thread
{
	final static int G7 = 3135;
	final static int FIS7 = 2959;
	final static int F7 = 2793;
	final static int E7 = 2637;
	final static int DIS7 = 2489;
	final static int D7 = 2349;
	final static int C7 = 2093;
	final static int B6 = 1975;
	final static int AIS6 = 1865;
	final static int A6 = 1760;
	final static int GIS6 = 1661;
	final static int G6 = 1568;
	final static int FIS6 = 1480;
	final static int F6 = 1397;
	final static int E6 = 1318;
	final static int DIS6 = 1244;
	final static int D6 = 1175;
	final static int CIS6 = 1109;
	final static int C6 = 1046;
	final static int B5 = 988;
	final static int AIS5 = 932;
	final static int A5 = 880;
	final static int GIS5 = 831;
	final static int G5 = 784;
	final static int FIS5 = 740;
	final static int F5 = 698;
	final static int E5 = 659;
	final static int DIS5 = 622;
	final static int D5 = 587;
	final static int CIS5 = 554;
	final static int C5 = 523;
	final static int B4 = 493;
	final static int AIS4 = 466;
	final static int A4 = 440;
	final static int GIS4 = 415;
	final static int G4 = 391;
	final static int FIS4 = 369;
	final static int F4 = 349;
	final static int E4 = 329;
	final static int DIS4 = 311;
	final static int D4 = 293;
	final static int CIS4 = 277;
	final static int C4 = 261;
	
	final static int BEAT = 210;
	final static int SLEEP = 100;
	final static int PAUSE = -1;
	final static int VOLUME = Sound.VOL_MAX;//max = 100
	final static int[] SAMENOTE = {PAUSE, 11};
	
	
	final static int STARWARS_INTRO[][] = 
		{
			{C5, 2*BEAT}, {F5, 4*BEAT},	{C6, 2*BEAT},
			{AIS5, BEAT}, {A5, BEAT},	{G5, BEAT},
			{F6, 4*BEAT}, {C6, 2*BEAT},	{AIS5, BEAT},
			{A5, BEAT},   {G5, BEAT},	{F6, 4*BEAT},
			{C6, 2*BEAT}, {AIS5, BEAT},	{A5, BEAT},
			{AIS5,BEAT},  {G5, 6*BEAT}, {PAUSE, 4*BEAT}
		};
	
	final static int JAWS[][] = 
		{
			{D5, BEAT}, {DIS5, BEAT}, {D5, BEAT}, {E5, BEAT}
		};
	
	final static int TEST[][] = 
		{
			{G5, BEAT}, {G5, BEAT}, {G5, BEAT}
		};
	
	final static int KYLE_SONG[][] = 
		{
			{DIS4, 2*BEAT}, {AIS4, 2*BEAT}, {PAUSE, BEAT/4},
			{AIS4, 2*BEAT}, {FIS4, 2*BEAT}, {F4, 2*BEAT}, 
			{PAUSE, BEAT/4},{F4, 2*BEAT}, {PAUSE, BEAT/4},
			{F4, 2*BEAT}, {PAUSE, BEAT/4}, {F4, BEAT},
			{FIS4, BEAT}, {DIS4, 3*BEAT}, {PAUSE, BEAT/4}
		};
	
	final static int YES_SONG[][] = 
		{
			{A6, BEAT/2}, {PAUSE, BEAT/4}, {A6, BEAT/2}, {PAUSE, BEAT/4}, {A6, BEAT/2}, 
			{PAUSE, BEAT/4}, {A6, BEAT/2}, {PAUSE, BEAT/4}, {A6, BEAT/2}, {PAUSE, BEAT/4},{A6, BEAT/2} 
		};
	
	final static int NO_SONG[][] = 
		{
			{C4, BEAT*2}, {PAUSE, BEAT/4}, {C4, BEAT*2} 
		};
	
	final static int TEST_SONG[][] = 
		{
			{G6, BEAT}, {PAUSE, 10},{G6, BEAT}, {PAUSE, BEAT*2}
		};
	
	final static int CRAZY_SONG[][] =
		{
			{C7, BEAT}, {PAUSE, BEAT/4}, {B6, BEAT}, {PAUSE, BEAT/4}, {AIS6, BEAT},
			{PAUSE, BEAT/4},{A6, BEAT}, {PAUSE, BEAT/4}, {GIS6, BEAT},{PAUSE, BEAT/4}, {G6, BEAT},
			{PAUSE, BEAT/4},{GIS6, BEAT}, {PAUSE, BEAT/4},{A6, BEAT}, {PAUSE, BEAT/4},{AIS6, BEAT},
			{PAUSE, BEAT/4},{B6, BEAT}, {PAUSE, BEAT/4},{C7, BEAT}
		};
	
	final static int MEOW_SONG[][] = 
		{
			{G6, BEAT}, {F6, BEAT}, {E6, BEAT},
			{D6, BEAT}, {G6, BEAT}, {F6, BEAT},
			{E6, BEAT}, {D6, BEAT}, {G6, BEAT},
			{F6, BEAT}, {G6, BEAT}, {GIS6, BEAT},
			{A6, BEAT}, {F6, BEAT}, {E6, BEAT},
			{D6, BEAT}, {A6, BEAT}, {F6, BEAT},
			{E6, BEAT}, {D6, BEAT}, {A6, BEAT},
			{F6, BEAT}, {E6, BEAT}, {D6, BEAT},
			{A6, BEAT}, {GIS6, BEAT}, {A6, BEAT},
			{AIS6, BEAT}, {B6, BEAT}, {G6, BEAT},
			{E6, BEAT}, {D6, BEAT}, {G6, BEAT},
			{F6, BEAT}, {E6, BEAT}, {D6, BEAT},
			{G6, BEAT}, {F6, BEAT}, {E6, BEAT},
			{D6, BEAT}, {G6, BEAT}, {F6, BEAT},
			{G6, BEAT}, {B6, BEAT}, {C7, BEAT*2},
			{C7, BEAT}, {E6, BEAT}, {G6, BEAT},
			{C7, BEAT}, {B6, BEAT}, {D6, BEAT},
			{G6, BEAT}, {B6, BEAT}, {A6, BEAT},
			{D6, BEAT}, {F6, BEAT}, {A6, BEAT},
			{G6, BEAT*2}
		};
	
	final static int OTHER_SONG[][] = 
		{
			{F4, BEAT}, {AIS4, BEAT}, {PAUSE, BEAT/5},
			{AIS4, BEAT}, {AIS4, BEAT},
			{GIS4, BEAT/2}, {AIS4, BEAT/2}, 
			{AIS4, BEAT/2}, {GIS4, BEAT}, {F4, BEAT/2},
			 {F4, BEAT/2}, 
			{F4, BEAT/2}, {GIS4, BEAT}, {AIS4, BEAT},
			{PAUSE, BEAT/5}, {AIS4, BEAT}, {PAUSE, BEAT/5},
			{AIS4, BEAT}, {GIS4, BEAT/2}, {AIS4, BEAT/2},
			{PAUSE, BEAT/5}, {AIS4, BEAT/2}, {GIS4, BEAT},
			{F4, BEAT/2}, {PAUSE, BEAT/5}, {F4, BEAT/2},
			{PAUSE, BEAT/5}, {F4, BEAT}, {GIS4, BEAT/2},
			{AIS4, BEAT}, {PAUSE, BEAT/5}, {AIS4, BEAT},
			{PAUSE, BEAT/5}, {AIS4, BEAT}, {GIS4, BEAT/2},
			{AIS4, BEAT/2}, {PAUSE, BEAT/5}, {AIS4, BEAT/2},
			{GIS4, (int)Math.round(BEAT/1.5)}, {PAUSE, BEAT/2}, {F4, BEAT/2},
			{PAUSE, BEAT/5}, {F4, BEAT/2}, {AIS4, BEAT/2},
			{PAUSE, BEAT/5}, {AIS4, BEAT}, {PAUSE, BEAT/5},
			{AIS4, BEAT}, {PAUSE, BEAT/5}, {AIS4, BEAT},
			{GIS4, BEAT/2}, {AIS4, BEAT/2}, {PAUSE, BEAT/5},
			{AIS4, BEAT/2}, {PAUSE, BEAT/5}, {AIS4, BEAT/2},
			{C5, BEAT}, {F4, BEAT}, {PAUSE, BEAT/5},
			{F4, BEAT/2}, {AIS4, BEAT/2}, {PAUSE, BEAT/5},
			{AIS4, BEAT}, {PAUSE, BEAT/5}, {AIS4, BEAT},
			{PAUSE, BEAT/5}, {C5, BEAT/2}, {AIS4, BEAT/2},
			{PAUSE, BEAT/5}, {AIS4, BEAT/2}, {GIS4, BEAT},
			{F4, BEAT/2}, {PAUSE, BEAT/5}, {F4, BEAT},
			{PAUSE, BEAT/5}, {F4, BEAT/2}, {GIS4, BEAT/2},
			{AIS4, BEAT}, {PAUSE, BEAT/5}, {AIS4, BEAT},
			{PAUSE, BEAT/5}, {AIS4, BEAT}, {GIS4, BEAT/2},
			{AIS4, BEAT/2}, {PAUSE, BEAT/5}, {AIS4, BEAT/2},
			{PAUSE, BEAT/5}, {AIS4, (int)Math.round(BEAT/1.5)}, {PAUSE, BEAT/2},
			{E4, BEAT/2}, {F4, BEAT/2}, {GIS4, BEAT/2},
			{AIS4, BEAT}, {PAUSE, BEAT/5}, {AIS4, BEAT},
			{PAUSE, BEAT/5}, {AIS4, BEAT/2}, {GIS4, BEAT},
			{AIS4, BEAT/2}, {PAUSE, BEAT/5}, {AIS4, BEAT/2},
			{GIS4, BEAT}, {F4, BEAT/2}, {PAUSE, BEAT/5},
			{F4, BEAT/2}, {PAUSE, BEAT/5}, {F4, BEAT},
			{AIS4, BEAT/2}, {PAUSE, BEAT/5}, {AIS4, BEAT},
			{PAUSE, BEAT/5}, {AIS4, BEAT}, {PAUSE, BEAT/5},
			{AIS4, BEAT}, {GIS4, BEAT/2}, {AIS4, BEAT/2},
			{PAUSE, BEAT/5}, {AIS4, BEAT}, {PAUSE, BEAT/5},
			{AIS4, BEAT/2}, {C5, BEAT/2}, {PAUSE, BEAT/5},
			{C5, 2*BEAT}, {PAUSE, BEAT/5}, {C5, 4*BEAT},
		};
	
	final static int MISSERY_BUSINESS[][] = 
		{
			{GIS5, BEAT}, {GIS5, BEAT*2}, {GIS5, BEAT},
			{AIS5, BEAT}, {C6, BEAT}, {AIS5, BEAT},
			{C6, BEAT}, {G5, BEAT}, {G5, BEAT*2},
			{G5, BEAT}, {G5, BEAT*3}, {G5, BEAT},
			{GIS5, BEAT}, {GIS5, BEAT*2}, {GIS5, BEAT},
			{AIS5, BEAT}, {C6, BEAT}, {AIS5, BEAT},
			{C6, BEAT}, {F5, BEAT}, {F5, BEAT*2},
			{F5, BEAT}, {F5, BEAT*4},
			{GIS5, BEAT}, {GIS5, BEAT*2}, {GIS5, BEAT},
			{AIS5, BEAT}, {C6, BEAT}, {AIS5, BEAT},
			{C6, BEAT}, {G5, BEAT}, {G5, BEAT*2},
			{G5, BEAT}, {G5, BEAT*3}, {G5, BEAT},
			{GIS5, BEAT}, {GIS5, BEAT*2}, {GIS5, BEAT},
			{AIS5, BEAT}, {C6, BEAT}, {AIS5, BEAT},
			{C6, BEAT},{F5, BEAT}, {G5, BEAT}, 
			{GIS5, BEAT}, {AIS5, BEAT}, {C6, BEAT},
			{DIS6, BEAT*3}, {PAUSE, BEAT}, {C6, BEAT},
			{C6, BEAT}, {C6, BEAT}, {CIS6, BEAT},
			{C6, BEAT}, {C6, BEAT}, {C6, BEAT*2},
			{AIS5, BEAT}, {AIS5, BEAT}, {AIS5, BEAT},
			{AIS5, BEAT}, {AIS5, BEAT}, {AIS5, BEAT},
			{AIS5, BEAT}, {F5, BEAT}, {F5, BEAT},
			{C6, BEAT}, {C6, BEAT}, {C6, BEAT},
			{C6, BEAT}, {C6, BEAT}, {DIS6, BEAT},
			{DIS6, BEAT}, {CIS6, BEAT}, {CIS6, BEAT},
			{C6, BEAT}, {CIS6, BEAT}, {C6, BEAT},
			{AIS5, BEAT}, {GIS5, BEAT}, {F5, BEAT*3},
			{C6, BEAT/2}, {C6, BEAT/2}, {C6, BEAT},
			{C6, BEAT}, {C6, BEAT}, {C6, BEAT*2},
			{AIS5, BEAT}, {GIS5, BEAT} //here --> 29 lines -- 85 notes
		};
	
	final static int[][] M_B = 
		{
			{AIS5, BEAT}, {GIS5, BEAT},
			{AIS5, BEAT}, {C6, BEAT}, {C6, BEAT*2},
			{PAUSE, BEAT*3}, {C6, BEAT/2}, {C6, BEAT/2},
			{C6, BEAT}, {C6, BEAT}, {C6, BEAT},
			{C6, BEAT*2}, {C6, BEAT}, {C6, BEAT},
			{C6, BEAT}, {C6, BEAT}, {C6, BEAT},
			{C6, BEAT*2}, {PAUSE, BEAT}, {F5, BEAT},
			{F5, BEAT}, {F5, BEAT}, {GIS5, BEAT},
			{C6, BEAT}, {C6, BEAT*2}, {PAUSE, BEAT},
			{F5, BEAT}, {F5, BEAT}, {F5, BEAT},
			{AIS5, BEAT}, {F5, BEAT*2}, {F5, BEAT*2},
			{GIS5, BEAT}, {GIS5, BEAT}, {GIS5, BEAT},
			{GIS5, BEAT}, {GIS5, BEAT*2}, {GIS5, BEAT*2},
			{F5, BEAT}, {F5, BEAT}, {F5, BEAT},
			{F5, BEAT}, {F5, BEAT}, {F5, BEAT},
			{GIS5, BEAT}, {F5, BEAT*2}, {PAUSE, BEAT},
			{GIS5, BEAT}, {GIS5, BEAT}, {GIS5, BEAT},
			{GIS5, BEAT}, {GIS5, BEAT}, {C6, BEAT},
			{C6, BEAT*2}, {C6, BEAT*2}, {PAUSE, BEAT*2},
			{C6, BEAT/2}, {C6, BEAT/2}, {C6, BEAT/2},
			{F5, BEAT*2}, {F5, BEAT}, {F5, BEAT*2},
			{F5, BEAT}, {F5, BEAT}, {F5, BEAT},
			{F6, BEAT*2}, {F6, BEAT}, {F6, BEAT*2},
			{E5, BEAT}, {E5, BEAT}, {E5, BEAT},
			{E5, BEAT}, {D5, BEAT}, {D5, BEAT},
			{D5, BEAT}, {D5, BEAT}, {D5, BEAT},
			{D5, BEAT}, {D5, BEAT}, {D5, BEAT},
			{C4, BEAT}, {C4, BEAT/2}, {C4, BEAT/2},
			//{C4, BEAT}, {C4, BEAT}, {C4, BEAT*2}
			//{PAUSE, BEAT*2}//29 lines -- 83 notes
		};
	
	final static int[][] MB_3 = 
		{
			{C4, BEAT}, {C4, BEAT}, {C4, BEAT*2},
			{PAUSE, BEAT*2}
		};
	
	final static int[][] WONDER_WALL = 
		{
			{CIS6, BEAT}, {B5, (BEAT/2)*3}, {A5, BEAT/2},
			{B5, BEAT/2}, {A5, BEAT/2}, {B5, BEAT/2},
			{A5, BEAT/2}, {B5, BEAT}, {B5, BEAT/2},
			{A5, BEAT/2}, {B5, BEAT/2}, {A5, BEAT/2},
			{B5, BEAT/2}, {A5, BEAT/2}, {B5, BEAT},
			{CIS6, BEAT/2}, {A5, (BEAT/2)*5}, {PAUSE, BEAT*3},
			{CIS6, BEAT}, {B5, (BEAT/2)*3},
			{A5, BEAT/2}, {B5, BEAT/2}, {A5, BEAT/2},
			{B5, BEAT}, {B5, BEAT}, {B5, BEAT/2},
			{A5, BEAT/2}, {B5, BEAT}, {B5, BEAT/2},
			{A5, BEAT/2}, {B5, BEAT}, {CIS6, BEAT},
			{A5, (BEAT/2)*5}, {PAUSE, BEAT*2}, {CIS6, BEAT/2},
			{E6, BEAT/2}, {CIS6, BEAT/2}, {E6, (BEAT/2)*3},
			{FIS6, (BEAT/2)*3}, {E6, BEAT/2}, {B5, BEAT},
			{A5, (BEAT/2)*3}, {B5, (BEAT/2)*3}, {B5, BEAT/2},
			{B5, BEAT/2}, {CIS6, BEAT}, {A5, BEAT*2},
			{E5, BEAT/2}, {FIS5, BEAT}, {A5, BEAT/2},
			{A5, (BEAT/2)*3}, {FIS5, BEAT},
		};
	
	final static int[][] FIRST_MOSTER = 
		{
			{G5, BEAT}, {F5, BEAT}, {G5, BEAT},
			{AIS5, BEAT*2}, {G5, BEAT}, {D6, BEAT},
			{C6, BEAT}, {AIS5, BEAT}, {C5, BEAT*2},
			{AIS4, BEAT}, {A4, BEAT}, {F5, BEAT},
			{DIS5, BEAT}, {D5, BEAT}, {C5, BEAT},
			{AIS4, BEAT}, {F5, BEAT}, {AIS4, BEAT},
			{G4, BEAT}, {AIS4, BEAT}, {D5, BEAT},
			{G6, BEAT}, {D6, BEAT}, {AIS5, BEAT},
			{G5, BEAT}, {F6, BEAT}, {AIS5, BEAT},
			{G5, BEAT}, {F5, BEAT}, 
		};
	
	final static int[][] SCARY_MONSTERS =
		{
			/*{G5, BEAT}, {F5, BEAT}, {G5, BEAT},
			{AIS5, BEAT*2}, {G5, BEAT}, {D6, BEAT},
			{C6, BEAT}, {AIS5, BEAT}, {C5, BEAT*2},
			{AIS4, BEAT}, {A4, BEAT}, {F5, BEAT},
			{DIS5, BEAT}, {D5, BEAT}, {C5, BEAT},
			{AIS4, BEAT}, {F5, BEAT}, {AIS4, BEAT},
			{G4, BEAT}, {AIS4, BEAT}, {D5, BEAT},
			{G6, BEAT}, {D6, BEAT}, {AIS5, BEAT},
			{G5, BEAT}, {F6, BEAT}, {AIS5, BEAT},
			{G5, BEAT}, {F5, BEAT}, {PAUSE, BEAT}, */
			{G5, BEAT}, {F5, BEAT}, {G5, BEAT},
			{AIS5, BEAT*2}, {G5, BEAT}, {D6, BEAT},
			{C6, BEAT}, {AIS5, BEAT}, {C5, BEAT*2},
			{AIS4, BEAT}, {A4, BEAT}, {F5, BEAT},
			{DIS5, BEAT}, {D5, BEAT}, {C5, BEAT},
			{AIS4, BEAT}, {F5, BEAT}, {AIS4, BEAT},
			{G4, BEAT}, {AIS4, BEAT}, {D5, BEAT},
			{G6, BEAT}, {D6, BEAT}, {AIS5, BEAT},
			{G5, BEAT}, {F6, BEAT}, {AIS5, BEAT},
			{G5, BEAT}, {F5, BEAT}, 
			{G4, BEAT*4}, {F5, BEAT*4}, {D5, BEAT},
			{PAUSE, BEAT}, {D5, BEAT}, {D5, BEAT/2},
			{D5, BEAT/2}, {C5, BEAT}, {AIS4, BEAT},
			{AIS4, BEAT/2}, {C5, BEAT/2}, {D5, BEAT/2},
			{DIS5, BEAT/2}, {D5, BEAT}, {F4, BEAT},
			{AIS4, BEAT}, {AIS4, BEAT}, {AIS4, BEAT},
			{F4, BEAT}, {AIS4, BEAT}, {AIS4, BEAT},
			{AIS4, BEAT}, {AIS4, BEAT}, {AIS4, BEAT},
			{AIS4, BEAT/2}, {C5, BEAT/2}, {AIS4, BEAT*2},
			{A4, BEAT*2}, {G4, BEAT*2},
			{G4, BEAT*4}, {F5, BEAT*4}, {D5, BEAT},
			{PAUSE, BEAT}, {D5, BEAT}, {D5, BEAT/2},
			{D5, BEAT/2}, {C5, BEAT}, {AIS4, BEAT},
			{AIS4, BEAT/2}, {C5, BEAT/2}, {D5, BEAT/2},
			{DIS5, BEAT/2}, {F5, BEAT}, {D4, BEAT},
			{AIS4, BEAT}, {AIS4, BEAT}, {AIS4, BEAT},
			{D4, BEAT}, {AIS4, BEAT}, {AIS4, BEAT}
			
			
			
			/*
			{AIS5, BEAT*2}, {AIS5, (3*(BEAT/2))}, {AIS5, BEAT/2},
			{F6, (3*(BEAT/2))}, {D6, BEAT}, {C6, BEAT*2},
			{C6, BEAT}, {C6, BEAT}, {C6, BEAT},
			{C6, BEAT}, {AIS5, BEAT/2}, {C6, BEAT/2},
			{D6, BEAT/2}, {DIS6, BEAT/2}, {D6, BEAT},
			{AIS5, BEAT}, {AIS5, BEAT}, {AIS5, BEAT/2},
			{C6, BEAT/2}, {AIS5, BEAT/2}, {F6, BEAT},
			{AIS5, BEAT}, {AIS5, BEAT}, {AIS5, BEAT/2},
			{C6, BEAT}, {AIS5, BEAT}, {A5, BEAT},
			{F5, BEAT}, {F6, BEAT}, {F5, BEAT},
			{AIS5, BEAT}, {A5, BEAT}, {G5, BEAT*2}
			*/
		};
	
	//Functions
	
	private int[][] melody = null;
	private boolean playing = true;
	private boolean looping = true;
	
	public Jukebox()
	{
		super();
		melody = null;
		playing = true;
		start();
	}
	
	
	
	public void play(int[][] melody, boolean looping)
	{
		try
		{
			off();
			sleep(BEAT);
		}
		catch(InterruptedException ex)
		{
			ex.printStackTrace();
		}
		
		this.melody = melody;
		this.looping = looping;
	}
	
	public void off()
	{
		melody = null;
	}
	
	public void poweroff()
	{
		melody = null;
		playing = false;
	}
	
	public void run()
	{
		
		while (playing)
		{
			try
			{
				if (melody != null)
					playTheMelody();
				else
					sleep(SLEEP);
			}
			catch(InterruptedException iex)
			{	
				iex.printStackTrace();
			}
		}
	}
	
	private void playTheMelody() throws InterruptedException
	{
		int i = 0;
		int length = -1;
		int note = A5;
		int duration = BEAT;
		
		if (melody != null)
			length = melody.length;
		
		while (i < length)
		{
			if (melody == null)
				length = -1;
			else
			{
				if (melody != null)
					note = melody[i][0];
				if (melody != null)
		 			duration = melody[i][1];
				if (note != PAUSE)
					Sound.playTone(note, duration);
				yield();
				sleep(duration);
				i++;
			}
		}
		if (!looping)
			melody = null;
	}
	
	public static int[][] fixTheMelody(int[][] array)
	{
		int count=0;
		for(int i=0; i<array.length-1;i++)
		{
			if(array[i][0] == array[i+1][0] )
				count++;
		}
		int[][] result = new int[array.length+count][array.length];
		for(int i=0;i<array.length;i++)
		{
			result[i][0] = array[i][0];
			result[i][1] = array[i][1];
		}
		
		for(int i=0; i < result.length;i++)
		{
			if(result[i][0]==0)
			{
				result[i][0] = PAUSE;
				result[i][1] = 10;
			}
		}
		for(int i=0; i < result.length; i++)
		{
			if(i == result.length-1)
				break;
			if(result[i][0] == result[i+1][0])
			{
				int tempnote = result[result.length-1][0];
				int temptime = result[result.length-1][1];
				for(int j=result.length-1; j>i;j--)
				{
					if(j == i+1)
					{
						result[j][0] = tempnote;
						result[j][1] = temptime;
					}
					else
					{
						result[j][0] = result[j-1][0];
						result[j][1] = result[j-1][1];
					}
				}
			}
		}
		return result;
	}
}

