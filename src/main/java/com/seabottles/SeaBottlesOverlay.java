package com.seabottles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.EnumMap;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.SplitComponent;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;

class SeaBottlesOverlay extends Overlay
{
	private static final Color TITLE = new Color(0xFF9040);
	private static final Color LABEL = new Color(0xC8C8C8);
	private static final Color SAFE = new Color(0x5CDB5C);
	private static final Color UNSAFE = new Color(0xFF5050);
	private static final Color CONDITIONAL = new Color(0xFFC832);

	private final Client client;
	private final ItemManager itemManager;
	private final TooltipManager tooltipManager;
	private final Map<CrateDrink, Tooltip> tooltips = new EnumMap<>(CrateDrink.class);

	@Inject
	SeaBottlesOverlay(Client client, ItemManager itemManager, TooltipManager tooltipManager)
	{
		this.client = client;
		this.itemManager = itemManager;
		this.tooltipManager = tooltipManager;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (client.isMenuOpen())
		{
			return null;
		}

		MenuEntry[] entries = client.getMenu().getMenuEntries();
		if (entries.length == 0)
		{
			return null;
		}

		MenuEntry entry = entries[entries.length - 1];
		int component = entry.getParam1();
		if (component != InterfaceID.Inventory.ITEMS
			&& component != InterfaceID.Bankside.ITEMS
			&& component != InterfaceID.Bankmain.ITEMS
			&& component != InterfaceID.Bankmain.BANKTAGS_DISPLAY_ITEMS)
		{
			return null;
		}

		Widget widget = entry.getWidget();
		CrateDrink drink = CrateDrink.forItem(widget != null && widget.getItemId() > 0 ? widget.getItemId() : entry.getItemId());
		if (drink != null)
		{
			tooltipManager.add(tooltips.computeIfAbsent(drink, this::buildTooltip));
		}
		return null;
	}

	private Tooltip buildTooltip(CrateDrink drink)
	{
		PanelComponent panel = new PanelComponent();
		panel.setPreferredSize(new Dimension(218, 0));
		panel.setBorder(new Rectangle(7, 6, 7, 6));
		panel.setGap(new Point(0, 3));

		panel.getChildren().add(SplitComponent.builder()
			.first(new ImageComponent(itemManager.getImage(drink.itemId)))
			.second(LineComponent.builder().left(drink.name).leftColor(TITLE).build())
			.orientation(ComponentOrientation.HORIZONTAL)
			.gap(new Point(5, 0))
			.build());
		addRow(panel, "Player safe", drink.playerSafe.label, safetyColor(drink.playerSafe));
		addRow(panel, "Cargo safe", drink.cargoSafe.label, safetyColor(drink.cargoSafe));
		addRow(panel, "Repeatable", drink.repeatable.label, Color.WHITE);
		panel.getChildren().add(LineComponent.builder().left("Effects").leftColor(LABEL).build());
		panel.getChildren().add(LineComponent.builder().left(drink.effects).build());
		return new Tooltip(panel);
	}

	private static void addRow(PanelComponent panel, String label, String value, Color color)
	{
		panel.getChildren().add(LineComponent.builder()
			.left(label).leftColor(LABEL).right(value).rightColor(color).build());
	}

	private static Color safetyColor(CrateStatus status)
	{
		switch (status)
		{
			case YES:
				return SAFE;
			case NO:
				return UNSAFE;
			default:
				return CONDITIONAL;
		}
	}
}
