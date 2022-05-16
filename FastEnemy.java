package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject{
	
	private Handler handler;

	public FastEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler=handler;
		velx = 2;
		vely = 9;
		
	}
	
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle ((int) x,(int) y, 16, 16);
	}

	
	public void tick() {
		// TODO Auto-generated method stub
		x += velx;
		y += vely;
		
		if(y<= 0 || y >= Game.HEIGHT-32) vely *= -1;
		
		if(x<= 0 || x >= Game.WIDTH-16) velx *= -1;
		
		handler.addObject(new Trail(x,y,ID.Trail,Color.yellow,16,16,0.02f,handler));
	}

	
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect((int) x, (int) y, 16, 16);
		
	}

}