package minestrapp.block.item;

import minestrapp.block.BlockColdSand;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMultistate extends ItemBlock
{

	public ItemBlockMultistate(Block block)
	{
		super(block);
		if(!(block instanceof IMetaBlockName))
		{
			throw new IllegalArgumentException(String.format("The given Block %s is not an instance of IMetaBlockName!", block.getUnlocalizedName()));
		}
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return super.getUnlocalizedName() + "_" + ((IMetaBlockName) this.block).getSpecialName(stack);
	}
	
	public int getMetadata(int damage)
	{
		return damage;
	}
}
