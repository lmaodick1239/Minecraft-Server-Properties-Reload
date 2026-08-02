package chylex.serverproperties.props.supported;

import chylex.serverproperties.props.GameRuleBooleanProperty;
import net.minecraft.world.level.gamerules.GameRules;

public final class EnableCommandBlockProperty extends GameRuleBooleanProperty {
	public static final EnableCommandBlockProperty INSTANCE = new EnableCommandBlockProperty();

	private EnableCommandBlockProperty() {
		super("enable-command-block", GameRules.COMMAND_BLOCKS_WORK, false, false);
	}
}