import org.gradle.api.file.DuplicatesStrategy.EXCLUDE
import java.text.SimpleDateFormat
import java.util.Date

val modId: String by project
val modName: String by project
val modDescription: String by project
val modAuthor: String by project
val modVersion: String by project
val modLicense: String by project
val modSourcesURL: String by project
val modIssuesURL: String by project

val minecraftVersion: String by project
val mixinVersion: String by project

val modNameStripped = modName.replace(" ", "")
val jarVersion = "$minecraftVersion+v$modVersion"

repositories {
	maven("https://repo.spongepowered.org/repository/maven-public/")
	mavenCentral()
}

plugins {
	`java-library`
	idea
}

dependencies {
	api("com.google.code.findbugs:jsr305:3.0.2")
	implementation("org.jetbrains:annotations:22.0.0")
}

// Root project is just a source container - subprojects compile the sources
tasks.withType<JavaCompile> {
	enabled = false
}

base {
	archivesName.set("$modNameStripped-Common")
}

extensions.getByType<JavaPluginExtension>().apply {
	toolchain.languageVersion.set(JavaLanguageVersion.of(25))
}

tasks.withType<JavaCompile> {
	options.encoding = "UTF-8"
	options.release.set(25)
}

allprojects {
	group = "com.$modAuthor.$modId"
	version = modVersion
}

subprojects {
	repositories {
		maven("https://repo.spongepowered.org/maven")
	}
	
	// Only apply java plugin if Loom isn't present (Loom provides its own java plugin)
	if (!plugins.hasPlugin("net.fabricmc.fabric-loom")) {
		apply(plugin = "java")
	}
	
	dependencies {
		implementation("org.jetbrains:annotations:22.0.0")
	}
	
	plugins.withType<JavaPlugin> {
		extensions.getByType<JavaPluginExtension>().apply {
			toolchain.languageVersion.set(JavaLanguageVersion.of(25))
		}
	}
	
	tasks.withType<JavaCompile> {
		options.encoding = "UTF-8"
		options.release.set(25)
	}
	
	base {
		archivesName.set("$modNameStripped-${project.name}")
	}
	
	tasks.withType<JavaCompile> {
		source({ rootProject.sourceSets.main.get().allSource })
	}
	
	tasks.processResources {
		from(rootProject.sourceSets.main.get().resources)
		
		inputs.property("name", modName)
		inputs.property("description", modDescription)
		inputs.property("version", modVersion)
		inputs.property("author", modAuthor)
		inputs.property("license", modLicense)
		inputs.property("sourcesURL", modSourcesURL)
		inputs.property("issuesURL", modIssuesURL)
	}
	
	tasks.jar {
		archiveVersion.set(jarVersion)
		
		from(rootProject.file("LICENSE"))
		
		manifest {
			attributes(
				"Specification-Title" to modId,
				"Specification-Vendor" to modAuthor,
				"Specification-Version" to "1",
				"Implementation-Title" to "$modNameStripped-${project.name}",
				"Implementation-Vendor" to modAuthor,
				"Implementation-Version" to modVersion,
				"Implementation-Timestamp" to SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").format(Date()),
				"MixinConfigs" to "$modId.mixins.json"
			)
		}
	}
}

tasks.register("setupIdea") {
	group = "mod"
	
	tasks.findByName("decompile")?.let { dependsOn(it) }
	
	val forge = findProject(":Forge")
	if (forge != null) {
		dependsOn(forge.tasks.getByName("genIntellijRuns"))
	}
	
	val fabric = findProject(":Fabric")
	if (fabric != null) {
		dependsOn(fabric.tasks.getByName("genSources"))
	}
}

val copyJars = tasks.register<Copy>("copyJars") {
	group = "build"
	duplicatesStrategy = EXCLUDE
	
	for (subproject in subprojects) {
		dependsOn(subproject.tasks.assemble)
		from(subproject.base.libsDirectory.file("${subproject.base.archivesName.get()}-$jarVersion.jar"))
	}
	
	into(layout.buildDirectory.dir("dist"))
}

tasks.assemble {
	finalizedBy(copyJars)
}
