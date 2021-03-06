package com.rhymes.game.entity.elements.menu;

import com.rhymes.game.data.AssetConstants;
import com.rhymes.game.entity.elements.ui.Button;
import com.rhymes.game.stage.menus.ChoosePlayerandBall;
import com.rhymes.game.stage.menus.OptionMenu;
import com.rhymes.ge.core.data.GlobalVars;
import com.rhymes.ge.core.renderer.Point;
import com.rhymes.helpers.Helper;

public class ButtonSelectPlayer extends Button{
	boolean isTouched = false;
	private int bcp;
	@Override
	public void render() {
		if(isTouched){
			GlobalVars.ge.getScreen().getBatch().setColor(0, 1, 0, 1f);
//			Helper.println("asse");
		}
		super.render();
		GlobalVars.ge.getScreen().getBatch().setColor(1, 1, 1, 1f);
	}

	public ButtonSelectPlayer(float x, float y, float width, float height,
			int zIndex, String imagePath) {
		super(x, y, width, height, zIndex, imagePath);
	}
	
	public ButtonSelectPlayer(float x, float y, float width, float height,
			int zIndex, String imagePath,int bcp) {
		super(x, y, width, height, zIndex, imagePath);
		
		this.bcp = bcp;
	}
	
	
	public int getBcp() {
		return bcp;
	}

	public void setBcp(int bcp) {
		this.bcp = bcp;
	}

	@Override
	public void onTouch(Point p) {
//		Helper.println("Checking hitpoint...");
		if(this.checkHit(p)){
			isTouched = true;
			Helper.println("set image set for ball and player...");
			((ChoosePlayerandBall)GlobalVars.ge.getCurrentStage()).selectPlayer(this);
//			this.setImage(Helper.getImageFromAssets(AssetConstants.IMG_OPTIONS_PRESSED));
//			GlobalVars.ge.loadStage(new ChoosePlayerandBall());			
		}
	}

	public ButtonSelectPlayer(float x, float y, float width, float height, int zIndex) {
		super(x, y, width, height, zIndex);
	}
	
	public void clearSelection()
	{
		isTouched = false;
	}
}
