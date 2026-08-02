package chylex.serverproperties.props.supported;
import chylex.serverproperties.props.IntServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class FunctionPermissionLevel extends IntServerProperty {
	public static final FunctionPermissionLevel INSTANCE = new FunctionPermissionLevel();

	private FunctionPermissionLevel() {}

	@Override
	protected int getInt(final DedicatedServerProperties properties) {
		return properties.functionPermissions.level().id();
	}

	@Override
	protected void applyInt(final DedicatedServer server, final int value, final PropertyChangeCallback callback) {}
}