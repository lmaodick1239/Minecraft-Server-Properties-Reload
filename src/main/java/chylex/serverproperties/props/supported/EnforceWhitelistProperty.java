package chylex.serverproperties.props.supported;
import chylex.serverproperties.props.BoolServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import chylex.serverproperties.props.finalizers.EnforceWhitelist;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class EnforceWhitelistProperty extends BoolServerProperty {
	public static final EnforceWhitelistProperty INSTANCE = new EnforceWhitelistProperty();
	
	private EnforceWhitelistProperty() {}
	
	@Override
	protected boolean getBool(final DedicatedServerProperties properties) {
		return properties.enforceWhitelist.get();
	}
	
	@Override
	protected void applyBool(final DedicatedServer server, final boolean value, final PropertyChangeCallback callback) {
		callback.addFinalizer(new EnforceWhitelist());
	}
}
