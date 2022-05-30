package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Boss1bullet extends GameObject{
	
	private Handler handler;

	Random r = new Random();
	public Boss1bullet(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler=handler;
		velx =(r.nextInt(5 - -5)+ -5);
		vely = 5;
		
	}
	
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle ((int)x,(int) y, 16, 16);
	}

	
	public void tick() {
		// TODO Auto-generated method stub
		x += velx;
		y += vely;
		
		//if(y<= 0 || y >= Game.HEIGHT-32) vely *= -1;
		
		//if(x<= 0 || x >= Game.WIDTH-16) velx *= -1;
		
		handler.addObject(new Trail(x,y,ID.Trail,Color.blue,16,16,0.1f,handler));
		
		if(y >= Game.HEIGHT) handler.removeObject(this);
	}

	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int) x,(int) y, 16, 16);
		
	}

}