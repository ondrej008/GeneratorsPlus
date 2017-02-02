package me.choco.generators;

import org.bukkit.plugin.java.JavaPlugin;

import me.choco.generators.generators.fuel.GeneratorFuelSource;
import me.choco.generators.registry.FuelRegistry;

public class GeneratorsPlus extends JavaPlugin {
	
	private FuelRegistry fuelRegistry;
	
	@Override
	public void onEnable() {
		this.fuelRegistry = new FuelRegistry();
		
		// Register basic fuel sources
		this.fuelRegistry.registerFuelSource(GeneratorFuelSource.COAL);
	}
	
	@Override
	public void onDisable() {
		this.fuelRegistry.clearFuelSources();
	}
	
	public FuelRegistry getFuelRegistry() {
		return fuelRegistry;
	}
}