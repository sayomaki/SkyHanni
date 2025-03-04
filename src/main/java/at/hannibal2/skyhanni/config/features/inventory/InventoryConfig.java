package at.hannibal2.skyhanni.config.features.inventory;

import at.hannibal2.skyhanni.config.FeatureToggle;
import at.hannibal2.skyhanni.config.HasLegacyId;
import at.hannibal2.skyhanni.config.features.inventory.chocolatefactory.ChocolateFactoryConfig;
import at.hannibal2.skyhanni.config.features.inventory.helper.HelperConfig;
import at.hannibal2.skyhanni.config.features.itemability.ItemAbilityConfig;
import at.hannibal2.skyhanni.config.features.misc.EstimatedItemValueConfig;
import at.hannibal2.skyhanni.config.features.misc.PocketSackInASackConfig;
import com.google.gson.annotations.Expose;
import io.github.notenoughupdates.moulconfig.annotations.Accordion;
import io.github.notenoughupdates.moulconfig.annotations.Category;
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorBoolean;
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorDraggableList;
import io.github.notenoughupdates.moulconfig.annotations.ConfigOption;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static at.hannibal2.skyhanni.config.features.inventory.InventoryConfig.ItemNumberEntry.LARVA_HOOK;
import static at.hannibal2.skyhanni.config.features.inventory.InventoryConfig.ItemNumberEntry.NEW_YEAR_CAKE;
import static at.hannibal2.skyhanni.config.features.inventory.InventoryConfig.ItemNumberEntry.RANCHERS_BOOTS_SPEED;
import static at.hannibal2.skyhanni.config.features.inventory.InventoryConfig.ItemNumberEntry.VACUUM_GARDEN;

public class InventoryConfig {

    @Expose
    @Category(name = "Skyblock Guide", desc = "Helps finding stuff to do in SkyBlock.")
    public SkyblockGuideConfig skyblockGuideConfig = new SkyblockGuideConfig();

    @Expose
    @Category(name = "Auction House", desc = "Be smart when buying or selling expensive items in the Auctions House.")
    public AuctionHouseConfig auctions = new AuctionHouseConfig();

    @Expose
    @Category(name = "Bazaar", desc = "Be smart when buying or selling many items in the Bazaar.")
    public BazaarConfig bazaar = new BazaarConfig();

    @Expose
    @Category(name = "Enchant Parsing", desc = "Settings for Skyhanni's Enchant Parsing")
    public EnchantParsingConfig enchantParsing = new EnchantParsingConfig();

    @Expose
    @Category(name = "Helpers", desc = "Some smaller Helper settings.")
    public HelperConfig helper = new HelperConfig();

    @Expose
    @Category(name = "Item Abilities", desc = "Stuff about item abilities.")
    public ItemAbilityConfig itemAbilities = new ItemAbilityConfig();

    @Expose
    @Category(name = "Chocolate Factory", desc = "Features to help you master the Chocolate Factory idle game.")
    public ChocolateFactoryConfig chocolateFactory = new ChocolateFactoryConfig();

    @Expose
    @ConfigOption(name = "Not Clickable Items", desc = "Better not click that item.")
    @Accordion
    public HideNotClickableConfig hideNotClickable = new HideNotClickableConfig();

    @Expose
    @ConfigOption(name = "RNG Meter", desc = "")
    @Accordion
    public RngMeterConfig rngMeter = new RngMeterConfig();

    @Expose
    @ConfigOption(name = "Stats Tuning", desc = "")
    @Accordion
    public StatsTuningConfig statsTuning = new StatsTuningConfig();

    @Expose
    @ConfigOption(name = "Jacob Farming Contest", desc = "")
    @Accordion
    public JacobFarmingContestConfig jacobFarmingContests = new JacobFarmingContestConfig();

    @Expose
    @ConfigOption(name = "Sack Items Display", desc = "")
    @Accordion
    public SackDisplayConfig sackDisplay = new SackDisplayConfig();

    @Expose
    @ConfigOption(name = "Estimated Item Value", desc = "(Prices for Enchantments, Reforge Stones, Gemstones, Drill Parts and more)")
    @Accordion
    public EstimatedItemValueConfig estimatedItemValues = new EstimatedItemValueConfig();

    @Expose
    @ConfigOption(name = "Chest Value", desc = "")
    @Accordion
    public ChestValueConfig chestValueConfig = new ChestValueConfig();

    @Expose
    @ConfigOption(name = "Get From Sack", desc = "")
    @Accordion
    public GetFromSackConfig gfs = new GetFromSackConfig();

    @ConfigOption(name = "Pocket Sack-In-A-Sack", desc = "")
    @Accordion
    @Expose
    public PocketSackInASackConfig pocketSackInASack = new PocketSackInASackConfig();

    @Expose
    @ConfigOption(
        name = "Item Number",
        desc = "Showing the item number as a stack size for these items."
    )
    @ConfigEditorDraggableList
    public List<ItemNumberEntry> itemNumberAsStackSize = new ArrayList<>(Arrays.asList(
        NEW_YEAR_CAKE,
        RANCHERS_BOOTS_SPEED,
        LARVA_HOOK,
        VACUUM_GARDEN
    ));

