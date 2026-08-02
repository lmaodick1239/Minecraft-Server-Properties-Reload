package chylex.serverproperties.props.supported;
import chylex.serverproperties.props.BoolServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import chylex.serverproperties.props.finalizers.ReloadResourcePack;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class RequireResourcePackProperty extends BoolServerProperty {
	public static final RequireResourcePackProperty INSTANCE = new RequireResourcePackProperty();

	private RequireResourcePackProperty() {}

	@Override
	protected boolean getBool(final DedicatedServerProperties properties) {
		return properties.serverResourcePackInfo.map(info -> info.isRequired()).orElse(false);
	}

	@Override
	protected void applyBool(final DedicatedServer server, final boolean value, final PropertyChangeCallback callback) {
		callback.addFinalizer(new ReloadResourcePack(server.getServerResourcePack()));
	}
}