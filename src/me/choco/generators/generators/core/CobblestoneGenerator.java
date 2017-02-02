package me.choco.generators.generators.core;

import java.util.Arrays;

import com.google.gson.JsonElement;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;

import me.choco.generators.generators.Generator;

public class CobblestoneGenerator extends Generator {
	
	private static final ItemStack[] PRODUCTS = { new ItemStack(Material.COBBLESTONE) };
	
	public CobblestoneGenerator(Block generatorBlock) {
		super(generatorBlock, BlockFace.SELF);
	}

	@Override
	public int getGenerateTime() {
		return 0;
	}

	@Override
	public double getDropRadius() {
		return -1;
	}

	@Override
	public ItemStack[] getPossibleProducts() {
		return Arrays.copyOf(PRODUCTS, PRODUCTS.length);
	}

	@Override
	public JsonElement serializeExtraData(JsonElement existingData) { 
		return existingData;
	}

	@Override
	public void deserializeExtraData(JsonElement data) {}
	
}