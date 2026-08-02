package chylex.serverproperties.props;

import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

final class PropertyUpdateContractTest {
	@Test
	void propertyApplyUsesServerSourceAndCallbackOnly() throws ReflectiveOperationException {
		assertNotNull(ServerProperty.class.getMethod(
			"apply",
			DedicatedServer.class,
			DedicatedServerProperties.class,
			PropertyChangeCallback.class
		));
	}
}