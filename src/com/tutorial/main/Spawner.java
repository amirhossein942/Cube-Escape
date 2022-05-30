package com.tutorial.main;

import java.util.Random;

public class Spawner {

	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	private int scoreKeep=0;
	
	public Spawner(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() {
		scoreKeep++;
		
		if(scoreKeep >= 200) {
			scoreKeep=0;
			hud.setLevel(hud.getLevel()+1);
			
			if(hud.getLevel()==2) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
			}
			else if(hud.getLevel()==3) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
				
			}
			else if(hud.getLevel()==4) {
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
				
			}
			else if(hud.getLevel()==5) {
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
				
			}
			
			else if(hud.getLevel()==6) {
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.SmartEnemy, handler));
				
			}
			
			else if(hud.getLevel()==9) {
				handler.clearEnemies();
				handler.addObject(new Boss1((Game.WIDTH/2)-48, -120, ID.Boss1, handler));
				// put -120 because we want the boss to spawn from top outside of screen. 
				//and (width/2) because we want it to start in the middle
			}
			
			
		}
	}
	
	
	
}
