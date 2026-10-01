package dev.b2spirit.item;

import dev.b2spirit.client.ClientItemHints;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;

/** Styled translation arguments keep numbers and keys distinct in either language. */
public final class SpecialItemText {
    public static MutableComponent line(String key, Object... arguments) {
        return Component.translatable(key, arguments).withStyle(ChatFormatting.GRAY);
    }

    public static MutableComponent number(Object value) {
        return Component.literal(String.valueOf(value)).withStyle(ChatFormatting.AQUA, ChatFormatting.BOLD);
    }

    public static MutableComponent key(String value) {
        return switch (value) {
            case "RMB" -> Component.translatable("tooltip.b2spirit.special.right_click").withStyle(ChatFormatting.GOLD);
            case "Shift + RMB" -> Component.translatable("tooltip.b2spirit.special.sneak_click").withStyle(ChatFormatting.GOLD);
            default -> Component.literal(value).withStyle(ChatFormatting.GOLD);
        };
    }

    public static boolean expanded() {
        return FMLEnvironment.dist == Dist.CLIENT && ClientItemHints.shiftDown();
    }

    private SpecialItemText() {}
}
