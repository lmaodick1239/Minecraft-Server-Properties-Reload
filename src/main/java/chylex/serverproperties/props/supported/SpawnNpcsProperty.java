package chylex.serverproperties.props.supported;

import chylex.serverproperties.props.GameRuleBooleanProperty;
import net.minecraft.world.level.gamerules.GameRules;

public final class SpawnNpcsProperty extends GameRuleBooleanProperty {
	public static final SpawnNpcsProperty INSTANCE = new SpawnNpcsProperty();

	private SpawnNpcsProperty() {
		super("spawn-npcs", GameRules.SPAWN_MOBS, true, true);
	}
}