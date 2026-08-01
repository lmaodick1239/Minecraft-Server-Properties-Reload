package chylex.serverproperties.props.unsupported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.mixin.MinecraftServerMixin;
import chylex.serverproperties.props.BoolServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class SpawnAnimalsProperty extends BoolServerProperty {
	public static final SpawnAnimalsProperty INSTANCE = new SpawnAnimalsProperty();
	
	private SpawnAnimalsProperty() {}
	
	@Override
	protected boolean getBool(final DedicatedServerProperties properties) {
		throw new UnsupportedOperationException();
	}
	
	@SuppressWarnings("CastToIncompatibleInterface")
	@Override
	protected void applyBool(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final boolean value, final PropertyChangeCallback callback) {
		throw new UnsupportedOperationException();
	}
}
