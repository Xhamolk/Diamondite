package xk.diamondite.block

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.texture.IconRegister
import xk.diamondite.lib.Ores
import net.minecraft.util.Icon
import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.minecraft.world.IBlockAccess


class BlockOre(blockID: Int) extends Block(blockID, Material.rock) {

  val subCount = Ores.values().length
  val textures: Array[Icon] = new Array[Icon](subCount)

  override def registerIcons(registry: IconRegister) {
    for(i <- 0 to subCount )
      textures(i) = registry.registerIcon( Ores.get(i).getTextureFile )
  }

  @SideOnly(Side.CLIENT)
  override def getBlockTexture(access: IBlockAccess, x: Int, y: Int, z: Int, side: Int): Icon = {
    val meta = access.getBlockMetadata(x, y, z)
    textures(meta)
  }

  def registerHarvestLevel() {

  }

}
