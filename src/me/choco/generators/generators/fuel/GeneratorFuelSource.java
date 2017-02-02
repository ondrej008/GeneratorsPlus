package me.choco.generators.generators.fuel;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

/**
 * Represents a material that can be used as a fuel source for generators
 * implementing the {@link IFuelable} interface
 * 
 * @author Parker Hawke - 2008Choco
 */
public class GeneratorFuelSource {
	
	/**
	 * <b>Items:</b> Coal, Charcoal
	 * <br><b>Burn Time:</b> 1,600 ticks - 80 seconds
	 * <br><b>Unit Power:</b> 12,000J (12kJ)
	 */
	public static final GeneratorFuelSource COAL = new GeneratorFuelSource(Material.COAL, 1_600, 12_000);
	
	private final Material material;
	private final byte data;
	private final int burnTime;
	private final float generates;
	
	/**
	 * Construct a new GeneratorFuelSource object
	 * 
	 * @param material - The material to represent this fuel source
	 * @param data - The data to represent this fuel source
	 * @param burnTime - The amount of time in ticks this fuel source can burn for
	 * @param generates - The final power that a single unit of this fuel source
	 */
	public GeneratorFuelSource(Material material, byte data, int burnTime, float generates) {
		this.material = material;
		this.data = data;
		this.burnTime = burnTime;
		this.generates = generates;
	}
	
	/**
	 * Construct a new GeneratorFuelSource object
	 * 
	 * @param material - The material to represent this fuel source
	 * @param burnTime - The amount of time in ticks this fuel source can burn for
	 * @param generates - The final power that a single unit of this fuel source
	 */
	public GeneratorFuelSource(Material material, int burnTime, float generates) {
		this.material = material;
		this.data = -1;
		this.burnTime = burnTime;
		this.generates = generates;
	}
	
	/**
	 * Construct a new GeneratorFuelSource object
	 * 
	 * @param materialData - The material data to represent this fuel source
	 * @param burnTime - The amount of time in ticks this fuel source can burn for
	 * @param generates - The final power that a single unit of this fuel source
	 */
	@SuppressWarnings("deprecation")
	public GeneratorFuelSource(MaterialData materialData, int burnTime, float generates) {
		this(materialData.getItemType(), materialData.getData(), burnTime, generates);
	}
	
	/**
	 * Get the material representing this fuel source
	 * 
	 * @return the associated material
	 */
	public Material getMaterial() {
		return material;
	}
	
	/**
	 * Get the material byte data representing this fuel source
	 * 
	 * @return the associated byte data, or -1 if all variants
	 */
	public byte getData() {
		return data;
	}
	
	/**
	 * Get the amount of time in ticks this fuel source can burn for
	 * 
	 * @return burn time of this fuel
	 */
	public int getBurnTime() {
		return burnTime;
	}
	
	/**
	 * Get the final power that a single unit of this fuel source can
	 * generate after the overall burn time
	 * 
	 * @return single-unit power generation
	 */
	public float getGenerates() {
		return generates;
	}
	
	/**
	 * Check whether an ItemStack object matches the requirements to be
	 * this generator fuel source
	 * 
	 * @param item - The item to check
	 * @return true if the item matches
	 */
	@SuppressWarnings("deprecation")
	public boolean isSimilarFuelSource(ItemStack item) {
		return item.getType() == material && (item.getData().getData() == data || data == -1);
	}
}