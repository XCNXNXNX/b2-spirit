package dev.b2spirit.client;

import dev.b2spirit.B2Spirit;
import dev.b2spirit.registry.ModContent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

@EventBusSubscriber(modid = B2Spirit.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class B2SpiritClient {
    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModContent.B2.get(), B2Renderer::new);
    }
    @SubscribeEvent
    public static void onKeys(RegisterKeyMappingsEvent event) { event.register(B2Controls.GEAR); }
    private B2SpiritClient() {}
}
