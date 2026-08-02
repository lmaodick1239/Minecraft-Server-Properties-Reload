package chylex.serverproperties.mixin;

import net.minecraft.server.dedicated.DedicatedServerProperties;
import net.minecraft.server.dedicated.DedicatedServerSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(DedicatedServerSettings.class)
public interface DedicatedServerSettingsMixin {
	@Accessor
	void setProperties(DedicatedServerProperties properties);
}