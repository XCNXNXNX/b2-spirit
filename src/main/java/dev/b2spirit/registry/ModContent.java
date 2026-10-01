package dev.b2spirit.registry;

import dev.b2spirit.B2Spirit;
import dev.b2spirit.item.B2Item;
import dev.b2spirit.vehicle.B2Entity;
import dev.b2spirit.vehicle.B2Geometry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModContent {
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(B2Spirit.MOD_ID);
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, B2Spirit.MOD_ID);
    private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, B2Spirit.MOD_ID);
    public static final DeferredHolder<EntityType<?>, EntityType<B2Entity>> B2 = ENTITIES.register("b2_spirit",
        () -> EntityType.Builder.<B2Entity>of(B2Entity::new, MobCategory.MISC).sized(8F, B2Geometry.HEIGHT)
            .clientTrackingRange(16).updateInterval(2).build("b2spirit:b2_spirit"));
    public static final DeferredItem<B2Item> B2_ITEM = ITEMS.register("b2_spirit",
        () -> new B2Item(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).fireResistant()));
    private static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB = TABS.register("aircraft",
        () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.b2spirit"))
            .icon(() -> B2_ITEM.get().getDefaultInstance()).displayItems((parameters, output) -> output.accept(B2_ITEM.get())).build());
    public static void register(IEventBus bus) { ITEMS.register(bus); ENTITIES.register(bus); TABS.register(bus); }
    private ModContent() {}
}
