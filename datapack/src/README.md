# Biolith Examples example datapack

## Using the test datapack

* Put everything at the level of this readme in a zip file, and
* Place the zip file in the Minecraft server's (or integrated) datapacks directory, and
* Add [Biolith](https://modrinth.com/mod/biolith/versions) for your mod loader of choice to your mods.
  * For this version of the datapack, the minimum Biolith version is 3.0.0-alpha.1.

## What this pack should change in world generation

* The Cherry Grove biome will be removed from all of its vanilla noise hypercubes.
* The Crimson Forest biome will be added to a noise hypercube spanning most of the vanilla Cherry Grove points.
* All vanilla Plains biomes in the Overworld will be replaced with Warped Forest.
* All vanilla Warped Forest biomes in the Nether will be replaced with End Highlands.
* All vanilla End Highlands in the End will be replaced with Plains.
* The most desert-like parts of vanilla Deserts in the Overworld will be replaced with Old Growth Pine Taiga.

* Surface rules will be added for all the above biomes placed in a different dimension than normal.
* A surface rule will be added to replace the surface of the Birch Forest with calcite.

## Testing

* In the Overworld
  * Attempting to locate Cherry Grove or Plains should fail.
  * Locating Crimson Forest and Warped Forest should succeed.
  * Crimson Forest and Warped Forest should have a surface of their respective nylium, with netherrack below.
  * The Birch Forest biome should have a surface of calcite instead of grass blocks and dirt.

* In the Nether
  * Attempting to locate Warped Forest should fail.
  * Locating End Highlands should succeed.
  * End Highlands should have a surface of end stone.

* In the End
  * Attempting to locate End Highlands should fail.
  * Locating Plains should succeed.
  * Plains should have a surface of grass blocks with dirt below.
