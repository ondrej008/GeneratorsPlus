package me.choco.generators.generators.fuel;

/**
 * Represents a generator that can be fueled by a {@link GeneratorFuelSource}
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface IFuelable {
	
	/**
	 * Get the types of fuels that may fuel this generator
	 * 
	 * @return generator fuel types
	 */
	public GeneratorFuelSource[] getFuelSources();
	
}