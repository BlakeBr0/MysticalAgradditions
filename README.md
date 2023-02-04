# Mystical Agradditions

<p align="left">
    <a href="https://blakesmods.com/mystical-agradditions" alt="Downloads">
        <img src="https://img.shields.io/endpoint?url=https://api.blakesmods.com/v2/badges/mysticalagradditions/downloads&style=for-the-badge" />
    </a>
    <a href="https://blakesmods.com/mystical-agradditions" alt="Latest Version">
        <img src="https://img.shields.io/endpoint?url=https://api.blakesmods.com/v2/badges/mysticalagradditions/version&style=for-the-badge" />
    </a>
    <a href="https://blakesmods.com/mystical-agradditions" alt="Minecraft Version">
        <img src="https://img.shields.io/endpoint?url=https://api.blakesmods.com/v2/badges/mysticalagradditions/mc_version&style=for-the-badge" />
    </a>
    <a href="https://blakesmods.com/wiki/mysticalagradditions" alt="Docs">
        <img src="https://img.shields.io/static/v1?label=wiki&message=view&color=brightgreen&style=for-the-badge" />
    </a>
</p>

An addon for Mystical Agriculture.

## Download

The official release builds can be downloaded from the following websites.

- [Blake's Mods](https://blakesmods.com/mystical-agradditions/download)
- [CurseForge](https://www.curseforge.com/minecraft/mc-mods/mystical-agradditions)
- [Modrinth](https://modrinth.com/mod/mystical-agradditions)

## Development

To use this mod in a development environment, you will need to add the following to your `build.gradle`.

```groovy
repositories {
    maven {
        url 'https://maven.blakesmods.com'
    }
}

dependencies {
    implementation fg.deobf('com.blakebr0.cucumber:Cucumber:<minecraft_version>-<mod_version>')
    implementation fg.deobf('com.blakebr0.mysticalagradditions:MysticalAgradditions:<minecraft_version>-<mod_version>')
}
```

## License

[MIT License](./LICENSE)
