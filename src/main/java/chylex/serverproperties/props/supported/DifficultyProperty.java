package chylex.serverproperties.props.supported;
import chylex.serverproperties.props.PropertyChangeCallback;
import chylex.serverproperties.props.ServerProperty;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;
import net.minecraft.world.Difficulty;
import java.util.Locale;

public final class DifficultyProperty extends ServerProperty<Difficulty> {
	public static final DifficultyProperty INSTANCE = new DifficultyProperty();
	
	private DifficultyProperty() {}
	
	@Override
	public Difficulty get(final DedicatedServerProperties properties) {
		return properties.difficulty.get();
	}
	
	@Override
	public void apply(final DedicatedServer server, final Difficulty value, final PropertyChangeCallback callback) {
		server.setDifficulty(value, true);
	}
	
	@Override
	public String toString(final Difficulty value) {
		return super.toString(value).toLowerCase(Locale.ROOT);
	}
}
