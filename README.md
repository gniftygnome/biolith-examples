<p align="center"><a href="https://modrinth.com/mod/biolith"><img height="286" width="286" src="./common/src/main/resources/assets/biolith_examples/logo.png" /></a></p>

# Biolith Examples
This mod provides a testing framework for Biolith in Fabric, Forge, and
NeoForge, with modifications to all three vanilla dimensions.  The testing
configuration may be useful as usage examples, and over time I intend to
add further usage examples to this mod.

## Mod Configuration

* [Fabric](https://github.com/gniftygnome/biolith-examples/blob/master/fabric/build.gradle)
* [Forge](https://github.com/gniftygnome/biolith-examples/blob/master/forge/build.gradle)
* [NeoForge](https://github.com/gniftygnome/biolith-examples/blob/master/neoforge/build.gradle)

## Biome Placement

Testing placements are here: [BiolithExamples.java](https://github.com/gniftygnome/biolith-examples/blob/master/common/src/main/java/com/terraformersmc/biolithexamples/BiolithExamples.java)

Things to check when testing Biolith with this mod:
* In the Overworld, Crimson Forest should be placed somewhere near Deserts/Jungles, and the features should generate.
* In the Overworld, all Plains should be replaced with Warped Forest, and the features should generate.
* In the Overworld, a portion generally less than 20% of Deserts should be replaced by Mega Taiga.
* In the Nether, all Warped Forests should be replaced with End Highlands (features do not generate).
* In the End, all End Highlands should be replaced with Plains, and the features should generate (villages too).

## Releases via Maven

Much like Terraform API, add the Terraformers maven repository to your `build.gradle`:

```
repositories {
    maven {
        name = 'TerraformersMC'
        url = 'https://maven.terraformersmc.com/'
    }
}
```

And add the Biolith version for your loader (fabric, forge, or neoforge)
to the dependencies section of `build.gradle`:

```
dependencies {
    modImplementation("com.terraformersmc:biolith-fabric:${project.biolith_version}") {
		exclude(group: "com.github.glitchfiend")
	}
}
```

If you wish to include Biolith in your mod for distribution, wrap the `modImplementation()` with an `include()`

Finally, set the Biolith version you want in `gradle.properties`:

```
biolith_version=1.2.0-alpha.2
```

For convenience, [Biolith can also be downloaded from Modrinth](https://modrinth.com/mod/biolith).
