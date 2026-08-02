package chylex.serverproperties.props;

import chylex.serverproperties.mixin.SettingsMixin;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;
import net.minecraft.world.level.gamerules.GameRule;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public abstract class GameRuleBooleanProperty extends BoolServerProperty {
	private final String propertyName;
	private final GameRule<Boolean> gameRule;
	private final boolean refreshMobSpawning;
	private final boolean defaultValue;

	protected GameRuleBooleanProperty(final String propertyName, final GameRule<Boolean> gameRule, final boolean refreshMobSpawning, final boolean defaultValue) {
		this.propertyName = propertyName;
		this.gameRule = gameRule;
		this.refreshMobSpawning = refreshMobSpawning;
		this.defaultValue = defaultValue;
	}

	@Override
	protected final boolean getBool(final DedicatedServerProperties properties) {
		return parseBoolean(((SettingsMixin)properties).getProperties().getProperty(propertyName), defaultValue);
	}

	@Override
	protected final void applyBool(final DedicatedServer server, final boolean value, final PropertyChangeCallback callback) {
		server.getGameRules().set(gameRule, value, server);
		if (refreshMobSpawning) {
			server.updateMobSpawningFlags();
		}
	}

	public static boolean parseBoolean(final String value, final boolean defaultValue) {
		return "true".equalsIgnoreCase(value) || (!"false".equalsIgnoreCase(value) && defaultValue);
	}

	public static Set<String> findConflicts(final Properties properties) {
		final Set<String> conflicts = new HashSet<>();
		final boolean spawnAnimals = parseBoolean(properties.getProperty("spawn-animals"), true);
		final boolean spawnNpcs = parseBoolean(properties.getProperty("spawn-npcs"), true);

		if (spawnAnimals != spawnNpcs) {
			conflicts.add("spawn-animals");
			conflicts.add("spawn-npcs");
		}

		return conflicts;
	}
}