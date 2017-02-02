package me.choco.generators.generators;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

/**
 * Represents a generator that requires power in order to function
 * and produce its products
 * 
 * @author Parker Hawke - 2008Choco
 */
public abstract class PoweredGenerator extends Generator {
	
	private float powerBuffer;
	
	/**
	 * Construct a new PoweredGenerator instance
	 * 
	 * @param generatorBlock - The block position of the generator
	 * @param dropDirection - The direction in which products are dropped. 
	 * {@link BlockFace#SELF} for self-contained or null for all directions
	 */
	public PoweredGenerator(Block generatorBlock, BlockFace dropDirection) {
		super(generatorBlock, dropDirection);
	}
	
	/**
	 * Add power to the generator's buffer
	 * 
	 * @param power - The power to add
	 * @return the remaining power that was not added due to buffer 
	 * limit (if any)
	 */
	public float addPower(float power) {
		float newPower = powerBuffer + power;
		this.powerBuffer = Math.min(newPower, powerBuffer);
		
		return Math.max(newPower - powerBuffer, 0);
	}
	
	/**
	 * Subtract power from the generator's buffer
	 * 
	 * @param power - The power to subtract
	 * @return the remaining power that was not subtracted due to 
	 * being less than 0 (if any)
	 */
	public float removePower(float power) {
		float newPower = powerBuffer - power;
		this.powerBuffer = Math.max(newPower, 0);
		
		return Math.abs(Math.min(newPower, 0));
	}
	
	/**
	 * Get the power currently stored within the generators buffer
	 * 
	 * @return power in the buffer
	 */
	public float getPowerBuffer() {
		return powerBuffer;
	}
	
	/**
	 * Get the limit to the power buffer that this generator can store
	 * 
	 * @return the power buffer limit
	 */
	public abstract float getPowerBufferLimit();
	
	/**
	 * Get the amount of power required to generate a product
	 * 
	 * @return the amount of required power
	 */
	public abstract float getRequiredPower();
	
}