package chylex.serverproperties.props.unsupported;
import chylex.serverproperties.props.IntServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class RateLimitProperty extends IntServerProperty {
	public static final RateLimitProperty INSTANCE = new RateLimitProperty();
	
	private RateLimitProperty() {}
	
	@Override
	protected int getInt(final DedicatedServerProperties properties) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	protected void applyInt(final DedicatedServer server, final int value, final PropertyChangeCallback callback) {
		throw new UnsupportedOperationException();
	}
}
