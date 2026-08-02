package chylex.serverproperties.props.finalizers;

import chylex.serverproperties.props.PropertyChangeFinalizer;
import net.minecraft.server.dedicated.DedicatedServer;

public final class EnforceWhitelist implements PropertyChangeFinalizer {
	@Override
	public String getKey() {
		return "enforce-whitelist";
	}

	@Override
	public void run(final DedicatedServer server) {
		if (server.getProperties().enforceWhitelist.get()) {
			server.kickUnlistedPlayers();
		}
	}
}