package chylex.serverproperties.props.supported;
import chylex.serverproperties.props.PropertyChangeCallback;
import chylex.serverproperties.props.ServerProperty;
import chylex.serverproperties.props.finalizers.ReloadResourcePack;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class ResourcePackSha1Property extends ServerProperty<String> {
	public static final ResourcePackSha1Property INSTANCE = new ResourcePackSha1Property();

	private ResourcePackSha1Property() {}

	@Override
	public String get(final DedicatedServerProperties properties) {
		return properties.serverResourcePackInfo.map(info -> info.hash()).orElse("");
	}

	@Override
	public void apply(final DedicatedServer server, final String value, final PropertyChangeCallback callback) {
		callback.addFinalizer(new ReloadResourcePack(server.getServerResourcePack()));
	}
}