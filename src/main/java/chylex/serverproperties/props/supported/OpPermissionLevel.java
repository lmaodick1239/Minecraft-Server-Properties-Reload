package chylex.serverproperties.props.supported;
import chylex.serverproperties.props.IntServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class OpPermissionLevel extends IntServerProperty {
	public static final OpPermissionLevel INSTANCE = new OpPermissionLevel();

	private OpPermissionLevel() {}

	@Override
	protected int getInt(final DedicatedServerProperties properties) {
		return properties.opPermissions.get().level().id();
	}

	@Override
	protected void applyInt(final DedicatedServer server, final int value, final PropertyChangeCallback callback) {}
}