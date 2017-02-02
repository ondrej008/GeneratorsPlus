package me.choco.generators.generators;

import java.util.UUID;

import com.google.gson.JsonElement;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;

/**
 * Represents a generator in a world. Permits the passive generation of 
 * various products
 * 
 * @author Parker Hawke - 2008Choco
 */
public abstract class Generator {
	
	private final UUID uniqueId;
	
	private Block generatorBlock;
	private BlockFace dropDirection;
	
	private int tier;
	private int generationProgress = 0;
	
	/**
	 * Construct a new Generator instance
	 * 
	 * @param generatorBlock - The block position of the generator
	 * @param dropDirection - The direction in which products are dropped. 
	 * {@link BlockFace#SELF} for self-contained or null for all directions
	 */
	public Generator(Block generatorBlock, BlockFace dropDirection) {
		this.uniqueId = UUID.randomUUID();
		this.generatorBlock = generatorBlock;
		this.dropDirection = dropDirection;
	}
	
	/**
	 * Get the unique identification associated with this block
	 * 
	 * @return the unique id
	 */
	public final UUID getUniqueId() {
		return uniqueId;
	}
	
	/**
	 * Get the Bukkit block representing this generator object
	 * 
	 * @return the representing block
	 */
	public final Block getGeneratorBlock() {
		return generatorBlock;
	}
	
	/**
	 * Get the direction in which products will be dropped
	 * 
	 * @return the drop direction. {@link BlockFace#SELF} for self-contained 
	 * or null for all directions
	 */
	public final BlockFace getDropDirection() {
		return dropDirection;
	}
	
	/**
	 * Set the tier of this generator
	 * 
	 * @param tier - The tier to set
	 */
	public final void setTier(int tier) {
		this.tier = tier;
	}
	
	/**
	 * Get the tier of this generator
	 * 
	 * @return the generators tier
	 */
	public final int getTier() {
		return tier;
	}
	
	/**
	 * Set the current generator progress
	 * 
	 * @param generationProgress - The new progress
	 */
	public final void setGenerationProgress(int generationProgress) {
		this.generationProgress = generationProgress;
	}
	
	/**
	 * Get the current generator progress
	 * 
	 * @return the generation progress
	 */
	public final int getGenerationProgress() {
		return generationProgress;
	}
	
	/**
	 * Get the time required to generate a product
	 * 
	 * @return the required product generation time
	 */
	public abstract int getGenerateTime();
	
	/**
	 * Get the radius in which generator products can be dropped
	 * 
	 * @return product drop radius
	 */
	public abstract double getDropRadius();
	
	/**
	 * Get all possible products that can be generated from 
	 * this generator
	 * 
	 * @return all generator products
	 */
	public abstract ItemStack[] getPossibleProducts();
	
	/**
	 * Serialize any extra data stored in generation implementations
	 * 
	 * @return the resulting json data
	 */
	public abstract JsonElement serializeExtraData(JsonElement existingData);
	
	/**
	 * Deserialize any extra data stored in generation implementations
	 * 
	 * @param data - The data to deserialize
	 */
	public abstract void deserializeExtraData(JsonElement data);
	
}