package xk.diamondite.core

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemStack
import xk.diamondite.lib.Ores

object CreativeTabDiamondite extends CreativeTabs("") {

  override def getIconItemStack: ItemStack = Ores.DIAMONDITE.toItemStack

}
