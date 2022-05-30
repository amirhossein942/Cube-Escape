package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.tutorial.main.Game.STATE;

public class Menu extends MouseAdapter{
	private static boolean play = false;
	private static boolean help=false;
	private static boolean quit=false;
    private static boolean back=false;
	
	private Game game;
	private Handler handler;
	private Random r; 
	private HUD hud;
	
	public Menu(Game game, Handler handler, HUD hud) {
		this.game=game;
		this.handler =handler;
		this.hud = hud;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		
		if(game.gameState == STATE.Menu) {
			//if mouse is hovering over the box, initialize the game 
			//basically go in game mode
			
			//play button
			if(mouseOver(mx, my, 210, 150, 200, 64)) {
				game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
				//to get rid of all the menu cubes when you hit play 
				handler.clearEnemies();
				 
			    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
			}
			
			//help button
			if(mouseOver(mx, my, 210, 250, 200, 64)) {
				game.gameState = STATE.Help;
			}
			
			//quit button
			if(mouseOver(mx, my, 210, 350, 200, 64)){
				System.exit(1);
			}
		}
		
		//back button for help
		if(game.gameState == STATE.Help) {
			if(mouseOver(mx, my, 210, 350, 200, 64)) {
				game.gameState = STATE.Menu;
				return;
			}
		}
			//back button for help
			if(game.gameState == STATE.END) {
				if(mouseOver(mx, my, 210, 350, 200, 64)) {
					game.gameState = STATE.Game;
					hud.setLevel(1);
					hud.setScore(0);
					handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
					handler.clearEnemies();
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
					
				}
		}
		
	
		
		
	}
	
	public void mouseReleased(MouseEvent e) {}
	
	public void mouseMoved(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		int q = 200;
		int j = 64;
		int w = Game.WIDTH;
		int h = Game.HEIGHT;
		
		if(game.gameState == STATE.Menu) {
			if(mouseOver(mx, my , w/2-q/2, h/2-(j*3/2), q, j)) play=true;
			else play = false;
			
		    if (mouseOver(mx, my, w / 2 - q / 2, h / 2, q, j)) help = true;
	        else help = false;
		    
		    if (mouseOver(mx, my, w / 2 - q / 2, h / 2 + (j * 3 / 2), q, j)) quit = true;
            else quit = false;
		}
		else if(game.gameState== STATE.Help) {
			if(mouseOver(mx,my,w / 2 - q / 2, h - (j * 2), q, j))
                back=true;
            else back=false;
		}
		
	}
	
	//if mouse is over a selected target
	//refer to vid 9 15:20 mark for explanation
	//basically checks if mouse is hovering over the box
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}
			else return false;
		}else return false;
	}
		
	
	public void tick() {}
 
	public  void render(Graphics g) {
		int q= 200;
		int j = 64; 
		int w = Game.WIDTH;
		int h = Game.HEIGHT;
		if(game.gameState == STATE.Menu) {
		Font fnt = new Font("arial", 1, 45);
		Font fnt2 = new Font("arial", 1, 30);
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Welcome to Cube Escape", 50, 70);
		
		
		g.setFont(fnt2);
		if(play)g.setColor(Color.red);
		else g.setColor(Color.white);
		g.drawRect(210, 150, 200, 64);
		g.drawString("Play", 270, 190);
		
		if (help) g.setColor(Color.yellow);
        else g.setColor(Color.white);
		g.drawRect(210, 250, 200, 64);
		g.drawString("Help", 270, 290);
		
	    if (quit) g.setColor(Color.magenta);
        else g.setColor(Color.white);
		g.drawRect(210, 350, 200, 64);
		g.drawString("Quit", 270, 390);
		}
		
		else if (game.gameState == STATE.Help) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 17);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help", 260, 70);
			
			g.setFont(fnt3);
			g.drawString("Use WASD keys to move around "
					+ "and try your best to dodge the enemies!", 30, 200);
			
			g.setFont(fnt2);
			  if(back) g.setColor(Color.orange);
	            else g.setColor(Color.white);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 270, 390);
		}
		else if (game.gameState == STATE.END) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 17);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Game Over", 190, 70);
			
			g.setFont(fnt3);
			g.drawString("You lost with a score of " + hud.getScore(), 200, 200);
			
			g.setFont(fnt2);
			  if(back) g.setColor(Color.orange);
	            else g.setColor(Color.white);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Try Again", 245, 390);
		}
	}
	
	
}
