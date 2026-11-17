package com.seabottles;

import javax.inject.Inject;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Sea Bottles",
	description = "Shows the effects and risks of Sailing crate drinks",
	tags = {
		"sail", "sailing", "chart", "charting", "sea", "bottle", "sealed", "crate",
		"drink", "potion", "cargo", "safety", "effects", "tooltip", "hover"
	}
)
public class SeaBottlesPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private SeaBottlesOverlay overlay;

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(overlay);
	}
}
