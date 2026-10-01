package dev.b2spirit;

import dev.b2spirit.registry.ModContent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(B2Spirit.MOD_ID)
public final class B2Spirit {
    public static final String MOD_ID = "b2spirit";
    public static final Logger LOGGER = LoggerFactory.getLogger("B2Spirit");
    public B2Spirit(IEventBus modBus) { ModContent.register(modBus); }
}
