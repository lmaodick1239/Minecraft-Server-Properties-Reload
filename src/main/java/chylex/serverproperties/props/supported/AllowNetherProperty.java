package chylex.serverproperties.props.supported;

import chylex.serverproperties.props.GameRuleBooleanProperty;
import net.minecraft.world.level.gamerules.GameRules;

public final class AllowNetherProperty extends GameRuleBooleanProperty {
	public static final AllowNetherProperty INSTANCE = new AllowNetherProperty();

	private AllowNetherProperty() {
		super("allow-nether", GameRules.ALLOW_ENTERING_NETHER_USING_PORTALS, false, true);
	}
}