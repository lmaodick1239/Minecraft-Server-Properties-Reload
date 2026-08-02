package chylex.serverproperties.props.supported;
import chylex.serverproperties.props.PropertyChangeCallback;
import chylex.serverproperties.props.ServerProperty;
import chylex.serverproperties.props.finalizers.ReloadResourcePack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class ResourcePackPromptProperty extends ServerProperty<Component> {
	public static final ResourcePackPromptProperty INSTANCE = new ResourcePackPromptProperty();

	private ResourcePackPromptProperty() {}

	@Override
	public Component get(final DedicatedServerProperties properties) {
		return properties.serverResourcePackInfo.map(info -> info.prompt()).orElse(Component.empty());
	}

	@Override
	public void apply(final DedicatedServer server, final Component value, final PropertyChangeCallback callback) {
		callback.addFinalizer(new ReloadResourcePack(server.getServerResourcePack()));
	}

	@Override
	public String toString(final Component value) {
		return value.getString();
	}
}