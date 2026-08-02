package chylex.serverproperties.props.supported;
import chylex.serverproperties.props.IntServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class SpawnProtectionProperty extends IntServerProperty {
	public static final SpawnProtectionProperty INSTANCE = new SpawnProtectionProperty();
	
	private SpawnProtectionProperty() {}
	
	@Override
	protected int getInt(final DedicatedServerProperties properties) {
		return properties.spawnProtection.get();
	}
	
	@Override
	protected void applyInt(final DedicatedServer server, final int value, final PropertyChangeCallback callback) {
	}
}