    public enum ItemNumberEntry implements HasLegacyId {
        MASTER_STAR_TIER("§bMaster Star Tier", 0),
        MASTER_SKULL_TIER("§bMaster Skull Tier", 1),
        DUNGEON_HEAD_FLOOR_NUMBER("§bDungeon Head Floor Number", 2),
        NEW_YEAR_CAKE("§bNew Year Cake", 3),
        PET_LEVEL("§bPet Level", 4),
        MINION_TIER("§bMinion Tier", 5),
        CRIMSON_ARMOR("§bCrimson Armor", 6),
        KUUDRA_KEY("§bKuudra Key", 8),
        SKILL_LEVEL("§bSkill Level", 9),
        COLLECTION_LEVEL("§bCollection Level", 10),
        RANCHERS_BOOTS_SPEED("§bRancher's Boots speed", 11),
        LARVA_HOOK("§bLarva Hook", 12),
        DUNGEON_POTION_LEVEL("§bDungeon Potion Level", 13),
        VACUUM_GARDEN("§bVacuum (Garden)", 14),
        BOTTLE_OF_JYRRE("§bBottle Of Jyrre", 15),
        EDITION_NUMBER("§bEdition Number", 16),
        BINGO_GOAL_RANK("§bBingo Goal Rank"),
        ;

        private final String str;
        private final int legacyId;

        ItemNumberEntry(String str, int legacyId) {
            this.str = str;
            this.legacyId = legacyId;
        }

        // Constructor if new enum elements are added post-migration
        ItemNumberEntry(String str) {
            this(str, -1);
        }

        @Override
        public int getLegacyId() {
            return legacyId;
        }

        @Override
        public String toString() {
            return str;
        }
    }

    @Expose
    @ConfigOption(name = "Highlight Widgets", desc = "Highlight enabled and disabled widgets in /tab.")
    @ConfigEditorBoolean
    @FeatureToggle
    public boolean highlightWidgets = true;

    @Expose
    @ConfigOption(name = " Vacuum Bag Cap", desc = "Cap the Garden Vacuum Bag item number display to 40.")
    @ConfigEditorBoolean
    public boolean vacuumBagCap = true;

    @Expose
    @ConfigOption(
        name = "Quick Craft Confirmation",
        desc = "Require Ctrl+Click to craft items that aren't often quick crafted " +
            "(e.g. armor, weapons, accessories). Sack items can be crafted normally."
    )
    @ConfigEditorBoolean
    @FeatureToggle
    public boolean quickCraftingConfirmation = false;

    @Expose
    @ConfigOption(name = "Sack Name", desc = "Show an abbreviation of the sack name.")
    @ConfigEditorBoolean
    @FeatureToggle
    public boolean displaySackName = false;

    @Expose
    @ConfigOption(name = "Anvil Combine Helper", desc = "Suggests the same item in the inventory when trying to combine two items in the anvil.")
    @ConfigEditorBoolean
    @FeatureToggle
    public boolean anvilCombineHelper = false;

    @Expose
    @ConfigOption(name = "Item Stars",
        desc = "Show a compact star count in the item name for all items.")
    @ConfigEditorBoolean
    @FeatureToggle
    public boolean itemStars = false;

    @Expose
    @ConfigOption(name = "Missing Tasks",
        desc = "Highlight missing tasks in the SkyBlock Level Guide inventory.")
    // TODO move( , "inventory.highlightMissingSkyBlockLevelGuide", "inventory.skyblockGuideConfig.highlightMissingSkyBlockLevelGuide")
    @ConfigEditorBoolean
    @FeatureToggle
    public boolean highlightMissingSkyBlockLevelGuide = true;

    @Expose
    @ConfigOption(name = "Power Stone Guide",
        desc = "Highlight missing power stones, show their total bazaar price, and allows to open the bazaar when clicking on the items in the Power Stone Guide.")
    // TODO move( , "inventory.powerStoneGuide", "inventory.skyblockGuideConfig.powerStoneGuide")
    @ConfigEditorBoolean
    @FeatureToggle
    public boolean powerStoneGuide = true;

    @Expose
    @ConfigOption(name = "Shift Click Equipment", desc = "Makes normal clicks to shift clicks in equipment inventory.")
    @ConfigEditorBoolean
    @FeatureToggle
    public boolean shiftClickForEquipment = false;

    @Expose
    @ConfigOption(name = "Shift Click NPC sell", desc = "Makes normal clicks to shift clicks in npc inventory for selling.")
    @ConfigEditorBoolean
    @FeatureToggle
    public boolean shiftClickNPCSell = false;

    @Expose
    @ConfigOption(name = "Shift Click Brewing", desc = "Makes normal clicks to shift clicks in Brewing Stand inventory.")
    @ConfigEditorBoolean
    @FeatureToggle
    public boolean shiftClickBrewing = false;
}
