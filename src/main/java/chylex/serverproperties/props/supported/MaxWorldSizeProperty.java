package chylex.serverproperties.props.supported;
import chylex.serverproperties.props.IntServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.network.protocol.game.ClientboundInitializeBorderPacket;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

public final class MaxWorldSizeProperty extends IntServerProperty {
	public static final MaxWorldSizeProperty INSTANCE = new MaxWorldSizeProperty();
	
	private MaxWorldSizeProperty() {}
	
	@Override
	protected int getInt(final DedicatedServerProperties properties) {
		return properties.maxWorldSize;
	}
	
	@Override
	protected void applyInt(final DedicatedServer server, final int value, final PropertyChangeCallback callback) {
		for (final ServerLevel level : server.getAllLevels()) {
			level.getWorldBorder().setAbsoluteMaxSize(value);
			for (final ServerPlayer player : level.players()) {
				player.connection.send(new ClientboundInitializeBorderPacket(level.getWorldBorder()));
			}
		}
	}
}
