val modId: String by project
val minecraftVersion: String by project
val loaderVersion: String by project
val fabricVersion: String by project
val mixinVersion: String by project

plugins {
	idea
	id("net.fabricmc.fabric-loom") version "1.17-SNAPSHOT"
}

dependencies {
	minecraft("com.mojang:minecraft:$minecraftVersion")
	// Minecraft 26.1+ ships unobfuscated with parameter names, so no mappings are required.
	implementation("net.fabricmc:fabric-loader:$loaderVersion")
	implementation("net.fabricmc.fabric-api:fabric-api:$fabricVersion")
	implementation("org.spongepowered:mixin:$mixinVersion")
}

loom {
	runs {
		named("client") {
			client()
			runDir = "../run"
		}
		
		named("server") {
			server()
			runDir = "../run"
		}
	}
}

tasks.processResources {
	filesMatching("fabric.mod.json") {
		expand(inputs.properties)
	}
}
