package com.rhymes.game.entity.elements.solitaire.menu.panel.optionpanel;

import com.rhymes.ge.core.data.GlobalVars;
import com.rhymes.ge.core.entity.elements.ElementBase;
import com.rhymes.ge.pw.assets.AssetPack;
import com.rhymes.helpers.Helper;

public class OptionsPanel extends ElementBase{

	
	String imagePath;
//	private boolean touched;

	public OptionsPanel(float x, float y, float width, float height,
			int zIndex, String imagePath){
		super(x, y, width, height, zIndex);

		this.imagePath = imagePath; 
	}
	
	
	@Override
	public void getAssets(AssetPack assetPack) {
		assetPack.addTexture(imagePath);
	}

	@Override
	public void init() {
		this.image = Helper.getImageFromAssets(imagePath);
	}

	@Override
	public void render() {
			
		GlobalVars.ge.getRenderer().render(image, x, y, width, height);
	}
	
}
