package dev.b2spirit.gametest;

import dev.b2spirit.B2Spirit;
import dev.b2spirit.registry.ModContent;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.gametest.GameTestHolder;
import net.neoforged.neoforge.gametest.PrefixGameTestTemplate;

@GameTestHolder(B2Spirit.MOD_ID)
@PrefixGameTestTemplate(false)
public final class B2ItemTests {
    @GameTest(template = "test_empty")
    public static void droppedB2SurvivesCactusLavaAndFireButNotOtherDamage(GameTestHelper h) {
        var pos = h.absolutePos(new BlockPos(2, 2, 2));
        var stack = new ItemStack(ModContent.B2_ITEM.get());
        stack.set(DataComponents.CUSTOM_NAME, Component.literal("Protected aircraft"));
        var drop = new ItemEntity(h.getLevel(), pos.getX(), pos.getY(), pos.getZ(), stack);
        var damage = h.getLevel().damageSources();
        for (var source : new net.minecraft.world.damagesource.DamageSource[]{
                damage.cactus(), damage.lava(), damage.inFire(), damage.onFire()}) {
            h.assertTrue(!drop.hurt(source, 1000), "Protected damage must be rejected by the real dropped item");
            h.assertTrue(!drop.isRemoved() && ItemStack.matches(stack, drop.getItem()), "Drop must retain its item and custom name");
        }
        var ordinary = new ItemEntity(h.getLevel(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.RED_CARPET));
        h.assertTrue(ordinary.hurt(damage.cactus(), 1000) && ordinary.isRemoved(), "Protection must not leak to the carpet roll");
        h.assertTrue(drop.hurt(damage.generic(), 1000) && drop.isRemoved(), "B2 must retain normal damage behaviour outside the requested protection");
        h.succeed();
    }

    @GameTest(template = "test_empty")
    public static void rarityProtectionAndCustomNameSurviveSave(GameTestHelper h) {
        var stack = new ItemStack(ModContent.B2_ITEM.get());
        h.assertTrue(stack.getRarity() == Items.NETHER_STAR.getDefaultInstance().getRarity()
            && stack.has(DataComponents.FIRE_RESISTANT), "Aircraft must keep nether-star rarity and fire resistance");
        h.assertTrue(stack.getHoverName().getStyle().isBold()
            && stack.getHoverName().getStyle().getColor().getValue() == ChatFormatting.LIGHT_PURPLE.getColor(),
            "Aircraft title must keep its distinct appearance");
        stack.set(DataComponents.CUSTOM_NAME, Component.literal("Spirit of Ceremony"));
        var restored = ItemStack.parse(h.getLevel().registryAccess(), stack.save(h.getLevel().registryAccess())).orElseThrow();
        h.assertTrue(ItemStack.matches(stack, restored) && restored.getHoverName().getString().equals("Spirit of Ceremony"),
            "Saving the protected aircraft item must retain its custom name");
        h.succeed();
    }
}
