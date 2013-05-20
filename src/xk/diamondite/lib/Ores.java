package xk.diamondite.lib;

import net.minecraft.item.ItemStack;
import xk.diamondite.DiamonditeMod;

public enum Ores {
	DIAMONDITE("ore.diamondite", "Diamondite Ore", "oreDiamondite");

	private final String unLocalizedName;
	private final String localizedName;
	private final String textureFile;

	private Ores(String unLocalizedName, String localizedName, String textureFile) {
		this.unLocalizedName = unLocalizedName;
		this.localizedName = localizedName;
		this.textureFile = textureFile;
	}

	public String getTextureFile() {
		return Reference.TEXTURE_PREFIX() + textureFile;
	}

	public String getUnLocalizedName() {
		return unLocalizedName;
	}

	public String getLocalizedName(String lang) {
		return localizedName; // temp
	}

	public ItemStack toItemStack() {
		return new ItemStack( DiamonditeMod.blockOre().blockID, 1, this.ordinal() );
	}

	public static Ores get(int index) {
		return Ores.values()[index];
	}

}
