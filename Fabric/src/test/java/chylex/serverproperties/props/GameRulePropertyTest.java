package chylex.serverproperties.props;

import chylex.serverproperties.props.supported.AllowNetherProperty;
import chylex.serverproperties.props.supported.EnableCommandBlockProperty;
import chylex.serverproperties.props.supported.PvpProperty;
import chylex.serverproperties.props.supported.SpawnAnimalsProperty;
import chylex.serverproperties.props.supported.SpawnMonstersProperty;
import chylex.serverproperties.props.supported.SpawnNpcsProperty;
import net.minecraft.SharedConstants;
import net.minecraft.server.Bootstrap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Properties;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

final class GameRulePropertyTest {
	@BeforeAll
	static void bootstrapMinecraft() {
		SharedConstants.tryDetectVersion();
		Bootstrap.bootStrap();
	}

	@Test
	void exposesSixGameruleBackedProperties() {
		assertInstanceOf(GameRuleBooleanProperty.class, AllowNetherProperty.INSTANCE);
		assertInstanceOf(GameRuleBooleanProperty.class, EnableCommandBlockProperty.INSTANCE);
		assertInstanceOf(GameRuleBooleanProperty.class, PvpProperty.INSTANCE);
		assertInstanceOf(GameRuleBooleanProperty.class, SpawnAnimalsProperty.INSTANCE);
		assertInstanceOf(GameRuleBooleanProperty.class, SpawnMonstersProperty.INSTANCE);
		assertInstanceOf(GameRuleBooleanProperty.class, SpawnNpcsProperty.INSTANCE);
	}

	@Test
	void usesVanillaDefaultForMissingOrMalformedBoolean() {
		assertEquals(true, GameRuleBooleanProperty.parseBoolean(null, true));
		assertEquals(false, GameRuleBooleanProperty.parseBoolean("invalid", false));
		assertEquals(true, GameRuleBooleanProperty.parseBoolean("true", false));
		assertEquals(false, GameRuleBooleanProperty.parseBoolean("false", true));
	}

	@Test
	void rejectsIndependentValuesMappedToSharedSpawnRule() {
		final Properties properties = new Properties();
		properties.setProperty("spawn-animals", "true");
		properties.setProperty("spawn-npcs", "false");

		assertEquals(Set.of("spawn-animals", "spawn-npcs"), GameRuleBooleanProperty.findConflicts(properties));
	}
}