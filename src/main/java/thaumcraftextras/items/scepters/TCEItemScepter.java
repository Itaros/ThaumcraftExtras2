package thaumcraftextras.items.scepters;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import thaumcraftextras.main.init.TCETabs;
import wasliecore.helpers.ColorHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TCEItemScepter extends Item{

	public TCEItemScepter(int maxEnergy, int crystalColor, String name) {
		super();
		setMaxStackSize(1);

		maxMCE = maxEnergy;
		color = crystalColor;
		itemName = name;
		
		setMaxDamage(maxEnergy);
		setCreativeTab(TCETabs.tabMain);

		setUnlocalizedName("thaumcraftextras" + "." + "scepter" + "." + name);

		GameRegistry.registerItem(this, this.getUnlocalizedName());
	}
	int maxMCE;
	int color;
	IIcon primary;
	IIcon secondary;
	String itemName;
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamageForRenderPass(int meta, int renderPass) {
		if(renderPass > 0) {
			return this.secondary;
		}
		return this.primary;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	@Override
	public int getRenderPasses(int meta) {
		return 2;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int pass)
	{		
		if(pass > 0) 
		{
			return ColorHelper.getColorCodeFromRGB(255, 255, 255);
		}
			return color;
	}
	
	@Override
    public void registerIcons(IIconRegister ir) 
	{
		this.primary = ir.registerIcon("thaumcraftextras:scepter_0");
		this.secondary = ir.registerIcon("thaumcraftextras:scepter_1");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean id)
	{		
		list.add(EnumChatFormatting.RED + "Creative Tool");
	}
	
	public String getLower(String s)
	{
		return s.toLowerCase();
	}
}