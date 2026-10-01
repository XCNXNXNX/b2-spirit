package dev.b2spirit.network;

import dev.b2spirit.B2Spirit;
import dev.b2spirit.vehicle.B2Entity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;

@EventBusSubscriber(modid = B2Spirit.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class ModNetwork {
    @SubscribeEvent
    public static void onRegisterPayloads(RegisterPayloadHandlersEvent event) {
        event.registrar("3").playToServer(B2ControlPayload.TYPE, B2ControlPayload.STREAM_CODEC, (payload, context) ->
            context.enqueueWork(() -> {
                var player = context.player();
                if (player.getVehicle() instanceof B2Entity plane && plane.getId() == payload.entityId())
                    plane.acceptControls(player, payload.input(), payload.steering(), payload.elevator(), payload.scroll());
            }));
    }
    private ModNetwork() {}
}
