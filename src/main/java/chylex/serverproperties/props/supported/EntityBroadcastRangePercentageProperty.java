package chylex.serverproperties.props.supported;
import chylex.serverproperties.props.IntServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class EntityBroadcastRangePercentageProperty extends IntServerProperty {
	public static final EntityBroadcastRangePercentageProperty INSTANCE = new EntityBroadcastRangePercentageProperty();
	
	private EntityBroadcastRangePercentageProperty() {}
	
	@Override
	protected int getInt(final DedicatedServerProperties properties) {
		return properties.entityBroadcastRangePercentage.get();
	}
	
	@Override
	protected void applyInt(final DedicatedServer server, final int value, final PropertyChangeCallback callback) {
	}
}
