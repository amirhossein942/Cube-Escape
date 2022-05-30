package com.tutorial.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	protected float x,y;
	protected ID id;
	protected float velx, vely;
	
	public GameObject(float x, float y, ID id) {
		this.id = id;
		this.x = x;
		
		this.y = y;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public void setX(float x) {
		this.x=x;
	}
	
	public void setY(float y) {
		this.y=y;
	}
	 public float getX() {
		 return x;
	 }
	 
	 public float getY() {
		 return y;
	 }
	 
	 public void setId(ID id) {
		 this.id = id;
	 }
	 
	 public ID getId() {
		 return id;
	 }
	 
	 public void setVelx(float velx) {
		 this.velx= velx ;
	 }
	 
	 public void setVely(float vely) {
		 this.vely=vely;
	 }
	 
	 public float getVelx() {
		 return velx;
	 }
	 
	 public float getVely() {
		 return vely;
	 }
	 
	 
}
