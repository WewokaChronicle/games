package com.rhymes.helpers;

import java.util.HashMap;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.rhymes.game.data.StartupInfo;
import com.rhymes.ge.core.data.GlobalVars;
import com.rhymes.ge.core.entity.elements.ElementBase;
import com.rhymes.ge.core.renderer.Point;

public class Helper {
	public static long stepTime = 0; 
	private static HashMap<String, TextureRegion> textureCache = new HashMap<String, TextureRegion>();
	
	
	public static void println(String s, boolean force){
//		if(StartupInfo.debugLevel < 3)
//			return;
		if(force)
			System.out.println(s);
		else if(StartupInfo.debugLevel < 3)
			return;
	}
	
	public static void println(String s){
//		if(StartupInfo.debugLevel < 3)
//			return;
		System.out.println(s);
	}
	
	public static void printKeyVal(String key, String val){
		if(StartupInfo.debugLevel < 2)
			return;
		System.out.println(formatStringKeyVal(key, val));
	}

	public static void printKeyVal(String key, double val){
		if(StartupInfo.debugLevel < 2)
			return;
		System.out.println(formatStringKeyVal(key, val+""));
	}
	
	public static String formatStringKeyVal(String key, String val){
		if(StartupInfo.debugLevel < 2)
			return null;
		return new String("" + key + ": " + val);
	}
	
	public static float getAngle(float x1, float y1, float x2, float y2)
	{
		float angle =(float) Math.atan((y2 - y1)
				/ (x2-x1))
				* 180 / (float) Math.PI -90;
		if(x2-x1 < 0)
			angle += 180;
		return angle;
	}
	
	
	public static double pointToLineDistance(Point A, Point B, Point hitPoint)
	{
		 double normalLength = Math.sqrt((B.x - A.x) * (B.x - A.x) + (B.y - A.y) * (B.y - A.y));
		 return Math.abs((hitPoint.x - A.x) * (B.y - A.y) - (hitPoint.y - A.y) * (B.x - A.x)) / normalLength;
	}
	
		
	public static boolean insideRegion(Point p, ElementBase e2)
	{
		if(p.x <= e2.getRight() && p.x >=e2.getLeft())
		{
			return true;
		}
		return false;
	}

	public static float getAngle(Point p, Point n) {
		return getAngle(p.x, p.y, n.x, n.y);
	}
	
	public static boolean checkHit(Point p, ElementBase e)
	{
		if(e.getLeft() <= p.x && e.getRight()>= p.x && e.getTop() >= p.y && e.getBottom() <= p.y)
			return true;
		return false;
	}
	
	static TextureRegion image;
	public static TextureRegion getImageFromAssets(String imageConstant)
	{

		image = textureCache.get(imageConstant);
		if(image == null){
//			Helper.println("Image is not loaded, loading from file: " + imageConstant);
			try {
//				Helper.println("Image loaded successfully, loading from file: " + imageConstant);
				image = new TextureRegion(GlobalVars.ge.getAssetHandler().getTexture(
						imageConstant));
			} catch (Exception e) {
//				Helper.println("Image can not be loaded, loading from file: " + imageConstant);
				return null;
			} 
			textureCache
				.put(imageConstant, image);
		}
//		else
//			Helper.println("Image already loaded, loading from file: " + imageConstant);
		return image;
	}
	public static void disposeTextures()
	{
		for(TextureRegion t:textureCache.values())
			t.getTexture().dispose();
		GlobalVars.ge.getAssetHandler().clearAssets();
	}

}
