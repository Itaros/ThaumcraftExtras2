package thaumcraftextras.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import thaumcraft.api.IGoggles;
import thaumcraft.api.IRepairable;
import thaumcraft.api.IVisDiscountGear;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.nodes.IRevealer;
import thaumcraftextras.main.ThaumcraftExtras;
import thaumcraftextras.main.init.TCETabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEnergyHelmet extends ItemArmor implements IVisDiscountGear, IRepairable, IGoggles, IRevealer
{
	public ItemEnergyHelmet(String itemName, String textureName, ArmorMaterial material, int i, int j, int maxDamage, int visDiscount)
	{
		super(material, i, j);
		setCreativeTab(TCETabs.tabMain);
		setUnlocalizedName(ThaumcraftExtras.modName.toLowerCase() + "." + "armor" + "." + itemName.toLowerCase());
		name = itemName;
		texture = textureName;
		discount = visDiscount;
		setMaxDamage(maxDamage);
	}
	String name;
	String texture;
	int discount;
	
	@Override
	public void registerIcons(IIconRegister ir) {
		itemIcon = ir.registerIcon(ThaumcraftExtras.modName.toLowerCase() + ":" + texture); 
	}

	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return ThaumcraftExtras.modName.toLowerCase() + ":" + "textures/models/armor_model_helmet_energy.png";
	}
	
	@Override
	public int getVisDiscount(ItemStack stack, EntityPlayer player, Aspect asp) {
		return 5;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "rawtypes", "unchecked" })
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) 
	{
		list.add(EnumChatFormatting.DARK_PURPLE + "" + discount + "% discount");
	}

	@Override
	public boolean showIngamePopups(ItemStack stack, EntityLivingBase living) {
		return true;
	}

	@Override
	public boolean showNodes(ItemStack stack, EntityLivingBase living) {
		return true;
	}
}