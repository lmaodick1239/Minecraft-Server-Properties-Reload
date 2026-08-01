package chylex.serverproperties.props.supported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.props.BoolServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class WhiteListProperty extends BoolServerProperty {
	public static final WhiteListProperty INSTANCE = new WhiteListProperty();
	
	private WhiteListProperty() {}
	
	@Override
	protected boolean getBool(final DedicatedServerProperties properties) {
		return properties.whiteList.get().booleanValue();
	}
	
	@Override
	protected void applyBool(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final boolean value, final PropertyChangeCallback callback) {
		// target.setWhiteList(value); // Method removed in 26.2
		// server.getPlayerList().setWhitelistEnabled(value); // Method removed in 26.2
		// Whitelist property management changed in 26.2 - may need alternative approach via mixin
	}
}
