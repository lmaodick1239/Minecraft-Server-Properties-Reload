package chylex.serverproperties.command;

import net.minecraft.server.permissions.LevelBasedPermissionSet;
import net.minecraft.server.permissions.PermissionSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

final class PropertiesCommandPermissionTest {
	@Test
	void requiresAdministrativeCommandPermission() {
		assertFalse(PropertiesCommand.canReloadProperties(PermissionSet.NO_PERMISSIONS));
		assertTrue(PropertiesCommand.canReloadProperties(LevelBasedPermissionSet.ADMIN));
		assertTrue(PropertiesCommand.canReloadProperties(LevelBasedPermissionSet.OWNER));
	}
}