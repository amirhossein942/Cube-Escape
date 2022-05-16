package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Boss1 extends GameObject{
	
	private Handler handler;
	Random r = new Random();
	private int timer = 80;
	private int timer2=50;

	public Boss1(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler=handler;
		velx =0;
		vely = 2;
		
	}
	
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle ((int)x,(int) y, 96, 96);
	}

	
	public void tick() {
		// TODO Auto-generated method stub
		x += velx;
		y += vely;
		
		
		if(timer <= 0) vely=0;
		else timer--;
		
		if(timer <= 0 ) timer2--;
		if(timer2 <= 0) 
		{
			if(velx==0) velx = 2;
			//speeding up the boss, remove if too hard, 
			//clamp sets a maximum speed to not exceed
			if(velx > 0) {
			velx += 0.005f;}
			else if(velx < 0) {
				velx -=0.005f;
			}
			velx = Game.clamp(velx, -10, 10);
			
			
			int spawn = r.nextInt(10);
			if(spawn == 0) handler.addObject(new Boss1bullet((int)x+48, (int)y+48, ID.BasicEnemy, handler));
		}
		
		//if(y<= 0 || y >= Game.HEIGHT-32) vely *= -1;
		
		if(x<= 0 || x >= Game.WIDTH-96) velx *= -1;
		
		handler.addObject(new Trail(x,y,ID.Trail,Color.red,96,96,0.1f,handler));
	}

	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int) x,(int) y, 16, 16);
		
	}

}
