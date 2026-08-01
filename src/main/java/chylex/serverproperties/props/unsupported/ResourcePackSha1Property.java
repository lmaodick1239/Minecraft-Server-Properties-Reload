package chylex.serverproperties.props.unsupported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.props.PropertyChangeCallback;
import chylex.serverproperties.props.ServerProperty;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class ResourcePackSha1Property extends ServerProperty<String> {
	public static final ResourcePackSha1Property INSTANCE = new ResourcePackSha1Property();
	
	private ResourcePackSha1Property() {}
	
	@Override
	public String get(final DedicatedServerProperties properties) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void apply(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final String value, final PropertyChangeCallback callback) {
		throw new UnsupportedOperationException();
	}
}
