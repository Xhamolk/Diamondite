package xk.diamondite.block.item

import net.minecraft.item.{ItemStack, ItemBlock}
import xk.diamondite.lib.Ores

class ItemBlockOre(blockID: Int) extends ItemBlock(blockID) {

  override def getMetadata(meta: Int): Int = meta

  override def getUnlocalizedName(itemStack: ItemStack)= Ores.get(itemStack.getItemDamage).getUnLocalizedName

}
