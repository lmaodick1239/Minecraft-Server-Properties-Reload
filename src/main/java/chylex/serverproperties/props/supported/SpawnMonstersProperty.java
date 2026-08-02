package chylex.serverproperties.props.supported;

import chylex.serverproperties.props.GameRuleBooleanProperty;
import net.minecraft.world.level.gamerules.GameRules;

public final class SpawnMonstersProperty extends GameRuleBooleanProperty {
	public static final SpawnMonstersProperty INSTANCE = new SpawnMonstersProperty();

	private SpawnMonstersProperty() {
		super("spawn-monsters", GameRules.SPAWN_MONSTERS, true, true);
	}
}