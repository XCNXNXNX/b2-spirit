package dev.b2spirit.client;

import dev.b2spirit.B2Spirit;
import dev.b2spirit.compat.TaczItems;
import dev.b2spirit.vehicle.B2Entity;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.EntityHitResult;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import org.lwjgl.glfw.GLFW;

/** Prioritize aircraft interaction before TaCZ turns the same mouse press into aiming. */
@EventBusSubscriber(modid = B2Spirit.MOD_ID, value = Dist.CLIENT)
public final class B2GunInteraction {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onMousePress(InputEvent.MouseButton.Pre event) {
        if (event.getAction() != GLFW.GLFW_PRESS) return;
        var minecraft = Minecraft.getInstance();
        var player = minecraft.player;
        if (minecraft.screen != null || minecraft.getOverlay() != null || !minecraft.mouseHandler.isMouseGrabbed()
            || player == null || minecraft.level == null || minecraft.gameMode == null
            || player.isSpectator() || !player.getAbilities().mayBuild) return;
        if (!minecraft.options.keyUse.matchesMouse(event.getButton())
            || !TaczItems.isGun(player.getMainHandItem())) return;
        if (minecraft.hitResult instanceof EntityHitResult entityHit
            && entityHit.getEntity() instanceof B2Entity plane && player.canInteractWithEntity(plane, 0)) {
            event.setCanceled(true);
            var result = minecraft.gameMode.interact(player, plane, InteractionHand.MAIN_HAND);
            if (result.shouldSwing()) player.swing(InteractionHand.MAIN_HAND);
            return;
        }
    }

    private B2GunInteraction() {}
}
