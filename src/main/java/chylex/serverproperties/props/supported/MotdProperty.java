package chylex.serverproperties.props.supported;
import chylex.serverproperties.props.PropertyChangeCallback;
import chylex.serverproperties.props.ServerProperty;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class MotdProperty extends ServerProperty<String> {
	public static final MotdProperty INSTANCE = new MotdProperty();
	
	private MotdProperty() {}
	
	@Override
	public String get(final DedicatedServerProperties properties) {
		return properties.motd.get();
	}
	
	@Override
	public void apply(final DedicatedServer server, final String value, final PropertyChangeCallback callback) {}
}
