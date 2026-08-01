rootProject.name = "Server-Properties-Reload"

pluginManagement {
	repositories {
		maven(url = "https://maven.fabricmc.net/") { name = "Fabric" }
		maven(url = "https://repo.spongepowered.org/repository/maven-public/") { name = "Sponge Snapshots" }
		gradlePluginPortal()
	}
}

// if (settings.extra.has("forgeVersion")) {
// 	include("Forge")
// }

if (settings.extra.has("fabricVersion")) {
	include("Fabric")
}
