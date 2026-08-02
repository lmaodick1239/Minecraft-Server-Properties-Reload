package chylex.serverproperties.props.supported;

import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer.ServerResourcePackInfo;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public final class ServerResourcePackProperties {
	public static ServerResourcePackInfo fromComponents(final String url, final String hash, final boolean required, final Component prompt) {
		return new ServerResourcePackInfo(UUID.nameUUIDFromBytes(url.getBytes(StandardCharsets.UTF_8)), url, hash, required, prompt);
	}

	public static ServerResourcePackInfo withUrl(final ServerResourcePackInfo info, final String url) {
		return new ServerResourcePackInfo(info.id(), url, info.hash(), info.isRequired(), info.prompt());
	}

	public static ServerResourcePackInfo withHash(final ServerResourcePackInfo info, final String hash) {
		return new ServerResourcePackInfo(info.id(), info.url(), hash, info.isRequired(), info.prompt());
	}

	public static ServerResourcePackInfo withRequired(final ServerResourcePackInfo info, final boolean required) {
		return new ServerResourcePackInfo(info.id(), info.url(), info.hash(), required, info.prompt());
	}

	public static ServerResourcePackInfo withPrompt(final ServerResourcePackInfo info, final Component prompt) {
		return new ServerResourcePackInfo(info.id(), info.url(), info.hash(), info.isRequired(), prompt);
	}

	private ServerResourcePackProperties() {}
}