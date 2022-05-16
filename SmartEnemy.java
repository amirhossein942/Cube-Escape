package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject{
	
	private Handler handler;
	private GameObject player;

	public SmartEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler=handler;
		
		for(int c=0; c<handler.object.size(); c++) {
			if(handler.object.get(c).getId()==ID.Player) player= handler.object.get(c);
		}
		
	}
	
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle ((int)x,(int) y, 16, 16);
	}

	
	public void tick() {
		// TODO Auto-generated method stub
		x += velx;
		y += vely;
		
		//8 to get the minimum like top corner
		float diffx = x - player.getX() - 8;
		float diffy = y - player.getY() - 8;
		float distance = (float) Math.sqrt((x-player.getX()) * (x-player.getX()) + (y-player.getY()) * (y-player.getY()));
		
		velx = (float) ((-1.0/distance) *diffx);
		vely = (float) ((-1.0/distance) *diffy);
		
		if(y<= 0 || y >= Game.HEIGHT-32) vely *= -1;		
		if(x<= 0 || x >= Game.WIDTH-16) velx *= -1;
		
		handler.addObject(new Trail(x,y,ID.Trail,Color.ORANGE,16,16,0.02f,handler));
	}

	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int) x,(int) y, 16, 16);
		
	}

}