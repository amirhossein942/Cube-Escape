package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{
	
	Random r = new Random();
	Handler handler ;

	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
			
	}

	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int) x, (int) y, 32, 32);
	}
	
	public void tick() {
		// TODO Auto-generated method stub
		x += velx;
		y += vely;
		
		x = Game.clamp(x, 0, Game.WIDTH -45);
		y = Game.clamp(y, 0, Game.HEIGHT -64);
		
		handler.addObject(new Trail(x,y, ID.Trail, Color.magenta, 32, 32, 0.05f, handler));
		
		collision();
	}

	public void collision() {
		for(int i =0; i<handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy 
					|| tempObject.getId() == ID.Boss1) {
				if(getBounds().intersects(tempObject.getBounds())) {
					//collision code
					HUD.HEALTH -=2;
				}
			}
		}
	}
	
	public void render(Graphics g) {
		//Code just to draw the outline of collision box.
		/*
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.green);
		g2d.draw(getBounds());
		*/
		
		g.setColor(Color.MAGENTA);
		g.fillRect( (int) x, (int) y, 32, 32);
		
	}



	
	
	

}
