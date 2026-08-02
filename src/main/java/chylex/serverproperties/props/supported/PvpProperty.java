package chylex.serverproperties.props.supported;

import chylex.serverproperties.props.GameRuleBooleanProperty;
import net.minecraft.world.level.gamerules.GameRules;

public final class PvpProperty extends GameRuleBooleanProperty {
	public static final PvpProperty INSTANCE = new PvpProperty();

	private PvpProperty() {
		super("pvp", GameRules.PVP, false, true);
	}
}