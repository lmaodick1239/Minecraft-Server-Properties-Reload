package chylex.serverproperties.props.unsupported;
import chylex.serverproperties.props.PropertyChangeCallback;
import chylex.serverproperties.props.ServerProperty;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class ResourcePackHashProperty extends ServerProperty<String> {
	public static final ResourcePackHashProperty INSTANCE = new ResourcePackHashProperty();
	
	private ResourcePackHashProperty() {}
	
	@Override
	public String get(final DedicatedServerProperties properties) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void apply(final DedicatedServer server, final String value, final PropertyChangeCallback callback) {
		throw new UnsupportedOperationException();
	}
}
