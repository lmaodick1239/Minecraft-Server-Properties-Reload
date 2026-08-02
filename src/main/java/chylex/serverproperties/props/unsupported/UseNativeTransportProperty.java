package chylex.serverproperties.props.unsupported;
import chylex.serverproperties.props.BoolServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class UseNativeTransportProperty extends BoolServerProperty {
	public static final UseNativeTransportProperty INSTANCE = new UseNativeTransportProperty();
	
	private UseNativeTransportProperty() {}
	
	@Override
	protected boolean getBool(final DedicatedServerProperties properties) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	protected void applyBool(final DedicatedServer server, final boolean value, final PropertyChangeCallback callback) {
		throw new UnsupportedOperationException();
	}
}
