package chylex.serverproperties.props;

import chylex.serverproperties.props.supported.ServerResourcePackProperties;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer.ServerResourcePackInfo;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class ServerResourcePackPropertiesTest {
	private static final UUID ID = UUID.fromString("01234567-89ab-cdef-0123-456789abcdef");
	private static final ServerResourcePackInfo INFO = new ServerResourcePackInfo(ID, "https://old", "old-hash", false, Component.literal("old"));

	@Test
	void replacesOneComponentWithoutLosingOthers() {
		assertEquals(new ServerResourcePackInfo(ID, "https://new", "old-hash", false, Component.literal("old")), ServerResourcePackProperties.withUrl(INFO, "https://new"));
		assertEquals(new ServerResourcePackInfo(ID, "https://old", "new-hash", false, Component.literal("old")), ServerResourcePackProperties.withHash(INFO, "new-hash"));
		assertEquals(new ServerResourcePackInfo(ID, "https://old", "old-hash", true, Component.literal("old")), ServerResourcePackProperties.withRequired(INFO, true));
		assertEquals(new ServerResourcePackInfo(ID, "https://old", "old-hash", false, Component.literal("new")), ServerResourcePackProperties.withPrompt(INFO, Component.literal("new")));
	}

	@Test
	void derivesStableIdFromUrl() {
		assertEquals(
			ServerResourcePackProperties.fromComponents("https://pack", "hash", false, Component.empty()),
			ServerResourcePackProperties.fromComponents("https://pack", "hash", false, Component.empty())
		);
	}
}