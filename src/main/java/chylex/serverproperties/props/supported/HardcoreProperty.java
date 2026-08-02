package chylex.serverproperties.props.supported;
import chylex.serverproperties.mixin.PrimaryLevelDataMixin;
import chylex.serverproperties.props.BoolServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;
import net.minecraft.world.level.LevelSettings;

public final class HardcoreProperty extends BoolServerProperty {
	public static final HardcoreProperty INSTANCE = new HardcoreProperty();
	
	private HardcoreProperty() {}
	
	@Override
	protected boolean getBool(final DedicatedServerProperties properties) {
		return properties.hardcore;
	}
	
	@Override
	protected void applyBool(final DedicatedServer server, final boolean value, final PropertyChangeCallback callback) {
		final PrimaryLevelDataMixin worldDataMixin = (PrimaryLevelDataMixin)server.getWorldData();
		final LevelSettings settings = worldDataMixin.getSettings();
		final LevelSettings.DifficultySettings difficulty = settings.difficultySettings();
		worldDataMixin.setSettings(new LevelSettings(
			settings.levelName(),
			settings.gameType(),
			new LevelSettings.DifficultySettings(difficulty.difficulty(), value, difficulty.locked()),
			settings.allowCommands(),
			settings.dataConfiguration()
		));
	}
}
