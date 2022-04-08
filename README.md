# Mystical Agradditions [![](http://cf.way2muchnoise.eu/full_256247_downloads.svg)](https://minecraft.curseforge.com/projects/mystical-agradditions)
An addon for Mystical Agriculture.

## Download

The official release builds can be downloaded from the following websites.

- [Blake's Mods](https://blakesmods.com/mystical-agradditions/download)
- [CurseForge](https://www.curseforge.com/minecraft/mc-mods/mystical-agradditions)

## Development

To use this mod in a development environment, you will need to add the following to your `build.gradle`.

```groovy
repositories {
    maven {
        url 'https://maven.blakesmods.com'
    }
}

dependencies {
    implementation 'com.blakebr0.cucumber:Cucumber:<minecraft_version>-<mod_version>'
    implementation 'com.blakebr0.mysticalagradditions:MysticalAgradditions:<minecraft_version>-<mod_version>'
}
```

## License

[MIT License](./LICENSE)