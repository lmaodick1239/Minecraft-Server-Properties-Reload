package chylex.serverproperties.debug;

import net.minecraft.server.dedicated.DedicatedServerProperties;

// Temporary debug class to explore available fields
public class PropertyFieldsDebug {
	public static void inspectProperties(DedicatedServerProperties props) {
		// Try to access fields to see what exists
		var test1 = props.allowFlight;
		var test2 = props.broadcastConsoleToOps;
		var test3 = props.difficulty;
		var test4 = props.enableQuery;
		var test5 = props.enforceWhitelist;
		var test6 = props.hardcore;
		var test7 = props.hideOnlinePlayers;
		var test8 = props.maxPlayers;
		var test9 = props.motd;
		var test10 = props.queryPort;
		var test11 = props.simulationDistance;
		var test12 = props.spawnProtection;
		var test13 = props.viewDistance;
		var test14 = props.whiteList;
		
		// These likely don't exist in 26.2:
		// var fail1 = props.gamemode;
		// var fail2 = props.allowNether;
		// var fail3 = props.enableCommandBlock;
		// var fail4 = props.functionPermissionLevel;
		// var fail5 = props.opPermissionLevel;
		// var fail6 = props.pvp;
		// var fail7 = props.rconPassword;
		// var fail8 = props.resourcePack;
		// var fail9 = props.spawnAnimals;
		// var fail10 = props.spawnMonsters;
		// var fail11 = props.spawnNpcs;
	}
}
