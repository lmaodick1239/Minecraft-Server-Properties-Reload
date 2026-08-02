package chylex.serverproperties.props.supported;
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
	protected void applyBool(final DedicatedServer server, final boolean value, final PropertyChangeCallback callback) {}
}
