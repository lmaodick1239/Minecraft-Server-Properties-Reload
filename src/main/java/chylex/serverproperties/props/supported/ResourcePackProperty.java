package chylex.serverproperties.props.supported;
import chylex.serverproperties.props.PropertyChangeCallback;
import chylex.serverproperties.props.ServerProperty;
import chylex.serverproperties.props.finalizers.ReloadResourcePack;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class ResourcePackProperty extends ServerProperty<String> {
	public static final ResourcePackProperty INSTANCE = new ResourcePackProperty();

	private ResourcePackProperty() {}

	@Override
	public String get(final DedicatedServerProperties properties) {
		return properties.serverResourcePackInfo.map(info -> info.url()).orElse("");
	}

	@Override
	public void apply(final DedicatedServer server, final String value, final PropertyChangeCallback callback) {
		callback.addFinalizer(new ReloadResourcePack(server.getServerResourcePack()));
	}
}