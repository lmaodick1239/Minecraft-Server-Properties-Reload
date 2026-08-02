package chylex.serverproperties.props.supported;

import chylex.serverproperties.props.GameRuleBooleanProperty;
import net.minecraft.world.level.gamerules.GameRules;

public final class SpawnAnimalsProperty extends GameRuleBooleanProperty {
	public static final SpawnAnimalsProperty INSTANCE = new SpawnAnimalsProperty();

	private SpawnAnimalsProperty() {
		super("spawn-animals", GameRules.SPAWN_MOBS, true, true);
	}
}