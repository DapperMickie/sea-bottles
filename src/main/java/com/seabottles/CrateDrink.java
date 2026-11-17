package com.seabottles;

import java.util.HashMap;
import java.util.Map;
import net.runelite.api.gameval.ItemID;

import static com.seabottles.CrateStatus.*;

enum CrateDrink
{
	// Safety and effect facts from the OSRS Wiki, Sealed crate, revision 15397474.
	PRYING_TIMES(ItemID.SAILING_CHARTING_DRINK_CRATE_PRYING_TIMES, "Bottle of fish bladder stout", NO, YES, NO, "Drains Attack, Strength, Ranged and Magic by 2. Spawns a hostile level 14 drink troll."),
	SORODAMIN_BRU(ItemID.SAILING_CHARTING_DRINK_CRATE_SORODAMIN_BRU, "Bottle of sOrodamin's bru", NO, YES, NO, "Deals 5 damage. Drains Defence by 2 plus 20%, and Attack, Strength, Ranged and Magic by 2 plus 10% of current levels."),
	SMUGGLED_RUM(ItemID.SAILING_CHARTING_DRINK_CRATE_SMUGGLED_RUM, "Bottle of almost smuggled rum", YES, YES, NO, "Raises Strength and lowers Attack by about 1–5 levels each."),
	MARROW_WINE(ItemID.SAILING_CHARTING_DRINK_CRATE_MARROW_WINE, "Bottle of Potterington's marrow wine", YES, YES, NO, "Boosts Farming by 5 and drains Agility by about 26%."),
	BANKERS_DRAUGHT(ItemID.SAILING_CHARTING_DRINK_CRATE_BANKERS_DRAUGHT, "Bottle of banker's draught", MAYBE, YES, NO, "Banks carried and equipped items. Ultimate Ironmen instead take damage equal to 10% of max HP."),
	SLUG_BALM(ItemID.SAILING_CHARTING_DRINK_CRATE_SLUG_BALM, "Bottle of slug's mind balm", YES, NO, NO, "Teleports you to Witchaven and docks your ship there or at Port Sarim, depending on Sailing level. Destroys courier cargo and drains current Strength and Magic by 20%."),
	OGRE_PRAYER(ItemID.SAILING_CHARTING_DRINK_CRATE_OGRE_PRAYER, "Bottle of ogre prayer potion", NO, YES, NO, "Restores Prayer like a prayer potion and deals 50% of max HP as damage."),
	MYTHS_MIXER(ItemID.SAILING_CHARTING_DRINK_CRATE_MYTHS_MIXER, "Bottle of myths mighty mixer", NO, YES, NO, "Deals 25% of max HP as damage."),
	POSSIBLE_ALBUMEN(ItemID.SAILING_CHARTING_DRINK_CRATE_POSSIBLE_ALBUMEN, "Bottle of possible albumen", NO, YES, NO, "Spawns a hostile level 81 angry tortugan."),
	CREATORS_COCKTAIL(ItemID.SAILING_CHARTING_DRINK_CRATE_CREATORS_COCKTAIL, "Bottle of creator's cocktail", NO, YES, NO, "Deals one third of max HP as damage, rounded down. A blue soul cape prevents it."),
	DOGNOSE_DRAUGHT(ItemID.SAILING_CHARTING_DRINK_CRATE_DOGNOSE_DRAUGHT, "Bottle of Dognose draught", YES, YES, NO, "Raises Cooking by up to 3 levels and lowers Farming by the same amount."),
	HEADLESS_UNICORNMAN(ItemID.SAILING_CHARTING_DRINK_CRATE_HEADLESS_UNICORNMAN, "Bottle of headless unicornman's heady beer", YES, YES, NO, "Fills free inventory slots with ensouled chaos druid, dog, elf, giant or hellhound heads."),
	LIFE_WATER(ItemID.SAILING_CHARTING_DRINK_CRATE_LIFE_WATER, "Bottle of Elidinis's life water", YES, YES, NO, "Fully heals you, restores 50% of Prayer, cures disease and gives 6 minutes of poison protection."),
	MANGO_GIN(ItemID.SAILING_CHARTING_DRINK_CRATE_MANGO_GIN, "Bottle of Captain Clop's mango gin", YES, YES, NO, "Makes you move in random directions five times."),
	ROBERTS_PORT(ItemID.SAILING_CHARTING_DRINK_CRATE_ROBERTS_PORT, "Bottle of Robert's Port", NO, YES, NO, "Deals 10% of max HP five times. Each hit consumes cooked fish instead if available. One kebab prevents all five hits."),
	KHARAZI_COOLER(ItemID.SAILING_CHARTING_DRINK_CRATE_KHARAZI_COOLER, "Bottle of Kharazi cooler", YES, YES, NO, "Sets run energy to zero."),
	POINT_PUNCH(ItemID.SAILING_CHARTING_DRINK_CRATE_POINT_PUNCH, "Bottle of get to the point punch", NO, YES, NO, "Five coughs each deal 1 damage and give five matching arrowtips."),
	BLUE_LAGOON(ItemID.SAILING_CHARTING_DRINK_CRATE_BLUE_LAGOON, "Bottle of Waterbirth blue lagoon", NO, YES, NO, "Spawns a hostile level 100 blue dagannoth."),
	OOGLUG(ItemID.SAILING_CHARTING_DRINK_CRATE_OOGLUG, "Bottle of Oo'glug", YES, YES, NO, "Applies the stamina effect."),
	MONKFISH_STOUT(ItemID.SAILING_CHARTING_DRINK_CRATE_MONKFISH_STOUT, "Bottle of monkfish bladder stout", YES, NO, NO, "Spawns a hostile level 217 drink troll queen. The ship can capsize if attacked."),
	FISHTONGUE_TONIC(ItemID.SAILING_CHARTING_DRINK_CRATE_FISHTONGUE_TONIC, "Bottle of fishtongue tonic", YES, YES, NO, "Makes you speak in bubbles and temporarily prevents crewmate commands."),
	BANANA_DAIQUIRI(ItemID.SAILING_CHARTING_DRINK_CRATE_BANANA_DAIQUIRI, "Bottle of banana daiquiri", YES, YES, NO, "Turns you into a banana."),
	LUNARSHINE(ItemID.SAILING_CHARTING_DRINK_CRATE_LUNARSHINE, "Bottle of lunarshine", YES, YES, NO, "Changes your hairstyle to an afro."),
	SEA_SPRAY(ItemID.SAILING_CHARTING_DRINK_CRATE_SEA_SPRAY, "Bottle of sea spray", YES, YES, NO, "Rocks the camera for 20 seconds."),
	WAY_HOME(ItemID.SAILING_CHARTING_DRINK_CRATE_WAY_HOME, "Bottle of the way home", YES, NO, NO, "Teleports you outside your player-owned house and docks the ship at Port Sarim. Destroys courier cargo."),
	WILD_WHISKY(ItemID.SAILING_CHARTING_DRINK_CRATE_WILD_WHISKY, "Bottle of wild wood whisky", YES, YES, YES, "Summons a squirrel, chinchompa and racoon you cannot interact with."),
	ALCO_SOL(ItemID.SAILING_CHARTING_DRINK_CRATE_ALCO_SOL, "Bottle of alco-sol", NO, MAYBE, NO, "Obscures the screen for several seconds. It fades to black if colourful fade effects are disabled. The ship can drift into danger."),
	ALONE_AT_SEA(ItemID.SAILING_CHARTING_DRINK_CRATE_ALONE_AT_SEA, "Bottle of alone at sea", NO, MAYBE, NO, "Plays a 75-second unskippable cutscene. Your ship can drift into hazardous waters during it."),
	BARRACUDA_BREW(ItemID.SAILING_CHARTING_DRINK_CRATE_BARRACUDA_BREW, "Bottle of Barracuda brew", NO, YES, NO, "Knocks you back and briefly stuns you. On a raft, it can knock you overboard and deal repeated, potentially fatal damage."),
	BLACK_LOBSTER(ItemID.SAILING_CHARTING_DRINK_CRATE_BLACK_LOBSTER, "Bottle of black lobster ale", YES, YES, YES, "Sets Fishing and Cooking to 0 and gives a rare black lobster."),
	SAILING_CAT(ItemID.SAILING_CHARTING_DRINK_CRATE_SAILING_CAT, "Bottle of Captain Cat's black rum", YES, YES, YES, "Summons a Sailing cat aboard your ship."),
	CROCODILE_TEARS(ItemID.SAILING_CHARTING_DRINK_CRATE_CROCODILE_TEARS, "Bottle of crocodile tears", NO, YES, NO, "Dehydrates you and deals damage unless you have a waterskin."),
	CRYSTAL_VODKA(ItemID.SAILING_CHARTING_DRINK_CRATE_CRYSTAL_VODKA, "Bottle of crystal clear vodka", NO, YES, NO, "Plays a loud ringing sound and deals about 20% of max HP as damage."),
	CRYSTAL_WATER(ItemID.SAILING_CHARTING_DRINK_CRATE_CRYSTAL_WATER, "Bottle of crystal clear water", YES, YES, NO, "Prevents poison for 6 minutes."),
	ELVEN_WINE(ItemID.SAILING_CHARTING_DRINK_CRATE_ELVEN_WINE, "Bottle of delicate elven wine", YES, NO, NO, "Teleports you east of Tyras Camp and docks your ship at Port Tyras. Courier cargo is lost."),
	DESTRUCTORS_COCKTAIL(ItemID.SAILING_CHARTING_DRINK_CRATE_DESTRUCTORS_COCKTAIL, "Bottle of destructor's cocktail", NO, YES, NO, "Deals 33% of max HP as damage, rounded down. A red soul cape prevents it."),
	DWARVERN_WIZARD(ItemID.SAILING_CHARTING_DRINK_CRATE_DWARVERN_WIZARD, "Bottle of dwarvern wizard's stout bomb", YES, YES, NO, "Boosts Magic by 4 and Mining and Smithing by 2. Sets Attack, Strength and Defence to 0."),
	EXILES_WELCOME(ItemID.SAILING_CHARTING_DRINK_CRATE_EXILES_WELCOME, "Bottle of exile's welcome", YES, NO, NO, "Sends you to a random Lunar teleport. Docks the ship at Lunar Isle with 76 Sailing and Lunar Diplomacy, otherwise Port Sarim. Courier cargo is lost."),
	FISH_STOUTIER(ItemID.SAILING_CHARTING_DRINK_CRATE_FISH_STOUTIER, "Bottle of fish bladder stoutier", NO, YES, NO, "Spawns Dinky the drink troll, which can hit hard."),
	FISHIER_STOUT(ItemID.SAILING_CHARTING_DRINK_CRATE_FISHIER_STOUT, "Bottle of fishier bladderier stout", NO, NO, YES, "Teleports you to fight three drink trolls. Docks your ship at Rellekka with 62 Sailing, otherwise Port Sarim. Courier cargo is lost. Each troll brew awards XP once."),
	GOLDLESS_ALE(ItemID.SAILING_CHARTING_DRINK_CRATE_GOLDLESS_ALE, "Bottle of goldless asgoldian ale", YES, YES, NO, "Takes 100 coins from your inventory."),
	CORPSE_REVIVER(ItemID.SAILING_CHARTING_DRINK_CRATE_CORPSE_REVIVER, "Bottle of graveyard corpse reviver", NO, YES, NO, "Spawns a level 103 corpse that can revive nine times."),
	DRUNK_IMPLING(ItemID.SAILING_CHARTING_DRINK_CRATE_DRUNK_IMPLING, "Bottle of impling surprise", YES, YES, NO, "Gives a random impling jar."),
	KGP_MARTINI(ItemID.SAILING_CHARTING_DRINK_CRATE_KGP_MARTINI, "Bottle of KGP standard issue martini", YES, NO, NO, "Teleports you to the Rellekka Hunter area and docks your ship at Rellekka. Courier cargo is lost."),
	LIGHT_DARK(ItemID.SAILING_CHARTING_DRINK_CRATE_LIGHT_DARK, "Bottle of light in the dark", NO, YES, NO, "Deals 5 damage and briefly shakes the screen."),
	MYSTERY_CIDER(ItemID.SAILING_CHARTING_DRINK_CRATE_MYSTERY_CIDER, "Bottle of mystery fruit cider", YES, YES, NO, "Shows a chat message about learning the nature of the mystery fruit."),
	REDDEST_RUM(ItemID.SAILING_CHARTING_DRINK_CRATE_REDDEST_RUM, "Bottle of ol' random's reddest rum", YES, YES, NO, "Disguises you as coins, a bush, a snowman, rocks or Third Age gear."),
	PLATINUM_RUM(ItemID.SAILING_CHARTING_DRINK_CRATE_PLATINUM_RUM, "Bottle of platinum rum", YES, YES, NO, "Seven drunken dwarves hand out seven beers and kebabs in total."),
	PORTAL_PERRY(ItemID.SAILING_CHARTING_DRINK_CRATE_PORTAL_PERRY, "Bottle of portal nexus perry", YES, NO, NO, "Teleports you near the Dark Mage in the Abyss and docks your ship at Port Sarim. Courier cargo is lost."),
	PUZZLERS_POTEEN(ItemID.SAILING_CHARTING_DRINK_CRATE_PUZZLERS_POTEEN, "Bottle of puzzlers poteen", YES, YES, YES, "Summons the Quiz Master. Answer five questions correctly to get five mystery boxes. Repeat attempts give no additional rewards."),
	SEA_SHANDY(ItemID.SAILING_CHARTING_DRINK_CRATE_SEA_SHANDY, "Bottle of Sea Shandy 2", YES, NO, NO, "Teleports you and your ship to the Port Sarim dock. Courier cargo is lost."),
	CONGRATULATION_WINE(ItemID.SAILING_CHARTING_DRINK_CRATE_CONGRATULATION_WINE, "Bottle of self-congratulation wine", YES, YES, NO, "Plays the level-99 fireworks animation."),
	SNAKE_GRAVY(ItemID.SAILING_CHARTING_DRINK_CRATE_SNAKE_GRAVY, "Bottle of slippery snake skins in possibly gravy", NO, YES, NO, "Spawns a hostile level 90 snakeling with 1 HP that can instantly envenom you."),
	SOUL_BOTTLE(ItemID.SAILING_CHARTING_DRINK_CRATE_SOUL_BOTTLE, "Bottle of soul", NO, YES, NO, "The first of Soul and Soul Juice starts a chat with Death. The second deals 90% of max HP and can kill you."),
	SOUL_JUICE(ItemID.SAILING_CHARTING_DRINK_CRATE_SOUL_JUICE, "Bottle of soul juice", NO, YES, NO, "The first of Soul and Soul Juice starts a chat with Death. The second deals 90% of max HP and can kill you."),
	SPINNERS_GASP(ItemID.SAILING_CHARTING_DRINK_CRATE_SPINNERS_GASP, "Bottle of spinner's last gasp", NO, YES, NO, "Poisons you for 4 minutes."),
	COMP_KVASS(ItemID.SAILING_CHARTING_DRINK_CRATE_COMP_KVASS, "Bottle of spinning comp-kvass", YES, YES, NO, "Gives a medium clue or medium scroll box, subject to the storage limit."),
	SUQAH_COLA(ItemID.SAILING_CHARTING_DRINK_CRATE_SUQAH_COLA, "Bottle of suqah-free cola", YES, YES, NO, "Fully heals you and boosts all skills by 1."),
	TOAD_CIDER(ItemID.SAILING_CHARTING_DRINK_CRATE_TOAD_CIDER, "Bottle of tangled toad's legs cider", YES, YES, NO, "Makes you croak and drops a swamp toad fifteen times. You can pick them up."),
	ENDLESS_NIGHT(ItemID.SAILING_CHARTING_DRINK_CRATE_ENDLESS_NIGHT, "Bottle of the endless night", YES, YES, NO, "Briefly fades the screen to black, tells a story and reduces Miscellania approval."),
	UNDERGROUND_MILK(ItemID.SAILING_CHARTING_DRINK_CRATE_UNDERGROUND_MILK, "Bottle of underground passteurised milk", NO, YES, NO, "Deals 66% of max HP as damage."),
	WEISS_MELTWATER(ItemID.SAILING_CHARTING_DRINK_CRATE_WEISS_MELTWATER, "Bottle of Weiss meltwater", NO, YES, NO, "Deals 33% of max HP as damage unless you wear at least four pieces of warm clothing."),
	WINTER_SUN(ItemID.SAILING_CHARTING_DRINK_CRATE_WINTER_SUN, "Bottle of winter sun", YES, NO, NO, "Teleports you to a dune west of Pollnivneach and docks your ship at Ruins of Unkah. Courier cargo is lost."),
	ZOGRES_KISS(ItemID.SAILING_CHARTING_DRINK_CRATE_ZOGRES_KISS, "Bottle of zogre's sloppy kisses", NO, YES, NO, "Inflicts poison and disease."),
	ZUL_RYE(ItemID.SAILING_CHARTING_DRINK_CRATE_ZUL_RYE, "Bottle of zul-rye beer", NO, YES, NO, "Inflicts venom.");

	private static final Map<Integer, CrateDrink> BY_ITEM = new HashMap<>();

	static
	{
		for (CrateDrink drink : values())
		{
			BY_ITEM.put(drink.itemId, drink);
		}
	}

	static CrateDrink forItem(int itemId)
	{
		return BY_ITEM.get(itemId);
	}

	final int itemId;
	final String name;
	final CrateStatus playerSafe;
	final CrateStatus cargoSafe;
	final CrateStatus repeatable;
	final String effects;

	CrateDrink(int itemId, String name, CrateStatus playerSafe,
		CrateStatus cargoSafe, CrateStatus repeatable, String effects)
	{
		this.itemId = itemId;
		this.name = name;
		this.playerSafe = playerSafe;
		this.cargoSafe = cargoSafe;
		this.repeatable = repeatable;
		this.effects = effects;
	}
}
