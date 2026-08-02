package chylex.serverproperties.props.supported;
import chylex.serverproperties.props.BoolServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class AllowFlightProperty extends BoolServerProperty {
	public static final AllowFlightProperty INSTANCE = new AllowFlightProperty();
	
	private AllowFlightProperty() {}
	
	@Override
	protected boolean getBool(final DedicatedServerProperties properties) {
		return properties.allowFlight.get();
	}
	
	@Override
	protected void applyBool(final DedicatedServer server, final boolean value, final PropertyChangeCallback callback) {
		// server.setFlightAllowed(value); // Method removed in 26.2
	}
}
