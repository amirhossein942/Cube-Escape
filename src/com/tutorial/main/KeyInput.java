package com.tutorial.main;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private boolean[] KeyDown = new boolean[4];
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		KeyDown[0] = false;
		KeyDown[1] = false;
		KeyDown[2] = false;
		KeyDown[3] = false;
	} 

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i<handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				//key events for player 1
				
				if(key == KeyEvent.VK_W) {tempObject.setVely(-7); KeyDown[0]=true;}
				if(key == KeyEvent.VK_S) {tempObject.setVely(7); KeyDown[1] = true;}
				if(key == KeyEvent.VK_D) {tempObject.setVelx(7); KeyDown[2] = true;}
				if(key == KeyEvent.VK_A) {tempObject.setVelx(-7); KeyDown[3] = true;}
				
			}
					
		}
		
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i<handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				//key events for player 1
				
				if(key == KeyEvent.VK_W) KeyDown[0] = false;//tempObject.setVely(0);
				if(key == KeyEvent.VK_S) KeyDown[1] = false;//tempObject.setVely(0);
				if(key == KeyEvent.VK_D) KeyDown[2] = false;//tempObject.setVelx(0);
				if(key == KeyEvent.VK_A) KeyDown[3] = false;//tempObject.setVelx(0);
				
				//vertical movement
				if(!KeyDown[0] && !KeyDown[1]) tempObject.setVely(0);
				
				//horizontal movement 
				if(!KeyDown[2] && !KeyDown[3]) tempObject.setVelx(0);
			}
			
			
			}
	}
	
	
}
