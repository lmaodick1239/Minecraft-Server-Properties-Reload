package chylex.serverproperties.props.finalizers;

import chylex.serverproperties.props.PropertyChangeFinalizer;
import net.minecraft.network.protocol.common.ClientboundResourcePackPopPacket;
import net.minecraft.network.protocol.common.ClientboundResourcePackPushPacket;
import net.minecraft.server.MinecraftServer.ServerResourcePackInfo;
import net.minecraft.server.dedicated.DedicatedServer;

import java.util.Optional;

public final class ReloadResourcePack implements PropertyChangeFinalizer {
	private final Optional<ServerResourcePackInfo> oldPack;

	public ReloadResourcePack(final Optional<ServerResourcePackInfo> oldPack) {
		this.oldPack = oldPack;
	}

	@Override
	public String getKey() {
		return "resource-pack";
	}

	@Override
	public void run(final DedicatedServer server) {
		oldPack.ifPresent(pack -> server.getPlayerList().broadcastAll(new ClientboundResourcePackPopPacket(Optional.of(pack.id()))));
		server.getServerResourcePack().ifPresent(pack -> server.getPlayerList().broadcastAll(new ClientboundResourcePackPushPacket(
			pack.id(),
			pack.url(),
			pack.hash(),
			pack.isRequired(),
			Optional.ofNullable(pack.prompt())
		)));
	}
}