package chylex.serverproperties.props;

import net.minecraft.core.RegistryAccess;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerSettings;
import net.minecraft.server.dedicated.Settings;
import net.minecraft.server.permissions.LevelBasedPermissionSet;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRules;
import org.junit.jupiter.api.Test;

import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

final class MinecraftApiContractTest {
	@Test
	void exposesSettingsUpdateContracts() throws ReflectiveOperationException {
		assertNotNull(DedicatedServerSettings.class.getMethod("update", UnaryOperator.class));
		assertNotNull(Settings.MutableValue.class.getMethod("update", RegistryAccess.class, Object.class));
	}

	@Test
	void exposesLiveServerUpdateContracts() throws ReflectiveOperationException {
		assertNotNull(DedicatedServer.class.getMethod("setOperatorUserPermissions", LevelBasedPermissionSet.class));
		assertNotNull(MinecraftServer.class.getMethod("setDefaultGameType", GameType.class));
		assertNotNull(GameRules.class.getMethod("set", GameRule.class, Object.class, MinecraftServer.class));
	}

	@Test
	void exposesLegacyPropertyGameRules() throws ReflectiveOperationException {
		assertNotNull(GameRules.class.getField("ALLOW_ENTERING_NETHER_USING_PORTALS"));
		assertNotNull(GameRules.class.getField("COMMAND_BLOCKS_WORK"));
		assertNotNull(GameRules.class.getField("PVP"));
		assertNotNull(GameRules.class.getField("SPAWN_MOBS"));
		assertNotNull(GameRules.class.getField("SPAWN_MONSTERS"));
	}

	@Test
	void exposesCompositeResourcePackRecord() {
		assertEquals(5, MinecraftServer.ServerResourcePackInfo.class.getRecordComponents().length);
	}
}