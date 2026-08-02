package chylex.serverproperties.command;

import org.junit.jupiter.api.Test;

import java.util.Properties;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

final class PropertiesCommandMergeTest {
	@Test
	void mergesOnlySuccessfullyReloadedProperties() {
		final Properties oldProperties = new Properties();
		oldProperties.setProperty("motd", "old");
		oldProperties.setProperty("server-port", "25565");

		final Properties newProperties = new Properties();
		newProperties.setProperty("motd", "new");
		newProperties.setProperty("server-port", "25566");
		newProperties.setProperty("unknown", "value");

		final Properties merged = PropertiesCommand.mergeProperties(oldProperties, newProperties, Set.of("motd"));

		assertEquals("new", merged.getProperty("motd"));
		assertEquals("25565", merged.getProperty("server-port"));
		assertEquals(null, merged.getProperty("unknown"));
	}

	@Test
	void classifiesOnlyIntentionalUnsupportedFailures() {
		assertTrue(PropertiesCommand.isUnsupported(new UnsupportedOperationException()));
		assertFalse(PropertiesCommand.isUnsupported(new IllegalStateException()));
	}
}