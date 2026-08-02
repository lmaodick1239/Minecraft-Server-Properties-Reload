package chylex.serverproperties.props;

import chylex.serverproperties.props.supported.FunctionPermissionLevel;
import chylex.serverproperties.props.supported.OpPermissionLevel;
import net.minecraft.server.permissions.LevelBasedPermissionSet;
import net.minecraft.server.permissions.PermissionLevel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

final class PermissionPropertyTest {
	@Test
	void mapsLegacyPermissionLevelsWithoutLoss() {
		for (int value = 0; value <= 4; ++value) {
			final LevelBasedPermissionSet permissions = LevelBasedPermissionSet.forLevel(PermissionLevel.byId(value));
			assertEquals(value, permissions.level().id());
		}
	}

	@Test
	void exposesRestoredPermissionProperties() {
		assertNotNull(OpPermissionLevel.INSTANCE);
		assertNotNull(FunctionPermissionLevel.INSTANCE);
	}
}