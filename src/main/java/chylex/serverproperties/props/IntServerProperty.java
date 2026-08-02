package chylex.serverproperties.props;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public abstract class IntServerProperty extends ServerProperty<Integer> {
	
	@Override
	public final Integer get(final DedicatedServerProperties properties) {
		return Integer.valueOf(getInt(properties));
	}
	
	@Override
	public final void apply(final DedicatedServer server, final Integer value, final PropertyChangeCallback callback) {
		applyInt(server, value.intValue(), callback);
	}
	
	@Override
	public String toString(final Integer value) {
		return String.valueOf(value.intValue());
	}
	
	protected abstract int getInt(DedicatedServerProperties properties);
	
	protected abstract void applyInt(DedicatedServer server, int value, PropertyChangeCallback callback);
}
