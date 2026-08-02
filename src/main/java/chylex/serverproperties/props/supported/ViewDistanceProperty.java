package chylex.serverproperties.props.supported;
import chylex.serverproperties.props.IntServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class ViewDistanceProperty extends IntServerProperty {
	public static final ViewDistanceProperty INSTANCE = new ViewDistanceProperty();
	
	private ViewDistanceProperty() {}
	
	@Override
	protected int getInt(final DedicatedServerProperties properties) {
		return properties.viewDistance.get();
	}
	
	@Override
	protected void applyInt(final DedicatedServer server, final int value, final PropertyChangeCallback callback) {
		server.getPlayerList().setViewDistance(value);
	}
}
