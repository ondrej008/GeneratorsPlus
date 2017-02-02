package me.choco.generators.registry;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

import me.choco.generators.generators.fuel.GeneratorFuelSource;

public class FuelRegistry {
	
	private final Set<GeneratorFuelSource> registeredFuelSources = new HashSet<>();
	
	public boolean registerFuelSource(GeneratorFuelSource fuelSource) {
		if (registeredFuelSources.stream().anyMatch(f -> f.getMaterial() == fuelSource.getMaterial() && f.getData() == fuelSource.getData()))
			return false;
		return this.registeredFuelSources.add(fuelSource);
	}
	
	public boolean unregisterFuelSource(GeneratorFuelSource fuelSource) {
		return this.registeredFuelSources.remove(fuelSource);
	}
	
	public GeneratorFuelSource getFuelSource(Material material, byte data) {
		return this.registeredFuelSources.stream()
				.filter(f -> f.getMaterial() == material && f.getData() == data)
				.findFirst()
				.orElse(null);
	}
	
	public GeneratorFuelSource getFuelSource(Material material) {
		return this.getFuelSource(material, (byte) -1);
	}
	
	@SuppressWarnings("deprecation")
	public GeneratorFuelSource getFuelSource(MaterialData materialData) {
		return this.getFuelSource(materialData.getItemType(), materialData.getData());
	}
	
	public GeneratorFuelSource getFuelSource(ItemStack item) {
		return this.getFuelSource(item.getData());
	}
	
	@SuppressWarnings("deprecation")
	public boolean isFuelSource(ItemStack item) {
		Material material = item.getType();
		byte data = item.getData().getData();
		
		return this.registeredFuelSources.stream()
				.filter(f -> f.getMaterial() == material)
				.filter(f -> f.getData() == data || f.getData() == -1)
				.findAny().isPresent();
	}
	
	public Set<GeneratorFuelSource> getRegisteredFuelSources() {
		return ImmutableSet.copyOf(registeredFuelSources);
	}
	
	public void clearFuelSources() {
		this.registeredFuelSources.clear();
	}
}