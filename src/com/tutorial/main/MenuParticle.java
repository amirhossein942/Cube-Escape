package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject{
	
	private Handler handler;
	
	Random r = new Random();
	

    private Color col;

    
	public MenuParticle(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler=handler;
		
		
			velx = (r.nextInt(5 - -5) + -5);
			vely = (r.nextInt(5 - -5) + -5);
		    if(velx==0) velx=1;
		    if(vely==0) vely=1;
		
	
		
		col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		
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
		
		handler.addObject(new Trail(x,y,ID.Trail, col,16,16,0.05f,handler));
	}

	
	public void render(Graphics g) {
		g.setColor(col);
		g.fillRect((int) x, (int) y, 16, 16);
		
	}

}
