package xk.diamondite

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.network.NetworkMod
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLPreInitializationEvent, FMLInitializationEvent}
import net.minecraft.block.{Block, BlockOre}
import net.minecraftforge.common.Configuration
import cpw.mods.fml.common.registry.{LanguageRegistry, GameRegistry}
import xk.diamondite.block.item.ItemBlockOre
import xk.diamondite.core.CreativeTabDiamondite
import xk.diamondite.lib.{Ores, Reference}


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = "0.1", modLanguage = "scala")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
object DiamonditeMod {

  var blockOre: Block = null

  private var blockOreID = 0

  @Mod.PreInit
  def preInit(event: FMLPreInitializationEvent) {
    // Load configurations
    val config = new Configuration(event.getSuggestedConfigurationFile)
    config.load()
    blockOreID = config.getBlock("oreId", 1000).getInt
    config.save()

    // Initialize Items - no items atm!

    /*-- Blocks --*/

    // Initialize
    blockOre = new BlockOre(blockOreID).setCreativeTab(CreativeTabDiamondite).setHardness(3.0f)

    // Register
    GameRegistry.registerBlock(blockOre, classOf[ItemBlockOre], "blockOre")

    // Add Localization
    for (ore <- Ores.values())
      LanguageRegistry.addName(ore.toItemStack, ore.getLocalizedName("en_US"))
  }

  @Mod.Init
  def init(e: FMLInitializationEvent) {
    // world gen?
  }

  @Mod.PostInit
  def postInit(e: FMLPostInitializationEvent) {
    // register handlers.
  }

}
